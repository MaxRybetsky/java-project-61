package hexlet.code.data;

public final class GameRoundData {
    private final String question;
    private final String correctAnswer;

    public GameRoundData(String questionStr, String correctAnswerStr) {
        this.question = questionStr;
        this.correctAnswer = correctAnswerStr;
    }

    public GameRoundData(String questionStr, int correctAnswerNumber) {
        this(questionStr, String.valueOf(correctAnswerNumber));
    }

    public GameRoundData(int questionNumber, String correctAnswerNumber) {
        this(String.valueOf(questionNumber), correctAnswerNumber);
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
