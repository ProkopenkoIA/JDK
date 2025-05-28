package Log;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logger {
    private final String logFilePath;

    public Logger(String logFileName) {
        if (logFileName == null) logFileName = "";
        logFilePath = "log_" + logFileName + ".log";
    }

    /**
     * Сохранение сообщения в файл логов
     * @param message строка для сохранения в файл Логов
     */
    public void saveLogToFile(String message) {
        try {
            // Проверяем наличие файла лога и создаем его, если он не существует
            if (!Files.exists(Paths.get(logFilePath))) {
                Files.createFile(Path.of(logFilePath));
            }

            // Генерируем и форматируем строку с текущим временем и сообщением

            String formattedMessage =  message + "\n";

            // Открываем файл лога для записи (режим 'append' - дозапись)
            try (FileWriter writer = new FileWriter(logFilePath, true)) {
                writer.write(formattedMessage);
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при записи в файл лога: " + e.getMessage());
        }
    }

    // Получает текст из лог-файла
    public String getLogFromFile() {
        try {
            Path path = Path.of(logFilePath);

            if (Files.exists(path)) {
                try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
                    return lines.collect(Collectors.joining("\n"));
                }
            } else {
                return "";
            }
        } catch (IOException e) {
            System.out.println("I/O error when reading the log file: " + e.getMessage());
            return "";
        }
    }
}
