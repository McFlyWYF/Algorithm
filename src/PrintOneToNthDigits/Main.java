package PrintOneToNthDigits;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;

public class Main {

    /**
     * 输入数字n,按顺序打印出从1到最大的n为十进制数。比如输入3，打印出1,2,3，一直到最大的三位数999。
     */

    /*
    第一种方法
     */

    //n数字的最大位数
    public static void printOneToNthDigits(int n){

        //输入的数字不能小于1
        if (n < 1){
            throw new RuntimeException("The input number must larger than 0");
        }

        //创建一个数组用于存储最大位数值
        int[] arr = new int[n];
        printOneToNthDigits(0,arr);
    }

    //输入数字n,按顺序打印出从1到最大的n位十进制数。
    public static void printOneToNthDigits(int n,int[] arr){

        //所以的数据排列选择已经处理完了
        if (n >= arr.length){
            //可以输出数组的值
            printArray(arr);
        }else {
            for (int i = 0;i <= 9;i++){
                arr[n] = i;
                printOneToNthDigits(n + 1,arr);
            }
        }
    }

    public static void printArray(int[] arr){
        //找第一个非0的元素
        int index = 0;
        while (index < arr.length && arr[index] == 0){
            index++;
        }

        //从第一个非0值到开始输出到最后的元素
        for (int i = index;i < arr.length;i++){
            System.out.print(arr[i]);
        }

        //条件成立说明数组有非0元素，需要换行
        if (index < arr.length){
            System.out.println();
        }
    }

    /*
    第二种方法
     */

   public static void printOneToNthDigits2(int n){

       //输入值必须大于0
       if (n < 1){
           throw new RuntimeException("The input number must larger than 0");
       }

       //创建一个长度为n的数组
       int[] arr = new int[n];

       //为数组元素赋初值
       for (int i = 0;i < arr.length;i++){
           arr[i] = 0;
       }

       //求结果，如果最高位没有进位数一直进行处理
       while (addOne(arr) == 0){
           printArray(arr);
       }
   }

   /*
   对arr表示的数组的最低位加1，arr中的每一个数都不能超过9不能小于0,
    */

   public static int addOne(int[] arr){
       //保存进位，因为每次最低位加1
       int carry = 1;
       //最低位的位置的后一位
       int index = arr.length;

       do {
           //指向上一个处理位置
           index--;
           //处理位置的值加上进位的值
           arr[index] += carry;
           //求处理位置的进位
           carry = arr[index] / 10;
           //求处理位置的值
           arr[index] %= 10;
       }while (carry != 0 && index > 0);

       if (carry > 0 && index == 0){
           return 1;
       }

       //无进位返回0
       return 0;
   }


    public static void main(String[] args) {
        printOneToNthDigits(2);
        System.out.println();
        printOneToNthDigits2(2);
    }
}
