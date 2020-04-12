import java.util.HashMap;
import java.util.Map;

/**
 * @author Steve
 * Created on 2020-04
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 1、首先肯定要用map保存字符的位置信息，key是字符，val是上一次出现的位置
 * 2、整一个指针记录当前不重复子串的头:start
 * 3、整一个指针记录当前不重复子串的尾:end
 * 4、遍历字符串，如果当前字符在map中找到，（【边界条件】 且上一次出现的位置val>=start）, 就把头指针指向val。
 * 5、计算尾指针-头指针的长度，更新最大长度
 *
 * 边角条件，考虑连续的重复字符
 */
public class No_3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= start) {
                start = map.get(s.charAt(end)) + 1;
            }
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
            }
            map.put(s.charAt(end), end);
            end++;
        }
        return maxLength;
    }
}
