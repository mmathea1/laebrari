# Generated by Django 3.2.9 on 2022-09-30 11:15

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('user_library', '0019_auto_20220930_1034'),
    ]

    operations = [
        migrations.AlterField(
            model_name='userlibrary',
            name='type',
            field=models.CharField(blank=True, choices=[('PRIVATE', 'PRIVATE'), ('PUBLIC', 'PUBLIC'), ('UNLISTED', 'UNLISTED')], default=('PRIVATE', 'PRIVATE'), max_length=255, null=True),
        ),
    ]
