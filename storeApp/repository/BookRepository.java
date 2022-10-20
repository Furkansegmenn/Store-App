package furkan.storeApp.repository;

import furkan.storeApp.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements ProductRepository<Book> {
    static int objectCount = 0;
    List<Book> bookList = new ArrayList<>();

    public BookRepository() {
        if (objectCount > 0) {
            throw new RuntimeException("Bu objeden daha fazla oluşturamazsınız.");
        }
        bookList.add(new Book(10001, "The Martian", 40, "Andy WEIR", 25));
        bookList.add(new Book(10002, "1984", 45, "George ORWELL", 20));
        bookList.add(new Book(10003, "The Metamorphosis", 35, "Franz KAFKA", 15));
        objectCount++;
    }

    @Override
    public void addProduct(Book product) {
        bookList.add(product);
    }

    @Override
    public void deleteProduct(int id) {
        Book bookForDelete = null;
        for (Book book : bookList) {
            if (book.getId() == id) {
                bookForDelete = book;
            }
        }
        bookList.remove(bookForDelete);
    }

    @Override
    public List<Book> getProductList() {
        return bookList;
    }
}
