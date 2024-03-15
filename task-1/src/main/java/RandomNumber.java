import java.util.Random;

public class RandomNumber {
    int number;

    public RandomNumber(int min, int max) {
        Random random = new Random();
        number = random.nextInt(max - min) + min;
    }
    public int getNumber() {
        return number;
    }
}
