package BinaryNumber;


/**
 * 输入一个整数，输出该数二进制表示中1的个数
 */

public class Main {
    public static int numberOfOne1(int n) {
        //记录1的个数
        int result = 0;

        // JAVA语言规范中，int整形占四个字节，总计32位
        // 对每一个位置与1进行求与操作，再累加就可以求出当前数字的表示是多少位1
        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            n >>>= 1;
        }

        //返回求得的结果
        return result;
    }

    public static int numberOfOne2(int n) {
        int result = 0;

        while (n != 0) {
            result++;

            // 从最右边的1开始，每一次操作都使n的最右的一个1变成了0，
            // 即使是符号位也会进行操作。
            n = (n - 1) & n;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne1(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(numberOfOne1(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(numberOfOne1(0B11111111_11111111_11111111_11111111)); // -1
        System.out.println(0B01111111_11111111_11111111_11111111 == Integer.MAX_VALUE);
        System.out.println(numberOfOne1(0B01111111_11111111_11111111_11111111)); // Integer.MAX_VALUE
        System.out.println(0B10000000_00000000_00000000_00000000 == Integer.MIN_VALUE);
        System.out.println(numberOfOne1(0B10000000_00000000_00000000_00000000)); // Integer.MIN_VALUE

        System.out.println("");
        System.out.println(numberOfOne2(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(numberOfOne2(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(numberOfOne2(0B11111111_11111111_11111111_11111111)); // -1
        System.out.println(numberOfOne2(0B01111111_11111111_11111111_11111111)); // Integer.MAX_VALUE
        System.out.println(numberOfOne2(0B10000000_00000000_00000000_00000000)); // Integer.MIN_VALUE

        System.out.println(numberOfOne2(000000010010011));//4

        int n = 10;
        String result = Integer.toBinaryString(n);//转换为二进制
        System.out.println(result);
        int m = Integer.valueOf(result);//转换为整数
        System.out.println(m);
        System.out.println(numberOfOne1(m));
    }

}
