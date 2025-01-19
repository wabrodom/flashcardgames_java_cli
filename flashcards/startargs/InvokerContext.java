package flashcards.startargs;

public class InvokerContext {
    private ArgsAction action;

    public void setAction(ArgsAction action) {
        this.action = action;
    }

    public void executeAction(String name) {
        if (action != null) {
            action.execute(name);
        }
    }
}
