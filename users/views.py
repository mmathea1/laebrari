from rest_framework import viewsets
from rest_framework import permissions
from users.models import User
from users.serializers import UserSerializer
from django.shortcuts import render 

def home(request):
    return render(request, "users/home.html")

class UserViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = User.objects.all().order_by('id')
    serializer_class = UserSerializer
    permission_classes = [permissions.IsAuthenticated]
