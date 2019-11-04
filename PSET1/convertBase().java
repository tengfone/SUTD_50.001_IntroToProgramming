public class BaseTranslator {
     public static int[] convertBase(int[] digits, int baseA, int baseB, int precisionB) {
         if (baseA < 2 || baseB < 2 || precisionB < 1)
            return null;
        for (int item:digits){
            if (item<0 || item >= baseA)
                return null;
        }

        int[] output = new int[precisionB];
        for (int i =0; i<precisionB ; i++){
            int carry = 0;
            for (int j = digits.length - 1; j>= 0; j --){
                int x = ( digits[j] * baseB ) + carry;
                digits[j] = x % baseA;
                carry = x / baseA;
            }
            output[i] = carry;
        }
        return output;

    }
}

