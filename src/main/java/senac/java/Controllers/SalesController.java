package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;

import senac.java.Domain.Sales;
import senac.java.Services.ResponseEndPoints;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class SalesController {

    static ResponseEndPoints res = new ResponseEndPoints();

    private static List<Sales> salesList = new ArrayList<>();
    public static class SalesHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = "";

            if ("GET".equals(exchange.getRequestMethod())){

                List<Sales> getAllFromArray = Sales.getAllSales(salesList);

                if(!getAllFromArray.isEmpty()){

                    Sales sales = new Sales();

                    for(Sales salesJson : getAllFromArray){
                        System.out.println("Imagem 1: " + salesJson.getImage());
                        System.out.println("Titulo: " + salesJson.getTitulo());
                        System.out.println("Subtitulo: " + salesJson.getSubtitulo());
                        System.out.println("");
                    }

                    System.out.println("getallfromarray"+getAllFromArray);
                    System.out.println("salesList"+salesList);

                    response = "Dados encontrados com sucesso";
                    res.enviarResponseJson(exchange, sales.arrayToJson(getAllFromArray), 201);
                }

                else{
                    response = "Dados não encontrados";
                    res.enviarResponse(exchange, response,405);
                }
            }

            else if ("POST".equals(exchange.getRequestMethod())){
                try(InputStream requestBody = exchange.getRequestBody()){
                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    Sales sales = new Sales(
                            json.getString("image"),
                            json.getString("titulo"),
                            json.getString("subtitulo")
                    );

                    salesList.add(sales);

                    res.enviarResponseJson(exchange, sales.toJson(), 200);
                }catch(Exception e){
                    response = e.toString();

                    System.out.println(response);
                    System.out.println("---------");

                    res.enviarResponse(exchange, response, 200);
                }
            }

            else if ("OPTIONS".equals(exchange.getRequestMethod())){
                exchange.sendResponseHeaders(204,-1);
                exchange.close();
                return;
            }
            else if ("DELETE".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de vendedor - DELETE";
                res.enviarResponse(exchange, response, 200);
            }
            else if ("PUT".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de vendedor - PUT";
                res.enviarResponse(exchange, response, 200);
            }
            else {
                response = "nao definido." + "O metodo utilizado foi: " + exchange.getRequestMethod() + " So aceitamos get, put, post e delete";
                res.enviarResponse(exchange, response, 405);
            }
        }
    }
}