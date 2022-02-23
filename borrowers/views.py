from django.shortcuts import render
from books.models import Book
from books.serializers import BookSerializer
from borrowers.models import Borrower
from borrowers.serializers import BorrowerSerializer
from rest_framework import viewsets, permissions
# Create your views here.


class BorrowerViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = Borrower.objects.all().order_by('id')
    serializer_class = BorrowerSerializer
    permission_classes = [permissions.IsAuthenticated]
