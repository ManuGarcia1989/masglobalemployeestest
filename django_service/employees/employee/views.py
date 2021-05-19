from django.http import HttpResponseRedirect
from django.shortcuts import render
import time
# Create your views here.
from django.views.generic import ListView
from .models import *
import requests

class employeeView(ListView):
    model = historyFinder
    template_name = "employee.html"
    def get_context_data(self, **kwargs):
        context = super(employeeView, self).get_context_data(**kwargs)
        id = self.kwargs.get('id')
        url = "http://localhost:8080/api/v1/employee/" + str(id)
        try:
            response = requests.get(url)
            employee = response.json()
            url = "http://localhost:8080/api/v1/employee/salary/" + employee['cc']
            salary = requests.get(url)
            employee.update({"annualSalary": salary.json()})
            print(employee)
            context["employee"] = employee
            context["isEmpty"] = False
        except:
            context["isEmpty"] = True


        return context

def employeesView(request):
    try:
        response = requests.get("http://localhost:8080/api/v1/employees")
        response = response.json()
        for employee in response:
            url = "http://localhost:8080/api/v1/employee/salary/" + employee['cc']
            salary = requests.get(url)
            employee.update({"annualSalary": salary.json()})
        return render(request,"employees.html",{"employees": response,"isEmpty":False})
    except:
        return render(request, "employees.html", {"isEmpty": True})

class employeesFinderView(ListView):
    model = historyFinder
    template_name = "index.html"

    def get_context_data(self, **kwargs):
        context = super(employeesFinderView, self).get_context_data(**kwargs)
        return context

    def post(self, request, *args, **kwargs):
        if request.method == 'POST':
            id = request.POST.get('id')
            print(id)
            url =""
            time.sleep(1)
            if id != "" :
                url = "/employee/" + str(id)
            else:
                url = "/employees/"

            return HttpResponseRedirect(url)

