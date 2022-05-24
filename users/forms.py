from django import forms
from django.contrib.auth.forms import UserCreationForm
from user_library.models import Profile
from users.models import User

class UserRegistrationForm(UserCreationForm):
    email = forms.EmailField(required=True)

    class Meta:
        model = User
        fields = ["username", "email", "password1", "password2"]
    
    def save(self, commit=True):
        user = super(UserRegistrationForm, self).save(commit=False)
        user.email = self.cleaned_data['email']
        if commit:
            user.save()
        return user
    
# Create a UserUpdateForm to update username and email
class UserUpdateForm(forms.ModelForm):
    # email = forms.EmailField(required=False)

    class Meta:
        model = User
        fields = ['username', 'email']

# Create a ProfileUpdateForm to update image
class ProfileUpdateForm(forms.ModelForm):

    class Meta:
        model = Profile
        fields = ['first_name', 'last_name',  'bio','phone_number', 'profile_picture',  'location', 'address']
