from django.urls import path
from django.urls import include, path
from rest_framework import routers

from user_library import views

router = routers.DefaultRouter()
router.register(r'library', views.UserLibraryViewSet, basename="library")
# router.register(r'library/books', views.UpdateLibraryViewSet, basename="library_books")


urlpatterns = [
    path('', include(router.urls)),
    path('library/books',views.UpdateLibraryViewSet, 'library_books')
]