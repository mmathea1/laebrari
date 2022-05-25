
from django.db import models
from users.models import Profile
LIBRARY_TYPES = (
    ('PRIVATE', 'PRIVATE'),
    ('PUBLIC', 'PUBLIC'),
    ('UNLISTED', 'UNLISTED'),
)

# Create your models here.

class UserLibrary(models.Model):
    librarian = models.ForeignKey('users.Profile', on_delete=models.DO_NOTHING, related_name='librarians')
    location = models.CharField(max_length=255, blank=True, null=True)
    address = models.CharField(max_length=255, blank=True, null=True)
    description = models.TextField(blank=True, null=True)
    phone_number = models.CharField(max_length=255, blank=True, null=True)
    email = models.EmailField(blank=True, null=True)
    name = models.CharField(max_length=255, blank=True, null=True)
    date_established = models.DateTimeField(blank=True, null=True)
    established_by = models.ForeignKey('users.Profile', on_delete=models.DO_NOTHING, related_name="library_owner")
    type = models.CharField(max_length=255, blank=True, null=True, choices=LIBRARY_TYPES)


# class Book(models.Model):
#     title = models.CharField(verbose_name="book_title", max_length=255)
#     author = models.CharField(verbose_name="author", max_length=255)
#     date_acquired = models.DateField(verbose_name="date_acquired")
#     owner = models.ForeignKey(
#         to='users.User', on_delete=models.DO_NOTHING, related_name="book_owner")
#     genre = models.CharField(max_length=255, blank=True, null=True)
#     available_to_borrow = models.BooleanField(default=False)
#     available_to_sell = models.BooleanField(default=False)
#     private_library = models.BooleanField(default=True)
#     borrowing_price = models.IntegerField()
#     selling_price = models.FloatField()
#     book_condition = models.CharField(max_length=255, blank=True)


# class BookTransaction(models.Model):
#     transaction_type = models.CharField(
#         max_length=255, choices=[['borrow', 'Borrow'], ['sell', 'Sell']])
#     borrower = models.ForeignKey(
#         to='users.User', on_delete=models.DO_NOTHING, related_name="borrower")
#     buyer = models.ForeignKey(
#         to='users.User', on_delete=models.DO_NOTHING, related_name="buyer")
#     owner = models.ForeignKey(
#         to='users.User', on_delete=models.DO_NOTHING, related_name="transaction_owner")
#     book_transacted = models.ForeignKey(
#         to=Book, on_delete=models.DO_NOTHING, related_name="book_transacted")
#     transaction_date = models.DateField(
#         auto_now=True, verbose_name="date_borrowed")
#     return_date = models.DateField(verbose_name="return_date")

#     def __str__(self) -> str:
#         return "{}{}".format(self.borrower, self.book_borrowed)

