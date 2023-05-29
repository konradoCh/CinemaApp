public class Ticket implements Interface {
    final Person person;

    private final int selectedRow;
    private final int selectedSeat;

    public Ticket(Person person, int selectedRow, int selectedSeat) {
        this.person = person;
        this.selectedRow = selectedRow;
        this.selectedSeat = selectedSeat;

    }

    @Override
    public String toString() {
        return person +
                ", Row = " + (selectedRow + 1)+
                ", Seat = " + (selectedSeat + 1);
    }
}
