package furkan.storeApp.visit;


import furkan.storeApp.entity.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Visit {
    final Date date;
    private double bookExpense;
    private double cdExpense;
    private double totalExpense;

    private List<Product> productList;


    public Visit(Date date) {
        this.date = date;
    }

    public double getBookExpense() {
        return bookExpense;
    }

    public double getCdExpense() {
        return cdExpense;
    }

    public double setTotalExpense() {

        totalExpense = getBookExpense() + getCdExpense();
        return totalExpense;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void addProductItem(Product product) {
        if (productList == null) {
            productList = new ArrayList<>();
        }
        if (productList.contains(product)) {
            System.out.println("You have already added this book to your cart");
            return;
        }
        productList.add(product);
        totalExpense += product.getExpense();
        System.out.println(product.getName() + " has been added your cart");
        System.out.println("Cart amount: " + totalExpense + "$");
    }

    public void removeProductItem(int id) {
        if (productList == null) {
            System.out.println("Your Cart is Empty");
        }
        Product prod = null;
        for (Product product : productList) {
            if (product.getId() == id) {
                prod = product;
            }
        }
        productList.remove(prod);
        totalExpense -= prod.getExpense();
        System.out.println(prod.getName() + " has been removed your cart");
        System.out.println("Cart amount: " + totalExpense + "$");
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void printProductList() {
        if (productList == null) {
            return;
        }
        System.out.print("[");
        if (productList.size() != 1) {
            for (Product product : productList) {
                if (!Objects.equals(product.getName(), productList.get(productList.size() - 1).getName())) {
                    System.out.print(product.getName() + " ,");
                } else {
                    System.out.print(product.getName());
                }
            }
        } else if (productList.size() == 1) {
            System.out.print(productList.get(0).getName());
        } else {
            System.out.print("Your cart is empty");
        }
        System.out.print("]");
    }
}

