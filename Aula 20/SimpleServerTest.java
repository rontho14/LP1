import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class SimpleServerTest{
    public static final String ENDERECO = "127.0.0.1";
    public static final int PORTA = 3344;

    public static void main(String args[]){
        try{
            ServerSocket servidor = new ServerSocket(PORTA);
             System.out.println("Servidor iniciado na porta" + PORTA);
            Socket cliente = servidor.accept();
            System.out.println("Cliente do IP: " + cliente.getInetAddress().getHostAddress() + "conectando ao servidor");
            Scanner entrada = new Scanner(cliente.getInputStream());
            System.out.println("Mensagens do Cliente");
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }
            System.out.println("Servidor fializado!");
            entrada.close();
            servidor.close();
        }
            catch(IOException ex){
                System.out.println("Erro ao criar o servidor!");
            }
    }
}