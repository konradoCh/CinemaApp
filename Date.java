import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Date implements Interface {
    static ZonedDateTime userZonedDateTimeNow = ZonedDateTime.now();
    static ZonedDateTime nextSeance = userZonedDateTimeNow.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
    private final String date;
    private final ScreeningRoom screeningRoom;
    private final List<Ticket> ticketList;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy", Locale.ENGLISH);

    public Date() {
        this.date = dateFormatter.format(nextSeance);
        nextSeance = nextSeance.plusDays(1);
        this.screeningRoom = new ScreeningRoom();
        this.ticketList = new ArrayList<>();
    }

    public Date(String date) {
        this.date = dateFormatter.format((LocalDate.parse(date)));
        this.screeningRoom = new ScreeningRoom();
        this.ticketList = new ArrayList<>();
    }

    public static void showTicketsList() {
        try {
            scan.nextLine();
            int selectedMovie = Logic.selectingMovie();
            int selectedSeanceNumber = Logic.selectingSeance(selectedMovie);
            List<Ticket> ticketList = MoviesCatalog.movieList.get(selectedMovie - 1).getDatesList().get(selectedSeanceNumber - 1).getTicketList();
            if (ticketList.isEmpty()) {
                System.out.println("Nobody bought ticket for this seance.");
            } else {
                for (Ticket ticket : ticketList) {
                    System.out.println(ticket);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Wrong number. Try again");
            scan.nextLine();
            showTicketsList();
        }
    }

    public void addTicket() {
        System.out.println("Enter your name:");
        String name = scan.nextLine();
        System.out.println("Enter your surname:");
        String surname = scan.nextLine();
        Person person = new Person(name, surname);
        Ticket ticket = new Ticket(person, screeningRoom.getSelectedRow(), screeningRoom.getSelectedSeat());
        ticketList.add(ticket);
        System.out.println("Reserved!");
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public ScreeningRoom getScreeningRoom() {
        return screeningRoom;
    }

    @Override
    public String toString() {
        return "" + date;
    }
}
