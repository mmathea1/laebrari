from django.db import models
from django.contrib.auth.models import UserManager
from django.contrib.auth.models import AbstractUser

# Create your models here.
class User(AbstractUser):
    REQUIRED_FIELDS = ('email', 'password',)
    USERNAME_FIELD = 'username'
    EMAIL_FIELD = 'email'
    
    email = models.EmailField(max_length=255, blank=False, null=False)
    username = models.CharField(
        max_length=255, blank=False, null=False, unique=True)
    password = models.CharField(max_length=255, blank=False, null=False)
    
    def __str__(self):
        return "{}".format(self.email)

    objects = UserManager()

