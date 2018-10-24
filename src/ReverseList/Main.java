package ReverseList;

public class Main {

    /**
     * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
     */

    public static class ListNode{
        int value;
        ListNode next;
    }

    public static ListNode reverseList1(ListNode head){
        //创建一个临时结点，当作尾插法的逻辑头结点
        ListNode root = new ListNode();
        //逻辑头结点的下一个结点为空
        root.next = null;

        //用于记录要处理的下一个结点
        ListNode next;

        //当前处理的结点不为空
        while (head != null){
            //记录要处理的下一个结点
            next = head.next;
            //当前结点的下一个结点指向逻辑头结点的下一个结点
            head.next = root.next;
            //逻辑头结点的下一个结点指向当前处理的结点
            root.next = head;

            //当前结点指向下一个要处理的结点
            head = next;
        }

        //逻辑头结点的下一个结点就是返回后的头结点
        return root.next;
    }

    //递归实现
    public static ListNode reverseList2(ListNode head){

        if (head == null || head.next == null){
            return head;
        }

        ListNode p;
        p = head.next;

        ListNode root;
        root = reverseList2(p);
        p.next = head;
        head.next = null;
        return root;
    }

    //尾递归实现
    public static ListNode reverseList3(ListNode head,ListNode newHead){
        if (head == null){
            return newHead;
        }
        else {
            ListNode p;
            p = head.next;
            head.next = newHead;
            return reverseList3(p,head);
        }
    }

    public static ListNode reverse_tail(ListNode head){
        return reverseList3(head,null);
    }

    //迭代实现
    public static ListNode reverseList4(ListNode head){
        ListNode newHead = null;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode tmp = cur.next;
            if (tmp == null){
                newHead = cur;
            }

            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return newHead;
    }

    /**
     * 输出链表的元素值
     */

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
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

        System.out.println("链表原始的值为:");
        printList(head);
        head = reverseList1(head);
        System.out.println("反转后的值为:");
        printList(head);
        head = reverseList2(head);
        printList(head);
        head = reverse_tail(head);
        printList(head);
        head = reverseList4(head);
        printList(head);
    }
}
