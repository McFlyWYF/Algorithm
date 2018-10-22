package List;

import java.util.Stack;

public class Main {

    /**
     * 用两个栈模拟的队列
     * 分别完成在队列尾部插入结点和在队列头部删除结点的功能
     */

    public static class MList<T>{

        //插入栈，只用于插入的数据
        private Stack<T> stack1 = new Stack<>();

        //弹出栈，只用于弹出数据
        private Stack<T> stack2 = new Stack<>();

        public MList(){

        }

        //添加操作，队尾插入
        public void appendTail(T t){
            stack1.add(t);
        }

        //删除操作，队列头部删除结点
        public T deleteHead(){
            /*
            先判断是否为空,如果为空，将元素压入空栈中
             */
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.add(stack1.pop());
                }
            }
            //如果弹出栈中还没有数据就抛出异常
            if (stack2.isEmpty()){
                throw new RuntimeException("No more element");
            }

            //返回弹出栈的栈顶元素，就是队首元素
            return stack2.pop();
        }

    }

    public static void main(String[] args) {
        MList mList = new MList();
        mList.appendTail(1);
        mList.appendTail(2);
        mList.appendTail(3);
        mList.appendTail(4);
        mList.appendTail(5);

        System.out.println(mList.deleteHead());
        System.out.println(mList.deleteHead());

        mList.appendTail(6);
        mList.appendTail(7);


    }
}
