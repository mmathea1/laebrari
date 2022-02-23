from datetime import timedelta
from django.db import models

# Create your models here.


class Borrower(models.Model):
    borrower = models.ForeignKey(
        to='users.User', on_delete=models.DO_NOTHING, related_name="borrower")
    lender = models.ForeignKey(
        to='users.User', on_delete=models.DO_NOTHING, related_name="lender")
    book_borrowed = models.ForeignKey(
        to='books.Book', on_delete=models.DO_NOTHING, related_name="book_borrowed")
    date_borrowed = models.DateField(
        auto_now=True, verbose_name="date_borrowed")
    return_date = models.DateField(verbose_name="return_date")

    def __str__(self) -> str:
        return "{}{}".format(self.borrower, self.book_borrowed)
