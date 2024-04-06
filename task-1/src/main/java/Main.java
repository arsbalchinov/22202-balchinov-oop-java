import java.util.Scanner;

public class Main {
    public static void main(String[] Args) {
        RandomNumber random = new RandomNumber(1023, 9876);
        Validator validator = new Validator();
        int number = random.getNumber();
        while (!validator.isValid(number)) {
            random = new RandomNumber(1023, 9876);
            number = random.getNumber();
        }
        BullsAndCowsGameController game = new BullsAndCowsGameController(number);
        int num;
        int count = 0;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Guess the number: ");
            num = in.nextInt();
            if (!validator.isValid(num)) {
                System.err.println("Number isn't valid, input a 4-digit number with non-repeating digits.");
                continue;
            }
            count++;
            if (num == number) {
                System.out.println("You win! Game over.\nNumber of attempts: "+ count);
                break;
            }
            BullsAndCowsResult bac = game.guess(num);
            game.printBullsAndCows();
        }
        in.close();
    }
}
