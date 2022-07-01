from rest_framework.response import Response

from user_library.models import UserLibrary
from rest_framework import viewsets, status
from rest_framework import permissions
from user_library.serializers import UserLibrarySerializer
# Create your views here.


class UserLibraryViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users create, view or edit libraries.
    """
    serializer_class = UserLibrarySerializer
    permission_classes = [permissions.IsAuthenticated]

    def get_queryset(self):
        return UserLibrary.objects.filter(librarian__user=self.request.user.pk).order_by('id')

    def create(self, request):
        serializer = UserLibrarySerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)