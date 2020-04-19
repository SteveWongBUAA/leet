import java.util.Stack;

/**
 * @author Steve
 * Created on 2020-04
 * <p>
 * 利用栈的特性
 * 每发现一个左括号则进栈
 * 发现一个右扩号则出栈
 * 如果某一次出栈的元素为空或者不匹配对应的左括号，则返回失败
 * 如果遍历完了栈不为空则返回失败
 * 其他情况返回成功
 */
public class No_20_validParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character sc = stack.pop();
                if (sc == '{' && c != '}') {
                    return false;
                }
                if (sc == '[' && c != ']') {
                    return false;
                }
                if (sc == '(' && c != ')') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
