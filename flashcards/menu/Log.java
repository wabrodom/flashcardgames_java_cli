package flashcards.menu;

import flashcards.CheckInput;
import flashcards.SaveInOut;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class Log extends FlashcardAction{

    @Override
    public void doExecute() {
        SaveInOut.println("File name:");
        String fileName = CheckInput.getString();

        File logToExport = new File("./" + fileName);

        try (PrintWriter writer = new PrintWriter(logToExport)) {
            for (String line : SaveInOut.getInputOutput()) {
                writer.printf("%s", line);
            }
            System.out.println("The log has been saved.");
        } catch (IOException e) {
            SaveInOut.println("error : " + e.getMessage());
        }


    }
}
