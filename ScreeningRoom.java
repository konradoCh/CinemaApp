public class ScreeningRoom implements Interface {

    static final int NUMBERS_OF_SEATS = 10;
    static final int NUMBERS_OF_ROWS = 6;
    final char[][] array = new char[NUMBERS_OF_ROWS][NUMBERS_OF_SEATS];
    int availableSeats = NUMBERS_OF_SEATS * NUMBERS_OF_ROWS;
    int reservedSeats = 0;

    private int selectedRow;
    private int selectedSeat;

    {
        for (int i = 0; i < NUMBERS_OF_ROWS; i++) {
            for (int j = 0; j < NUMBERS_OF_SEATS; j++) {
                array[i][j] = 'o';
            }
        }
    }

    void printScreeningRoom() {
        if (availableSeats == EXIT) {
            System.out.println("There is no available seats for this seance. ");
            return;
        }
        printLegend();
        printScreen();
        printRows();
        printSeatsNumbers();
        printSeatsText();
    }

    void printLegend() {
        System.out.println("o - available seat (" + availableSeats + ")");
        System.out.println("x - reserved seat (" + reservedSeats + ")");
    }

    void printScreen() {
        String seatsText = "|SCREEN|";
        String spaces = " ".repeat(NUMBERS_OF_SEATS * 2);
        System.out.print(spaces);

        for (int i = 0; i < seatsText.length(); i++) {
            System.out.printf("%1c ", seatsText.charAt(i));
        }
        System.out.println();
        System.out.print(spaces);
        for (int i = 0; i < seatsText.length(); i++) {
            System.out.printf("%1s ", "-");
        }
        System.out.println();
    }

    void printRows() {
        if (NUMBERS_OF_ROWS < 6) {
            System.err.println("You cannot create such a small screening room.");
            return;
        }

        String rowsText = "ROWS";
        int startRowsText = (NUMBERS_OF_ROWS - rowsText.length()) / 2;
        int textIter = 0;

        for (int i = 0; i < NUMBERS_OF_ROWS; i++) {
            if (i >= startRowsText && i <= rowsText.length()) {
                System.out.printf("%2c ", rowsText.charAt(textIter));
                textIter++;
            } else {
                System.out.printf("%2s ", " ");
            }
            System.out.printf("%3d ", i + 1);
            System.out.print("|");
            for (int j = 0; j < NUMBERS_OF_SEATS; j++) {
                System.out.printf("%3c ", array[i][j]);
            }
            System.out.println();
        }
    }

    void printSeatsNumbers() {
        for (int i = 0; i < NUMBERS_OF_SEATS; i++) {
            if (i == 0) {
                System.out.print("        "); // second indentation
            }
            System.out.printf("%3s ", "---");
        }
        System.out.println();
        System.out.print("        "); // first row indentation (for seats number)
        for (int i = 0; i < NUMBERS_OF_SEATS; i++) {
            System.out.printf("%3d ", i + 1);
        }
        System.out.println();
    }

    void printSeatsText() {
        String seatsText = "SEATS";
        String spaces = " ".repeat(NUMBERS_OF_SEATS * 2);
        System.out.print("  " + spaces);
        for (int i = 0; i < seatsText.length(); i++) {
            System.out.printf("%1c ", seatsText.charAt(i));
        }
        System.out.println();
    }

    void reservingSeat() {
        System.out.println("Which seat do you want to reserve?");
        System.out.println("Choose row number: (or press 0 to EXIT)");
        setSelectedRow(scan.nextInt() - 1);
        if (getSelectedRow() + 1 == EXIT) {
            System.out.println("Purchase cancelled.");
            CinemaApp.firstChoice();
        }
        System.out.println("Choose seat number:");
        setSelectedSeat(scan.nextInt() - 1);
        scan.nextLine();
        checkAvailability(getSelectedRow(), getSelectedSeat());
    }

    private void checkAvailability(int selectedRow, int selectedSeat) {

        if (array[selectedRow][selectedSeat] == 'x') {
            System.out.println("This seat is reserved. Select another seat.");
            reservingSeat();
        } else {
            array[getSelectedRow()][getSelectedSeat()] = 'x';
            reservedSeats++;
            availableSeats--;
        }
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public int getSelectedSeat() {
        return selectedSeat;
    }

    public void setSelectedSeat(int selectedSeat) {
        this.selectedSeat = selectedSeat;
    }
}

