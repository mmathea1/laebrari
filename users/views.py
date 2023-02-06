
from rest_framework import generics
from users.models import  User
from users.serializers import RegisterSerializer, UserSerializer
from django.contrib.auth import login, logout
from rest_framework.response import Response
from rest_framework import generics
from rest_framework.permissions import IsAuthenticated 
from rest_framework.permissions import AllowAny
from rest_framework.views import APIView
from rest_framework.authentication import TokenAuthentication
from rest_framework.authtoken.views import ObtainAuthToken
from rest_framework.authtoken.models import Token
from django.core.exceptions import ValidationError
from django.contrib.auth.hashers import check_password
from django.db import IntegrityError

class UserDetailView(APIView):
    authentication_classes = (TokenAuthentication,)
    permission_classes = (AllowAny,)
    def get(self,request,*args,**kwargs):
        user=User.objects.get(id=request.user.id)
        serializer=UserSerializer(user)
        return Response(serializer.data)

class RegisterUserView(generics.CreateAPIView):
    permission_classes = (AllowAny, )
    serializer_class = RegisterSerializer

    def post(self,request,*args,**kwargs):
        try:
            data = {}
            print(request.data)
            serializer = RegisterSerializer(data=request.data)
            if serializer.is_valid(raise_exception=True):
                account = serializer.save()
                account.is_active = True
                token = Token.objects.get_or_create(user=account)[0].key
                data['message']= "Account created successfully"
                data['email'] = account.email
                data['token'] = token
                data['username'] = account.username
            else:
                data = serializer.errors
            return Response(data)
        except IntegrityError as i:
            account = User.objects.get(username='')
            account.delete()
            raise ValidationError({"400": f'{str(i)}'})
        except KeyError as k:
            raise ValidationError({"400": f'Field {str(k)} missing'})


class LoginUserView(ObtainAuthToken):
    authentication_classes = (TokenAuthentication,)
    permission_classes = (AllowAny,)
    def post(self, request, *args, **kwargs):
        data = {}
        username = request.data.get('username')
        password = request.data.get('password')
        try:
            account = User.objects.get(username=username)
        except BaseException as e:
            raise ValidationError({"400": f'{str(e)}'})
        token = Token.objects.get_or_create(user=account)[0].key
        if not check_password(password, account.password):
            raise ValidationError({"message": "Incorrect login credentials."})
        
        if account:
            if account.is_active:
                login(request, account)
                data['message']= "login successful"
                data['email'] = account.email
                response = {"data": data, "token": token}
                return Response(response)
            else:
                raise ValidationError({"400": f'Account inactive'})
        else:
            raise ValidationError({"Account does not exist."})
        
class LogOutView(APIView):
    permission_classes = (IsAuthenticated, )
    def get(self, request, *args, **kwargs):
        request.user.auth_token.delete()
        logout(request)
        return Response({"message": "User logged out."})