from django.http import Http404
from rest_framework import generics
from rest_framework.response import Response
from user_library import serializers
from user_library.models import Book, BookTransaction, TransactionRating, UserLibrary
from rest_framework import viewsets, status
from rest_framework import permissions
from user_library.serializers import BookSerializer, BookTransactionSerializer, CreateBookTransactionSerializer, TransactionRatingSerializer, UserLibrarySerializer
from users.models import Profile
from users.serializers import UserSerializer
from django.db.models import Q
from rest_framework.decorators import action

class UserLibraryViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users create, view or edit libraries.
    """
    serializer_class = UserLibrarySerializer
    permission_classes = [permissions.IsAuthenticated]

    def get_queryset(self):
        req_user = self.request.user
        user = UserSerializer(req_user)
        if user['is_staff'].value is True:
            queryset = UserLibrary.objects.all().order_by('id')
        else:
            queryset = UserLibrary.objects.filter(librarian__user=req_user).order_by('id')    
        return queryset
            
    def create(self, request):
        serializer = UserLibrarySerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
    

    def list(self, request, *args, **kwargs):
        queryset = self.get_queryset()
        serializer = UserLibrarySerializer(queryset, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)
    
    def retrieve(self, request, pk=None):
        lib = UserLibrary.objects.get(pk=pk)
        if lib.type == 'PUBLIC' or lib.librarian != request.user:
            libraries = UserLibrarySerializer(lib)
            queryset = Book.objects.filter(library=pk)
            books = BookSerializer(queryset, many=True)
            data = {"library": libraries.data, "books": books.data}
            return Response(data, status=status.HTTP_200_OK)
        return Response('Library not found', status=status.HTTP_404_NOT_FOUND)

class LibraryBookViewSet(viewsets.ModelViewSet):
    serializer_class = BookSerializer
    permission_classes = [permissions.IsAuthenticated]

    def get_queryset(self):
        req_user = self.request.user
        user = UserSerializer(req_user)
        profile = Profile.objects.get(user=req_user)
        if user['is_staff'].value is True:
            queryset = Book.objects.all()
        else:
            queryset = Book.objects.filter(Q(owner=profile) | Q(library__librarian=profile) | Q(library__type="PUBLIC"))
        return queryset
    
    def create(self, request, *args, **kwargs):
        data = request.data.copy()
        data['owner'] = Profile.objects.get(user=request.user).pk
        serializer = BookSerializer(data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
    
    @action(detail=True, methods=['post'])
    def create_book_transaction(self, request, pk=None):
        book = self.get_object()
        data = {"book": book.id, "transaction_type": request.data.get('transaction_type'), "patron": request.user.id}
        serializer = CreateBookTransactionSerializer(data=data)
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors,
                            status=status.HTTP_400_BAD_REQUEST)
        
    @action(detail=True, methods=['GET'])
    def list_book_transactions(self, request, *args, **kwargs):
        book = self.get_object()
        book_transactions = BookTransaction.objects.filter(book=book)
        serializer = BookTransactionSerializer(book_transactions, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def list(self, request, *args, **kwargs):
        queryset = self.get_queryset()
        serializer = BookSerializer(queryset, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)
        
    def retrieve(self, request, pk, format=None):
        book = self.get_object(pk)
        serializer = BookSerializer(book)
        return Response(serializer.data, status=status.HTTP_200_OK)

class BookTransactionViewSet(viewsets.ModelViewSet):
    queryset = BookTransaction.objects.all().order_by('id')
    serializer_class = BookTransactionSerializer
    permission_classes = [permissions.IsAuthenticated]

    def list(self, request, *args, **kwargs):
        queryset = BookTransaction.objects.filter(Q(patron=request.user.id) | Q(book__owner=request.user.id) | Q(book__library__librarian=request.user.id)).order_by('id')
        serializer = BookTransactionSerializer(queryset, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)
    
    @action(detail=False)
    def list_user_transactions(self, request, *args, **kwargs):
        queryset = BookTransaction.objects.filter(patron=request.user.id)
        serializer = BookTransactionSerializer(queryset, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    
    @action(detail=True, methods=['POST'])
    def rate_book_transaction(self, request, *args, **kwargs):
        data = {"transaction":self.get_object().id, "rated_by":request.user.id, "rating":request.data['rating']}
        serializer = TransactionRatingSerializer(data=data) 
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)









