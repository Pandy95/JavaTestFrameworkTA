package classes;

import org.openqa.selenium.WebElement;

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
    public void setName(WebElement name){
        this.name = name.getText();
    }
    public Integer getPrice(){return price;}
    public void setPrice(WebElement price) {
        this.price = Integer.parseInt(price.getText()
                .replaceAll(" ", "")
                .split("U", 2)[0]);
    }
}
