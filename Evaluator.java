import java.util.Map;

public class Evaluator {

    public static int[] compare(
            Map<Integer, String> answers,
            Map<Integer, String> responses) {

        int correct = 0, wrong = 0;

        for (Integer qNo : answers.keySet()) {
            if (answers.get(qNo).equals(responses.get(qNo))) {
                correct++;
            } else {
                wrong++;
            }
        }

        return new int[]{correct, wrong};
    }
}