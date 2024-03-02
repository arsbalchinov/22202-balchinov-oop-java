public class Validator {
    public boolean isValid(int number) {
        if (number > 999 && number < 10000) {
            String numStr = Integer.toString(number);

            for (int i = 0; i < numStr.length() - 1; i++) {
                for (int j = i + 1; j < numStr.length(); j++) {
                    if (numStr.charAt(i) == numStr.charAt(j)) {
                        return false;
                    }
                }
            }
            return true;

        }
        return false;
    }
}
