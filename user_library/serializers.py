from dbm.ndbm import library
from pyexpat import model
from user_library.models import Book, UserLibrary
from rest_framework import serializers

from users.models import Profile

# list libraries this profile is associated with
class UserLibrarySerializer(serializers.ModelSerializer):
    class Meta:
        model = UserLibrary
        fields = '__all__'

class BookSerializer(serializers.ModelSerializer):
    class Meta:
        model = Book
        fields = '__all__'

class UserLibraryBooksSerializer(serializers.Serializer):
    books = BookSerializer(many=True)

    class Meta:
        model = UserLibrary
        fields = ['name', 'books', 'library']
