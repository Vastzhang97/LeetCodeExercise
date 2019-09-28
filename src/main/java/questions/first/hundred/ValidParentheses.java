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

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
//        System.out.println(solution.isValid4("()[]{}"));
        System.out.println(solution.isValid4("{()}"));
    }

    private ValidParentheses() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    private boolean isValid2(String str) {

        return false;
    }

    private boolean isValid1(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
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

    /**
     * 使用栈存储前一个括号，栈顶遇到匹配的就弹出，最后栈为空则通过
     */
    public boolean isValid3(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.size() == 0) {
                stack.push(aChar);
            } else if (isSym(stack.peek(), aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }

    private boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }

    /**
     * 从最内层开始找匹配到的括号对饼干替换为""，最后剩下全""则通过
     */
    private boolean isValid4(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
            if (s.contains("[]")) {
                s = s.replace("[]", "");
            }
        }

        return s.isEmpty();
    }
}
