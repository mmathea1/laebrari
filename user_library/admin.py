from django.contrib import admin

from user_library.models import BookGenre, UserLibrary



# # Register your models here.
admin.site.register(UserLibrary)
admin.site.register(BookGenre)
# admin.site.register(Book)
# admin.site.register(BookTransaction)