class Vehicle:
    def __init__(self, hours):
        self.hours = hours

    def calculate_charge(self):
        return 0.0


class Bike(Vehicle):
    def calculate_charge(self):
        return self.hours * 10


class Car(Vehicle):
    def calculate_charge(self):
        if self.hours == 1:
            return 30
        return 30 + (self.hours - 1) * 20


class Truck(Vehicle):
    def calculate_charge(self):
        return max(self.hours * 50, 100)


class ParkingSystem:
    def __init__(self):
        self.vehicles = []

    def add_vehicle(self, vehicle):
        self.vehicles.append(vehicle)

    def process_vehicles(self):
        total = 0.0

        for vehicle in self.vehicles:
            charge = vehicle.calculate_charge()
            print(f"{vehicle.__class__.__name__.upper()}: {charge:.2f}")
            total += charge

        print(f"Total: {total:.2f}")


n = int(input())
parking = ParkingSystem()

for i in range(n):
    data = input().split()
    vehicle_type = data[0]
    hours = int(data[1])

    if vehicle_type == "BIKE":
        vehicle = Bike(hours)
    elif vehicle_type == "CAR":
        vehicle = Car(hours)
    else:
        vehicle = Truck(hours)

    parking.add_vehicle(vehicle)

parking.process_vehicles()
