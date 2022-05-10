from django.db import models
from django.contrib.auth.models import UserManager
from django.contrib.auth.models import AbstractUser

# Create your models here.
class User(AbstractUser):
    REQUIRED_FIELDS = ('email', 'password',)
    USERNAME_FIELD = 'username'
    EMAIL_FIELD = 'email'
    
    first_name = models.CharField(max_length=255, blank=False, null=False)
    last_name = models.CharField(max_length=255, blank=False, null=False)
    phone_number = models.CharField(max_length=255, blank=False, null=False)
    location = models.CharField(max_length=255, blank=False, null=False)
    date_joined = models.DateTimeField(verbose_name="Date joined", auto_now_add=True, null=True)
    email = models.EmailField(max_length=255, blank=False, null=False)
    username = models.CharField(
        max_length=255, blank=False, null=False, unique=True)
    password = models.CharField(max_length=255, blank=False, null=False)

    def __str__(self):
        return "{} {}".format(self.first_name, self.last_name)

    objects = UserManager()
