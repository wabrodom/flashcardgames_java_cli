package flashcards;

import flashcards.startargs.Export;
import flashcards.startargs.Import;
import flashcards.startargs.InvokerContext;

public class StartArgs {

    final private static InvokerContext invoker = new InvokerContext();

    public static void callWithArgs(String[] args) {
//        String[] importExport = extractImportExport(args);

        for (int i = 0; i < args.length -1; i++) {
            if (args[i].equals("-import") && !args[i+1].equals("-export")) {
                String importFileName = args[i + 1];                // possible null
                invoker.setAction(new Import());
                invoker.executeAction(importFileName);
            }

            if (args[i].equals("-export") && !args[i+1].equals("-import")) {
                String exportFileName = args[i + 1];                // possible null
                invoker.setAction(new Export());
                invoker.executeAction(exportFileName);
            }
        }


    }

    public static String[] extractImportExport(String[] args) {
        String[] importExport = new String[2]; // Reference type default is Null

        for (int i = 0; i < args.length - 1; i++) {
            
            if (args[i].equals("-import") && !args[i+1].equals("-export")) {
                importExport[0] = args[i + 1];
            }

            if (args[i].equals("-export") && !args[i+1].equals("-import")) {
                importExport[1] = args[i + 1];
            }
        }
        return importExport;
    }
}
