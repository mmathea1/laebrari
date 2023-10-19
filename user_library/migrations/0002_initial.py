# Generated by Django 3.2.14 on 2023-02-01 08:24

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('user_library', '0001_initial'),
        ('users', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='userlibrary',
            name='librarian',
            field=models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, related_name='librarians', to='users.profile'),
        ),
        migrations.AddField(
            model_name='booktransaction',
            name='book',
            field=models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, related_name='book_transacted', to='user_library.book'),
        ),
        migrations.AddField(
            model_name='booktransaction',
            name='patron',
            field=models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, related_name='borrower', to='users.profile'),
        ),
        migrations.AddField(
            model_name='book',
            name='library',
            field=models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, related_name='library_book', to='user_library.userlibrary'),
        ),
        migrations.AddField(
            model_name='book',
            name='owner',
            field=models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, related_name='book_owner', to='users.profile'),
        ),
        migrations.AlterUniqueTogether(
            name='userlibrary',
            unique_together={('name', 'location')},
        ),
        migrations.AlterUniqueTogether(
            name='book',
            unique_together={('title', 'author')},
        ),
    ]
