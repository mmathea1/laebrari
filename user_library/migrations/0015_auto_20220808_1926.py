# Generated by Django 3.2.9 on 2022-08-08 19:26

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('user_library', '0014_auto_20220804_0245'),
    ]

    operations = [
        migrations.AlterField(
            model_name='book',
            name='book_condition',
            field=models.CharField(choices=[('NEW', 'NEW'), ('OLD', 'OLD'), ('GOOD CONDITION', 'GOOD CONDITION')], max_length=255),
        ),
        migrations.AlterField(
            model_name='book',
            name='genre',
            field=models.CharField(default='horror', max_length=255),
            preserve_default=False,
        ),
    ]