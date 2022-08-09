from django.http import Http404
from rest_framework import generics
from rest_framework.response import Response

from user_library.models import Book, BookTransaction, UserLibrary
from rest_framework import viewsets, status
from rest_framework import permissions
from user_library.serializers import BookSerializer, BookTransactionSerializer, UserLibrarySerializer
from users.models import Profile
from users.serializers import UserSerializer
from django.db.models import Q
from rest_framework.renderers import TemplateHTMLRenderer

class LibraryBookView(generics.ListCreateAPIView):
    queryset = Book.objects.all().order_by('id')
    serializer_class = BookSerializer
    permission_classes = [permissions.IsAuthenticated]
    
    def post(self, request, *args, **kwargs):
        data = request.data.copy()
        data['owner'] = Profile.objects.get(user=request.user).pk
        serializer = BookSerializer(data=data) 
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class BookDetailView(generics.RetrieveUpdateAPIView):
    queryset = Book.objects.all().order_by('id')
    serializer_class = BookSerializer
    permission_classes = [permissions.IsAuthenticated]

    def get_object(self, pk):
        try:
            return Book.objects.get(pk=pk)
        except Book.DoesNotExist:
            raise Http404
    
    def get(self, request, pk, format=None):
        book = self.get_object(pk)
        serializer = BookSerializer(book)
        return Response(serializer.data)

    def put(self, request, pk, format=None):
        book = self.get_object(pk)
        serializer = BookSerializer(book, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class BorrowBookView(generics.CreateAPIView):
    queryset = Book.objects.all().order_by('id')
    serializer_class = BookTransactionSerializer
    permission_classes = [permissions.IsAuthenticated]

    def post(self, request, *args, **kwargs):
        data = request.data.copy()
        data['patron'] = Profile.objects.get(user=request.user).pk
        bt = BookTransactionSerializer(data=data)
        if bt.is_valid():
            bt.save()
            return Response(bt.data, status=status.HTTP_201_CREATED)
        else:
            return Response(bt.errors, status=status.HTTP_400_BAD_REQUEST)

class LibraryView(generics.ListCreateAPIView):
    serializer_class = UserLibrarySerializer
    permission_classes = [permissions.IsAuthenticated]

    def get_queryset(self):
        req_user = self.request.user
        queryset = UserLibrary.objects.filter(librarian__user=req_user).order_by('id') 
        return queryset

    def list(self, request, *args, **kwargs):
        queryset = self.get_queryset()
        serializer = UserLibrarySerializer(queryset, many=True)
        return Response(serializer.data)

class LibraryDetail(generics.RetrieveAPIView):
    serializer_class = UserLibrarySerializer
    permission_classes = [permissions.IsAuthenticated]
    renderer_classes = [TemplateHTMLRenderer]

    def get_queryset(self):
        req_user = self.request.user
        user = UserSerializer(req_user)
        if user['is_staff'].value is True:
            queryset = UserLibrary.objects.all().order_by('id')
        else:
            queryset = UserLibrary.objects.filter(librarian__user=req_user).order_by('id')    
        return queryset
    
    def get(self, request, pk, format=None):
        lib = UserLibrary.objects.get(pk=pk)
        libraries = UserLibrarySerializer(lib)
        queryset = Book.objects.filter(library=pk)
        books = BookSerializer(queryset, many=True)
        data = {"library": libraries.data, "books": books.data}
        return Response(data, status=status.HTTP_200_OK, template_name="userlibraries/library-detail.html")
      
class BookTransactionList(generics.ListAPIView):
    queryset = BookTransaction.objects.all().order_by('id')
    serializer_class = BookTransactionSerializer
    permission_classes = [permissions.IsAuthenticated]


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
        serializer = BookSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class BookTransactionViewSet(viewsets.ModelViewSet):
    queryset = BookTransaction.objects.all().order_by('id')
    serializer_class = BookTransactionSerializer
    permission_classes = [permissions.IsAuthenticated]




