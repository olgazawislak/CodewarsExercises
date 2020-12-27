import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightSort {
    /**
     *
     * @param string a string with the weights ex. "56 65 74 100 99 68 86 180 90"
     * @return a string ordered by the sum of its digits (ascending); if the same, weights are compared in natural
     * order, ex. "100 180 90 56 65 74 68 86 99".
     */
    public String orderWeight(String string) {
        if (string.isEmpty()) {
            return string;
        }

        String[] splitString = string.trim().replaceAll("  +", " ").split("\\s");
        return Arrays.stream(splitString)
                .sorted(Comparator.comparing(this::sumOfDigits).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.joining(" "));
    }

    private int sumOfDigits(String str) {
        return str.chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
