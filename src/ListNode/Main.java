package ListNode;

import java.util.Stack;

public class Main {

    /**
     * 结点对象
     */

    public static class ListNode{
        int val;    //结点的值
        ListNode next;  //下一个结点
    }

    /**
     * 输入一个链表的头结点，从尾到头反过来打印每个结点的值
     * 使用栈的方式进行
     */

    public void printListInverselyUsingIteration(ListNode root){
        Stack<ListNode> stack = new Stack<>();

        while (root != null){   //根结点不为空，压入栈中
            stack.push(root);
            root = root.next;   //  指向下一个结点
        }

        ListNode tmp;
        while (!stack.isEmpty()){
            tmp = stack.pop();      //栈不为空，出栈
            System.out.println(tmp.val + " ");  //  打印
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;

        root.next = new ListNode();
        root.next.val = 2;

        root.next.next = new ListNode();
        root.next.next.val = 3;

        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;

        Main main = new Main();
        main.printListInverselyUsingIteration(root);
    }

}
