package hexlet.code.validator;

import java.util.Objects;

public class AnswerValidator {
    public static boolean validate(String answer, String correctAnswer) {
        return Objects.equals(answer, correctAnswer);
    }
}
