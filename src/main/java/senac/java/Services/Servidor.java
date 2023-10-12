package senac.java.Services;

import senac.java.Domain.Users;
import com.sun.net.httpserver.HttpServer;  // Criar um servidor
import com.sun.net.httpserver.HttpExchange;  //  Envia a requisicao do front pro back (passa pelos caminhos)
import com.sun.net.httpserver.HttpHandler; //

import java.io.IOException; //Erros do servidor e o que fazer
import java.io.OutputStream; //
import java.net.InetSocketAddress; // Protocolo de leitura da internet // ele quem abre o caminho para as informacoes na internet

import senac.java.Controllers.ProductController;
import senac.java.Controllers.UserController;
import senac.java.Controllers.SalesPersonController;

public class Servidor {


    public void apiServer() throws IOException{


        HttpServer server = HttpServer.create(new InetSocketAddress(3000),
                0);

        server.createContext("/api/vendedor", new SalesPersonController.SalesPersonHandler());
        server.createContext("/api/usuario",  new UserController.UserHandler());
        server.createContext("/api/produtos", new ProductController.ProductsHandler());

        server.setExecutor(null);
        System.out.println("Servidor Iniciado");
        server.start();
    }}























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