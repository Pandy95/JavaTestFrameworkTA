package classes;

public class Product {

    private String name;

    private int price;

    public Product(){
        name = "default_name";
        price = 0;
    }

    public  Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getPrice(){return price;}
    public void setPrice(int price){this.price = price;}
}
