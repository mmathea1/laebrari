from books.serializers import BookSerializer
from rest_framework import serializers
from borrowers.models import Borrower
from users.serializers import UserSerializer


class BorrowerSerializer(serializers.ModelSerializer):
    borrower = UserSerializer()
    lender = UserSerializer()
    book_borrowed = BookSerializer()

    class Meta:
        model = Borrower
        fields = ['borrower', 'lender', 'book_borrowed',
                  'date_borrowed', 'return_date']
