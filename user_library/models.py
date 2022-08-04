
from django.db import models
LIBRARY_TYPES = (
    ('PRIVATE', 'PRIVATE'),
    ('PUBLIC', 'PUBLIC'),
    ('UNLISTED', 'UNLISTED'),
)

BOOK_CONDITIONS = (
    ('NEW', 'NEW'),
    ('OLD', 'OLD'),
    ('GOOD CONDITION', 'GOOD CONDITION'),
)

TRANSACTION_TYPES = (('LOAN', 'LOAN'), ('SELL', 'SELL'))


class UserLibrary(models.Model):
    librarian = models.ForeignKey('users.Profile', on_delete=models.DO_NOTHING, related_name='librarians')
    location = models.CharField(max_length=255, blank=True, null=True)
    address = models.CharField(max_length=255, blank=True, null=True)
    description = models.TextField(blank=True, null=True)
    phone_number = models.CharField(max_length=255, blank=True, null=True)
    email = models.EmailField(blank=True, null=True)
    name = models.CharField(max_length=255, blank=True, null=True)
    date_established = models.DateTimeField(blank=True, null=True)
    established_by = models.CharField(max_length=255, blank=True, null=True)
    type = models.CharField(max_length=255, blank=True, null=True, choices=LIBRARY_TYPES)


    def __str__(self):
        return "{} - {}".format(self.name, self.location)


class Book(models.Model):
    title = models.CharField(verbose_name="book title", max_length=255)
    author = models.CharField(verbose_name="author", max_length=255)
    memo = models.CharField(verbose_name="author", max_length=255)
    isbn = models.CharField(verbose_name="author", max_length=255)
    date_acquired = models.DateField(verbose_name="date acquired")
    owner = models.ForeignKey(
        to='users.Profile', on_delete=models.DO_NOTHING, related_name="book_owner")
    genre = models.CharField(max_length=255, blank=True, null=True)
    available_to_borrow = models.BooleanField(default=False)
    available_to_sell = models.BooleanField(default=False)
    borrowing_price = models.IntegerField()
    selling_price = models.FloatField()
    book_condition = models.CharField(max_length=255, blank=True, choices=BOOK_CONDITIONS)
    library = models.ForeignKey(to=UserLibrary, on_delete=models.DO_NOTHING, related_name="library_book")


    def __str__(self):
        return "{}".format(self.title)


class BookTransaction(models.Model):
    transaction_type = models.CharField(
        max_length=255, choices=TRANSACTION_TYPES)
    patron = models.ForeignKey(
        to='users.Profile', on_delete=models.DO_NOTHING, related_name="borrower",  null=True, blank=True)
    book = models.ForeignKey(
        to=Book, on_delete=models.DO_NOTHING, related_name="book_transacted")
    transaction_date = models.DateField(
        auto_now=True, verbose_name="transaction_date")
    end_of_transaction = models.DateField(verbose_name="return_date",null=True, blank=True)

    def __str__(self) -> str:
        return "{} - {}".format(self.patron, self.book)

