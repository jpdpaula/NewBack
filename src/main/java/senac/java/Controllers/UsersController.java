package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import org.json.JSONObject;

import senac.java.DAL.UserDal;
import senac.java.Domain.Users;
import senac.java.Services.Conexao;
import senac.java.Services.ResponseEndPoints;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

public class UsersController {

    public static String response = "";
    static ResponseEndPoints res = new ResponseEndPoints();

    private static List<Users> usersList = new ArrayList<>();

    public static class UsersHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            if ("GET".equals(exchange.getRequestMethod())) {
                doGet(exchange);
            } else if ("POST".equals(exchange.getRequestMethod())) {
                doPost(exchange);
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                doDelete(exchange);
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                doPut(exchange);
            } else if ("OPTIONS".equals(exchange.getRequestMethod())) {
                doOptions(exchange);
            } else {
                response = "nao definido." + "O metodo utilizado foi: " + exchange.getRequestMethod() + " So aceitamos get, put, post e delete";
                res.enviarResponse(exchange, response, 405);
            }
        }
    }

    public static void doGet(HttpExchange exchange) throws IOException {
        UserDal userDal = new UserDal();

        List<Users> getAllFromArray = Users.getAllUsers(usersList);

        if (!getAllFromArray.isEmpty()) {
            Users users = new Users();
            for (Users usersJson : getAllFromArray) {
                System.out.println("Nome: " + usersJson.getName());
                System.out.println("Sobrenome: " + usersJson.getLastName());
                System.out.println("Idade: " + usersJson.getAge());
                System.out.println("Endereço: " + usersJson.getAddress());
                System.out.println("Email: " + usersJson.getEmail());
                System.out.println("Cpf:" + usersJson.getCpf());

                System.out.println(" ");
            }

            try {
                userDal.listarUsuario();
            } catch (Exception e) {
                System.out.println("O erro foi: " + e);
            }

            System.out.println("getallfromarray" + getAllFromArray);
            System.out.println("usersList" + usersList);

            response = "Dados encontrados com sucesso";
            res.enviarResponseJson(exchange, users.arrayToJson(getAllFromArray), 201);
        } else {
            response = "Dados não encontrados";
            res.enviarResponse(exchange, response, 405);
        }
    }

    public static void doPost(HttpExchange exchange) throws IOException {
        UserDal userDal = new UserDal();

        try (InputStream requestBody = exchange.getRequestBody()) {
            JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));
            int resp = 0;

            Users users = new Users(
                    json.getString("nome"),
                    json.getString("lastName"),
                    json.getInt("age"),
                    json.getString("address"),
                    json.getString("email"),
                    json.getString("password"),
                    json.getString("cpf")
            );

            usersList.add(users);

            resp = userDal.inserirUsuario(users.name, users.lastName, users.age,
                    users.address, users.email, users.password, users.cpf);

            if (resp == 0) {
                response = "Houve um problema ao criar usuário";
            } else {
                response = "Usuário criado com sucesso";
            }

            res.enviarResponse(exchange, response, 200);
        } catch (Exception e) {
            response = e.toString();

            System.out.println(response);
            System.out.println("---------");

            res.enviarResponse(exchange, response, 200);
        }
    }

    public static void doDelete(HttpExchange exchange) throws IOException {
        UserDal userDal = new UserDal();

        try (InputStream requestBody = exchange.getRequestBody()) {
            JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));
            int resp = 0;

            int id = Integer.parseInt("id");

            resp = userDal.excluirUsuario(id);

            if (resp == 0) {
                response = "Houve um problema ao deletar usuário";
            } else {
                response = "Usuário deletado com sucesso";
            }

            res.enviarResponse(exchange, response, 200);
        } catch (Exception e) {
            response = e.toString();

            System.out.println(response);
            System.out.println("---------");

        }

        response = "Essa e a rota de user - DELETE";
        res.enviarResponse(exchange, response, 200);
    }

    public static void doPut(HttpExchange exchange) throws IOException {
//        UserDal userDal = new UserDal();
//
//        try(InputStream requestBody = exchange.getRequestBody()){
//            JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));
//            int resp = 0;
//
//            Users users = new Users(
//                    json.getString("nome"),
//                    json.getString("lastName"),
//                    json.getInt("age"),
//                    json.getString("address"),
//                    json.getString("email"),
//                    json.getString("password"),
//                    json.getString("cpf"),
//                    json.getInt("id")
//            );
//
//            usersList.add(users);
//
//            resp = userDal.atualizarUsuario(users.nome, users.lastName, users.age,
//                    users.address, users.email, users.password, users.cpf, users.id);
//
//            if(resp == 0){
//                response = "Houve um problema ao atualizar usuário";
//            }else{
//                response = "Usuário atualizado com sucesso";
//            }
//
//            res.enviarResponse(exchange, response, 200);
//        }catch(Exception e){
//            response = e.toString();
//
//            System.out.println(response);
//            System.out.println("---------");
//
//            res.enviarResponse(exchange, response, 200);
//        }
    }


    public static void doOptions(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(204, -1);
        exchange.close();
        return;
    }
}