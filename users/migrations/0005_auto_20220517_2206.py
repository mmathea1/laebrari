# Generated by Django 3.2.9 on 2022-05-17 22:06

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion
import django.utils.timezone


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0004_user_confirm_password'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='user',
            name='confirm_password',
        ),
        migrations.RemoveField(
            model_name='user',
            name='location',
        ),
        migrations.RemoveField(
            model_name='user',
            name='phone_number',
        ),
        migrations.AlterField(
            model_name='user',
            name='date_joined',
            field=models.DateTimeField(default=django.utils.timezone.now, verbose_name='date joined'),
        ),
        migrations.CreateModel(
            name='Librarian',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('date_joined', models.DateTimeField(auto_now_add=True, null=True, verbose_name='Date joined')),
                ('location', models.CharField(max_length=255)),
                ('address', models.CharField(max_length=255)),
                ('phone_number', models.CharField(max_length=255)),
                ('user', models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, to=settings.AUTH_USER_MODEL)),
            ],
        ),
    ]