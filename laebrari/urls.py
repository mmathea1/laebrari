"""
laebrari URL Configuration
"""
from django.urls import path, include
from django.contrib import admin

urlpatterns = [
    path('users/', include('users.urls')),
    path('books/', include('books.urls')),
    path('borrowers/', include('borrowers.urls')),
    path('admin/', admin.site.urls),
    path('api/', include('rest_framework.urls', namespace='rest_framework'))

]
