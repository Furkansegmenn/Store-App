package furkan.storeApp.entity;

public class Book extends Product {
    private String author;

    public Book(int Id, String name, int expense, String author, int stock) {
        super(Id, name, expense, stock);
        this.author = author;
    }

    public String getBookAuthor() {
        return author;
    }

    public void setBookAuthor(String bookAuthor) {
        this.author = bookAuthor;
    }
}
