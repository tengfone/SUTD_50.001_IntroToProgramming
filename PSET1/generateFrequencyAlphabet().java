public class AlphabetGenerator {
    public static char[] generateFrequencyAlphabet(int base,
                                                   String[] trainingData) {
        String aTOz = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        int totalCount = 0;
        double[] prob = new double[26];
        double[] cdf = new double[26];
        char[] output = new char[base];

        if (base < 0)
            return null;

        for (String single : trainingData) {
            for (int i = 0; i < single.length(); i++) {
                String letter = Character.toString(single.charAt(i));
                if (aTOz.contains(letter))
                    count[aTOz.indexOf(letter)] += 1;
            }
        }
        for (int i : count) {
            totalCount += i;
        }
        prob[0] = (double)count[0];
        for (int i =1;i<count.length;i++){
            prob[i] = (double)count[i];
            prob[i] = prob[i] + prob[i-1];
        }
//        for (int i = 0; i < count.length - 1; i++) {
//           if (i == 0) {
//                prob[0] = (double) count[0];
//            }
//           else {
//                prob[i] = (double) count[i];
//                prob[i] = prob[i] + prob[i - 1];
//            }
//        }
        for (int i = 0; i < cdf.length; i++) {
            cdf[i] = prob[i] * base;
        }
        for (int i = 0; i < base; i++) {
            for (int j = 0; j < cdf.length; j++) {
                if (cdf[j] / totalCount > i) {
                    output[i] = aTOz.charAt(j);
                    break;
                }
            }
        }
        return output;
    }
}
