package flashcards.startargs;

import flashcards.SaveInOut;

abstract class ArgsAction {
    public void execute(String name) {
        doExecute(name);
        SaveInOut.println();
    }

    protected abstract void doExecute(String name);
}

