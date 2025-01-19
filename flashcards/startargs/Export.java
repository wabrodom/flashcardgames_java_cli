package flashcards.startargs;

import flashcards.MapManager;
import flashcards.SaveInOut;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Export extends ArgsAction {
    @Override
    protected void doExecute(String fileName) {
        File fileToExport = new File("./" + fileName);

        try(PrintWriter writer = new PrintWriter(fileToExport)) {
            for(Map.Entry<String, String> entry: MapManager.getMap().entrySet()) {
                String term = entry.getKey();
                String def = entry.getValue();
                int mistakes = MapManager.getMistakes(term);
                // pattern is #FC#
                writer.printf("#FC#%s#FC#%s#FC#%d#FC#%n", term, def, mistakes); 
            }

            SaveInOut.printf("%d cards have been saved.%n", MapManager.getNumberOfCards());
        } catch (IOException e) {
            SaveInOut.println("error : " + e.getMessage());
        }
    }
}
