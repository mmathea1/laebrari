from books.models import Book
from rest_framework import serializers
from users.models import User


class BookSerializer(serializers.ModelSerializer):
    owner = serializers.PrimaryKeyRelatedField(queryset=User.objects.all())

    class Meta:
        model = Book
        fields = ['title', 'id', 'author', 'date_acquired', 'owner']
