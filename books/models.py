from django.db import models

# Create your models here.


class Book(models.Model):
    title = models.CharField(verbose_name="book_title", max_length=255)
    author = models.CharField(verbose_name="author", max_length=255)
    date_acquired = models.DateField(verbose_name="date_acquired")
    owner = models.ForeignKey(
        to='users.User', on_delete=models.DO_NOTHING, related_name="book_owner")
