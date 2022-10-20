package furkan.storeApp.services;

import furkan.storeApp.authorization.Authority;
import furkan.storeApp.entity.Book;
import furkan.storeApp.person.User;
import furkan.storeApp.repository.BookRepository;

import java.util.List;
import java.util.Scanner;

public class BookService implements ProductService<Book> {
    BookRepository bookRepository = new BookRepository();

    @Override
    public void addProduct(List<Book> productList, Book product, User user) {
        if (!Authority.ADD_PRODUCT.userHasPermission(user)) {
            throw new RuntimeException("User don't have permission");
        }
        bookRepository.addProduct(product);
        System.out.println("Book Added Successfully");
    }

    @Override
    public void deleteProduct(List<Book> productList, Book product, User user) {
        if (!Authority.DELETE_PRODUCT.userHasPermission(user)) {
            throw new RuntimeException("User don't have permission");
        }
        bookRepository.deleteProduct(product.getId());
        System.out.println("Book deleted successfully");
    }

    @Override
    public List<Book> getProductList() {
        return bookRepository.getProductList();
    }

    public Book createBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id of book");
        int a = scanner.nextInt();
        String o = scanner.nextLine();
        System.out.println("Name of Book:");
        String b = scanner.nextLine();
        System.out.println("Expense of Book:");
        int c = scanner.nextInt();
        String z = scanner.nextLine();
        System.out.println("Author of Book");
        String d = scanner.nextLine();
        System.out.println("Stock of Book");
        int e = scanner.nextInt();

        return new Book(a, b, c, d, e);
    }


}
