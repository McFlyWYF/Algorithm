package Fibonacci;


/**
 * 斐波那契数列
 */

public class Main {

    public static void fibonacci(double[] arr) {
        arr[0] = 0;
        arr[1] = 1;

        System.out.println(arr[0]);
        System.out.println(arr[1]);

        for (int i = 2;i < arr.length;i++){
            arr[i] = arr[i - 1] + arr[i - 2];
            System.out.println(arr[i]);
//            if (i % 10 == 0){
//                System.out.println();
//            }
        }
    }

    //输出第n个斐波那契数，采用递归实现
    public static double fibonacci1(int n){

        if (n <= 0){
            return -1;
        }

        if (n == 1 || n ==2){
            return 1;
        }

        return fibonacci1(n - 1) + fibonacci1(n -2);
    }

    public static void main(String[] args) {
        double[] arr = new double[100];
        fibonacci(arr);

        System.out.println(fibonacci1(1));
        System.out.println(fibonacci1(2));
        System.out.println(fibonacci1(3));
    }
}
