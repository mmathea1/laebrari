
# from user_library.serializers import UserLibrarySerializer
from users.models import Profile, User
from rest_framework import serializers


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = '__all__'

class ProfileSerializer(serializers.ModelSerializer):
    class Meta:
        model = Profile
        fields = '__all__'

# class LibrarianSerializer(serializers.Serializer):
#     library = UserLibrarySerializer()
#     librarian = ProfileSerializer()
