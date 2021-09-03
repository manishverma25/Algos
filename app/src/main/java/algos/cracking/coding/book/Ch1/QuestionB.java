package algos.cracking.coding.book.Ch1;

import algos.cracking.coding.book.CtCILibrary.AssortedMethods;

public class QuestionB {

    public static boolean isSubstring(String big, String small) {
        if (indexOfNew(big,small,0) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        /* check that s1 and s2 are equal length and not empty */
        if (len == s2.length() && len > 0) {
            /* concatenate s1 and s1 within new buffer */
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public static void main(String[] args) {
//        String[][] pairs = {{"accab","ab"},{"abc", "cab"}};
        String[][] pairs = {{"accab","ab"},{"abc", "bc"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
//            boolean is_rotation = isRotation(word1, word2);
//            System.out.println(word1 + ", " + word2 + ": " + is_rotation);

            System.out.println(word1 + ", " + word2 + ": indexOfNew  " + indexOfNew(word1,word2,0));
        }
    }


    static int indexOfNew(String source,
                       String target,
                       int fromIndex) {
        final int sourceLength = source.length();
        final int targetLength = target.length();
        if (fromIndex >= sourceLength) {
            return (targetLength == 0 ? sourceLength : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetLength == 0) {
            return fromIndex;
        }

        char first = target.charAt(0);
        int max = (sourceLength - targetLength);

        for (int i = fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source.charAt(i)!= first) {
                while (++i <= max && source.charAt(i) != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetLength - 1;
                for (int k = 1; j < end && source.charAt(j)
                        == target.charAt(k); j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }

}

