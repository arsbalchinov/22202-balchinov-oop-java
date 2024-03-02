public class BullsAndCows {
    int bulls;
    int cows;
    public BullsAndCows(int num, int randNum) {
        boolean[] numDigits = new boolean[10];
        boolean[] randomDigits = new boolean[10];
        String numStr = Integer.toString(num);
        String randStr = Integer.toString(randNum);

        for (int i = 0; i < 4; i++) {
            int j = numStr.charAt(i) - '0';
            numDigits[j] = true;
            int k = randStr.charAt(i) - '0';
            randomDigits[k] = true;

            if (numStr.charAt(i) == randStr.charAt(i)) {
                bulls++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (numDigits[i] && randomDigits[i]) {
                cows++;
            }
        }
        cows -= bulls;
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
