package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import senac.java.Services.ResponseEndPoints;

import java.io.IOException;

import senac.java.Services.ResponseEndPoints;

public class UserController {

    public static ResponseEndPoints res = new ResponseEndPoints();
    public static class UserHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = "";

            if ("GET".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de usuario - GET";
                res.enviarResponse(exchange, response);
            }
            else if ("POST".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de usuario - POST";
                res.enviarResponse(exchange, response);
            }
            else if ("PUT".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de usuario - PUT";
                res.enviarResponse(exchange, response);
            }
            else if ("DELETE".equals(exchange.getRequestMethod())){
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
