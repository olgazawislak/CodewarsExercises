public class DigPow {
    /**
     *
     * @param n positive integer
     * @param p positive integer
     * @return a positive integer k, if it exists, such as the sum of the digits of n taken to the successive powers of p is equal to k * n; if not return -1
     */
    public static long digPow(int n, int p) {
        String number = String.valueOf(n);
        int[] arrayOfDigits = number.chars()
                .map(Character::getNumericValue).toArray();
        long sumOfPowersOfDigits = 0;
        for (int i : arrayOfDigits) {
            sumOfPowersOfDigits += Math.pow(i, p++);
        }
        if (sumOfPowersOfDigits % n == 0) {
            return sumOfPowersOfDigits / n;
        }
        return -1;
    }
}