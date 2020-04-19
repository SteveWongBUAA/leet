/**
 * @author Steve
 * Created on 2020-04
 * <p>
 * 三个循环
 * 第一个循环是l1不空且l2不空的情况下，找到小的放到结果链表
 * 第二个循环是l1不空则继续往后放
 * 第三个循环是l2不空则继续往后放
 */
public class No_21_merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode now = pre;
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                now.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                now.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            now = now.next;
        }
        while (l1 != null) {
            now = now.next = new ListNode(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            now = now.next = new ListNode(l2.val);
            l2 = l2.next;
        }
        return pre.next;
    }
}
