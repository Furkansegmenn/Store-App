package furkan.storeApp.entity;

public class Product {

    private int stock = 0;
    private String name;
    private int Id;
    private int expense;

    Product(int Id, String name, int expense, int stock) {
        this.Id = Id;
        this.name = name;
        this.expense = expense;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getExpense() {
        return expense;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public void addStock() {
        this.stock += 1;
    }

    public void removeStock() {
        this.stock -= 1;
    }
}
