import java.util.InputMismatchException;

public class CinemaApp implements Interface {

    private static final int SHOW_MOVIES = 1;
    private static final int BUY_TICKET = 2;
    private static final int ADMIN_MENU = 3;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        MoviesCatalog.startedCatalog();
        firstChoice();
    }

    private static void printMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1 - Show available movies, 2 - Buy ticket, 3 - Menu for Admin, 0 - Exit");
    }

    static int firstChoice() {
        int firstChoice = 0;
        boolean wrongSelect = true;
        do {
            do {
                try {
                    printMenu();
                    firstChoice = scan.nextInt();
                    scan.nextLine();
                    wrongSelect = false;
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.err.println("Please choose a number.");
                    firstChoice();
                }
            } while (wrongSelect);
            selectedOption(firstChoice);
        } while (firstChoice != EXIT);
        return firstChoice;
    }

    private static void selectedOption(int userChoice) {
        switch (userChoice) {
            case SHOW_MOVIES:
                Logic.printSeanceByMovie();
                break;
            case BUY_TICKET:
                Seance.purchaseConfirmation();
                break;
            case ADMIN_MENU:
                Admin.adminAccess();
                break;
            case EXIT:
                System.out.println("This is the end of the program.");
                break;
            default:
                System.out.println("Please choose a right number.");
                firstChoice();
        }
    }
}
