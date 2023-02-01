
from rest_framework import viewsets, generics, permissions, status
from user_library.models import Book, UserLibrary
from user_library.serializers import BookSerializer, UserLibrarySerializer
from users.forms import  ProfileUpdateForm, UserRegistrationForm
from users.models import Profile, User
from users.serializers import ProfileSerializer, UserSerializer
from django.shortcuts import  render, redirect
from django.contrib.auth import login
from django.contrib import messages
from rest_framework.response import Response
from rest_framework.renderers import TemplateHTMLRenderer
from rest_framework import generics
from rest_framework.permissions import IsAuthenticated 

class HomeView(generics.ListAPIView):
    permission_classes = (IsAuthenticated,) 
    queryset = Book.objects.filter(library__type='PUBLIC')
    serializer_class = BookSerializer

    def get(self, request):
        queryset = self.get_queryset()
        serializer = BookSerializer(queryset, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

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

class ProfileView(generics.RetrieveUpdateAPIView):
    queryset = Profile.objects.all().order_by('id')
    serializer_class = ProfileSerializer
    permission_classes = [permissions.IsAuthenticated]
    renderer_classes = [TemplateHTMLRenderer]
    
    def get(self, request, *args, **kwargs):
        profile = ProfileSerializer(request.user.profile)
        if profile:
            libs = UserLibrary.objects.filter(librarian=profile['id'].value)  
            libraries = UserLibrarySerializer(libs, many=True)
            data = {"profile": profile.data, "libraries": libraries.data}
            return Response(data, status=status.HTTP_200_OK, template_name="users/profile.html")
        return Response('PROFILE_NOT_FOUND', status.HTTP_404_NOT_FOUND)


    def patch(self, request, *args, **kwargs):
        p_form = ProfileUpdateForm(request.POST, request.FILES, instance=request.user.profile) 
        if p_form.is_valid():
            p_form.save()
            messages.success(request, f'Your account has been updated!')
        return Response('Your account has been updated!', status=status.HTTP_200_OK)

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
        serializer = ProfileSerializer(data)
        return Response(serializer.data)
