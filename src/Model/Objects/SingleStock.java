package Model.Objects;

/**
 * Created by x00110033 on 15/04/2015.
 */
public class SingleStock {
    String barcode = "";
    int quantity = 0;

    public SingleStock(String b, int q){
        barcode = b;
        quantity = q;
    }
    public String getBarcode() {
        return barcode;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}