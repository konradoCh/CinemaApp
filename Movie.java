import java.util.ArrayList;
import java.util.List;

public class Movie implements Interface {
    private final String title;
    private final List<Date> datesList;

    public Movie(String title) {
        this.title = title;
        datesList = new ArrayList<>();
        MoviesCatalog.movieList.add(this);
    }

    public String getTitle() {
        return title;
    }

    public List<Date> getDatesList() {
        return datesList;
    }

    public void addDateToList(Date date) {
        datesList.add(date);
    }

    @Override
    public String toString() {
        return title;
    }
}

