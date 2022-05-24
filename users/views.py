import re
from rest_framework import viewsets, generics, permissions
from users.forms import  ProfileUpdateForm, UserRegistrationForm, UserUpdateForm
from users.models import User
from users.serializers import UserSerializer
from django.shortcuts import render, redirect
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
        u_form = UserUpdateForm(request.POST)  
        p_form = ProfileUpdateForm(request.POST, request.FILES, instance=request.user.profile) 

        if u_form.is_valid() and p_form.is_valid():
            u_form.save()
            p_form.save()
            messages.success(request, f'Your account has been updated!')
            return redirect('profile') # Redirect back to profile page
    else:
        u_form = UserUpdateForm(instance=request.user)
        p_form = ProfileUpdateForm(instance=request.user.profile)
    
    context = {
        'user': request.user,
        'u_form': u_form,
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
