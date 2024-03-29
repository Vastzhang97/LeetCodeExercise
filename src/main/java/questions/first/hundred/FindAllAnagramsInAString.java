package questions.first.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.438 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例:
 * 输入: s: "cbaebabacd" p: "abc"
 * 输出: [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 */
public class FindAllAnagramsInAString {

    private static String inputStr = "cbaebabacd";
    private static String matchedStr = "abc";

    public static void main(String[] args) {
        FindAllAnagramsInAString bean = new FindAllAnagramsInAString();
        bean.findAnagrams(inputStr, matchedStr);
    }

    private List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int[] curAToZ = new int[26];
        int[] aToZ = new int[26];
        for (char c : pChar) {
            aToZ[c - 'a']++;
        }
        for (int i = 0; i < sChar.length; i++) {
            if (i >= pChar.length) {
                System.out.println("[i - pChar.length] " + (i - pChar.length));
                System.out.println("sChar[i - pChar.length] - 'a' " + (sChar[i - pChar.length] - 'a'));
                curAToZ[sChar[i - pChar.length] - 'a']--;
            }
            curAToZ[sChar[i] - 'a']++;
            if (Arrays.equals(curAToZ, aToZ)) {
                result.add(i - pChar.length + 1);
            }
        }
        return result;
    }
}
