import re
from requests import Response
from rest_framework import viewsets, generics, permissions
from user_library.models import UserLibrary
from user_library.serializers import UserLibrarySerializer
from users.forms import  ProfileUpdateForm, UserRegistrationForm, UserUpdateForm
from users.models import Profile, User
from users.serializers import LibrarianSerializer, ProfileSerializer, UserSerializer
from django.shortcuts import get_object_or_404, render, redirect
from django.urls import reverse_lazy
from django.contrib.auth.forms import UserCreationForm
from django.views.generic.edit import CreateView
from django.contrib.auth import login
from django.contrib import messages

def home(request):
    return render(request, "users/home.html")

def user_registration(request):
    if request.method == "POST":
        form = UserRegistrationForm(request.POST)
        if form.is_valid():
            user = form.save()
            login(request, user)
            messages.success(request, "Registration successful." )
            return redirect("home")
        messages.error(request, "Unsuccessful registration. Invalid information.")
    form = UserRegistrationForm()
    return render (request=request, template_name="users/signup.html", context={"register_form":form})

def profile(request):
    if request.method == "POST": 
        p_form = ProfileUpdateForm(request.POST, request.FILES, instance=request.user.profile) 

        if p_form.is_valid():
            p_form.save()
            messages.success(request, f'Your account has been updated!')
            return redirect('home') # Redirect back to home page
    else:
        p_form = ProfileUpdateForm(instance=request.user.profile)
    
    context = {
        'user': request.user,
        'p_form': p_form
    }

    return render(request, 'users/profile.html', context)

class UserViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = User.objects.all().order_by('id')
    serializer_class = UserSerializer
    permission_classes = [permissions.IsAuthenticated]

class ProfileViewSet(viewsets.ModelViewSet):
    """
    API endpoint for Profile 
    """
    queryset = Profile.objects.all().order_by('id')
    serializer_class = ProfileSerializer
    permission_classes = [permissions.IsAuthenticated] 

class LibrarianViewSet(viewsets.ViewSet):
    permission_classes = [permissions.IsAuthenticated]

    def retrieve(self, request, pk=None):    
        queryset = UserLibrary.objects.filter(librarian__user=request.user)
        data = {"library" : queryset, "librarian": request.user}
        serializer = LibrarianSerializer(data)
        return Response(serializer.data)
