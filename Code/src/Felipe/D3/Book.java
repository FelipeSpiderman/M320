package Felipe.D3;

public class Book {
    private String title;
    private boolean borrowed;

    public Book(String title) {
        this.title = title;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrow() throws InvalidInput {
        if (borrowed) {
            throw new InvalidInput("Das Buch ist bereits ausgeliehen: " + title);
        }
        borrowed = true;
    }

    public void giveBack() throws InvalidInput {
        if (!borrowed) {
            throw new InvalidInput("Das Buch war nicht ausgeliehen: " + title);
        }
        borrowed = false;
    }

    @Override
    public String toString() {
        return title + (borrowed ? " (ausgeliehen)" : " (verfügbar)");
    }
}
