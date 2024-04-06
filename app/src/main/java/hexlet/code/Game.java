package hexlet.code;

public interface Game {
    String QUESTION_TEMPLATE = "Question: %s\nYour answer: ";
    String CORRECT_ANSWER_MESSAGE = "\nCorrect!";
    String WRONG_ANSWER_MESSAGE_TEMPLATE =
            "\n'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!\n";

    String YES = "yes";
    String NO = "no";

    void printRules();
    boolean playRound();
}
