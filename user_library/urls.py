from django.urls import path
from django.urls import include, path
from rest_framework import routers

from user_library import views

router = routers.DefaultRouter()
router.register(r'library', views.UserLibraryViewSet, basename="library")

urlpatterns = [
    path('', include(router.urls)),
    path('library/books/', views.UpdateLibraryViewSet, name='library_books')
]