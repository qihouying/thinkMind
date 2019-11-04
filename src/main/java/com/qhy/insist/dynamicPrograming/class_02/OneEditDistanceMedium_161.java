package com.qhy.insist.dynamicPrograming.class_02;

/**
 * @Author dream
 * @Date 2019/11/3 12:36 AM
 * @Description [Medium]   Topics: [String] Companies: [Facebook Uber Twitter Snapchat]
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 * Companies
      Facebook Uber Twitter Snapchat
 */
public class OneEditDistanceMedium_161 {

    /**
     * To solve this problem, you first need to know what isedit distance. You may refer to this wikipedia article for
     * more information.
         For this problem, it implicitly assumes to use the classicLevenshtein distance, which involves insertion, deletion
         and substitution operations and all of them are of the same cost. Thus, if S is one edit distance apart from T ,
         T is automatically one edit distance apart from S .
         Now let's think about all the possible cases for two strings to be one edit distance apart. Well, that means, we
         can transform S to T by using exactly one edit operation. There are three possible cases:
         1. We insert a character into S to get T . 2. We delete a character from S to get T . 3. We substitute a character
         of S to get T .
         For cases 1 and 2, S and T will be one apart in their lengths. For cases 3, they are of the same length.
         It is relatively easy to handle case 3. We simply traverse both of them and compare the characters at the
         corresponding positions. If we find exactly one mismatch during the traverse, they are one edit distance apart.
         Now let's move on to cases 1 and 2. In fact, they can be merged into one case, that is, to delete a character
         from the longer string to get the shorter one, or equivalently, to insert a character into the shorter string to
         get the longer one.
         We will handle cases 1 and 2 using the shorter string as the reference. We traverse the two strings, once we find
         a mismatch. We know this position is where the deletion in the longer string happens. For example, suppose S = "kitten"
         and T = "kiten" , we meet the first mismatch in the 4 -th position ( 1 -based), which corresponds to the deleted
         character below, shown in between * . We then continue to compare the remaining sub-string of T ( en ) with the
         remaining sub-string of S ( en ) and find them to be the same. So they are one edit distance apart.
         S: k i t t e n
         T: k i t *t* e n
         In fact, cases 1, 2 and 3 can be further handled using the same piece of code. For strings of the same length,
         once we find a mismatch, we just substitute one to be another and check whether they are now the same. For strings
         of one apart in lengths, we insert the deleted character of the longer string into the shorter one and compare
         whether they are the same.
         The code is as follows. If you find the first half of the return statement (!mismatch && (n - m == 1) ) hard to
         understand, run the code on cases that the mismatch only occurs at the last character of the longer string,
         like S = "ab" and T = "abc" .
     */

    public boolean isOneEditDistance(String s, String t) {
        if (null == s || null == t)
            return false;
        int m = s.length(), n = t.length();
        if (m > n)
            return isOneEditDistance(t, s);
        if (n - m > 1)
            return false;
        boolean misMatch = false;

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    sb.replace(i,i+1, String.valueOf(t.charAt(i)));
                    System.out.println(sb.toString());
                } else {
                    sb.insert(i, t.charAt(i));
                }
                misMatch = true;
                break;
            }
        }
        return (!misMatch && n - m == 1) || (misMatch && sb.toString().equals(t));
    }

    public static void main(String[] args) {
        OneEditDistanceMedium_161 oneEditDistanceMedium = new OneEditDistanceMedium_161();
        System.out.println(oneEditDistanceMedium.isOneEditDistance("adc", "abc"));
    }

}
