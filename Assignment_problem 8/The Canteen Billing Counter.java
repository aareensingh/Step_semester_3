class Customer:
    def __init__(self, amount):
        self.amount = amount

    def calculate_amount(self):
        return self.amount


class Student(Customer):
    def calculate_amount(self):
        return self.amount * 0.90


class Staff(Customer):
    def calculate_amount(self):
        return self.amount * 0.95


class Guest(Customer):
    def calculate_amount(self):
        return self.amount + 10


class BillingCounter:
    def __init__(self):
        self.bills = []

    def add_bill(self, customer):
        self.bills.append(customer)

    def process_bills(self):
        total = 0.0

        for customer in self.bills:
            amount = customer.calculate_amount()
            print(f"{customer.__class__.__name__.upper()}: {amount:.2f}")
            total += amount

        print(f"Total: {total:.2f}")


n = int(input())
counter = BillingCounter()

for i in range(n):
    data = input().split()
    customer_type = data[0]
    amount = float(data[1])

    if customer_type == "STUDENT":
        customer = Student(amount)
    elif customer_type == "STAFF":
        customer = Staff(amount)
    else:
        customer = Guest(amount)

    counter.add_bill(customer)

counter.process_bills()
