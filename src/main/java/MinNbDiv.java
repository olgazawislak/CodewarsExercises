public class MinNbDiv {

    /**
     * @param n number of divisors
     * @return the smallest number having n divisors.
     */
    public int findMinNumBruteForceVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int minNum = 2;
        while (countDivisors(minNum) != n) {
            minNum++;
        }
        return minNum;
    }

    public int countDivisors(int number) {
        int counter = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                counter++;
                if (number / i != i) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
