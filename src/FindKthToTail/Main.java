package FindKthToTail;


public class Main {

    /**
     * 输入一个链表，输出链表中倒数第K个结点。
     * 例如1,2,3,4,5,6，倒数第3个结点的值为4
     */

    public static class ListNode{
        int value;
        ListNode next;
    }

    public static ListNode findKthToTail(ListNode head,int k){
        //输入的链表不能为空，并且k大于0
        if (k < 1 || head == null){
            return null;
        }

        //指向头结点
        ListNode pointer = head;

        //倒数第k个结点与倒数第一个结点相隔k-1个位置，pointer先移动k-1个位置
        for (int i = 1;i < k;i++){
            //还有结点
            if (pointer.next != null){
                pointer = pointer.next;
            }

            //已经没有结点了，但是i还没有到达k-1，说明k太大，链表没有那么多元素
            else {
                return null;
            }
        }

        //pointer没有到达链表的末尾，pointer和head同时移动，当pointer走到最后一个结点，即pointer.next = null,head就是倒数第K个结点。
        while (pointer.next != null){
            head = head.next;
            pointer = pointer.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        System.out.println(findKthToTail(head,1).value);//倒数第一个
        System.out.println(findKthToTail(head,5).value);//中间一个
        System.out.println(findKthToTail(head,9).value);//顺序第一个
        System.out.println(findKthToTail(head,10));//结点不存在
    }
}
