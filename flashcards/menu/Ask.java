package flashcards.menu;

import flashcards.CheckInput;
import flashcards.MapManager;
import flashcards.SaveInOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ask extends FlashcardAction {

    @Override
    public void doExecute() {
        SaveInOut.println("How many times to ask?");
        int times = CheckInput.getDigit();

        if (checkNumOfCards(times)) {
            checkKnowledge(times);
        }
    }

    private boolean checkNumOfCards(int times) {
        int cardsAmount = MapManager.getNumberOfCards();
        if (cardsAmount == 0) {
            SaveInOut.println("No cards available");
            return false;
        } else if (times > MapManager.getNumberOfCards()) {
            SaveInOut.printf("%d cards available%n", cardsAmount);
            return  false;
        }
        return true;
    }

    private void checkKnowledge(int times) {
        List<String> terms = new ArrayList<>(MapManager.getMap().keySet());
        Random random = new Random();

        for (int i = 0; i < times; i++) {
            String term = terms.get(random.nextInt(terms.size()));
            SaveInOut.printf("Print the definition of \"%s\":%n", term);
            checkAnswer(term);
        }
    }
    
    /*
     * check answer is it pair with key, if not addMistake to the term
     */
    private void checkAnswer(String term) {
        String answer = CheckInput.getString();
        String rightAnswer = MapManager.getDefinition(term);

        if (rightAnswer.equals(answer)) {
            SaveInOut.println("Correct!");
        } else if (MapManager.hasDefinition(answer)) {
            MapManager.addMistake(term);
            SaveInOut.printf("Wrong. The right answer is \"%s\", but your definition is correct for \"%s\".%n",
                    rightAnswer, findMatchTerm(answer));
        } else {
            MapManager.addMistake(term);
            SaveInOut.printf("Wrong. The right answer is \"%s\".%n", rightAnswer);
        }
    }


    private String findMatchTerm(String answer) {
        for (String key : MapManager.getMap().keySet()) {
            String currDefinition = MapManager.getDefinition(key);
            if (currDefinition.equals(answer)) {
                return key;
            }
        }
        return "term not found";
    }



}
