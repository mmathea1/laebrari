from django.urls import path
from . import views
urlpatterns = [
 path("signup/", views.user_registration, name="signup"),
 path('profile/', views.profile, name='profile')
]
