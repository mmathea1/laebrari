from user_library.models import UserLibrary
from rest_framework import serializers


class UserLibrarySerializer(serializers.ModelSerializer):
    class Meta:
        model = UserLibrary
        fields = '__all__'
