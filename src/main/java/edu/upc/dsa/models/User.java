package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private List<Product> productList;

    public User(){}
    public User(String id, String name){
        this.id = id;
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public String getId(){return this.id;}
    public void setId(String id){this.id=id;}

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    @Override
    public String toString(){return "id:"+this.getId()+"|name:"+this.getName();}
}
