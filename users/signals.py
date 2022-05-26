from django.dispatch import receiver
from django.db.models.signals import post_save
from users.models import User, Profile


@receiver(post_save, sender=User) 
def create_profile(sender, instance, created, **kwargs):
        if created:
            p = Profile.objects.create(user=instance)
            p.save()
