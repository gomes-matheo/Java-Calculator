import java.util.Scanner;

class Main {
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
            case "+" -> System.out.println(nbrInput1 + nbrInput2);
            case "-" -> System.out.println(nbrInput1 - nbrInput2);
            case "*" -> System.out.println(nbrInput1 * nbrInput2);
            case String op when op.equals("/") && nbrInput2 != 0 -> System.out.println(nbrInput1 / nbrInput2);
            case "%" -> System.out.println(nbrInput1 % nbrInput2);
            default -> System.out.println("Wrong operation");
        };
    }

	public static void main (String[] args) {
        Scanner continueLoop = new Scanner(System.in);
        char moreOperation = 'O';
        while (moreOperation == 'O') {
            calculator();
            System.out.println("Continue ? (O/N)");
            moreOperation = continueLoop.next().charAt(0);
            if ((moreOperation != 'N') && (moreOperation != 'O')) {
                System.out.println("Invalid answer, quitting now");
            }
        }
	}
}


