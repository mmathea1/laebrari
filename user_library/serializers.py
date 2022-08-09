from datetime import datetime
from user_library.models import  Book, BookTransaction, UserLibrary
from rest_framework import serializers


class UserLibrarySerializer(serializers.ModelSerializer):
    class Meta:
        model = UserLibrary
        fields = '__all__'
    
    def create(self, validated_data):
        instance, created = UserLibrary.objects.get_or_create(**validated_data)
        if not created:
            raise serializers.ValidationError({'message': instance.name + ' already exists.'})
        return instance

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
        fields = ['book', 'transaction_type', 'patron', 'end_of_transaction']
    
    def create(self, validated_data):
        instance, created = BookTransaction.objects.get_or_create(**validated_data)
        print(instance, created)
        if created:
            if validated_data.get('transaction_type') == 'LOAN' and validated_data.get('end_of_transaction') == '':
                end_of_transaction = datetime.now() + datetime.timedelta(days=14)
                validated_data['end_of_transaction'] =  end_of_transaction  
                instance.save()
                return instance
        else:
            raise serializers.ValidationError({'message': instance.book.title +' is already taken.'})
