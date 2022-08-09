# Generated by Django 3.2.9 on 2022-08-02 20:17

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('user_library', '0012_auto_20220714_2042'),
    ]

    operations = [
        migrations.RenameField(
            model_name='booktransaction',
            old_name='book_transacted',
            new_name='book',
        ),
        migrations.RenameField(
            model_name='booktransaction',
            old_name='borrower',
            new_name='transactor',
        ),
        migrations.RemoveField(
            model_name='booktransaction',
            name='buyer',
        ),
        migrations.RemoveField(
            model_name='booktransaction',
            name='library',
        ),
    ]
