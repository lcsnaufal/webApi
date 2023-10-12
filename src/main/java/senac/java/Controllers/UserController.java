package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import senac.java.Domain.Users;
import senac.java.Services.ResponseEndPoints;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import senac.java.Services.ResponseEndPoints;

public class UserController {

    static ResponseEndPoints res = new ResponseEndPoints();
    private static List<Users> usersList = new ArrayList<>();

    public static class UserHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = "";

            if ("GET".equals(exchange.getRequestMethod())) {

                List<Users> getAllFromArray = Users.getAllUsers(usersList);

                if(!getAllFromArray.isEmpty()){

                    for(Users user : getAllFromArray){
                        System.out.println("Name: " + user.getName());
                        System.out.println("Last Name: " + user.getLastName());
                        System.out.println("Age: " + user.getAge());
                        System.out.println("Address: " + user.getAddress());
                        System.out.println("Email: " + user.getEmail());
                        System.out.println("Password: " + user.getPassword());
                        System.out.println("Cpf" + user.getCpf());
                        System.out.println("");
                    }
                }
                else {
                    System.out.println("Nenhum usuario foi encontrado");
                }







//                Users getFromArray = Users.getUser(0, usersList);
//                if (getFromArray != null){
//                    System.out.println("Name: " + getFromArray.getName());
//                    System.out.println("Last Name: " + getFromArray.getLastName());
//                    System.out.println("Age: " + getFromArray.getAge());
//                    System.out.println("Address: " + getFromArray.getAddress());
//                    System.out.println("Email: " + getFromArray.getEmail());
//                    System.out.println("Password: " + getFromArray.getPassword());
//                    System.out.println("Cpf" + getFromArray.getCpf());
//                }
//                else {
//                    System.out.println("Usuário nao encontrado");
//                }
//                response = "Essa e a rota de usuario - GET";
//                res.enviarResponse(exchange, response);

            }

            else if ("POST".equals(exchange.getRequestMethod())) {
                response = "Essa e a rota de usuario - POST";

                try (InputStream requestBody = exchange.getRequestBody()) {

                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    Users user = new Users(
                            json.getString("name"),
                            json.getString("lastName"),
                            json.getInt("age"),
                            json.getString("address"),
                            json.getString("email"),
                            json.getString("password"),
                            json.getString("cpf")
                    );

                    usersList.add(user);
                    System.out.println("UserList contém: " + user.toJson());
                }
            }

            else if ("PUT".equals(exchange.getRequestMethod())) {

                response = "Essa e a rota de usuario - PUT";
                res.enviarResponse(exchange, response);

            }

            else if ("DELETE".equals(exchange.getRequestMethod())) {

                response = "Essa e a rota de usuario - DELETE";
                res.enviarResponse(exchange, response);

            }

            else {
                response = "nao definido." + "O metodo utilizado foi: " + exchange.getRequestMethod() + " So aceitamos get, put, post e delete";
                res.enviarResponse(exchange, response);
            }
        }
    }
}