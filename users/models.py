from django.db import models
from django.contrib.auth.models import UserManager
from django.contrib.auth.models import AbstractUser
from PIL import Image
from django.conf import settings
from django.db.models.signals import post_save
from django.dispatch import receiver
from rest_framework.authtoken.models import Token
from django.contrib.auth.hashers import make_password


@receiver(post_save, sender=settings.AUTH_USER_MODEL)   
def create_auth_token(sender, instance=None, created=False, **kwargs):
    if created:
        Token.objects.create(user=instance)

class CustomUserManager(UserManager):
    def create_user(self, email, username, password, **kwargs):
        if not email or not username:
            raise ValueError("Email and username are required")
        email  = self.normalize_email(email)
        user = self.model(email=email, username=username, **kwargs)
        user.set_password(password)
        user.save()
        return user
    
    def create_superuser(self, email, username, password, **kwargs):
        kwargs.setdefault('is_staff', True)
        kwargs.setdefault('is_superuser', True)
        kwargs.setdefault('is_active', True)

        if kwargs.get('is_superuser') is not True:
            raise ValueError("Superuser must be a superuser")
        if kwargs.get('is_staff') is not True:
            raise ValueError("Superuser must be a staff member")
        return self.create_user(email, username, password, **kwargs)


# Create your models here.
class User(AbstractUser):
    REQUIRED_FIELDS = ('email', 'password',)
    USERNAME_FIELD = 'username'
    EMAIL_FIELD = 'email'
    
    email = models.EmailField(max_length=255, blank=False, null=False)
    username = models.CharField(
        max_length=255, blank=False, null=False, unique=True)
    password = models.CharField(max_length=255, blank=False, null=False)
    profile_picture = models.ImageField(default='default.jpg', upload_to='profile_pics')
    bio = models.TextField(null=True, blank=True)
    date_joined = models.DateTimeField(verbose_name="Date joined", auto_now_add=True, null=True)
    location = models.CharField(max_length=255, blank=True, null=True)
    address = models.CharField(max_length=255, blank=True, null=True)
    phone_number = models.CharField(max_length=255, blank=True, null=True)
    can_loan = models.BooleanField(default=False, verbose_name="Can loan a book")
    can_borrow = models.BooleanField(default=False, verbose_name="Can borrow a book")
    can_sell = models.BooleanField(default=False, verbose_name="Can sell a book")

    
    def __str__(self):
        return "{}".format(self.email)


    def save(self, *args, **kwargs):
        super().save()

        img = Image.open(self.profile_picture.path)
        if img.height > 300 or img.width > 300:
            output_size = (300, 300)
            img.thumbnail(output_size)
            img.save(self.profile_picture.path)

    objects = CustomUserManager()

