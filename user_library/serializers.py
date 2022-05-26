from dbm.ndbm import library
from user_library.models import UserLibrary
from rest_framework import serializers

from users.models import Profile


class UserLibrarySerializer(serializers.ModelSerializer):

    class Meta:
        model = UserLibrary
        fields = '__all__'

class UserLibraryCreateSerializer(serializers.ModelSerializer):
    class Meta:
        model = UserLibrary
        fields = ['type', 'name', 'description', 'date_established', 'librarian']
