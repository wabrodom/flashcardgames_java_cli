package flashcards;


/*
 *  Check input is use other module scanner to save input
 */
public class CheckInput {
    private static final String errorMessage = "Wrong input...";
    // private static final Scanner scanner = new Scanner(System.in); 

    public static int getDigit() {
        while (true) {
            try {
                // int input = Integer.parseInt(scanner.nextLine());
                int input = Integer.parseInt(SaveInOut.scanner());
                if (input > 0) {
                    return input;
                } else {
                    SaveInOut.println(errorMessage);
                }
            } catch (Exception e) {
                SaveInOut.println(errorMessage + " : " + e);
            }
        }
    }


    public static String getString() {
        while (true) {
            // String value = scanner.nextLine();
            String value = SaveInOut.scanner();
            if (value.isEmpty()) {
                SaveInOut.println(errorMessage);
            } else {
                return value;
            }
        }
    }

}
