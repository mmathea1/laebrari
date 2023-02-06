# Generated by Django 3.2.14 on 2023-02-02 14:10

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('user_library', '0002_initial'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='booktransaction',
            name='book',
        ),
        migrations.RemoveField(
            model_name='booktransaction',
            name='patron',
        ),
        migrations.AlterUniqueTogether(
            name='userlibrary',
            unique_together=None,
        ),
        migrations.RemoveField(
            model_name='userlibrary',
            name='librarian',
        ),
        migrations.DeleteModel(
            name='Book',
        ),
        migrations.DeleteModel(
            name='BookTransaction',
        ),
        migrations.DeleteModel(
            name='UserLibrary',
        ),
    ]
