from django.shortcuts import render
from books.models import Book
from books.serializers import BookSerializer
from rest_framework import viewsets, permissions
# Create your views here.


class BorrowerViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = Book.objects.all().order_by('id')
    serializer_class = BookSerializer
    permission_classes = [permissions.IsAuthenticated]
