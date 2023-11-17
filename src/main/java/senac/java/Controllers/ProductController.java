package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;

import senac.java.Domain.Product;
import senac.java.Services.ResponseEndPoints;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class ProductController {

    public static ResponseEndPoints res = new ResponseEndPoints();

    private static List<Product> productList = new ArrayList<>();
    public static class ProductsHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = "";

            if ("GET".equals(exchange.getRequestMethod())){

                List<Product> getAllFromArray = Product.getAllProduct(productList);

                if(!getAllFromArray.isEmpty()){

                    Product product = new Product();

                    for(Product productJson : getAllFromArray){
                        System.out.println("Nome: " + productJson.getpName());
                        System.out.println("Preço: " + productJson.getpPrice());
                        System.out.println("Cor: " + productJson.getpColor());
                        System.out.println("Descrição: " + productJson.getpDescription());
                        System.out.println("Quantidade: " + productJson.getpQuantity());
                        System.out.println("Imagem :" + productJson.getImg());

                        System.out.println("");
                    }

                    System.out.println("getallfromarray" + getAllFromArray);
                    System.out.println("productList" + productList);

                    response = "Dados encontrados com sucesso";
                    res.enviarResponseJson(exchange, product.arrayToJson(getAllFromArray), 201);
                }

                else{
                    response = "Dados não encontrados";
                    res.enviarResponse(exchange, response,405);
                }
            }

            else if ("POST".equals(exchange.getRequestMethod())){
                try(InputStream requestBody = exchange.getRequestBody()){
                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    Product product = new Product(
                            json.getString("pName"),
                            json.getString("pPrice"),
                            json.getString("pColor"),
                            json.getString("pDescription"),
                            json.getInt("pQuantity"),
                            json.getString("img")
                    );

                    productList.add(product);

                    res.enviarResponseJson(exchange, product.toJson(), 200);
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

