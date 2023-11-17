package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Product {
    int id = 0;
    public String pName = "";
    public String pPrice = "";
    public String pColor = "";
    public String pDescription = "";
    public int pQuantity = 0;
    public String img = "";

    public Product() {
    }

    public Product(String pName, String pPrice, String pColor,
                   String pDescription, Integer pQuantity, String img){

        this.pName = pName;
        this.pPrice = pPrice;
        this.pColor = pColor;
        this.pDescription = pDescription;
        this.pQuantity = pQuantity;
        this.img = img;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpColor() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor = pColor;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();

        json.put("pName", pName);
        json.put("pPrice", pPrice);
        json.put("pColor", pColor);
        json.put("pDescription", pDescription);
        json.put("pQuantity", pQuantity);
        json.put("img", img);

        return json;
    }

    public JSONObject arrayToJson(List<Product> productList) {
        JSONObject json = new JSONObject();

        if (!productList.isEmpty()) {
            var keyJson = 1;

            for (Product product : productList) {

                JSONObject jsonFor = new JSONObject();

                jsonFor.put("pName", product.getpName());
                jsonFor.put("pPrice", product.getpPrice());
                jsonFor.put("pColor", product.getpColor());
                jsonFor.put("pDescription", product.getpDescription());
                jsonFor.put("pQuantity", product.getpQuantity());
                jsonFor.put("img", product.getImg());

                json.put(String.valueOf(keyJson), jsonFor);

                keyJson++;
            }
            return json;
        }

        else{
            return null;
        }
    }

    public static Product getProduct(int index, List<Product> productList){
        if(index >= 0 && index < productList.size())  {

            return productList.get(index);
        }

        else{
            return null;
        }
    }

    public static List<Product> getAllProduct(List<Product> productList){
    return productList;
    }
}