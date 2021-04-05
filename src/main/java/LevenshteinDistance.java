public class LevenshteinDistance {

    public int calculate(String word, String comparedWord) {

        int[][] levensteinMatrix = new int[word.length()+1][comparedWord.length()+1];

        for (int i = 0; i <= word.length(); i++) {
            levensteinMatrix[i][0] = i;
        }
        for (int j = 0; j <= comparedWord.length(); j++) {
            levensteinMatrix[0][j] = j;
        }

        for (int j = 1; j <= comparedWord.length(); j++) {
            for (int i = 1; i <= word.length(); i++) {
                int substitutionCost = 0;
                if (word.charAt(i) != comparedWord.charAt(j)) {
                    substitutionCost = 1;
                }
                levensteinMatrix[i][j] = Math.min(
                        Math.min(levensteinMatrix[i - 1][j] + 1, levensteinMatrix[i][j - 1] + 1),
                        levensteinMatrix[i - 1][j - 1] + substitutionCost);
            }
        }
        return levensteinMatrix[word.length()][comparedWord.length()];
    }
}
