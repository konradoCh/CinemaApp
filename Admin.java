import java.util.InputMismatchException;

public class Admin implements Interface {

    private static final String ADMIN_PASSWORD = "password";
    private static final int ADD_MOVIE = 1;
    private static final int REMOVE_MOVIE = 2;
    private static final int SHOW_MOVIES = 3;
    private static final int SHOW_TICKETS_LIST = 4;

    static void adminAccess() {
        System.out.println("Please enter the password or push 0 to EXIT.");
        String userPassword = scan.nextLine();
        if (userPassword.equals(String.valueOf(EXIT))) {
            System.out.println("Exit");
            return;
        }
        if (userPassword.equals(ADMIN_PASSWORD)) {
            adminMenu();
        } else {
            System.out.println("Wrong password.");
            adminAccess();
        }
    }

    static void adminMenu() {
        System.out.println("1 - Add movie, 2 - Remove movie, 3 - Show seance, 4- Show tickets list,  0 - EXIT");
        try {
            adminSelection(scan.nextInt());
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.err.println("Please choose a number.");
            adminMenu();
        }
    }

    private static void adminSelection(int choice) {
        switch (choice) {
            case ADD_MOVIE:
                scan.nextLine();
                addMovie();
                adminMenu();
                break;
            case REMOVE_MOVIE:
                MoviesCatalog.removeMovie();
                adminMenu();
                break;
            case SHOW_MOVIES:
                scan.nextLine();
                Logic.printSeanceByMovie();
                adminMenu();
                break;
            case SHOW_TICKETS_LIST:
                Date.showTicketsList();
                scan.nextLine();
                adminMenu();
                break;
            case EXIT:
                System.out.println("Returning to previous menu..");
                CinemaApp.firstChoice();
                break;
            default:
                System.out.println("Please choose right number.");
                adminMenu();
        }
    }

    private static void addMovie() {
        System.out.println("Enter title:");
        String title = scan.nextLine();
        title = title.trim();
        title = title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
        String date = addingDate();
        new Seance(new Movie(title), new Date(date));
        System.out.println("Added: " + title + ", date: " + date);
    }

    private static String addingDate() {
        System.out.println("Enter day of seance:");
        String day = scan.nextLine();
        System.out.println("Enter number of month:");
        String month = scan.nextLine();
        if (month.length() == 1 && !month.startsWith("0")) {
            month = "0" + month;
        }
        System.out.println("Enter year of seance:");
        String year = scan.nextLine();
        String date = year + "-" + month + "-" + day;
        return date;
    }
}
