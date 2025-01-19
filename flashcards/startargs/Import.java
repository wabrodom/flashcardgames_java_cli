package flashcards.startargs;

import flashcards.MapManager;
import flashcards.SaveInOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Import extends ArgsAction {
    @Override
    protected void doExecute(String fileName) {
        File fileToImport = new File("./" + fileName);

        try (Scanner fileScanner = new Scanner(fileToImport) ){
            int count = 0;
            while(fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split("#FC#");
                int mistakedSaved = Integer.parseInt(parts[3]);
                MapManager.addCard(parts[1], parts[2], mistakedSaved);
                count++;
            }

            SaveInOut.printf("%s cards have been loaded.%n", count);
        } catch (FileNotFoundException e) {
            SaveInOut.println("File not found.");
        }
    }




}