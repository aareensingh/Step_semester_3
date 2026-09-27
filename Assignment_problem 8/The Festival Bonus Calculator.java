class Employee:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

    def calculate_bonus(self):
        return 0.0


class FullTime(Employee):
    def calculate_bonus(self):
        return self.salary * 0.10


class PartTime(Employee):
    def calculate_bonus(self):
        return self.salary * 0.05


class Intern(Employee):
    def calculate_bonus(self):
        return 2000.0


class PayrollSystem:
    def __init__(self):
        self.employees = []

    def add_employee(self, employee):
        self.employees.append(employee)

    def process_employees(self):
        total = 0.0

        for employee in self.employees:
            bonus = employee.calculate_bonus()
            print(f"{employee.name}: {bonus:.2f}")
            total += bonus

        print(f"Total Bonus: {total:.2f}")


n = int(input())
payroll = PayrollSystem()

for i in range(n):
    data = input().split()

    employee_type = data[0]
    name = data[1]
    salary = float(data[2])

    if employee_type == "FULLTIME":
        employee = FullTime(name, salary)
    elif employee_type == "PARTTIME":
        employee = PartTime(name, salary)
    else:
        employee = Intern(name, salary)

    payroll.add_employee(employee)

payroll.process_employees()
