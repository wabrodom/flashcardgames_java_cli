package flashcards;

import flashcards.menu.*;

public class Menu {
    final private static InvokerContext invoker = new InvokerContext();

    public static void selectOption() {
        outerLoop:
        while(true) {
            SaveInOut.println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            String option = CheckInput.getString();
            switch (option) {
                case "add" -> {
                    invoker.setInvokerContext(new AddCard());
                    invoker.executeAction();
                }
                case "remove" -> {
                    invoker.setInvokerContext(new RemoveCard());
                    invoker.executeAction();
                }
                case "import" -> {
                    invoker.setInvokerContext(new Import());
                    invoker.executeAction();
                }
                case "export" -> {
                    invoker.setInvokerContext(new Export());
                    invoker.executeAction();
                }
                case "ask" -> {
                    invoker.setInvokerContext(new Ask());
                    invoker.executeAction();
                }
                case "exit" -> {
                    invoker.setInvokerContext(new Exit());
                    invoker.executeAction();
                    break outerLoop;
                }
                case "log" -> {
                    invoker.setInvokerContext(new Log());
                    invoker.executeAction();
                }
                case "hardest card" -> {
                    invoker.setInvokerContext(new HardestCard());
                    invoker.executeAction();
                }
                case "reset stats" -> {
                    invoker.setInvokerContext(new ResetStats());
                    invoker.executeAction();
                }

            }
        }

    }


}
