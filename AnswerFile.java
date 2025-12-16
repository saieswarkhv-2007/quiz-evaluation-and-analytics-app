import java.io.File;
import java.util.*;

public class AnswerFile {

    private File file;
    private HashMap<Integer, String> answers = new HashMap<>();

    public AnswerFile(String fileName) throws Exception {
        file = new File(fileName);
        loadAnswers();
    }

    private void loadAnswers() throws Exception {
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(",");
            answers.put(Integer.parseInt(data[0]), data[1]);
        }
        sc.close();
    }

    public boolean exists() {
        return file.exists();
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }
}