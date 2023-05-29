import java.util.*;


public class Seance implements Interface {

    //static Map<String, List<Date>> map = new HashMap<>();

    static List<Seance> seancesList = new ArrayList<>();
    private final Movie movie;
    private final Date date;

    public Seance(Movie movie, Date date) {
        this.movie = movie;
        this.date = date;
        seancesList.add(this);
        movie.addDateToList(date);
        //map.put(movie.getTitle(), movie.getDatesList());
    }

    public static void purchaseConfirmation() {
        int selectedMovieNumber = Logic.selectingMovie();
        if (selectedMovieNumber == EXIT) {
            System.out.println("Returning to previous menu..");
            return;
        }
        Movie selectedMovie = MoviesCatalog.movieList.get(selectedMovieNumber - 1);
        System.out.println(selectedMovie);
        System.out.println("Do you want to buy ticket for this movie?");
        System.out.println("(Y)es for yes or 0 to exit.");
        String choice = scan.nextLine();
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            try {
                int selectedSeance = Logic.selectingSeance(selectedMovieNumber);
                Date seanceByDate = selectedMovie.getDatesList().get(selectedSeance-1);
                seanceByDate.getScreeningRoom().printScreeningRoom();
                seanceByDate.getScreeningRoom().reservingSeat();
                seanceByDate.addTicket();
            } catch (InputMismatchException e) {
                System.out.println("Please enter the number.");
                scan.nextLine();
                purchaseConfirmation();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Wrong number. Try again.");
                scan.nextLine();
                purchaseConfirmation();
            }
        } else if (choice.equals(String.valueOf(EXIT))) {
            System.out.println("Purchase cancelled.");
            purchaseConfirmation();
        } else {
            System.out.println(("Please choose correct option."));
            purchaseConfirmation();
        }

    }

    @Override
    public String toString() {
        return "seance: " +
                "title: " + movie +
                ", date: " + date;
    }
}
