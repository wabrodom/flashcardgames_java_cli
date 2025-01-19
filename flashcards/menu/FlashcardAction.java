package flashcards.menu;

import flashcards.SaveInOut;

abstract class FlashcardAction {

    public void execute() {
        doExecute();
        SaveInOut.println();
    }

    protected abstract void doExecute();

}

// Input the action (add, remove, import, export, ask, exit):


