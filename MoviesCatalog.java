import java.util.*;

public class MoviesCatalog implements Interface {

    static List<Movie> movieList = new ArrayList<>();

    public static void startedCatalog() {
        Movie startedMovie = new Movie("Titanic");
        new Seance(startedMovie, new Date());
        new Seance(startedMovie, new Date());
        new Seance(new Movie("Inception"), new Date());
    }

    static void removeMovie() {
        System.out.println("Which movie do you want to remove? or press 0 to EXIT");
        printAllMovies();
        scan.nextLine();
        String removingMovie = scan.nextLine();

        if (removingMovie.equals(String.valueOf(EXIT))) {
            System.out.println("Returning to previous admin menu..");
            Admin.adminMenu();
            return;
        }

        try {
            Integer integerRemovingMovie = Integer.parseInt(removingMovie);
            removingByInteger(integerRemovingMovie);
        } catch (NumberFormatException e) {
            removingMovie = removingMovie.substring(0, 1).toUpperCase() + removingMovie.substring(1).toLowerCase();
            removingByString(removingMovie);
        }
    }

    public static void removingByInteger(Integer number) {
        if (number > movieList.size() || number < 0) {
            System.out.println("Please enter correct number or title.");
            removeMovie();
        }
        System.out.println("Are you sure to remove movie: " + movieList.get(number - 1));
        System.out.println("Confirm by yes:");
        if (!scan.nextLine().equalsIgnoreCase("yes")) {
            removeMovie();
        }
        System.out.println(movieList.get(number - 1) + " was removed.");
        movieList.remove(number - 1);
    }

    public static void removingByString(String removingMovie) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getTitle().equals(removingMovie)) {
                int number = i + 1;
                removingByInteger(number);
                return;
            }
        }
        System.out.println("There is no such a movie, please try again.");
        removeMovie();
    }

    public static void printAllMovies() {
        if (MoviesCatalog.movieList.size() == 0) {
            System.out.println("There are no movies in our cinema.");
            return;
        }
        System.out.println("Available movies in our cinema:");
        int counter = 1;
        for (Movie movie : movieList) {
            System.out.println(counter++ + ". " + movie);
        }
        System.out.println("Select movie by press movie's number or write title or press 0 to EXIT:");
    }
}

