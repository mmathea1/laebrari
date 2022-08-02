from user_library.models import Book, BookTransaction, UserLibrary
from rest_framework import serializers


class UserLibrarySerializer(serializers.ModelSerializer):
    class Meta:
        model = UserLibrary
        fields = '__all__'

class PublicBookSerializer(serializers.ModelSerializer):
    class Meta:
        model = Book
        fields = ['id', 'title', 'author', 'genre', 'isbn', 'book_condition', 'library' ]

class BookSerializer(serializers.ModelSerializer):
    class Meta:
        model = Book
        fields = '__all__'
    
    def create(self, validated_data):
        instance, created = Book.objects.get_or_create(**validated_data)
        if not created:
            raise serializers.ValidationError({'message': instance.title + ' already exists.'})
        return instance


class LibBookSerializer(serializers.ModelSerializer):
    library = UserLibrarySerializer()
    class Meta:
        model = Book
        fields = ['title', 'author', 'date_acquired', 'owner', 'memo', 'genre', 'book_condition', 'borrowing_price', 'selling_price', 'available_to_borrow', 'isbn', 'library']

class BookTransactionSerializer(serializers.ModelSerializer):
    class Meta:
        model = BookTransaction
        fields = ['book', 'transaction_type', 'transactor']


