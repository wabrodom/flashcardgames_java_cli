package flashcards.menu;

import flashcards.CheckInput;
import flashcards.MapManager;
import flashcards.SaveInOut;

public class RemoveCard extends FlashcardAction {

    @Override
    protected void doExecute() {
        SaveInOut.println("Which card?");
        String term = CheckInput.getString();

        if (MapManager.hasTerm(term)) {
            MapManager.removeCard(term);
            SaveInOut.println("The card has been removed.");
        } else {
            SaveInOut.printf("Can't remove \"%s\": there is no such card.", term);
        }
    }
} 
