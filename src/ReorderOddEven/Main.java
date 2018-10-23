package ReorderOddEven;

public class Main {

    /**
     * 输入一个整数数组，实现一个函数调整该数组中数字的顺序。
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     */

    public static void reorderOddEven(int[] arr){

        //对于输入的数组为空，或者长度小于2的直接返回
        if (arr == null || arr.length < 2){
            return;
        }

        //从左向右记录偶数的位置
        int start = 0;
        //从右向左记录奇数的位置
        int end = arr.length - 1;

        //开始调整奇数和偶数的位置
        while (start < end){
            //找偶数
            while (start < end && arr[start] % 2 != 0){
                start++;
            }

            //找奇数
            while (start < end && arr[end] % 2 == 0){
                end--;
            }

            //找到后交换位置
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    /**
     * 输出数组的信息
     */
    public static void printArray(int[] arr){
        if (arr != null && arr.length > 0){
            for (int i : arr){
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        reorderOddEven(array);
        printArray(array);
    }

}
