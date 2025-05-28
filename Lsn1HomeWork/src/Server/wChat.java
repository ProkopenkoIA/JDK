package Server;

import Log.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class wChat extends JFrame {

    Logger logger;

    private static final int HEIGHT = 555;
    private static final int WIDTH = 507;
    private static final int POS_X = 650;
    private static final int POS_Y = 100;

    private final JTextArea textOutput = new JTextArea();

    private final JTextField textInput = new JTextField();



    public wChat(String login) {
        this.logger = new Logger("Chat");

       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Окно пользователя: " + login);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textOutput.setLineWrap(true);
        textOutput.setWrapStyleWord(true);
        textOutput.setEditable(false);
        textOutput.setBackground(new Color(247, 245, 166));

        loadChatHistory();

        JPanel grid = new JPanel(new GridLayout(4, 1));
        grid.add(textOutput);
        grid.add(new JScrollPane(textOutput));
        JLabel label = new JLabel("ВВЕДИТЕ СООБЩЕНИЕ ");
        grid.add(label);
        grid.add(textInput);
        JButton buttonConnect = new JButton("ОТПРАВИТЬ");
        grid.add(buttonConnect);

        buttonConnect.addActionListener(e -> sendMessage(login));

        textInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(login);
                }
            }
        });

        add(grid);
        setVisible(true);
    }

    private void sendMessage(String login) {
        String message = "["+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"))+ "] "+login + " : " + textInput.getText() + "\n";
        textOutput.append(message);
        textOutput.setCaretPosition(textOutput.getDocument().getLength());
        saveMessageToFile(message);
        textInput.setText("");

    }

    private void saveMessageToFile(String message) {

        logger.saveLogToFile(message);

    }

    private void loadChatHistory() {
        textOutput.append(logger.getLogFromFile() + "\n");
        textOutput.setCaretPosition(textOutput.getDocument().getLength());
    }
}