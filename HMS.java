import java.io.*;
import java.util.*;



class HotelManagementSystem {
    private List<Room> roomList = new ArrayList<>();
    private static final String ROOMS_FILE = "rooms.txt";

    public HotelManagementSystem() {
        loadRooms();
    }

    public void loadRooms() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ROOMS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int roomNumber = Integer.parseInt(parts[0].trim());
                    String roomType = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    boolean isAvailable = Boolean.parseBoolean(parts[3].trim());
                    Room room = new Room(roomNumber, roomType, price, isAvailable);
                    roomList.add(room);
                }
            }
            System.out.println("Rooms loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading room data: " + e.getMessage());
        }
    }

    public void saveRooms() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ROOMS_FILE))) {
            for (Room room : roomList) {
                writer.write(room.getRoomNumber() + "," + room.getRoomType() + "," + room.getPrice() + "," + room.isAvailable());
                writer.newLine();
            }
            System.out.println("Rooms data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving room data: " + e.getMessage());
        }
    }

    public double calculateTotalAmount(int roomNumber) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                return room.getPrice();
            }
        }
        return -1.0; // Return -1 to indicate room not found or not available
    }

    public void bookRoomByType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the room type you want to book (e.g., Single, Deluxe, Suite, Luxury): ");
        String roomType = scanner.nextLine();
        
        List<Room> availableRooms = new ArrayList<>();

        for (Room room : roomList) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }

        if (availableRooms.isEmpty()) {
            System.out.println("No " + roomType + " rooms are available.");
        } else {
            System.out.println("Available " + roomType + " Rooms:");
            for (Room room : availableRooms) {
                System.out.println(room);
            }

            System.out.print("Enter the room number you want to book (Type: " + roomType + "): ");
            int roomNumberToBook = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            boolean roomFound = false;
            for (Room room : availableRooms) {
                if (room.getRoomNumber() == roomNumberToBook) {
                    room.setAvailable(false);
                    roomFound = true;
                    System.out.println("Room " + roomNumberToBook + " (Type: " + roomType + ") booked successfully.");
                    saveRooms();
                    break;
                }
            }

            if (!roomFound) {
                System.out.println("Room " + roomNumberToBook + " is not available or does not exist.");
            }
        }
    }

    public void cancelBooking(int roomNumber) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == roomNumber && !room.isAvailable()) {
                room.setAvailable(true);
                System.out.println("Booking for Room " + roomNumber + " canceled successfully.");
                saveRooms();
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not booked or does not exist.");
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : roomList) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public static void main(String[] args) {
        HotelManagementSystem hotelSystem = new HotelManagementSystem();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nHotel Management System Menu:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room(s)");
            System.out.println("3. Book Room by Type");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Calculate Total Amount");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    hotelSystem.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter the number of rooms you want to book: ");
                    int numRoomsToBook = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    hotelSystem.bookRoom(numRoomsToBook);
                    break;
                case 3:
                    hotelSystem.bookRoomByType();
                    break;
                case 4:
                    System.out.print("Enter the room number you want to cancel the booking for: ");
                    int cancelRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    hotelSystem.cancelBooking(cancelRoomNumber);
                    break;
                case 5:
                    System.out.print("Enter the room number to calculate total amount: ");
                    int calcRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    double calcTotalAmount = hotelSystem.calculateTotalAmount(calcRoomNumber);
                    if (calcTotalAmount >= 0) {
                        System.out.println("Total Amount: $" + calcTotalAmount);
                    } else {
                        System.out.println("Room " + calcRoomNumber + " is not available or does not exist.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the Hotel Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
public void bookRoom(int numRoomsToBook) {
    Scanner scanner = new Scanner(System.in);
    List<Integer> bookedRoomNumbers = new ArrayList<>();
    double totalAmount = 0.0;

    for (int i = 0; i < numRoomsToBook; i++) {
        System.out.print("Enter the room number for booking (Room " + (i + 1) + "/" + numRoomsToBook + "): ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Room roomToBook = findRoom(roomNumber);
        if (roomToBook != null && roomToBook.isAvailable()) {
            roomToBook.setAvailable(false);
            bookedRoomNumbers.add(roomNumber);
            totalAmount += roomToBook.getPrice();
        } else {
            System.out.println("Room " + roomNumber + " is not available or does not exist. Try again.");
            i--; // Decrement i to re-enter the room number
        }
    }

    if (bookedRoomNumbers.isEmpty()) {
        System.out.println("No rooms were booked.");
    } else {
        System.out.println("Rooms booked successfully: " + bookedRoomNumbers);
        System.out.println("Total Amount: $" + totalAmount); // Display the total bill
        saveRooms();
    }
}

private Room findRoom(int roomNumber) {
    for (Room room : roomList) {
        if (room.getRoomNumber() == roomNumber) {
            return room;
        }
    }
    return null; // Room not found
}

}