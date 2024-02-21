import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();

        while (true) {
            boolean running = mainPage(system);
            if(!running) {
                System.out.println("Quitting.");
                break;
            }
        }

    }
    private static boolean mainPage(RegistrationSystem system) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("----- MAIN PAGE -----");
        System.out.println("1 for log in");
        System.out.println("2 for sign up");
        System.out.println("q for quit");

        loop:
        while (true) {
            System.out.print("Enter: ");
            choice = scanner.nextLine().trim(); // Trim leading/trailing whitespace

            switch (choice) {
                case "1":
                    loginPage(system);
                    break loop;
                case "2":
                    signupPage(system);
                    break loop;
                case "q":
                    return false;
                default:
                    System.out.print("Invalid input! ");
            }
        }
        return true;
    }


    private static void loginPage(RegistrationSystem system) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- LOGIN PAGE -----");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (system.hasUser(username)) {
            User user = system.getUser(username, password);
            if (user != null) {
                votePage(user);
            } else {
                System.out.println("Invalid password!");
            }
        } else {
            System.out.println("Invalid username!");
        }
        System.out.println("Returning..");
    }


    private static void signupPage(RegistrationSystem system) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- SIGN UP PAGE -----");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        while (system.hasUser(username)) {
            System.out.println("That username exists already! Select another.");
            System.out.print("Enter username: ");
            username = scanner.nextLine();
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("Are you sure to create a new user?");

        loop:
        while (true) {
            System.out.print("Enter [y/n]: ");
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "y": {
                        system.addUser(username, password);
                        System.out.println("Created successfully!");
                        break loop;
                }
                case "n":
                    break loop;
                default:
                    System.out.print("Invalid input! ");
            }
        }
        System.out.println("Returning..");
    }


    private static void votePage(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- VOTE PAGE -----");
        System.out.println("Select one of the followings: ");
        for (Vote vote: Vote.values()) {
            System.out.printf("%d for %s\n", vote.ordinal()+1, vote);
        }

        while (true) {
            System.out.print("Enter: ");
            String input = scanner.nextLine();
            if (!input.matches("\\d+")) {
                System.out.println("Invalid input! Please enter an integer.");
                continue;
            }

            int choice = Integer.parseInt(input);
            if (1 <= choice && choice <= Vote.values().length) {
                user.setVote(Vote.values()[choice-1]);
                System.out.println("Voted successfully!");
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid party number.");
            }
        }
    }
}


