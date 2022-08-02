from urllib.parse import quote_from_bytes
from rest_framework import generics
from rest_framework.response import Response

from user_library.models import Book, BookTransaction, UserLibrary
from rest_framework import viewsets, status
from rest_framework import permissions
from user_library.serializers import BookSerializer, BookTransactionSerializer, UserLibrarySerializer
from users.models import Profile, User
from users.serializers import UserSerializer
from django.db.models import Q
from rest_framework.renderers import TemplateHTMLRenderer
# Create your views here.

class LibraryBookCreateView(generics.ListCreateAPIView):
    queryset = Book.objects.all().order_by('id')
    serializer_class = BookSerializer
    permission_classes = [permissions.IsAuthenticated]
    
    def post(self, request, *args, **kwargs):
        owner = Profile.objects.get(user=request.user)
        request.data._mutable=True
        request.data['owner'] = owner.pk
        request.data._mutable=False
        serializer = BookSerializer(data=request.data) 
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class BorrowBookView(generics.CreateAPIView):
    queryset = Book.objects.all().order_by('id')
    serializer_class = BookTransactionSerializer
    permission_classes = [permissions.IsAuthenticated]

    def post(self, request, *args, **kwargs):
        transaction = request.data['transaction_type'].strip()
        transactor= Profile.objects.get(user=request.user);
        data = dict(book=kwargs['pk'], transaction_type=transaction, transactor=transactor.pk)
        bt = BookTransactionSerializer(data=data)
        if bt.is_valid(raise_exception=True):
            bt.save()
            return Response(bt.data, status=status.HTTP_201_CREATED)
        return Response(bt.errors, status=status.HTTP_400_BAD_REQUEST)


class LibraryListCreateView(generics.ListCreateAPIView):
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
    # create a new book transaction
    queryset = BookTransaction.objects.all().order_by('id')
    serializer_class = BookTransactionSerializer

    def create(self, request, *args, **kwargs):
        return super().create(request, *args, **kwargs)


