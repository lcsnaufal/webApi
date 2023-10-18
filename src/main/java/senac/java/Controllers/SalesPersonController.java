package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;

import senac.java.Domain.Salesperson;
import senac.java.Services.ResponseEndPoints;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class SalesPersonController {

    static ResponseEndPoints res = new ResponseEndPoints();

    private static List<Salesperson> salespersonList = new ArrayList<>();
    public static class SalesPersonHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = "";

            if ("GET".equals(exchange.getRequestMethod())){

                List<Salesperson> getAllFromArray = Salesperson.getAllSalesperson(salespersonList);

                if(!getAllFromArray.isEmpty()){

                    for(Salesperson salesperson : getAllFromArray){
                        System.out.println("Name: " + salesperson.getName());
                        System.out.println("Last Name: " + salesperson.getLastName());
                        System.out.println("Cpf" + salesperson.getCpf());
                        System.out.println("Email: " + salesperson.getEmail());
                        System.out.println("Número de telefone: " + salesperson.getPhoneNumber());
                        System.out.println("Address: " + salesperson.getAddress());
                        System.out.println("");
                    }
                    response = "Dados encontrados com sucesso";
                    res.enviarResponseJson(exchange, response, 200);
                }

                else{
                    response = "Dados não encontrados";
                    res.enviarResponse(exchange, response);
                }
            }

            else if ("POST".equals(exchange.getRequestMethod())){

                try(InputStream requestBody = exchange.getRequestBody()){

                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    Salesperson salesperson = new Salesperson(
                        json.getString("name"),
                        json.getString("lastName"),
                        json.getString("phoneNumber"),
                        json.getString("cpf"),
                        json.getString("email"),
                        json.getString("address")
                    );

                    salespersonList.add(salesperson);
                    System.out.println("SalesPersonList contém: " + salesperson.toJson());
                }
            }

            else if ("PUT".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de vendedor - PUT";
                res.enviarResponse(exchange, response);
            }
            else if ("DELETE".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de vendedor - DELETE";
                res.enviarResponse(exchange, response);
            }
            else {
                response = "nao definido." + "O metodo utilizado foi: " + exchange.getRequestMethod() + " So aceitamos get, put, post e delete";
                res.enviarResponse(exchange, response);
            }
        }
    }
}