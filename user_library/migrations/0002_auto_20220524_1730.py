# Generated by Django 3.2.9 on 2022-05-24 17:30

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
        ('user_library', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='librarian',
            name='bio',
            field=models.TextField(blank=True, null=True),
        ),
        migrations.AddField(
            model_name='librarian',
            name='can_borrow',
            field=models.BooleanField(default=False, verbose_name='Can borrow a book'),
        ),
        migrations.AddField(
            model_name='librarian',
            name='can_loan',
            field=models.BooleanField(default=False, verbose_name='Can a book'),
        ),
        migrations.AddField(
            model_name='librarian',
            name='can_sell',
            field=models.BooleanField(default=False, verbose_name='Can sell a book'),
        ),
        migrations.AlterField(
            model_name='librarian',
            name='user',
            field=models.OneToOneField(null=True, on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL),
        ),
    ]