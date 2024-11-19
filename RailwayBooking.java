import java.util.Scanner;
class Train {
    private int trainNumber;
    private String trainName;
    private int availableSeats;
    private double ticketPrice;

    public Train(int trainNumber, String trainName, int availableSeats, double ticketPrice) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public boolean bookTickets(int seats) {
        if (availableSeats >= seats) {
            availableSeats -= seats;
            return true;
        }
        return false;
    }
}

public class RailwayTicketBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Train train1 = new Train(101, "Express Line", 50, 300.0);
        Train train2 = new Train(102, "Super Fast", 30, 500.0);
        Train train3 = new Train(103, "Local Service", 100, 100.0);

        Train[] trains = {train1, train2, train3};

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Railway Ticket Booking System ---");
            System.out.println("1. View Available Trains");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Trains:");
                    for (Train train : trains) {
                        System.out.println("Train No: " + train.getTrainNumber() +
                                ", Name: " + train.getTrainName() +
                                ", Seats: " + train.getAvailableSeats() +
                                ", Price: $" + train.getTicketPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter Train Number: ");
                    int trainNumber = scanner.nextInt();
                    Train selectedTrain = null;

                    for (Train train : trains) {
                        if (train.getTrainNumber() == trainNumber) {
                            selectedTrain = train;
                            break;
                        }
                    }

                    if (selectedTrain != null) {
                        System.out.print("Enter Number of Tickets: ");
                        int seats = scanner.nextInt();
                        if (selectedTrain.bookTickets(seats)) {
                            System.out.println("Tickets Booked Successfully! Total Cost: $" + (seats * selectedTrain.getTicketPrice()));
                        } else {
                            System.out.println("Not enough seats available.");
                        }
                    } else {
                        System.out.println("Train not found.");
                    }
                    break;

                case 3:
                    exit = true;
                    System.out.println("Thank you for using the Railway Ticket Booking System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
