/**
 * @author Steve
 * Created on 2020-04
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 按顺序相加，有进位的话记进位
 *
 * 边界条件
 * 1、循环终止条件，不仅是两个链表到尾部，还要考虑到进位，当进位不为0的时候循环也不能终止。
 * 2、两个链表为空？程序也要兼容返回空
 */
public class No_2_addTwoSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode now = pre;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            now.next = new ListNode(carry);
            if (l1 != null) {
                now.next.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                now.next.val += l2.val;
                l2 = l2.next;
            }
            if (now.next.val >= 10) {
                carry = 1;
                now.next.val -= 10;
            } else {
                carry = 0;
            }
            now = now.next;
        }
        return pre.next;
    }





}
