from django.shortcuts import render
from rest_framework.response import Response

from user_library.models import UserLibrary
from rest_framework import viewsets, status
from rest_framework import permissions
from user_library.serializers import UserLibraryCreateSerializer, UserLibrarySerializer

# Create your views here.


class UserLibraryViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = UserLibrary.objects.all().order_by('id')
    serializer_class = UserLibrarySerializer
    permission_classes = [permissions.IsAuthenticated]

    def create(self, request):
        data = {
            'librarian': request.user.pk
        }
        data.update(request.data)
        serializer = UserLibraryCreateSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

