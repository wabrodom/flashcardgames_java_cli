package flashcards.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import flashcards.MapManager;
import flashcards.SaveInOut;

public class HardestCard extends FlashcardAction {
    private final HashMap<String, Integer> mistakesMap;
    private final HashMap<String, Integer> hardestMap;

    public HardestCard() {
        mistakesMap = MapManager.getMistakesMap();
        hardestMap = new HashMap<>();
    }

    @Override
    protected void doExecute() {
        fillHardestMap();
        int hardestAmount = hardestMap.size(); 
        if (hardestAmount == 0) {
            SaveInOut.println("There are no cards with errors.");
            return ;
        }

        List<String> hardestTerms = new ArrayList<>();

        for (String term : hardestMap.keySet()) {
            if (hardestAmount == 1) {
                SaveInOut.printf("The hardest card is \"%s\". You have %d errors answering it.%n",
                    term, hardestMap.get(term)
                );
                return ;
            } else {
                hardestTerms.add(String.format("\"%s\"", term));
            }
        }
            
        String concatHardest = String.join(", ", hardestTerms);
        SaveInOut.printf("The hardest cards are %s. You have %d errors answering them.",
                concatHardest, hardestMap.get(hardestTerms.get(0)));


    }


    private void fillHardestMap() {
        int maxErrors = findMaxError();
        if (maxErrors == 0) {
            return ;
        } 
        
        for (Map.Entry<String, Integer> entry : mistakesMap.entrySet()) {
            String term = entry.getKey();
            int errors = entry.getValue();

            if (errors == maxErrors) {
                hardestMap.put(term, errors);
            }
        }
    }

    private int findMaxError() {
        int maxErrors = 0;
        for (String term : mistakesMap.keySet()) {
            int errorsCount = mistakesMap.get(term);
            if (errorsCount > maxErrors) {
                maxErrors = errorsCount;
            }
        }
        return maxErrors;
    }

}
