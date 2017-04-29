package Model.Objects;

/**
 * Created by x00110033 on 15/04/2015.
 */
public class SingleItem {
    String item = "";
    String name = "";
    double price = 0.0;
    String category = "";
    String description = "";

    public SingleItem(String i, String n, double p, String c, String d){
        item = i;
        name = n;
        price = p;
        category = c;
        description = d;
    }

    public String getItem() {
        return item;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
