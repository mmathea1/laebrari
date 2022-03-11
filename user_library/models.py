from django.db import models

# Create your models here.


class Book(models.Model):
    title = models.CharField(verbose_name="book_title", max_length=255)
    author = models.CharField(verbose_name="author", max_length=255)
    date_acquired = models.DateField(verbose_name="date_acquired")
    owner = models.ForeignKey(
        to='users.User', on_delete=models.DO_NOTHING, related_name="book_owner")
    genre = models.CharField(max_length=255, blank=True, null=True)
    available_to_borrow = models.BooleanField(default=False)
    available_to_sell = models.BooleanField(default=False)
    private_library = models.BooleanField(default=True)
    borrowing_price = models.IntegerField()
    selling_price = models.FloatField()
    book_condition = models.CharField(max_length=255, blank=True)


class BookTransaction(models.Model):
    transaction_type = models.CharField(
        max_length=255, choices=[['borrow', 'Borrow'], ['sell', 'Sell']])
    borrower = models.ForeignKey(
        to='users.User', on_delete=models.DO_NOTHING, related_name="borrower")
    buyer = models.ForeignKey(
        to='users.User', on_delete=models.DO_NOTHING, related_name="borrower")
    owner = models.ForeignKey(
        to='users.User', on_delete=models.DO_NOTHING, related_name="owner")
    book_transacted = models.ForeignKey(
        to=Book, on_delete=models.DO_NOTHING, related_name="book_transacted")
    transaction_date = models.DateField(
        auto_now=True, verbose_name="date_borrowed")
    return_date = models.DateField(verbose_name="return_date")

    def __str__(self) -> str:
        return "{}{}".format(self.borrower, self.book_borrowed)


class Librarian(models.Model):
    user = models.ForeignKey('users.User', on_delete=models.DO_NOTHING)
    location = models.CharField(max_length=255, blank=False, null=False)
    address = models.CharField(max_length=255, blank=False, null=False)
    phone_number = models.CharField(max_length=255, blank=False, null=False)
    lender_rating = models.IntegerField()
    borrower_rating = models.IntegerField()
    seller_rating = models.IntegerField()
    overall_rating = models.IntegerField()


class UserLibrary(models.Model):
    books = models.ForeignKey(
        Book,  on_delete=models.DO_NOTHING, related_name="collection")
    library_owner = models.ForeignKey(
        Librarian, on_delete=models.DO_NOTHING, related_name="librarian")
    location = models.CharField(max_length=255, blank=True, null=True)
