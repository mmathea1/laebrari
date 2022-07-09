from dbm.ndbm import library
from multiprocessing import managers
from pyexpat import model

from django.template import Library
from user_library.models import Book, UserLibrary
from rest_framework import serializers

from users.models import Profile
from users.serializers import ProfileSerializer

# list libraries this profile is associated with
class BookSerializer(serializers.ModelSerializer):
    class Meta:
        model = Book
        fields = '__all__'

class UserLibrarySerializer(serializers.ModelSerializer):
    class Meta:
        model = UserLibrary
        fields = '__all__'


class LibraryBooksSerializer(serializers.Serializer):
    books = BookSerializer(many=True)
    library =  UserLibrarySerializer()
    librarian = ProfileSerializer(many=True)
