import java.util.*;

abstract class Booking {
    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double fare();

    double total() {
        return fare() + 50;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 2;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double fare() {
        return 2500 + distance * 4;
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking;

            if (mode.equals("BUS")) {
                booking = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new Train(distance);
            } else {
                booking = new Flight(distance);
            }

            System.out.printf("%s: %.2f%n", mode, booking.total());
        }

        sc.close();
    }
}
