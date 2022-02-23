"""
laebrari URL Configuration
"""
from posixpath import basename
from django.urls import path, include
from django.contrib import admin
from books.views import BookViewSet
from borrowers.views import BorrowerViewSet
from rest_framework import routers
from users.views import UserViewSet


router = routers.DefaultRouter()
router.register(r'users', UserViewSet, basename='users')
router.register(r'books', BookViewSet, basename='books')
router.register(r'borrowers', BorrowerViewSet, basename='borrowers')

urlpatterns = [
    path('', include(router.urls)),
    path('api/', include('rest_framework.urls', namespace='rest_framework')),
    path('admin/', admin.site.urls),


]
