import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<String> history = new ArrayList<>();

    /**
     * ADD THE PRECISED OPERATION TO HISTORY
     * @param nbr1 : first number of operation (int)
     * @param nbr2 : second number of operation (int)
     * @param operation : operand (String)
     * @param result : result of operation (int)
     */
    private static void addToHistory (int nbr1, int nbr2, String operation, int result) {
        history.add(String.valueOf(nbr1));
        history.add(String.valueOf(nbr2));
        history.add(operation);
        history.add(String.valueOf(result));
    }

    /**
     * SUMMONS HISTORY VIEW IN TERMINAL (INLINE)
     */
    private static void viewHistory () {
        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i) + " " + history.get(i + 2) + " " + history.get(i + 1) + " = " + history.get(i + 3));
            i += 3;
        }
    }

    /**
     * Calculation method, supports + - * / % =
     */
    private static void calculator () {
        int result = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number (in order) : ");
        int nbrInput1 = input.nextInt();
        System.out.println("Enter second number : ");
        int nbrInput2 = input.nextInt();
        System.out.println("Select an operator : ");
        String operator = input.next();

        switch (operator) {
            case "+" -> result = nbrInput1 + nbrInput2;
            case "-" -> result = nbrInput1 - nbrInput2;
            case "*" -> result = nbrInput1 * nbrInput2;
            case String op when op.equals("/") && nbrInput2 != 0 -> result = nbrInput1 / nbrInput2;
            case "%" -> result = nbrInput1 % nbrInput2;
            default -> System.out.println("Wrong operation");
        }
        System.out.println(nbrInput1 + operator + nbrInput2 + " = " + result);
        addToHistory(nbrInput1, nbrInput2, operator, result);

    }

	public static void main (String[] args) {
        Scanner continueLoop = new Scanner(System.in);
        char moreOperation = 'O';
        while ((moreOperation == 'O') || (moreOperation == 'H') ) {
            calculator();
            System.out.println("Continue ? (O/N) (Press H to view history)");
            moreOperation = continueLoop.next().charAt(0);
            if ((moreOperation != 'N') && (moreOperation != 'O') && (moreOperation != 'H')) {
                System.out.println("Invalid answer, quitting now");
            } else if (moreOperation == 'H') {
                viewHistory();
            }
        }
	}
}


