/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //函数签名
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //虚拟头结点
        ListNode dummy = new ListNode(-1) , p = dummy;
        ListNode p1 = list1, p2=list2;

        while(p1!=null&&p2!=null){
            //比较p1和p2两个指针
            //将值较小的节点连接到p指针
            if(p1.val<p2.val){
                p.next=p1;
                p1=p1.next;
            }else{
                p.next=p2;
                p2=p2.next;
            }
            //p指针不断前进
            p=p.next;
        }
        //其中一个为空后，剩下的由另一个相连
        if(p1!=null){
            p.next=p1;
        }
        if(p2!=null){
            p.next=p2;
        }
        return dummy.next;
    }
}