from books.models import Book
from rest_framework import serializers
from users.models import User


class BookSerializer(serializers.ModelSerializer):
    owner = serializers.PrimaryKeyRelatedField(queryset=User.objects.all())

    def create(self, validated_data):
        rq_user = validated_data.pop('request.user')
        print("rq_user: ", rq_user)
        owner = User.objects.get(pk=rq_user.pk)
        return Book.objects.create(owner=owner, **rq_user)

    class Meta:
        model = Book
        fields = ['title', 'id', 'author', 'date_acquired', 'owner']
