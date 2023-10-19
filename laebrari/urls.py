"""
laebrari URL Configuration
"""

from django.conf import settings
from django.urls import path, include
from django.contrib import admin
from django.conf.urls.static import static
from rest_framework import routers
from django.urls import include, path
from user_library.views import HomeView, LibraryBookViewSet, UserLibraryViewSet
from users.views import LoginUserView, RegisterUserView, UserDetailView

router = routers.DefaultRouter()
router.register(r'library', UserLibraryViewSet, basename='library')
router.register(r'book', LibraryBookViewSet, basename='library-book')

urlpatterns = [
    path('admin/', admin.site.urls),
    path('register/', RegisterUserView.as_view(), name='register'),
    path('login/', LoginUserView.as_view(), name='login'),
    path('api/', include(router.urls)),
    path('profile/', UserDetailView.as_view(), name='profile'),
    path('', HomeView.as_view(), name='home')
]

if settings.DEBUG:
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)