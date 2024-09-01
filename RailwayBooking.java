import java.util.ArrayList;
import java.util.Scanner;

class Train {
    String trainName;
    int trainNumber;
    int availableSeats;

    Train(String trainName, int trainNumber, int availableSeats) {
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.availableSeats = availableSeats;
    }

    void displayTrainInfo() {
        System.out.println("Train Number: " + trainNumber + ", Train Name: " + trainName + ", Available Seats: " + availableSeats);
    }
}

class Booking {
    String passengerName;
    int trainNumber;
    int seatsBooked;

    Booking(String passengerName, int trainNumber, int seatsBooked) {
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.seatsBooked = seatsBooked;
    }

    void displayBookingInfo() {
        System.out.println("Passenger Name: " + passengerName + ", Train Number: " + trainNumber + ", Seats Booked: " + seatsBooked);
    }
}

public class RailwayBookingApp {
    static ArrayList<Train> trains = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addDummyData();
        int choice;

        do {
            System.out.println("\n--- Railway Booking System ---");
            System.out.println("1. View Available Trains");
            System.out.println("2. Book a Ticket");
            System.out.println("3. View My Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableTrains();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    viewMyBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the Railway Booking System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    static void addDummyData() {
        trains.add(new Train("Express 101", 101, 50));
        trains.add(new Train("FastTrack 202", 202, 30));
        trains.add(new Train("SuperFast 303", 303, 20));
    }

    static void viewAvailableTrains() {
        System.out.println("\n--- Available Trains ---");
        for (Train train : trains) {
            train.displayTrainInfo();
        }
    }

    static void bookTicket() {
        System.out.print("\nEnter your name: ");
        scanner.nextLine(); // consume the newline
        String name = scanner.nextLine();
        System.out.print("Enter Train Number: ");
        int trainNumber = scanner.nextInt();
        System.out.print("Enter Number of Seats to Book: ");
        int seats = scanner.nextInt();

        Train selectedTrain = null;
        for (Train train : trains) {
            if (train.trainNumber == trainNumber) {
                selectedTrain = train;
                break;
            }
        }

        if (selectedTrain != null) {
            if (selectedTrain.availableSeats >= seats) {
                selectedTrain.availableSeats -= seats;
                bookings.add(new Booking(name, trainNumber, seats));
                System.out.println("Booking successful! " + seats + " seats booked on Train " + selectedTrain.trainName);
            } else {
                System.out.println("Sorry, not enough seats available.");
            }
        } else {
            System.out.println("Train not found!");
        }
    }

    static void viewMyBookings() {
        System.out.println("\n--- Your Bookings ---");
        for (Booking booking : bookings) {
            booking.displayBookingInfo();
        }
    }
}
