# Generated by Django 2.2.8 on 2021-05-18 04:04

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='historyFinder',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('id_employee', models.CharField(blank=True, max_length=100, null=True, verbose_name='Ingrese Nombre EPS')),
                ('date', models.DateField(blank=True, null=True, verbose_name='Date Find')),
            ],
        ),
    ]