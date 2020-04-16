package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Product;

import java.util.List;

public interface GameManager {
    List<User> getSortedUsersAplhabetical();
    int numUsers();
    int numProducts();

    int addUser(String id, String name);
    int setUser(String id, String name);
    User getUser(String id);

    int addProduct(String id, String name);
    int setProduct(String id, String name);
    Product getProduct(String id);
}
