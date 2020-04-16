package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Product;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameManagerImpl implements GameManager {
    private static GameManager instance;
    private static HashMap<String, User> userMap;
    private static List<Product> productList;
    private static Logger log = Logger.getLogger(GameManagerImpl.class);

    private GameManagerImpl(){
        this.userMap = new HashMap<>();
        this.productList = new ArrayList<>();
    }

    public static GameManager getInstance(){
        if(instance == null) {instance = new GameManagerImpl();}
        return instance;
    }

    @Override
    public List<User> getSortedUsersAplhabetical() {
        return null;
    }

    @Override
    public int numUsers() {
        return 0;
    }

    @Override
    public int numProducts() {
        return 0;
    }

    @Override
    public int addUser(String id, String name) {
        try{
            User newUser = new User(id,name);
            this.userMap.put(id,newUser);
            log.info("User added: "+ newUser);
            return 201; //CREATED
        }
        catch (Exception e){
            log.error("Unexpected Exception");
            return 500;//INTERNAL SERVER ERROR
        }
    }

    @Override
    public int setUser(String id, String name) {
        User updatedUser = this.userMap.get(id);
        return 0;
    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public int addProduct(String id, String name) {
        try{
            Product newProduct = new Product(id,name);
            this.productList.add(newProduct);
            return 201; //CREATED
        }
        catch (Exception e){
            log.error("Unexpected Exception");
            return 500;//INTERNAL SERVER ERROR
        }
    }

    @Override
    public int setProduct(String id, String name) {
        return 0;
    }

    @Override
    public Product getProduct(String id) {
        return null;
    }
}
