package flashcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInOut {
    private static final List<String> inputOutput = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * custom out, add to ArrayList
     */

    public static void println() {
        System.out.println();
        inputOutput.add("\n");
    }

    public static void print(String message) {
        SaveInOut.print(message);
        inputOutput.add(message + "\n");
    }

    public static void println(String message) {
        System.out.println(message);
        inputOutput.add(message + "\n");
    }

    public static void printf(String template, Object... args) {
        String formattedString = String.format(template, args);

        System.out.printf(formattedString);
        inputOutput.add(formattedString + "\n");
    }


    public static List<String> getInputOutput() {
        return new ArrayList<>(inputOutput);
    }

    public static void clearInputOutput() {
        inputOutput.clear();
    }

    /**
     *custom scanner for saved input text
     *
     */

    public static String scanner() {
        // try catch when noLinefound
        String inputValue = scanner.nextLine();
        inputOutput.add(inputValue + "\n");
        return inputValue;
    }

}
