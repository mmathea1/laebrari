from cProfile import Profile
from dbm.ndbm import library
from django.shortcuts import get_object_or_404
from rest_framework import generics
from rest_framework.response import Response

from user_library.models import Book, UserLibrary
from rest_framework import viewsets, status
from rest_framework import permissions
from user_library.serializers import BookSerializer, UserLibrarySerializer
# Create your views here.


class UserLibraryViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users create, view or edit libraries.
    """
    queryset = UserLibrary.objects.all().order_by('id')
    serializer_class = UserLibrarySerializer
    permission_classes = [permissions.IsAuthenticated]


    def create(self, request):
        serializer = UserLibrarySerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class LibraryBookViewSet(viewsets.ModelViewSet):
    queryset = Book.objects.all()
    serializer_class = BookSerializer
    permission_classes = [permissions.IsAuthenticated]

    def create(self, request, *args, **kwargs):
        serializer = BookSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


