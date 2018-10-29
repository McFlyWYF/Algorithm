package StackWithMin;

import java.util.Stack;

public class Main {

    /**
     * 定义栈的数据结构，实现一个能够的带栈的最小元素的min函数。
     * peek()获取栈顶值，不删除栈顶的值
     */

    public static class StackWithMin<T extends Comparable<T>>{
        //数据栈，存放插入的数据
        private Stack<T> dataStack;
        //最小数位置栈，存放数据栈中最小的数的位置
        private Stack<Integer> minStack;

        //构造函数
        public StackWithMin(){
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        /**
         * 出栈方法
         */

        public T pop(){
            //如果栈已经为空，抛出异常
            if (dataStack.isEmpty()){
                throw new RuntimeException("The stack is already empty");
            }

            //如果栈中有数据，最小数位置栈和数据栈必定是有相同的元素个数
            //两个栈同时出栈
            minStack.pop();
            return dataStack.pop();
        }

        /*
        元素入栈
         */

        public void push(T t){
            //如果入栈的元素为空就抛出异常
            if (t == null){
                throw new RuntimeException("Elemnet can be null");
            }

            //如果数据栈是空的，只将数据入栈，同时更新最小数位置栈中的数据
            if (dataStack.isEmpty()){
                dataStack.push(t);
                minStack.push(0);
            }

            //如果数据栈有数据
            else {
                //获取数据栈中的最小元素
                T e = dataStack.get(minStack.peek());
                //将t入栈
                dataStack.push(t);
                //如果插入的数据比栈中的最小元素小
                if (t.compareTo(e) < 0){
                    //将新的最小元素的位置入最小栈
                    minStack.push(dataStack.size() - 1);
                }else {
                    //插入的元素不比原来的最小元素小，复制最小栈栈顶元素，将其入栈
                    minStack.push(minStack.peek());
                }
            }
        }

        /**
         * 获取栈中的最小元素
         */

        public T min(){
            //如果最小数的位置栈已经为空，抛出异常
            if (minStack.isEmpty()){
                throw new RuntimeException("No element in stack");
            }

            //获取数据栈中的最小元素，并返回结果
            return dataStack.get(minStack.peek());
        }
    }

    public static void main(String[] args) {
        /**
         * 首先默认第一个元素是最小的，在最小位置栈中默认是0，然后将插入的第二个元素和原来栈中的元素进行比较，
         * 如果小于原来的，最小位置栈中的元素从当前位置开始变为1，如果大于原来的，默认的最小元素的位置还是0.
         */
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(1);
        stack.push(2);
        stack.push(0);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.min() == 3);
        System.out.println(stack.min() == 1);
        System.out.println(stack.dataStack);
        System.out.println(stack.minStack);

        stack.push(6);
        System.out.println(stack.dataStack);
        System.out.println(stack.minStack);

        stack.pop();
        System.out.println(stack.dataStack);
        System.out.println(stack.min() == 1);
    }
}
