"""
laebrari URL Configuration
"""

from django.conf import settings
from django.urls import path, include
from django.contrib import admin
from django.contrib.auth import views as auth_views
from django.conf.urls.static import static


urlpatterns = [
    path('admin/', admin.site.urls),
    path('accounts/', include('django.contrib.auth.urls')),
    path('api/', include('rest_framework.urls', namespace='rest_framework')),
    path('', include('users.urls')),
    path('', include('user_library.urls')),

]

if settings.DEBUG:
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)