import java.util.Map;

public class Scoring {

    private int correctMark;
    private int wrongMark;

    public Scoring(int correctMark, int wrongMark) {
        this.correctMark = correctMark;
        this.wrongMark = wrongMark;
    }

    public int calculateScore(
            Map<Integer, String> answers,
            Map<Integer, String> responses) {

        int score = 0;

        for (Integer qNo : answers.keySet()) {
            String ans = answers.get(qNo);
            String res = responses.get(qNo);

            if (ans != null && res != null &&
                ans.trim().equalsIgnoreCase(res.trim())) {
                score += correctMark;   
            } else {
                score += wrongMark;
            }
        }

        return score;
    }
}
