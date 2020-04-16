package edu.upc.dsa.models;

public class Product {
    private String id;
    private String name;

    public Product(){}
    public Product(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){return this.id;}
    public void setId(String id){this.id=id;}

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    @Override
    public String toString(){return "id:"+this.getId()+"|name:"+this.getName();}
}
