from django.db import models

# Create your models here.
class historyFinder(models.Model):
    id_employee = models.CharField(max_length=100, blank=True, null=True, verbose_name= "Ingrese Nombre EPS")
    date = models.DateField(null=True, blank=True, verbose_name="Date Find")