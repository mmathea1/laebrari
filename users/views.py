from rest_framework import viewsets, generics, permissions
from users.models import User
from users.serializers import UserSerializer
from django.shortcuts import render 
from django.urls import reverse_lazy

def home(request):
    return render(request, "users/home.html")

class SignUp(generics.CreateAPIView):
    serializer_class = UserSerializer
    success_url = reverse_lazy("login")
    template_name = "registration/signup.html"

class UserViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = User.objects.all().order_by('id')
    serializer_class = UserSerializer
    permission_classes = [permissions.IsAuthenticated]
