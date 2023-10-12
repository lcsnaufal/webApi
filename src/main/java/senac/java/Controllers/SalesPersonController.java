package senac.java.Controllers;

import com.sun.jdi.InterfaceType;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

import senac.java.Services.ResponseEndPoints;

import org.json.JSONObject;

public class SalesPersonController {

    static ResponseEndPoints res = new ResponseEndPoints();
    public static class SalesPersonHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = "";

            JSONObject responseJson = new JSONObject();

            responseJson.put("chave1", "valordachave1");
            responseJson.put("chave2", "valordachave2");
            responseJson.put("chave3", "valordachave3");

            if ("GET".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de vendedor - GET";

                res.enviarResponseJson(exchange, responseJson, 200);
            }
            else if ("POST".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de vendedor - POST";
                res.enviarResponse(exchange, response);
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