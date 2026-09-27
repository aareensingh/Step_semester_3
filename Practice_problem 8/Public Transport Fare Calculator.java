class Transport:
    def __init__(self, distance):
        self.distance = distance

    def calculate_fare(self):
        return 0.0


class Bus(Transport):
    def calculate_fare(self):
        fare = 2 + (0.10 * self.distance)
        return min(fare, 10)


class Train(Transport):
    def calculate_fare(self):
        return 3 + (0.15 * self.distance)


class Metro(Transport):
    def __init__(self, distance, peak_hour_factor):
        super().__init__(distance)
        self.peak_hour_factor = peak_hour_factor

    def calculate_fare(self):
        return (1.50 + (0.20 * self.distance)) * self.peak_hour_factor


class TransportSystem:
    def __init__(self):
        self.journeys = []

    def add_journey(self, journey):
        self.journeys.append(journey)

    def process_journeys(self):
        total = 0.0

        for journey in self.journeys:
            fare = journey.calculate_fare()
            print(f"{journey.__class__.__name__.upper()}: {fare:.2f}")
            total += fare

        print(f"Total: {total:.2f}")


n = int(input())
system = TransportSystem()

for i in range(n):
    data = input().split()

    transport_type = data[0]
    distance = float(data[1])

    if transport_type == "BUS":
        journey = Bus(distance)
    elif transport_type == "TRAIN":
        journey = Train(distance)
    else:
        peak_hour_factor = float(data[2])
        journey = Metro(distance, peak_hour_factor)

    system.add_journey(journey)

system.process_journeys()
