from django.urls import path
from . import views
urlpatterns = [
 path('', views.home, name = "home"),
 path("signup/", views.profile_registration, name="signup"),
]