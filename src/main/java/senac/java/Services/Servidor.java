package senac.java.Services;

import senac.java.Domain.Users;
import com.sun.net.httpserver.HttpServer;  // Criar um servidor
import com.sun.net.httpserver.HttpExchange;  //  Envia a requisicao do front pro back (passa pelos caminhos)
import com.sun.net.httpserver.HttpHandler; //

import java.io.IOException; //Erros do servidor e o que fazer
import java.io.OutputStream; //
import java.net.InetSocketAddress; // Protocolo de leitura da internet // ele quem abre o caminho para as informacoes na internet

public class Servidor {

    static HttpExchange pathCreator;
    //        String path = "";
    //        path = String.valueOf(pathCreator.getRequestURI());
    static Users users = new Users();



    public void apiServer() throws IOException{


        HttpServer server = HttpServer.create(new InetSocketAddress(3000),
                0);

        server.createContext("/api/vendedor", new SalesPersonHandler());
        server.createContext("/api/usuario", new UserHandler());
        server.createContext("/api/produtos", new ProductsHandler());

        server.setExecutor(null);
        System.out.println("Servidor Iniciado");
        server.start();
    }




    class SalesPersonHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException{

            String response = "Essa e a rota de vendedor";
            enviarResponse(exchange, response);
        }
    }
    class UserHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException{

            String response  = "Essa e a rota de usuario";
            enviarResponse(exchange, response);
        }
    }
    class ProductsHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException{

            String response = "Essa e a rota dos produtos";
            enviarResponse(exchange, response);
        }
    }

    public static void enviarResponse(HttpExchange exchange, String response) throws IOException{

        if ("GET".equals(exchange.getRequestMethod())){

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
            }
        }
    }














//    public static void serverRoute(HttpExchange exchange) throws IOException{
//
//        if("GET".equals(exchange.getRequestMethod())){
//
//            String response =  "ta indo";
//            exchange.sendResponseHeaders(200, response.getBytes().length);
//
//
//            OutputStream os = exchange.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
//        }else {
//            String response = "Método nao implementado";
//
//            exchange.sendResponseHeaders(405, response.getBytes().length);
//
//            OutputStream os = exchange.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
//        }
//    };