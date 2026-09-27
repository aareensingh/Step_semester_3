class Delivery:
    def __init__(self, weight, distance):
        self.weight = weight
        self.distance = distance

    def calculate_fee(self):
        return 0.0


class StandardDelivery(Delivery):
    def calculate_fee(self):
        return 5 + (0.50 * self.weight) + (0.10 * self.distance)


class ExpressDelivery(Delivery):
    def calculate_fee(self):
        return 15 + (1.00 * self.weight) + (0.20 * self.distance)


class InternationalDelivery(Delivery):
    def __init__(self, weight, distance, customs_fee):
        super().__init__(weight, distance)
        self.customs_fee = customs_fee

    def calculate_fee(self):
        return 25 + (2.00 * self.weight) + (0.50 * self.distance) + self.customs_fee


class DeliverySystem:
    def __init__(self):
        self.deliveries = []

    def add_delivery(self, delivery):
        self.deliveries.append(delivery)

    def process_deliveries(self):
        total = 0.0

        for delivery in self.deliveries:
            fee = delivery.calculate_fee()
            print(f"{delivery.__class__.__name__.replace('Delivery', '').upper()}: {fee:.2f}")
            total += fee

        print(f"Total: {total:.2f}")


n = int(input())
system = DeliverySystem()

for i in range(n):
    data = input().split()
    delivery_type = data[0]
    weight = float(data[1])
    distance = float(data[2])

    if delivery_type == "STANDARD":
        delivery = StandardDelivery(weight, distance)
    elif delivery_type == "EXPRESS":
        delivery = ExpressDelivery(weight, distance)
    else:
        customs_fee = float(data[3])
        delivery = InternationalDelivery(weight, distance, customs_fee)

    system.add_delivery(delivery)

system.process_deliveries()
