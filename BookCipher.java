import java.util.Arrays;

public class BookCipher {

    public static void main(String[] args) {
        String allAlphabets = "abcdefghijklmnopqrstuvwxyz";
        String cipherText = "SIDKHKDM AF HCRKIABIE SHIMC KD LFEAILA";
        String key = "The snow lay thick on the steps and the snow flakes driven by the wind looked black in the headlights of the cars";
        key = key.toLowerCase().replaceAll(" ", "");
        cipherText = cipherText.toLowerCase().replaceAll(" ", "");

        char[] key2 = key.toCharArray();
        String rmvdRptdWrdsFmKy = removeRepeatedAlpha(key2);
        System.out.println(decipherMessage(cipherText, rmvdRptdWrdsFmKy));
    }

    /**
     * used to decipher the cipher text with the key given
     *
     * @param cipherText text which is to be decrypted
     * @param key        with the given key
     * @return decrypted message
     */
    public static String decipherMessage(String cipherText, String key) {
        String allAlpha = "abcdefghijklmnopqrstuvwxyz";
        String decrypted = "";
        for (int i = 0; i < cipherText.length(); i++) {
            Character a = cipherText.charAt(i);
            int number = getNumberOfAlphabet(cipherText.charAt(i) + "", allAlpha);
            decrypted = decrypted + getAlphabetAtNumberIn(number, key);
        }
        return decrypted;
    }

    /**
     * used to remove the repeated Alphabets
     *
     * @param key in which repeated alphabets has to remove
     * @return string in which repeated characters are removed
     */
    public static String removeRepeatedAlpha(char[] key) {
        int idx = 0;
        for (int i = 0; i < key.length; i++) {
            int compare = 0;
            while (compare < i) {
                if (key[i] == key[compare]) {
                    break;
                }
                compare++;
            }
            if (compare == i) {
                key[idx++] = key[i];
            }
        }
        return String.valueOf(Arrays.copyOf(key, idx));
    }

    /**
     * used to shift given String by number "num"
     *
     * @param text which has to be shifted
     * @param num  number of times text has to be shifted
     * @return shifted text
     */
    public static String shiftTextBy(String text, int num) {
        String shiftedTxt = "";
        for (int i = 0; i < num; i++) {
            shiftedTxt = shiftByOne(text);
            text = shiftedTxt;
        }
        return text;
    }

    /**
     * shift provided text by one
     *
     * @param text shifting the given text by one
     * @return shifted text
     */
    public static String shiftByOne(String text) {
        int num = 0;
        String shifted = "";
        for (int i = 0; i < text.length(); i++) {
            num = getNumberOfAlphabet(text.charAt(i) + "", "abcdefghijklmnopqrstuvwxyz");
            num = (num + 1) % 26;
            shifted = shifted + getAlphabetAtNumberIn(num, "abcdefghijklmnopqrstuvwxyz");
        }
        return shifted;
    }

    /**
     * used to get the number of Alphabet according to the provided alphabets,
     *
     * @param alpha     number of this alphabet is to be returned
     * @param alphabets alphabets
     * @return number of provided alphabet, starting from 0
     */
    public static int getNumberOfAlphabet(String alpha, String alphabets) {
        for (int i = 0; i < alphabets.length(); i++) {
            if (alphabets.charAt(i) == alpha.charAt(0)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * used to get the number character at the given number, in provided key
     *
     * @param number
     * @param key
     * @return
     */
    public static String getAlphabetAtNumberIn(int number, String key) {
        return key.charAt(number) + "";
    }

    /**
     * used to count the number of time alpha is repeated in a text
     *
     * @param alpha
     * @param text
     * @return
     */
    public static int countTotalNumberOfanAlphabet(String alpha, String text) {
        int count = 0;
        alpha = alpha.toLowerCase();
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == alpha.charAt(0)) {
                count++;
            }
        }
        return count;
    }
    /********************************************************************************/

}
