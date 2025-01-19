package flashcards.menu;

import flashcards.SaveInOut;

public class Exit extends FlashcardAction {
    @Override
    protected void doExecute() {
        SaveInOut.println("Bye bye!");
    }
    
}
