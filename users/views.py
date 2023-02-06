
from rest_framework import generics
from users.models import  User
from users.serializers import RegisterSerializer, UserSerializer
from django.contrib.auth import login, logout
from rest_framework.response import Response
from rest_framework import status
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
            serializer = RegisterSerializer(data=request.data)
            if serializer.is_valid(raise_exception=True):
                account = serializer.save()
                account.is_active = True
                token = Token.objects.get_or_create(user=account)[0].key
                data['email'] = account.email
                data['token'] = token
                data['username'] = account.username
            else:
                data = serializer.errors
            return Response(data=data, status=status.HTTP_201_CREATED)
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
            return Response(data={"message": f'{str(e)}'}, status=status.HTTP_400_BAD_REQUEST)
        token = Token.objects.get_or_create(user=account)[0].key
        if not check_password(password, account.password):
            return Response(status=status.HTTP_400_BAD_REQUEST, data={"message": "Incorrect login credentials."})
        
        if account:
            if account.is_active:
                login(request, account)
                data['email'] = account.email
                data['token'] = token
                return Response(data=data, status=status.HTTP_200_OK)
            else:
                return Response(status=status.HTTP_400_BAD_REQUEST, data={"message": "Account inactive."})
        else:
            return Response(data={"message": "Account does not exist."}, status=status.HTTP_404_NOT_FOUND)
        
class LogOutView(APIView):
    permission_classes = (IsAuthenticated, )
    def get(self, request, *args, **kwargs):
        request.user.auth_token.delete()
        logout(request)
        return Response(status=status.HTTP_200_OK, data={"message": "User logged out."})