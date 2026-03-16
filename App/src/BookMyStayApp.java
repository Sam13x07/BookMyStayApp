import java.util.HashMap;
import java.util.Map;

abstract class Room {
    protected String type;
    protected double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
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

class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void updateAvailability(String type, int count) {
        inventory.put(type, count);
    }

    public void displayInventory() {
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Available: " + entry.getValue());
        }
    }
}

public class UseCase3InventorySetup {
    public static void main(String[] args) {
        System.out.println("BookMyStayApp - Version 3.0");
        System.out.println("---------------------------");

        RoomInventory hotelInventory = new RoomInventory();

        hotelInventory.addRoomType("Single Room", 10);
        hotelInventory.addRoomType("Double Room", 5);
        hotelInventory.addRoomType("Suite Room", 2);

        Room single = new SingleRoom();
        Room doubleRm = new DoubleRoom();
        Room suite = new SuiteRoom();

        single.displayDetails();
        System.out.println("Current Stock: " + hotelInventory.getAvailability(single.getType()));

        doubleRm.displayDetails();
        System.out.println("Current Stock: " + hotelInventory.getAvailability(doubleRm.getType()));

        suite.displayDetails();
        System.out.println("Current Stock: " + hotelInventory.getAvailability(suite.getType()));

        System.out.println("\n--- Final Inventory Status ---");
        hotelInventory.displayInventory();
    }
}