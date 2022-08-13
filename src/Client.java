import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int port = 9999;
        String host = "netology.homework";
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedReader sc = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String response = in.readLine();
            System.out.println(response);
            response = sc.readLine();
            out.println(response);
            response = in.readLine();
            response += in.readLine();
            response += in.readLine();
            System.out.println(response);
            response = sc.readLine();
            out.println(response);
            response = in.readLine();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
