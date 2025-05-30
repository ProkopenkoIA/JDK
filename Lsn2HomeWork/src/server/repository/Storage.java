package server.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Storage implements Repository{
    private String logFilePath;

    public Storage(String log_path){
        this.logFilePath = log_path;
    }

    @Override
    public void saveLogToFile(String text) {
        try {
            // Проверяем наличие файла лога и создаем его, если он не существует
            if (!Files.exists(Paths.get(logFilePath))) {
                Files.createFile(Path.of(logFilePath));
            }

            String formattedMessage =  text + "\n";

            try (FileWriter writer = new FileWriter(logFilePath, true)) {
                writer.write(formattedMessage);
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при записи в файл лога: " + e.getMessage());
        }

    }

    @Override
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

    @Override
    public String getHistory() {
        return getLogFromFile();
    }
}
