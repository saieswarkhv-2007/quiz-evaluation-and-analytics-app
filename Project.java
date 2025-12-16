import java.util.List;
import java.util.Scanner;

public class Project {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Questions CSV file: ");
        InputFile qFile = new InputFile(input.nextLine());

        System.out.print("Enter Answers CSV file: ");
        AnswerFile aFile = new AnswerFile(input.nextLine());

        System.out.print("Enter Responses CSV file: ");
        ResponseFile rFile = new ResponseFile(input.nextLine());

        if (!qFile.exists() || !aFile.exists() || !rFile.exists()) {
            System.out.println("One or more files not found!");
            input.close();
            return;
        }

        
        int[] evaluationResult =
                Evaluator.compare(aFile.getAnswers(), rFile.getResponses());

        
        Scoring scoring = new Scoring(1, 0);
        int totalScore = scoring.calculateScore(
                aFile.getAnswers(), rFile.getResponses());

        
        List<String> difficultyResult =
                DifficultyAnalyzer.analyzeDifficulty(
                        aFile.getAnswers(), rFile.getResponses());

        System.out.print("Enter Output Result CSV file: ");
        String outputFile = input.nextLine();
        System.out.println(outputFile+" created..");
       
        ResultWriter.writeResult(
                outputFile,
                aFile.getAnswers(),
                rFile.getResponses(),
                evaluationResult,
                totalScore,
                difficultyResult
        );

        input.close();
    }
}
