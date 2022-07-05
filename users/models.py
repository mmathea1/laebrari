from django.db import models
from django.contrib.auth.models import UserManager
from django.contrib.auth.models import AbstractUser
from PIL import Image

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

class Profile(models.Model):
    user = models.OneToOneField('users.User', null=True, on_delete=models.DO_NOTHING)
    first_name = models.CharField(max_length=255, blank=False, null=False)
    last_name = models.CharField(max_length=255, blank=False, null=False)
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
        return "{}".format(self.user.username)
    
    def save(self, *args, **kwargs):
        super().save()

        img = Image.open(self.profile_picture.path)
        if img.height > 300 or img.width > 300:
            output_size = (300, 300)
            img.thumbnail(output_size)
            img.save(self.profile_picture.path)
    
