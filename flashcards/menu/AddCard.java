package flashcards.menu;

import flashcards.CheckInput;
import flashcards.MapManager;
import flashcards.SaveInOut;


public class AddCard extends FlashcardAction {
 
    @Override
    protected void doExecute() {
        SaveInOut.printf("The card:%n");
        String term = CheckInput.getString();
        if (MapManager.hasTerm(term)) {
            SaveInOut.printf("The card \"%s\" already exists.%n", term);
            return;
        }

        SaveInOut.printf("The definition of the card:%n");
        String definition = CheckInput.getString();
        if (MapManager.hasDefinition(definition)) {
            SaveInOut.printf("The definition \"%s\" already exists.%n", definition);
            return ;
        }

        MapManager.addCard(term ,definition);
        SaveInOut.printf("The pair (\"%s\":\"%s\") has been added%n", term, definition);
    }
}
