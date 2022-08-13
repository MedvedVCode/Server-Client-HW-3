import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 9999;

        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            while (true) {
                System.out.println("Новое подключение!");
                out.println("Алоха амиго! Это Медвед-сервер тебя приветствует! Сейчас определим куда тебя деть)) Как тебя зовут?  ");
                String name = in.readLine();
                out.println("Рад познакомиться, " + name);
                out.println(
                        String.format(" Хотел сказать, что твой порт %d, правда зачем тебе это сейчас - нипонятнаа)) ",
                                clientSocket.getPort())
                );
                out.println("А сколько тебе годиков?");
                String ageStr = in.readLine();
                if (!ageStr.chars().allMatch(Character::isDigit)) {
                    out.println(String.format("%s - это по-мембарски что ли исчисляется? Ну, как знаешь, %s. Вот, держи леденец! ", ageStr, name));
                } else {
                    int age = Integer.parseInt(ageStr);
                    if (age < 18) {
                        out.println(String.format("%s, так как тебе всего %d лет, то вот тебе " +
                                "мафинки, совочек и песочек. Наслаждайся)))", name, age));
                    } else {
                        out.println(String.format("%s, %d - это отличный возраст. Let`s play in adults group!", name, age));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
