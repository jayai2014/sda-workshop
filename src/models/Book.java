package models;

public class Book {
    String isbn;
    String author;
    String title;
    String syllabus;
    int price;

    public Book(String isbn, String author, String title, String syllabus, int price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.syllabus = syllabus;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", price=" + price +
                '}';
    }
}
