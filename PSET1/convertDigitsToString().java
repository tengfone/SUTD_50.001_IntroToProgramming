public class DigitsToStringConverter {
    public static String convertDigitsToString(int[] digits, int base, char[] alphabet) {
                // TODO: Implement (Problem d)
        String output = "";
        for (int i=0; i < digits.length; i++){
            if (digits[i]>= base || digits[i]< 0)
                return null;
            output += alphabet[digits[i]];
        }
        if (alphabet.length!= base)
            return null;
        return output;
    }
}
