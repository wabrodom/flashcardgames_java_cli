package flashcards;


import java.util.HashMap;

public class MapManager {
    private static final HashMap<String, String> map = new HashMap<>();
    private static final HashMap<String, Integer> mistakesMap = new HashMap<>();

    private MapManager() {}

    public static HashMap<String, String> getMap() {
        return map;
    }


    public static void addCard(String term, String definition) {
        map.put(term, definition);
        mistakesMap.put(term, 0);
    }

    public static void removeCard(String term) {
        map.remove(term);
        mistakesMap.remove(term);
    }

    public static void rewriteCard(String term, String definition)  {
        if(map.containsKey(term)) {
            map.computeIfPresent(term, (key, value) -> definition);
        } else {
            addCard(term, definition);
        }
    }

    public static boolean hasTerm(String term) {
        return map.containsKey(term);
    }

    public static boolean hasDefinition(String definition) {
        return map.containsValue(definition);
    }

    public static String getDefinition(String term) {
        return map.get(term);
    }

    public static int getNumberOfCards() {
        return map.size();
    }

    public static boolean isEmpty() {
        return map.isEmpty();
    }

    //////
    // // mistakesMap modify method
    public static HashMap<String, Integer> getMistakesMap() {
        return mistakesMap;
    }

    public static int getMistakes(String term) {
        return mistakesMap.get(term);
    }

    public static boolean addMistake(String term) {
        if (mistakesMap.containsKey(term)) {
            mistakesMap.computeIfPresent(term, (key, value) -> value + 1);
            return true;
        }
        return false;
    }

    public static void clearMistakes() {
        mistakesMap.clear();
    }

    public static void addCard(String term, String definition, int savedMistakes) {
        map.put(term, definition);
        mistakesMap.put(term, savedMistakes);
    }


}
