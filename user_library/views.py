from dbm.ndbm import library
import re
from rest_framework.response import Response

from user_library.models import Book, UserLibrary
from rest_framework import viewsets, status
from rest_framework import permissions
from user_library.serializers import BookSerializer, UserLibrarySerializer
from users.models import Profile, User
from users.serializers import UserSerializer
from django.db.models import Q
# Create your views here.


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


