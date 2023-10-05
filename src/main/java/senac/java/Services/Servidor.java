package senac.java.Services;

import senac.java.Domain.Users;
import com.sun.net.httpserver.HttpServer;  // Criar um servidor
import com.sun.net.httpserver.HttpExchange;  //  Envia a requisicao do front pro back (passa pelos caminhos)

import java.io.IOException; //Erros do servidor e o que fazer
import java.io.OutputStream; //
import java.net.InetSocketAddress; // Protocolo de leitura da internet // ele quem abre o caminho para as informacoes na internet

public class Servidor {

    public static void apiServer() throws IOException{
        Users users = new Users();
        HttpServer server = HttpServer.create(new InetSocketAddress(3000),
                0);

        server.createContext("/api/usuario", (HttpExchange exchange) ->{
            if("GET".equals(exchange.getRequestMethod())){

                String response =  "Nome: " + users.name + " Sobrenome: " + users.lastName;
                exchange.sendResponseHeaders(200, response.getBytes().length);


                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }else {
                String response = "Método nao implementado";

                exchange.sendResponseHeaders(405, response.getBytes().length);

                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        server.setExecutor(null);
        System.out.println("Servidor Iniciado");
        server.start();
    }
}
