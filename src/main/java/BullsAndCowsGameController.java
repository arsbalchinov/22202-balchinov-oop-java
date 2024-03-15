public class BullsAndCowsGameController {
    int bulls;
    int cows;
    int randNumber;
    public BullsAndCowsGameController(int randNum) {
        randNumber = randNum;
    }
    public BullsAndCowsGameController guess(int num) {
        BullsAndCowsGameController bac = new BullsAndCowsGameController(randNumber);
        bac.bulls = 0;
        bac.cows = 0;
        boolean[] numDigits = new boolean[10];
        boolean[] randomDigits = new boolean[10];
        String numStr = Integer.toString(num);
        String randStr = Integer.toString(randNumber);

        for (int i = 0; i < 4; i++) {
            int j = numStr.charAt(i) - '0';
            numDigits[j] = true;
            int k = randStr.charAt(i) - '0';
            randomDigits[k] = true;

            if (numStr.charAt(i) == randStr.charAt(i)) {
                bac.bulls++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (numDigits[i] && randomDigits[i]) {
                bac.cows++;
            }
        }
        bac.cows -= bac.bulls;
        return bac;
    }
    public void printBullsAndCows() {
        System.out.println("Bulls: "+ bulls +"\nCows: "+ cows);
    }
    public int getBulls() {
        return bulls;
    }
    public int getCows() {
        return cows;
    }
}
