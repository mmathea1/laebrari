from django.db import models
from django.contrib.auth.models import UserManager

# Create your models here.


class User(models.Model):
    REQUIRED_FIELDS = ('email', 'password',)
    USERNAME_FIELD = 'username'

    email = models.EmailField(max_length=255, blank=False, null=False)
    username = models.CharField(
        max_length=255, blank=False, null=False, unique=True)
    password = models.CharField(max_length=255, blank=False, null=False)

    @property
    def is_anonymous(self):
        """
        Always return False. This is a way of comparing User objects to
        anonymous users.
        """
        return False

    @property
    def is_authenticated(self):
        return False

    def __str__(self):
        return "{} {}".format(self.email)


class UserProfile(models.Model):
    first_name = models.CharField(max_length=255, blank=False, null=False)
    last_name = models.CharField(max_length=255, blank=False, null=False)
    user = models.OneToOneField(
        User, related_name='profile', unique=True, on_delete=models.CASCADE)
    phone_number = models.CharField(max_length=255, blank=False, null=False)
    location = models.CharField(max_length=255, blank=False, null=False)

    objects = UserManager()
