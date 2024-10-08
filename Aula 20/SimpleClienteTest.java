import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class SimpleClienteTest  {
    private static Socket cliente;

    
    public static void main(String args[]){
        try{
            String msg;
            iniciaCliente();
            System.out.println("Mesnagens para o servidor: ");
            do{
                msg = JOptionPane.showInputDialog("Digite mensagem (ou <sair> para finalizar)");
                if(!msg.equalsIgnoreCase("sair")){
                    System.out.println(msg);
                    enviaMensagem(msg);
                }
            }while (!msg.equalsIgnoreCase("sair"));
            System.out.println("Cliente se desconectou do servidor!!");
        }catch(IOException ex){
            System.out.println("Falha na comunicação: " + ex.getMessage());
        }
    }
    private static void iniciaCliente() throws IOException{
        cliente = new Socket(SimpleServerTest.ENDERECO, SimpleServerTest.PORTA);
        System.out.println("Cliente: " + SimpleServerTest.ENDERECO + ":" + SimpleServerTest.PORTA + " conectado ao servidor!");
    }
    private static void enviaMensagem(String msg) throws IOException{
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        saida.println(msg);
    }
}