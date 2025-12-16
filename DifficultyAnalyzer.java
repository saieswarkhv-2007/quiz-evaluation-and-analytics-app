import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DifficultyAnalyzer {

    public static List<String> analyzeDifficulty(
            Map<Integer, String> answers,
            Map<Integer, String> responses) {

        List<String> result = new ArrayList<>();

        result.add("--- Question Difficulty ---");
        result.add("QNo\tStatus\tDifficulty");

        for (Integer qNo : answers.keySet()) {
            boolean correct = answers.get(qNo).equals(responses.get(qNo));

            String status = correct ? "Correct" : "Wrong";
            String difficulty = correct ? "Easy" : "Hard";

            result.add(qNo + "\t" + status + "\t" + difficulty);
        }

        return result;
    }
}
