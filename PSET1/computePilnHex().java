public class PiGenerator {
    public static int[] computePiInHex(int precision) {
    // Use PiDigit.piDigit() to call method piDigit()
        // TODO: Implement (Problem b)
        if (precision < 0) {
            return null;
        }
        // 3142XXXXXXX
        int[] precisionArray = new int[precision];
        for (int i = 1; i < precision + 1; i++) {
            precisionArray[i - 1] = PiDigit.piDigit(i);
        }
        return precisionArray;
    }

}
