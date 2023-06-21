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
    public ListNode mergeKLists(ListNode[] lists) {
        //注意一个lists的长度判断，会更快
        if(lists.length==0) return null;
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
        lists.length, (a, b)->(a.val - b.val));

        // A=new PriorityQueue<>(new Comparator<Integer>() {

		// 	@Override
		// 	public int compare(Integer o1, Integer o2) {
		// 		// TODO 自动生成的方法存根
		// 		return o2-o1;
		// 	}
        // });


        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while(!pq.isEmpty()){
            // 获取最小节点，接到结果链表中
            ListNode node=pq.poll();
            p.next=node;
            //为了把每个链表里面元素添加进来
            if(node.next!=null){
                pq.add(node.next);
            }
            //指针p不断前进
            p=p.next;
        }
        return dummy.next;
    }
}