
from user_library.models import Book, BookGenre, UserLibrary
from rest_framework import serializers
from rest_framework.serializers import PrimaryKeyRelatedField


class UserLibrarySerializer(serializers.ModelSerializer):
    class Meta:
        model = UserLibrary
        fields = '__all__'
    
    def create(self, validated_data):
        print("####", validated_data)
        data = validated_data['genres']
        
        instance, created = UserLibrary.objects.get_or_create(**validated_data)
        if not created:
            raise serializers.ValidationError({'message': instance.name + ' already exists.'})
        return instance

class BookGenreSerializer(serializers.ModelSerializer):
    
    class Meta:
        model = BookGenre
        fields = ['id', 'genre'] 

class BookSerializer(serializers.ModelSerializer):
    genre = BookGenreSerializer(many=True, read_only=True)

    class Meta:
        model = Book
        fields = ['id', 'title', 'author', 'date_acquired', 'owner', 'memo', 'genre', 'book_condition', 'borrowing_price', 'selling_price', 'available_to_borrow', 'isbn', 'library']
    
    def create(self, validated_data):
        genres = self.initial_data['genre']
        genreInstances = []

        for g in genres:
            genreInstances.append(BookGenre.objects.get(pk=g))
        
        instance, created = Book.objects.get_or_create(**validated_data)
        if not created:
            raise serializers.ValidationError({'message': instance.title + ' already exists.'})   
        instance.genre.set(genreInstances)
        return instance

# class LibBookSerializer(serializers.ModelSerializer):
#     library = UserLibrarySerializer()
#     class Meta:
#         model = Book
#         fields = ['title', 'author', 'date_acquired', 'owner', 'memo', 'genre', 'book_condition', 'borrowing_price', 'selling_price', 'available_to_borrow', 'isbn', 'library']

# class CreateBookTransactionSerializer(serializers.ModelSerializer):
#     class Meta:
#         model = BookTransaction
#         fields = ['book', 'transaction_type', 'patron']
 
#     def create(self, validated_data): 
#         if validated_data['transaction_type'] == 'LOAN':
#             validated_data['end_of_transaction'] = date.today() + timedelta(days=14)
#         elif validated_data['transaction_type'] == 'SALE':
#             validated_data['end_of_transaction'] = date.today()
#         return BookTransaction.objects.create(**validated_data)

# class BookTransactionSerializer(serializers.ModelSerializer):
#     class Meta:
#         model = BookTransaction
#         fields = '__all__'