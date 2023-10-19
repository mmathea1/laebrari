from rest_framework.views import APIView
from rest_framework.response import Response
from user_library.models import Book, UserLibrary
from rest_framework import viewsets, status, permissions
from user_library.serializers import  BookSerializer, UserLibrarySerializer
from users.models import User
from users.serializers import UserSerializer
from django.db.models import Q

class HomeView(APIView):
    permission_classes = []
    def get(self, request):
        libraries = UserLibrary.objects.filter(type='PUBLIC')
        serializer = UserLibrarySerializer(libraries, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

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
        data = request.data
        data['librarian'] = self.request.user.pk
        serializer = UserLibrarySerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
    

    # def list(self, request, *args, **kwargs):
    #     queryset = self.get_queryset()
    #     serializer = UserLibrarySerializer(queryset, many=True)
    #     return Response(serializer.data, status=status.HTTP_200_OK)
    
    # def retrieve(self, request, pk=None):
    #     lib = UserLibrary.objects.get(pk=pk)
    #     if lib.type == 'PUBLIC' or lib.librarian != request.user:
    #         libraries = UserLibrarySerializer(lib)
    #         queryset = Book.objects.filter(library=pk)
    #         books = BookSerializer(queryset, many=True)
    #         data = {"library": libraries.data, "books": books.data}
    #         return Response(data, status=status.HTTP_200_OK)
    #     return Response('Library not found', status=status.HTTP_404_NOT_FOUND)

class LibraryBookViewSet(viewsets.ModelViewSet):
    serializer_class = BookSerializer
    permission_classes = [permissions.IsAuthenticated]
    queryset = Book.objects.all()
    
    def create(self, request, *args, **kwargs):
        data = request.data
        data['owner'] = request.user.pk
        serializer = BookSerializer(data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
    
    def retrieve(self, request, pk, format=None):
        book = Book.objects.get(pk=pk)
        serializer = BookSerializer(book)
        if(serializer.data):
             return Response(serializer.data, status=status.HTTP_200_OK)
        return Response('Book not found', status=status.HTTP_404_NOT_FOUND)
        
    
#     @action(detail=True, methods=['post'])
#     def create_book_transaction(self, request, pk=None):
#         book = self.get_object()
#         data = {"book": book.id, "transaction_type": request.data.get('transaction_type'), "patron": request.user.id}
#         serializer = CreateBookTransactionSerializer(data=data)
#         if serializer.is_valid(raise_exception=True):
#             serializer.save()
#             return Response(serializer.data, status=status.HTTP_201_CREATED)
#         else:
#             return Response(serializer.errors,
#                             status=status.HTTP_400_BAD_REQUEST)
        
#     @action(detail=True, methods=['GET'])
#     def list_book_transactions(self, request, *args, **kwargs):
#         book = self.get_object()
#         book_transactions = BookTransaction.objects.filter(book=book)
#         serializer = BookTransactionSerializer(book_transactions, many=True)
#         return Response(serializer.data, status=status.HTTP_200_OK)

#     def list(self, request, *args, **kwargs):
#         queryset = self.get_queryset()
#         serializer = BookSerializer(queryset, many=True)
#         return Response(serializer.data, status=status.HTTP_200_OK)
        


# class BookTransactionViewSet(viewsets.ModelViewSet):
#     queryset = BookTransaction.objects.all().order_by('id')
#     serializer_class = BookTransactionSerializer
#     permission_classes = [permissions.IsAuthenticated]

#     def list(self, request, *args, **kwargs):
#         queryset = BookTransaction.objects.filter(Q(patron=request.user.id) | Q(book__owner=request.user.id) | Q(book__library__librarian=request.user.id)).order_by('id')
#         serializer = BookTransactionSerializer(queryset, many=True)
#         return Response(serializer.data, status=status.HTTP_200_OK)






