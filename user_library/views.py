from django.shortcuts import render
from rest_framework.response import Response

from user_library.models import Book, UserLibrary
from rest_framework import viewsets, status
from rest_framework import permissions
from user_library.serializers import UserLibrarySerializer
from rest_framework.parsers import MultiPartParser, FormParser, JSONParser
from rest_framework import generics
# Create your views here.


class UserLibraryViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
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

class UpdateLibraryViewSet(generics.RetrieveUpdateDestroyAPIView):
    queryset = Book.objects.all()
    parser_classes = (MultiPartParser, FormParser, JSONParser)
    serializer_class = UserLibrarySerializer
    lookup_field = 'id'

    def get(self, request, format=None):
        return Response(request.data, status=status.HTTP_200_OK)