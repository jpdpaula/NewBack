package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Sales {
    int id = 0;
    public String pImg = "";
    public  String pName = "";
    public  String pPrice = "";
    public  String pDescri = "";
    public Sales(){
    }

    public Sales(String pImg, String pName, String pPrice, String pDescri) {
        this.pImg = pImg;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pDescri = pDescri;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
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

    public String getpDescri() {
        return pDescri;
    }

    public void setpDescri(String pDescri) {
        this.pDescri = pDescri;
    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("pImg",pImg);
        json.put("pName", pName);
        json.put("pPrice", pPrice);
        json.put("pDescri",pDescri);


        return json;
    }

    public JSONObject arrayToJson(List<Sales> salesList) {
        JSONObject json = new JSONObject();

        if (!salesList.isEmpty()) {
            var keyJson = 0;

            for (Sales sales : salesList) {

                JSONObject jsonFor = new JSONObject();

                jsonFor.put("pImg", sales.getpImg());
                jsonFor.put("pName", sales.getpName());
                jsonFor.put("pPrice", sales.getpPrice());
                jsonFor.put("pDescri", sales.getpDescri());

                json.put(String.valueOf(keyJson), jsonFor);

                keyJson++;

            }
            return json;
        }

        else{
            return null;
        }
    }

    public static Sales getSales(int index, List<Sales> salesList){
        if(index >= 0 && index < salesList.size())  {

            return salesList.get(index);
        }

        else{
            return null;
        }
    }

    public static List<Sales> getAllSales(List<Sales> salesList){
        return salesList;
    }
}