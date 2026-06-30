package oops.Entities;



//### Book
//- Has: id, title, author, genre, year, total copies, available copies
//- Two ways to create a book: minimal (title, author) and full (title, author, genre, year, copies)
//- Two books are considered the same if their id matches, regardless of other field values
//- Needs a readable printed form for logging and display


public class Book {

    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;
    public static int TOTAL_COPIES;
    public static int AVAILABLE_COPIES;

    public Book(String title , String author){
        this.title = title;
        this.author = author;
    }

    public Book(String title , String author, String genre , int year , int copies){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        AVAILABLE_COPIES = copies;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return this.getId() == book.getId();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}
