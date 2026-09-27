class Room:
    def __init__(self, units):
        self.units = units

    def calculate_bill(self):
        return 0.0


class SingleRoom(Room):
    def calculate_bill(self):
        return self.units * 8


class SharedRoom(Room):
    def __init__(self, units, occupants):
        super().__init__(units)
        self.occupants = occupants

    def calculate_bill(self):
        return (self.units * 6) / self.occupants


class ACRoom(Room):
    def calculate_bill(self):
        return (self.units * 10) + 200


class Hostel:
    def __init__(self):
        self.rooms = []

    def add_room(self, room):
        self.rooms.append(room)

    def process_rooms(self):
        total = 0.0

        for room in self.rooms:
            bill = room.calculate_bill()
            print(f"{room.__class__.__name__.replace('Room', '').upper()}: {bill:.2f}")
            total += bill

        print(f"Total: {total:.2f}")


n = int(input())
hostel = Hostel()

for i in range(n):
    data = input().split()

    room_type = data[0]
    units = int(data[1])

    if room_type == "SINGLE":
        room = SingleRoom(units)
    elif room_type == "SHARED":
        occupants = int(data[2])
        room = SharedRoom(units, occupants)
    else:
        room = ACRoom(units)

    hostel.add_room(room)

hostel.process_rooms()
