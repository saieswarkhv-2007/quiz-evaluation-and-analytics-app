import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class ResultWriter {

    public static void writeResult(
            String outputFile,
            Map<Integer, String> answers,
            Map<Integer, String> responses,
            int[] evaluationResult,
            int totalScore,
            List<String> difficultyResult) throws Exception {

        FileWriter writer = new FileWriter(outputFile);

        writer.write("--- Evaluation ---\n");
        writer.write("Correct : " + evaluationResult[0] + "\n");
        writer.write("Wrong   : " + evaluationResult[1] + "\n\n");
        
        writer.write("Total Score : " + totalScore + "\n\n");

        for (String line : difficultyResult) {
            writer.write(line + "\n");
        }

        writer.close();
    }
}
