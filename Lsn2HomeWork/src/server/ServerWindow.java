package server;

import Chat.Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;


public class ServerWindow extends JFrame implements ServerView{

    private static final int HEIGHT = 555;
    private static final int WIDTH = 507;

    JButton btnStart, btnStop;
    JTextArea log;

    private Server server;

    public ServerWindow() {
        this.server = new Server(this);

       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        setTitle("Окно сервера");

        createPanel();

        setVisible(true);
    }

    public Server returnServer() {
        return server;
    }

    private void createPanel() {
        log = new JTextArea();
        log.setEditable(false);
        add(new JScrollPane(log));
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.getStatusServer()) {
                    showMessage("Сервер уже был запущен");
                    showAllClients();
                } else {
                    server.startServer();
                    showMessage("Сервер запущен!");
                    showAllClients();
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.getStatusServer()) {
                    showMessage("Сервер уже был остановлен");
                } else {
                    server.stopServer();
                    Iterator<Client> clientIterator = server.getClientList().iterator();
                    while (clientIterator.hasNext()){
                        server.serverDown(clientIterator.next());
                        clientIterator.remove();
                    }
                    showMessage("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    @Override
    public void showMessage(String text) {
        log.append(text + "\n");
    }

    public void showAllClients() {
        log.append("Текущий список клиентов: " + "\n");
        List<Client> clients = server.getClientList();
        for (Client client : clients) {
            log.append(client.getName()+"\n");
        }
    }
}