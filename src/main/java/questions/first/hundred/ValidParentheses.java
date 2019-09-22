package questions.first.hundred;

import java.util.HashMap;
import java.util.Stack;

/**
 * NO.20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例1: 输入: "()" 输出: true
 * 示例2: 输入: "()[]{}" 输出: true
 * 示例3: 输入: "(]" 输出: false
 * 示例4: 输入: "([)]" 输出: false
 * 示例5: 输入: "{[]}" 输出: true
 */
public class ValidParentheses {

    private static HashMap<Character, Character> map;
    private HashMap<Character, Character> mappings;
    private static char LEFT1 = '(';
    private static char RIGHT1 = ')';
    private static char LEFT2 = '[';
    private static char RIGHT2 = ']';
    private static char LEFT3 = '{';
    private static char RIGHT3 = '}';

    public static void main(String[] args) {
//        System.out.println(isValid("()[]{}"));
//        System.out.println(isValid("([)]"));
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("([)]"));
    }

    private static boolean isValid2(String str) {
        map = new HashMap<>();
        map.put(LEFT1, RIGHT1);
        map.put(LEFT2, RIGHT2);
        map.put(LEFT3, RIGHT3);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                char topElement = stack.lastElement();
                for (char key : map.keySet()) {
                    System.out.println(key);
                }
                for (char value : map.values()) {
                    System.out.println(value);
                }
                if (topElement != map.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    @Deprecated
    private static boolean isValid1(String str) {
        if (str.contains(String.valueOf(LEFT1))) {
            if (!str.contains(String.valueOf(RIGHT1))) {
                return false;
            }
        }
        if (str.contains(String.valueOf(LEFT2))) {
            if (!str.contains(String.valueOf(RIGHT2))) {
                return false;
            }
        }
        if (str.contains(String.valueOf(LEFT3))) {
            if (!str.contains(String.valueOf(RIGHT3))) {
                return false;
            }
        }
        return false;
    }

    @Deprecated
    private static int isPair1(String str) {
        int strLength = str.length();
        char[] strArray = str.toCharArray();
        int i = 0;
        int pairSymbolIndex = -1;
        for (; i < strLength; i++) {
            if (LEFT1 == strArray[i]) {
                pairSymbolIndex = isPair2(LEFT1, i, strArray);
            }
            if (LEFT2 == strArray[i]) {
                pairSymbolIndex = isPair2(LEFT2, i, strArray);
            }
            if (LEFT3 == strArray[i]) {
                pairSymbolIndex = isPair2(LEFT3, i, strArray);
            }
        }

        return pairSymbolIndex;
    }

    @Deprecated
    private static int isPair2(char symbol, int symbolIndex, char[] strArray) {
        char pairSymbol = 0;
        if (LEFT1 == symbol) {
            pairSymbol = RIGHT1;
        }
        if (LEFT2 == symbol) {
            pairSymbol = RIGHT2;
        }
        if (LEFT3 == symbol) {
            pairSymbol = RIGHT3;
        }
        int pairSymbolIndex = -1;
        for (; symbolIndex < strArray.length; symbolIndex++) {
            if (pairSymbol == strArray[symbolIndex]) {
                pairSymbolIndex = symbolIndex;
            }
        }
        return pairSymbolIndex;
    }

    ValidParentheses() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
