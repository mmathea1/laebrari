# Generated by Django 3.2.14 on 2023-10-19 10:26

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('user_library', '0006_auto_20231019_1023'),
    ]

    operations = [
        migrations.RenameModel(
            old_name='BookGenres',
            new_name='BookGenre',
        ),
    ]
