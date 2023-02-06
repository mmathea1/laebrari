from django.contrib.auth import get_user_model, get_user
from django.test import TestCase
from rest_framework.test import APIClient
from rest_framework.authtoken.models import Token
from rest_framework.reverse import reverse


User = get_user_model()
client = APIClient()
# Create your tests here.
class TestCustomUserManager(TestCase):
    def test_create_user(self):
        user = User.objects.create_user(username='fooUser', email='test@example.com', password='foo')
        self.assertEqual(user.email, 'test@example.com')
        self.assertEqual(user.username, 'fooUser')
        self.assertTrue(user.is_active)
        self.assertFalse(user.is_superuser)
        self.assertFalse(user.is_staff)

        try:
            self.assertIsNotNone(user.username)
            self.assertIsNotNone(user.email)
            self.assertIsNotNone(user.password)
        except AttributeError:
            pass
        with self.assertRaises(TypeError):
            User.objects.create_user()
    
    def test_create_superuser(self):
        admin_user = User.objects.create_superuser(username='admin', password='foo', email='test@example.com')
        self.assertEqual(admin_user.username, 'admin')
        self.assertEqual(admin_user.email, 'test@example.com')
        self.assertTrue(admin_user.is_superuser)
        self.assertTrue(admin_user.is_staff)
        self.assertTrue(admin_user.is_active)

        try:
            self.assertIsNotNone(admin_user.username)
        except AttributeError:
            pass
        with self.assertRaises(ValueError):
            User.objects.create_superuser(username='admin', email='test@example.com', password='foo', is_superuser=False)


class UrlTestCase(TestCase):
    # login url does not allow GET request
    def test_login_url(self):
        response = self.client.get('/login/')
        self.assertEqual(response.status_code, 405)
     # register url does not allow GET request
    def test_register_url(self):
        response = self.client.get('/register/')
        self.assertEqual(response.status_code, 405)

class RegisterTestCase(TestCase):

    def setUp(self):
        self.username = 'fooUser'
        self.password = 'fooPassword'
        self.email = 'foo@example.com'
        self.user = User.objects.create_user(username=self.username, password=self.password, email=self.email)
        self.user.set_password(self.password)
        self.user.save()
    
    def tearDown(self):
        users=User.objects.filter(username=self.username)
        for u in users:
            u.delete()
  

    def test_register(self):
        response = self.client.post(reverse('register'), data={
            'username':'foo', 
            'email':'foo1@example.com', 
            'password':'password1', 
            'first_name':'test', 
            'last_name':'name',
            'password2': 'password1'
        })
        token = Token.objects.get(user=User.objects.get(username='foo'))
        self.assertIsNotNone(User.objects.get(username='foo'))
        self.assertIsNotNone(token)
        self.assertEqual(response.status_code, 201)
        self.assertEqual(response.data, {'token':token.key, 'email':'foo1@example.com', 'username':'foo'})


    def test_login(self):
        self.assertFalse(get_user(self.client).is_authenticated)
        response = self.client.post('/login/', {'username':self.username, 'password':self.password})
        self.client.login(username=self.username, password=self.password)
        token = Token.objects.get(user=User.objects.get(username=self.username))
        self.assertTrue(get_user(self.client).is_authenticated)
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.data, {'email': self.email, 'token':token.key})


