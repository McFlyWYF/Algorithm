package DeleteNode;

public class Main {

    /**
     * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
     */

    public static class ListNode{
        int value;//保存链表的值
        ListNode next;//下一个结点
    }

    public static ListNode deleteNode(ListNode head,ListNode toBeDeleted){
        //如果输入参数有空值就返回头结点
        if (head == null || toBeDeleted == null){
            return head;
        }

        //如果删除的是头结点，直接返回头结点的下一个结点
        if (head == toBeDeleted){
            return head.next;
        }

        //链表至少有2个结点
        //如果删除的是最后一个结点
        if (toBeDeleted.next == null){
            //找待删除元素的前驱结点
            ListNode tmp = head;
            while (tmp.next != toBeDeleted){
                tmp = tmp.next;
            }

            //删除待删结点
            tmp.next = null;
        }

        //如果删除的是某个中间结点
        else {
            //将下一个结点的值输入到当前待删结点
            toBeDeleted.value = toBeDeleted.next.value;
            //待删除的结点的下一个指向原先待删除的下下个结点
            toBeDeleted.next = toBeDeleted.next.next;
        }
        //返回删除结点后的链表头结点
        return head;
    }

    /*
    打印链表的元素值
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

        ListNode middle = head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        ListNode last = head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head = deleteNode(head,null);//删除的结点为空
        printList(head);

        head = deleteNode(head,head);//删除头结点
        printList(head);

        head = deleteNode(head,last);//删除尾结点
        printList(head);

        head = deleteNode(head,middle);//删除中间结点
        printList(head);

        ListNode node = new ListNode();
        node.value = 12;
        head = deleteNode(head,node);//删除的结点不在链表中
        printList(head);
    }
}
