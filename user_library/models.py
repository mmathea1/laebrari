
from datetime import date, timedelta
from enum import unique
from django.db import models

LIBRARY_TYPES = (
    ('PRIVATE', 'PRIVATE'),
    ('PUBLIC', 'PUBLIC'),
    ('UNLISTED', 'UNLISTED'),
)

# BOOK_CONDITIONS = (
#     ('NEW', 'NEW'),
#     ('OLD', 'OLD'),
#     ('GOOD CONDITION', 'GOOD CONDITION'),
# )

# TRANSACTION_TYPES = (('LOAN', 'LOAN'), ('SELL', 'SELL'))


class UserLibrary(models.Model):
    librarian = models.ForeignKey('users.User', on_delete=models.DO_NOTHING, related_name='librarians')
    name = models.CharField(max_length=255, blank=False, null=False, default="None")
    location = models.CharField(max_length=255, blank=False, null=False, default="Kenya")
    address = models.CharField(max_length=255, blank=True, null=True)
    description = models.TextField(blank=True, null=True)
    phone_number = models.CharField(max_length=255, blank=True, null=True)
    email = models.EmailField(blank=True, null=True)
    date_established = models.DateField(blank=True, null=True)
    established_by = models.CharField(max_length=255, blank=True, null=True)
    type = models.CharField(max_length=255, blank=True, null=True, choices=LIBRARY_TYPES, default=LIBRARY_TYPES[0])


    def __str__(self):
        return "{} - {}".format(self.name, self.location)

    class  Meta:
        unique_together = ('name', 'location')


# class Book(models.Model):
#     title = models.CharField(verbose_name="book title", max_length=255, blank=False)
#     author = models.CharField(verbose_name="author", max_length=255, blank=False)
#     memo = models.CharField(verbose_name="memo", max_length=255)
#     isbn = models.CharField(verbose_name="isbn", max_length=255, blank=False)
#     date_acquired = models.DateField(verbose_name="date acquired")
#     owner = models.ForeignKey(
#         to='users.Profile', on_delete=models.DO_NOTHING, related_name="book_owner", blank=False)
#     genre = models.CharField(max_length=255, blank=False)
#     available_to_borrow = models.BooleanField(default=False)
#     available_to_sell = models.BooleanField(default=False)
#     borrowing_price = models.IntegerField()
#     selling_price = models.FloatField()
#     book_condition = models.CharField(max_length=255, blank=False, choices=BOOK_CONDITIONS)
#     library = models.ForeignKey(to=UserLibrary, blank=False, on_delete=models.DO_NOTHING, related_name="library_book")

#     def __str__(self):
#         return "{} - {}".format(self.title, self.author)
    
#     class Meta:
#         unique_together = ('title', 'author')


# class BookTransaction(models.Model):
#     transaction_type = models.CharField(
#         max_length=255, choices=TRANSACTION_TYPES, blank=False, verbose_name="Transaction Type")
#     patron = models.ForeignKey(
#         to='users.Profile', on_delete=models.DO_NOTHING, related_name="borrower", blank=False)
#     book = models.ForeignKey(
#         to=Book, on_delete=models.DO_NOTHING, related_name="book_transacted", blank=False)
#     transaction_date = models.DateField(
#         auto_now=True, verbose_name="transaction_date", blank=False)
#     end_of_transaction = models.DateField(verbose_name="return_date", blank=True, null=True)

#     def __str__(self) -> str:
#         return "{} - {}".format(self.patron, self.book)