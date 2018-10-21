package FindNumber;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 规律：首先选取数组中右上角的数字，如果该数字等于要查找的数字，查找过程结束；
 * 如果该数字大于要查找的数字，剔除这个数字所在的列；如果该数字小于要查找的数字，剔除这个数字所在的行。
 */

public class Main {

    public boolean find(int[][] arr, int number) {
        if (arr == null || arr.length < 1 || arr[0].length < 1) {
            return false;
        }

        int rows = arr.length;  //数组的行数
        int cols = arr[1].length;   //数组的列数
//        System.out.println(rows);
//        System.out.println(cols);

        int row = 0;//开始的行号
        int col = cols - 1;//开始的列号

        //查找的数
        while (row >= 0 && col >= 0 && row < rows && col < cols) {
            if (arr[row][col] == number) {//等于要查找的数
                return true;
            } else if (arr[row][col] > number) {//大于要查找的数
                col--; //列数--
            }else if (arr[row][col] < number){//小于要查找到的数
                row++; //行数++
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

        Main main = new Main();
        System.out.println(main.find(arr,7));   //要查找的数字在数组中
        System.out.println(main.find(arr,5));   //要查找的数字不在数组中
        System.out.println(main.find(null,16)); //输入空指针
    }
}