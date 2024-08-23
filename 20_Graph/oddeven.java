public class oddeven {

    public static void main(String[] args) {
        // Example input
        String S = "critical";
        String[] D = {"typical", "radical", "political", "mystical"};
        int length = D.length;

        // Find the best rhyme
        String bestRhyme = findBestRhyme(S, D, length);
        
        // Output the result
        System.out.println("The best rhyming word for \"" + S + "\" is: " + bestRhyme);
    }

    public static String findBestRhyme(String S, String[] D, int length) {
        String bestRhyme = "No Word";
        int maxMatch = 0;

        for (int i = 0; i < length; i++) {
            String word = D[i];
            if (word.equals(S)) {
                continue; // Skip the word if it's the same as S
            }

            // Find the maximum matching suffix length by comparing from the end of the strings
            int sIndex = S.length() - 1;
            int wIndex = word.length() - 1;
            int matchCount = 0;

            while (sIndex >= 0 && wIndex >= 0 && S.charAt(sIndex) == word.charAt(wIndex)) {
                matchCount++;
                sIndex--;
                wIndex--;
            }

            // Update the best rhyme if this word has more matching characters
            if (matchCount > maxMatch) {
                maxMatch = matchCount;
                bestRhyme = word;
            }
        }

        return bestRhyme;
    }
}
