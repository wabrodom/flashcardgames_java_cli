package flashcards.menu;


public class InvokerContext {
    private FlashcardAction action;

    public void setInvokerContext(FlashcardAction action) {
        this.action = action;
    }

    public void executeAction() {
        if (action != null) {
            action.execute();
        }
    }

}
