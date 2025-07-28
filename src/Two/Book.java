package Two;

public class Book {
    private final String author;
    private final String title;
    private final int yearOfPublication;
    private final int pages;

    public Book(String author, String title, int yearOfPublication, int pages) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
    }

    public String title() {
        return title;
    }

    public int yearOfPublication() {
        return yearOfPublication;
    }

    public int pages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", pages=" + pages +
                '}';
    }
}
