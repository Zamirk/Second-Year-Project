package Model.Objects;

/**
 * Created by x00110033 on 15/04/2015.
 */
public class SingleRating {
         String barcode = "";
        String rating = "";

        public SingleRating(String b, String r){
            barcode = b;
            rating = r;
        }
        public String getBarcode() {
            return barcode;
        }
        public String getRating() {
            return rating;
        }
        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }
        public void setRating(String rating) {
            this.rating = rating;
        }
}
