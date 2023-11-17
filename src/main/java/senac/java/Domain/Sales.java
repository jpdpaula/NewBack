package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Sales {
    int id = 0;
    public String image = "";
    public String titulo = "";
    public String subtitulo = "";

    public Sales(){
    }

    public Sales(String image, String titulo, String subtitulo){

        this.image = image;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo){
        this.subtitulo = subtitulo;
    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();

        json.put("image", image);
        json.put("titulo", titulo);
        json.put("subtitulo", subtitulo);

        return json;
    }

    public JSONObject arrayToJson(List<Sales> salesList) {
        JSONObject json = new JSONObject();

        if (!salesList.isEmpty()) {
            var keyJson = 1;

            for (Sales sales : salesList) {

                JSONObject jsonFor = new JSONObject();

                jsonFor.put("image", sales.getImage());
                jsonFor.put("titulo", sales.getTitulo());
                jsonFor.put("subtitulo", sales.getSubtitulo());

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