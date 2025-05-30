package Chat;


import server.Server;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientGUI extends JFrame implements ClientView{

    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;


    JTextArea log;
    JTextField ipaddressField, portField, loginField, messageField;
    JPasswordField password;
    JButton btnLogin, btnSend;
    JPanel headerPanel;
    private Client client;

    public ClientGUI(Server server){

        this.client = new Client(this, server);

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("ПОДКЛЮЧЕНИЕ К СЕРВЕРУ");

        createPanel();

        setVisible(true);

    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private void connectToServer() {
        if (client.connectToServer(loginField.getText())){
            hideHeaderPanel(false);
        }
    }

    private Component createHeaderPanel(){
        headerPanel = new JPanel(new GridLayout(2, 1));
        ipaddressField = new JTextField("127.0.0.1");
        portField = new JTextField("8000");
        loginField = new JTextField("New User");
        password = new JPasswordField("123456");
        btnLogin = new JButton("Подключиться");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        headerPanel.add(ipaddressField);
        headerPanel.add(portField);
        headerPanel.add(new JPanel());
        headerPanel.add(loginField);
        headerPanel.add(password);
        headerPanel.add(btnLogin);

        return headerPanel;
    }

    private Component createLog(){
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    sendMessage();
                }
            }
        });
        btnSend = new JButton("Отправить");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        panel.add(messageField);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    @Override
    public void showMessage(String text) {
        appendLog(text);
    }

    public void sendMessage() {
        client.sendMessage(messageField.getText());
        messageField.setText("");
    }
    private void appendLog(String text){
        log.append(text + "\n");
    }

    @Override
    public void disconnectFromServer() {
        hideHeaderPanel(true);
        client.disconnectServerDown();
    }

    private void hideHeaderPanel(boolean visible){
        headerPanel.setVisible(visible);
    }
}