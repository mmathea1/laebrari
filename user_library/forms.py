from django import forms

from user_library.models import Book


class BookCreateForm(forms.ModelForm):

    class Meta:
        model = Book
        fields = [
            'title', 
            'isbn', 
            'author', 
            'genre', 
            'memo', 
            'date_acquired', 
            'available_to_borrow', 
            'available_to_sell',
            'borrowing_price',
            'selling_price',
            'book_condition'
        ]

 