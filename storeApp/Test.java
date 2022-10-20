package furkan.storeApp;

import furkan.storeApp.entity.Book;
import furkan.storeApp.entity.MusicCD;
import furkan.storeApp.person.Admin;
import furkan.storeApp.person.Customer;
import furkan.storeApp.services.BookService;
import furkan.storeApp.services.MusicCdService;
import furkan.storeApp.types.MemberType;
import furkan.storeApp.visit.Visit;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Test {
    static BookService bookService = new BookService();
    static MusicCdService musicCdService = new MusicCdService();
    static List<MusicCD> musicCDList;
    static List<Book> bookList;
    static Scanner scanner;
    static Customer customerMember = new Customer("Jack", MemberType.MEMBER);
    static Visit forMember = new Visit(new Date());
    static Customer customerNonMember = new Customer("Emily", MemberType.NON_MEMBER);
    static Visit forNonMember = new Visit(new Date());
    static Admin admin = new Admin("Bill", 3535);

    public static void main(String[] args) {
        loginMenu();
    }

    public static void customerMenu(Customer customer) {
        System.out.println("Type 1 for Book Menu");
        System.out.println("Type 2 for Music Cd Menu");
        int x = scanner.nextInt();
        if (x == 1) {
            bookMenu(customer);
        } else if (x == 2) {
            cdMenu(customer);
        }
    }

    public static void bookMenu(Customer customer) {
        scanner = new Scanner(System.in);
        bookList = bookService.getProductList();
        System.out.println("1: Add book to your cart");
        System.out.println("2: Remove book from your cart");
        int b = scanner.nextInt();
        if (String.valueOf(b).charAt(0) == '1') {
            for (Book book : bookList) {
                System.out.println(book.getId() + " - " + book.getName() + " - " + book.getExpense() + "$" + " - " + book.getStock() + " adet");
            }
            for (int a = 0; a < 9999; a++) {
                int id = scanner.nextInt();
                if (String.valueOf(id).charAt(0) == '9') {
                    paymentMenu(customer);
                    break;
                } else if (String.valueOf(id).charAt(0) == '0') {
                    customerMenu(customer);
                    break;
                } else if (String.valueOf(id).charAt(0) != '1') {
                    System.out.println("Wrong Id");
                    continue;
                }
                for (Book book : bookList) {
                    if (book.getId() == id) {
                        customer.getVisit().addProductItem(book);
                        customer.getVisit().printProductList();
                        book.removeStock();
                        System.out.println("\n" + "0: Back to Main Menu");
                        System.out.println("\n" + "9: Go to Pay");
                    }
                }
            }
        } else if (String.valueOf(b).charAt(0) == '2') {
            customer.getVisit().printProductList();
            for (int a = 0; a < 9999; a++) {
                int id = scanner.nextInt();
                if (String.valueOf(id).charAt(0) == '9') {
                    paymentMenu(customer);
                    break;
                } else if (String.valueOf(id).charAt(0) == '0') {
                    customerMenu(customer);
                    break;
                } else if (String.valueOf(id).charAt(0) != '1') {
                    System.out.println("Wrong Id");
                    continue;
                }
                for (Book book : bookList) {
                    if (book.getId() == id) {
                        customer.getVisit().removeProductItem(book.getId());
                        customer.getVisit().printProductList();
                        book.addStock();
                        System.out.println("\n" + "0: Back to Main Menu");
                        System.out.println("\n" + "9: Go to Pay");
                    }
                }
            }
        }
    }

    public static void cdMenu(Customer customer) {
        musicCDList = musicCdService.getProductList();
        scanner = new Scanner(System.in);
        System.out.println("1: Add Music Cd to Your Cart");
        System.out.println("2: Remove Music Cd From Your Cart");
        int b = scanner.nextInt();
        if (String.valueOf(b).charAt(0) == '1') {
            for (MusicCD musicCD : musicCDList) {
                System.out.println(musicCD.getId() + " - " + musicCD.getName() + " - " + musicCD.getExpense() + "$" + " - " + musicCD.getStock() + " adet");
            }
            scanner = new Scanner(System.in);
            for (int a = 0; a < 9999; a++) {
                int id = scanner.nextInt();
                if (String.valueOf(id).charAt(0) == '9') {
                    paymentMenu(customer);
                    break;
                } else if (String.valueOf(id).charAt(0) == '0') {
                    customerMenu(customer);
                    break;
                } else if (String.valueOf(id).charAt(0) != '2') {
                    System.out.println("Wrong Id");
                    continue;
                }
                for (MusicCD musicCD : musicCDList) {
                    if (musicCD.getId() == id) {
                        customer.getVisit().addProductItem(musicCD);
                        customer.getVisit().printProductList();
                        musicCD.removeStock();
                        System.out.println("\n" + "0: Back to Main Menu");
                        System.out.println("\n" + "9: Go to Pay");
                    }
                }
            }
        } else if (String.valueOf(b).charAt(0) == '2') {
            customer.getVisit().printProductList();
            scanner = new Scanner(System.in);
            for (int a = 0; a < 9999; a++) {
                int id = scanner.nextInt();
                if (String.valueOf(id).charAt(0) == '9') {
                    paymentMenu(customer);
                    break;
                } else if (String.valueOf(id).charAt(0) == '0') {
                    customerMenu(customer);
                    break;
                } else if (String.valueOf(id).charAt(0) != '2') {
                    System.out.println("Wrong Id");
                    continue;
                }
                for (MusicCD musicCD : musicCDList) {
                    if (musicCD.getId() == id) {
                        customer.getVisit().removeProductItem(musicCD.getId());
                        customer.getVisit().printProductList();
                        musicCD.addStock();
                        System.out.println("\n" + "0: Back to Main Menu");
                        System.out.println("\n" + "9: Go to Pay");
                    }
                }
            }
        }
    }

    public static void paymentMenu(Customer customer) {
        scanner = new Scanner(System.in);
        System.out.println("Total Amount: " + customer.getVisit().getTotalExpense());
        customer.checkOut();
        System.out.println("The Amount of Points You Get: " + customer.getPoint());
        System.out.println("0: Pay and Quit");
        int x = scanner.nextInt();
        if (String.valueOf(x).charAt(0) == '0') {
            System.out.println("Your Order is Complete");
        }

    }

    public static void adminMenu(Admin admin) {
        System.out.println("Type 1 for Book Menu");
        System.out.println("Type 2 for Music Cd Menu");
        Scanner y = new Scanner(System.in);
        int login = y.nextInt();
        if (String.valueOf(login).charAt(0) == '1') {
            adminBookMenu(admin);
        } else if (String.valueOf(login).charAt(0) == '2') {
            adminCdMenu(admin);
        }
    }

    public static void adminBookMenu(Admin admin) {
        bookList = bookService.getProductList();
        scanner = new Scanner(System.in);
        System.out.println("1: Delete Book");
        System.out.println("2: Add Book");
        int b = scanner.nextInt();
        if (String.valueOf(b).charAt(0) == '1') {
            for (Book book : bookList) {
                System.out.println(book.getId() + " - " + book.getName() + " - " + book.getExpense() + "$" + " - " + book.getStock() + " Pieces");
            }
            scanner = new Scanner(System.in);
            for (int a = 0; a < 9999; a++) {
                int id = scanner.nextInt();
                if (String.valueOf(id).charAt(0) == '0') {
                    adminMenu(admin);
                } else if (String.valueOf(id).charAt(0) == '9') {
                    break;
                } else if (String.valueOf(id).charAt(0) != '1') {
                    System.out.println("Wrong Id");
                    continue;
                }
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).getId() == id) {
                        bookService.deleteProduct(bookList, bookList.get(i), admin);
                        System.out.println("\n" + "0: Back to Main Menu");
                        System.out.println("9: Quit");
                    }
                }
                for (Book book : bookList) {
                    System.out.println("\n" + book.getId() + " - " + book.getName() + " - " + book.getExpense() + "$" + " - " + book.getStock() + " Pieces");
                }
            }
        }
        else if (String.valueOf(b).charAt(0) == '2') {
            for (Book book : bookList) {
                System.out.println(book.getId() + " - " + book.getName() + " - " + book.getExpense() + "$" + " - " + book.getStock() + " Pieces");
            }
            scanner = new Scanner(System.in);
            for (int a = 0; a < 9999; a++) {
                bookService.addProduct(bookList, bookService.createBook(), admin);
                System.out.println("\n" + "0: Back to Main Menu");
                System.out.println("9: Quit");

                int id = scanner.nextInt();

                if (String.valueOf(id).charAt(0) == '0') {
                    adminMenu(admin);
                } else if (String.valueOf(id).charAt(0) == '9') {
                    break;
                }

                for (Book book : bookList) {
                    System.out.println("\n" + book.getId() + " - " + book.getName() + " - " + book.getExpense() + "$" + " - " + book.getStock() + " Pieces");
                }
            }
        }
    }

    public static void adminCdMenu(Admin admin) {
        musicCDList = musicCdService.getProductList();
        scanner = new Scanner(System.in);
        System.out.println("1: Delete Music Cd");
        System.out.println("2: Add Music Cd");
        int b = scanner.nextInt();
        if (String.valueOf(b).charAt(0) == '1') {

            for (MusicCD musicCD : musicCDList) {
                System.out.println(musicCD.getId() + " - " + musicCD.getName() + " - " + musicCD.getExpense() + "$" + " - " + musicCD.getStock() + " Pieces");
            }
            scanner = new Scanner(System.in);
            for (int a = 0; a < 9999; a++) {
                int id = scanner.nextInt();
                if (String.valueOf(id).charAt(0) == '0') {
                    adminMenu(admin);
                } else if (String.valueOf(id).charAt(0) == '9') {
                    break;
                } else if (String.valueOf(id).charAt(0) != '2') {
                    System.out.println("Wrong Id");
                    continue;
                }
                for (int i = 0; i < musicCDList.size(); i++) {
                    if (musicCDList.get(i).getId() == id) {
                        musicCdService.deleteProduct(musicCDList, musicCDList.get(i), admin);
                        System.out.println("\n" + "0: Back to Main Menu");
                        System.out.println("9: Quit");
                    }
                }
                for (MusicCD musicCD : musicCDList) {
                    System.out.println("\n" + musicCD.getId() + " - " + musicCD.getName() + " - " + musicCD.getExpense() + "$" + " - " + musicCD.getStock() + " Pieces");
                }
            }
        } else if (String.valueOf(b).charAt(0) == '2') {
            for (MusicCD musicCD : musicCDList) {
                System.out.println(musicCD.getId() + " - " + musicCD.getName() + " - " + musicCD.getExpense() + "$" + " - " + musicCD.getStock() + " Pieces");
            }
            scanner = new Scanner(System.in);
            for (int a = 0; a < 9999; a++) {
                musicCdService.addProduct(musicCDList, musicCdService.createMusicCd(), admin);
                System.out.println("\n" + "0: Back to Main Menu");
                System.out.println("9: Quit");

                int id = scanner.nextInt();

                if (String.valueOf(id).charAt(0) == '0') {
                    adminMenu(admin);
                } else if (String.valueOf(id).charAt(0) == '9') {
                    break;
                }

                for (MusicCD musicCD : musicCDList) {
                    System.out.println("\n" + musicCD.getId() + " - " + musicCD.getName() + " - " + musicCD.getExpense() + "$" + " - " + musicCD.getStock() + " Pieces");
                }
            }
        }
    }

    public static void loginMenu() {
        scanner = new Scanner(System.in);
        System.out.println("0: Admin");
        System.out.println("1: Customer");
        int x = scanner.nextInt();
        if (String.valueOf(x).charAt(0) == '0') {
            adminMenu(admin);
        }
        if (String.valueOf(x).charAt(0) == '1') {
            System.out.println("1: Member");
            System.out.println("2: Non-Member");
            x = scanner.nextInt();
            if (String.valueOf(x).charAt(0) == '1') {
                customerMember.setVisit(forMember);
                customerMenu(customerMember);
            } else if (String.valueOf(x).charAt(0) == '2') {
                customerNonMember.setVisit(forNonMember);
                customerMenu(customerNonMember);
            }

        }

    }
}


