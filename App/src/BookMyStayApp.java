abstract class Room {
    protected String type;
    protected double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public abstract void displayDetails();
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 100.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Type: " + type + " | Price: $" + price);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 180.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Type: " + type + " | Price: $" + price);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 350.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Type: " + type + " | Price: $" + price);
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("BookMyStayApp - Version 2.0");
        System.out.println("---------------------------");

        Room single = new SingleRoom();
        Room doubleRm = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        single.displayDetails();
        System.out.println("Available: " + singleAvailability);

        doubleRm.displayDetails();
        System.out.println("Available: " + doubleAvailability);

        suite.displayDetails();
        System.out.println("Available: " + suiteAvailability);
    }
}