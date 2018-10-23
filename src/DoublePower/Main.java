package DoublePower;

public class Main {

    /**
     * 求base的exponent次方。
     * 不使用库函数
     */

    public static double power(double base,int exponent){

        int i = 0;
        //指数和底数不能同时为0
        if (base == 0 && exponent == 0){
            throw new RuntimeException("Invalid input.base and exponent both are zero");
        }

        //指数为0返回1
        if (exponent == 0){
            return 1;
        }

        //求指数的绝对值
        long exp = exponent;
        if (exponent < 0){
            exp = -exp;
        }

        double result = 1;

        //求幂次方，指数大于0
        if (exponent > 0) {
            while (i < exponent) {
                result *= base;
                i++;
            }
        }

        //指数小于0
        if (exponent < 0){
            while (i < exp){
                result *= base;
                i++;
            }
            result = 1 / result;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(power(4, 3));
        System.out.println(power(2, 4));
        System.out.println(power(5, -2));
    }
}
