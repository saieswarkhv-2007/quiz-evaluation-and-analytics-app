import java.io.*;
import java.util.*;

public class ResponseFile {

    private File file;
    private Map<Integer, String> responses = new HashMap<>();

    public ResponseFile(String filename) {
        file = new File(filename);
        load();
    }

    public boolean exists() {
        return file.exists();
    }

    private void load() {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                responses.put(
                    Integer.parseInt(data[0].trim()),
                    data[1].trim()
                );
            }
        } catch (Exception e) {
            System.out.println("Error reading responses file");
        }
    }

    
    public Map<Integer, String> getResponses() {
        return responses;
    }
}
