import Chat.ClientGUI;
import server.Server;
import server.ServerWindow;

public class Main {
    public static void main(String[] args) {

        ServerWindow serverWindow = new ServerWindow();
        Server server = serverWindow.returnServer();

        new ClientGUI(server);
    }
}
