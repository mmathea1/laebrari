from books.models import Book
from books.serializers import BookSerializer
from rest_framework import serializers
from borrowers.models import Borrower
from users.models import User
from users.serializers import UserSerializer


class BorrowerSerializer(serializers.ModelSerializer):
    borrower = serializers.PrimaryKeyRelatedField(queryset=User.objects.all())
    lender = serializers.PrimaryKeyRelatedField(queryset=User.objects.all())
    book_borrowed = serializers.PrimaryKeyRelatedField(
        queryset=Book.objects.all())

    class Meta:
        model = Borrower
        fields = ['borrower', 'lender', 'book_borrowed',
                  'date_borrowed', 'return_date']
