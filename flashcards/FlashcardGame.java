package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class FlashcardGame {
    private final LinkedHashMap<String, String> cardMap = new LinkedHashMap<>();

    public void addCard(String term, String definition) {
        cardMap.put(term, definition);
        SaveInOut.printf("The pair (\"%s\":\"%s\") has been added%n", term, definition);
    }

    public void removeCard(String term) {
        if (cardMap.remove(term) != null) {
            SaveInOut.println("The card has been removed.");
        } else {
            SaveInOut.printf("Can't remove \"%s\": there is no such card.", term);
        }
    }

    public void askCards(int times) {
        if (cardMap.isEmpty()) {
            SaveInOut.println("No cards available");
            return ;
        }

        List<String> terms = new ArrayList<>(cardMap.keySet());
        Random random = new Random();

        for (int i = 0; i < times; i++) {
            String term = terms.get(random.nextInt(terms.size()));
            SaveInOut.printf("Print the definition of \"%s\":%n", term);
            checkAnswer(term);
        }
    }

  

    public String getCheckedTerm() {
        while (true) {
            String term = CheckInput.getString();
            if (cardMap.containsKey(term)) {
                // SaveInOut.printf("The term \"%s\" already exists. Try again:%n", term);
                SaveInOut.printf("The card \"%s\" already exists.%n", term);
                return null;
            } else {
                return term;
            }
        }
    }

    public String getCheckedDefinition() {
        while (true) {
            String definition = CheckInput.getString();
            if (cardMap.containsValue(definition)) {
                SaveInOut.printf("The definition \"%s\" already exists.%n", definition);
                return null;
            } else {
                return definition;
            }
        }
    }


    private void checkAnswer(String term) {
        String answer = CheckInput.getString();
        String rightAnswer = cardMap.get(term);

        if (rightAnswer.equals(answer)) {
            SaveInOut.println("Correct!");
        } else if (cardMap.containsValue(answer)) {
            SaveInOut.printf("Wrong. The right answer is \"%s\", but your definition is correct for \"%s\".%n",
                    rightAnswer, findMatchTerm(answer));
        } else {
            SaveInOut.printf("Wrong. The right answer is \"%s\".%n", rightAnswer);
        }

    }

    private String findMatchTerm(String answer) {
        for (String key : cardMap.keySet()) {
            String currDef = cardMap.get(key);
            if (currDef.equals(answer)) {
                return key;
            }
        }
        return "term not found";
    }


    public void checkKnowledge() {
        for(String term : cardMap.keySet()) {
            SaveInOut.printf("Print the definition of \"%s\":%n", term);
            checkAnswer(term);
        }
    }

    public void exportToFile(File file) {
        try(PrintWriter writer = new PrintWriter(file)) {
            for(Map.Entry<String, String> entry: cardMap.entrySet()) {
                String term = entry.getKey();
                String def = entry.getValue();
                writer.printf("#FC#%s#FC#%s#FC#%n", term, def);
            }

            SaveInOut.printf("%d cards have been saved.%n", cardMap.size());
        } catch (IOException e) {
            SaveInOut.println("error : " + e.getMessage());
        }
    }

    public void importFromFile(File file) {
        try (Scanner fileScanner = new Scanner(file) ){
            int count = 0;
            while(fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split("#FC#");
                SaveInOut.println(parts[1] + " : " + parts[2]);
                cardMap.put(parts[1], parts[2]);
                count++;
            }

            SaveInOut.printf("%s cards have been loaded.%n", count);
        } catch (FileNotFoundException e) {
            SaveInOut.println("File not found.");
        }
    }
}




  // private void initCardMap(int n) {
    //     for (int i = 0; i < n; i++) {
    //         SaveInOut.printf("Card #%d:%n", i + 1);
    //         String term  = getCheckedTerm();

    //         SaveInOut.printf("The definition for card #%d:%n", i + 1);
    //         String definition = getCheckedDefinition();

    //         cardMap.put(term, definition);
    //     }
    // }