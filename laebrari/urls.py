"""
laebrari URL Configuration
"""

from django.conf import settings
from django.urls import path, include
from django.contrib import admin
from django.conf.urls.static import static
from rest_framework import routers
from django.urls import include, path
from user_library.views import BookDetailView, BookTransactionList, BookTransactionViewSet, BorrowBookView, LibraryBookView, LibraryBookViewSet, LibraryView, UserLibraryViewSet
from users.views import HomeView, ProfileView, ProfileViewSet, UserViewSet, user_registration


router = routers.DefaultRouter()
router.register(r'users', UserViewSet, basename="user")
router.register(r'librarians', ProfileViewSet, basename="librarian")
router.register(r'libraries', UserLibraryViewSet, basename="library")
router.register(r'books', LibraryBookViewSet, basename="library_books")
router.register(r'transactions', BookTransactionViewSet, basename="book_transaction")

urlpatterns = [
    path('admin/', admin.site.urls),
    path('api/', include(router.urls)),
    path('accounts/', include('django.contrib.auth.urls')),
    path('', HomeView.as_view(), name='home'),
    path('signup/', user_registration, name='signup'),
    path('profile/', ProfileView.as_view(), name='profile'),
    path('book/add/', LibraryBookView.as_view(), name='add_book'),
    path('book/<int:pk>/', BookDetailView.as_view(), name='book-detail'),
    path('book/<int:book_id>/borrow/', BorrowBookView.as_view(), name='borrow-book'),
    path('library/', LibraryView.as_view(), name='library'),
    path('transactions/', BookTransactionList.as_view(), name='book-transaction'),
]

if settings.DEBUG:
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)