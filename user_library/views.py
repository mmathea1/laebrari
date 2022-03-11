from django.shortcuts import render

from user_library.models import UserLibrary
from rest_framework import viewsets
from rest_framework import permissions

# Create your views here.


class UserLibraryViewSet(viewsets.BaseViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = UserLibrary.objects.all().order_by('id')
    serializer_class = UserLibrarySerializer
    permission_classes = [permissions.IsAuthenticated]
