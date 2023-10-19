
# from user_library.serializers import UserLibrarySerializer
from users.models import User
from rest_framework import serializers
from rest_framework.validators import UniqueValidator
from django.contrib.auth.password_validation import validate_password

class LoginUserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['username', 'password']
    
   
class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['id','first_name', 'last_name', 'email', 'phone_number', 'username', 'location', 'bio']

class RegisterSerializer(serializers.Serializer):
    username = serializers.CharField(required=True, validators=[UniqueValidator(User.objects.all())])
    email = serializers.EmailField(required=True, validators=[UniqueValidator(User.objects.all())])
    password = serializers.CharField(required=True, write_only=True, validators=[validate_password])
    password2 = serializers.CharField(required=True, write_only=True)
    first_name = serializers.CharField(required=True)
    last_name = serializers.CharField(required=True)


    def validate(self,attrs):
            if attrs['password'] != attrs['password2']:
                raise serializers.ValidationError({"password": "Password fields did not match."})
            return attrs
        
    def create(self, validated_data):
        user = User.objects.create_user(
                username=validated_data['username'], 
                email=validated_data['email'], password=validated_data['password'], 
                first_name=validated_data['first_name'], 
                last_name=validated_data['last_name']
            )
        user.set_password(validated_data['password'])
        user.save()
        return user