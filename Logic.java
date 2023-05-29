public class Logic implements Interface {

    public static void printSeanceByMovie() {
        int selectedMovie = selectingMovie();
        showingSeance(selectedMovie);
    }

    public static int selectingMovie() {
        MoviesCatalog.printAllMovies();
        String userChoice = scan.nextLine();
        try {
            int userChoiceToInt = Integer.parseInt(userChoice);
            if (userChoiceToInt > MoviesCatalog.movieList.size() || userChoiceToInt < 0) {
                System.out.println("Wrong number, try again.");
                return selectingMovie();
            } else
                return userChoiceToInt;
        } catch (NumberFormatException e) {
            userChoice = userChoice.trim();
            userChoice = userChoice.substring(0, 1).toUpperCase() + userChoice.substring(1).toLowerCase();
            for (int i = 0; i < MoviesCatalog.movieList.size(); i++) {
                if (MoviesCatalog.movieList.get(i).getTitle().equals(userChoice)) {
                    return i + 1;
                }
            }
            System.out.println("There is no such a movie, please try again.");
        }
        return selectingMovie();
    }

    public static void showingSeance(int number) {
        if (number == EXIT) {
            System.out.println("Returning to previous menu.");
            return;
        }
        Movie movie = MoviesCatalog.movieList.get(number - 1);
        int counter = 1;
        System.out.println(movie.getTitle() + " - available seances:");
        for (int i = 0; i < movie.getDatesList().size(); i++) {
            System.out.println(counter++ + ". " + movie.getDatesList().get(i));
        }
    }

    public static int selectingSeance(int number) {
        if (number == EXIT) {
            selectingMovie();
        }
        Movie movie = MoviesCatalog.movieList.get(number - 1);
        int counter = 1;
        System.out.println(movie.getTitle() + " - available seances:");
        for (int i = 0; i < movie.getDatesList().size(); i++) {
            System.out.println(counter++ + ". " + movie.getDatesList().get(i));
        }
        System.out.println("Select seance:");
        return scan.nextInt();
    }
}
