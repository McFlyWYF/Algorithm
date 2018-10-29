package IsPopOrder;

import java.util.Stack;

public class Main {
    /**
     * 给定两个序列，一个是栈的入栈序列，一个是栈的出栈序列，判断序列二是否是栈一的出栈序列。
     * 如入栈序列是1,2,3,4,5
     * 出栈序列是4,5,3,2,1，则4,3,5,1,2就不可能是出栈序列。
     */

    public static boolean isPopOrder(int[] push, int[] pop) {
        //参数中两个数组的个数必须相同
        //输入校验，不能为空
        if (push == null || pop == null || pop.length == 0 || push.length == 0 || pop.length != push.length) {
            return false;
        }

        //存放入栈时的数据
        Stack<Integer> stack = new Stack<>();
        //记录入栈数组元素的处理位置
        int pushIndex = 0;
        //记录出栈数组元素的处理位置
        int popIndex = 0;
        //如果还有出栈元素要处理
        while (popIndex < pop.length) {
            //入栈元素还未全部入栈的条件下，如果栈为空，或者栈顶元素不与当前处理的相等，则一直进行栈操作。
            //直到入栈元素全部入栈或者找到了一个与当前出栈元素相等的元素
            while (pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
                //入栈数组中的元素入栈
                stack.push(push[pushIndex]);
                //指向下一个要处理的入栈元素
                pushIndex++;
            }
        }
        return true;
    }
}
