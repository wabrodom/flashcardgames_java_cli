package flashcards;

public class Main {
    public static void main(String[] args) {
        StartArgs.callWithArgs(args);
        Menu.selectOption();
        StartArgs.callWithArgs(args);
    }
}
