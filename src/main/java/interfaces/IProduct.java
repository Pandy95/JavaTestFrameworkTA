package interfaces;

import classes.Product;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public interface IProduct {

    default List<WebElement> getAllProductName(){return null;}

    default List<WebElement> getAllProductPrice(){return null;}

    default List<Product> getProductsList(List<WebElement> listName, List<WebElement> listPrice) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < listName.size(); i++) {
            Product temp = new Product();
            temp.setName(listName.get(i));
            temp.setPrice(listPrice.get(i));
            productList.add(temp);
        }
        return productList;
    }
}
