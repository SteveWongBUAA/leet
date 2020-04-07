import java.util.HashMap;
import java.util.Map;

/**
 * @author Steve
 * Created on 2020-04
 *
 * 使用map，key是target-当前的数组的值，value是当前数组的下标。
 * 遍历数组，查到符合的key则返回匹配的两个数下标。
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return res;
    }
}
