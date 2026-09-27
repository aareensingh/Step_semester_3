from datetime import date, timedelta

class LibraryItem:
    def __init__(self, title):
        self.title = title

    def calculate_due_date(self, current_date):
        return current_date + timedelta(days=self.get_borrowing_days())

    def get_borrowing_days(self):
        return 0


class Book(LibraryItem):
    def get_borrowing_days(self):
        return 14


class DVD(LibraryItem):
    def get_borrowing_days(self):
        return 7


class Magazine(LibraryItem):
    def get_borrowing_days(self):
        return 3


class LibrarySystem:
    def __init__(self):
        self.items = []

    def add_item(self, item):
        self.items.append(item)

    def process_items(self, current_date):
        for item in self.items:
            due_date = item.calculate_due_date(current_date)
            print(f"{item.title}: {due_date.strftime('%Y-%m-%d')}")


n = int(input())
library = LibrarySystem()

for i in range(n):
    data = input().strip()
    item_type, title = data.split(" ", 1)
    title = title.strip('"')

    if item_type == "BOOK":
        item = Book(title)
    elif item_type == "DVD":
        item = DVD(title)
    else:
        item = Magazine(title)

    library.add_item(item)

current_date = date(2023, 10, 26)
library.process_items(current_date)
