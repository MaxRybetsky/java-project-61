package hexlet.code.games;

import hexlet.code.validator.AnswerValidator;
import hexlet.code.Game;
import hexlet.code.random.RandomGenerator;

public class EvenNumberGame implements Game {
    private static final String EVEN_GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private final String userName;

    public EvenNumberGame(String userName) {
        this.userName = userName;
    }

    @Override
    public void printRules() {
        System.out.println(EVEN_GAME_RULES);
    }

    @Override
    public boolean playRound() {
        var givenNumber = getNumberForQuestion();
        var correctAnswer = calculateCorrectAnswer(givenNumber);

        return AnswerValidator.askAndValidateStringAnswer(
                String.valueOf(givenNumber),
                correctAnswer,
                userName
        );
    }

    private String calculateCorrectAnswer(int givenNumber) {
        return givenNumber % 2 == 0 ? YES : NO;
    }

    private int getNumberForQuestion() {
        return RandomGenerator.generateInteger();
    }
}
