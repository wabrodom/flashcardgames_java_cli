package flashcards.menu;

import flashcards.MapManager;
import flashcards.SaveInOut;

public class ResetStats extends FlashcardAction{
    @Override
    protected void doExecute() {
        MapManager.clearMistakes();
        SaveInOut.println("Card statistics have been reset.");
    }
}
