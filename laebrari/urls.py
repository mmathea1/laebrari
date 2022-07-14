"""
laebrari URL Configuration
"""

from django.conf import settings
from django.urls import path, include
from django.contrib import admin
from django.contrib.auth import views as auth_views
from django.conf.urls.static import static
from rest_framework import routers
from django.urls import include, path
from user_library.views import BookTransactionViewSet, LibraryBookViewSet, UserLibraryViewSet

from users.views import ProfileViewSet, UserViewSet, home, profile, user_registration


router = routers.DefaultRouter()
router.register(r'users', UserViewSet, basename="user")
router.register(r'librarians', ProfileViewSet, basename="librarian")
router.register(r'libraries', UserLibraryViewSet, basename="library")
router.register(r'books', LibraryBookViewSet, basename="library_books")
router.register(r'transactions', BookTransactionViewSet, basename="book_transaction")

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', home, name='login'),
    path('accounts/', include('django.contrib.auth.urls')),
    path('signup/', user_registration, name='signup'),
    path('profile/', profile, name='profile'),
    path('api/', include(router.urls))
]

if settings.DEBUG:
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)