/**
 * @author Steve
 * Created on 2020-04
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode invertList(ListNode l) {
        ListNode pre = null;
        ListNode now = l;
        ListNode next;
        while (now != null) {
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
