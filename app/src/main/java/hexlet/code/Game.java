package hexlet.code;

public interface Game {
    String QUESTION_TEMPLATE = "Question: %s\nYour answer: ";
    String CORRECT_ANSWER_MESSAGE = "Correct!";
    String WRONG_ANSWER_MESSAGE_TEMPLATE =
            "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!\n";

    void printRules();
    boolean playRound();
}
