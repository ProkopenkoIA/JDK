package server.repository;

public interface Repository {
    void saveLogToFile(String text);
    String getLogFromFile();
    String getHistory();

}
