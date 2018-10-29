package PrintMatrixClockWisely;

public class Main {

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印每一个数字。
     * 数组必须是N*N的。
     */

    public static void printMatrixClockWisely(int[][] numbers) {
        //输入的参数不能为空
        if (numbers == null) {
            return;
        }

        //记录一圈的开始位置的行
        int x = 0;
        //记录一圈的开始位置的列
        int y = 0;
        //对每一圈进行处理
        //行号最大是(numbers.length - 1) / 2
        //列好最大是(numbers.[0].length - 1) / 2
        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printMatrixInCircle(numbers, x, y);
            //指向下一个要处理的环的第一个位置
            x++;
            y++;
        }
    }

    public static void printMatrixInCircle(int[][] numbers, int x, int y) {
        //数组的行数
        int rows = numbers.length;
        //数组的列数
        int cols = numbers[0].length;

        //输出环的上面一行，包括最中的数字
        for (int i = y; i <= cols - y - 1; i++) {
            System.out.print(numbers[x][i] + " ");
        }

        //环的高度至少为2才会输出右边的一行
        //rows - x - 1：表示的是环最下的那一行的行号
        if (rows - x - 1 > x) {
            //右边那一列已经输出了，所以从x+1开始
            for (int i = x + 1; i <= rows - x - 1; i++) {
                System.out.print(numbers[i][cols - y - 1] + " ");
            }
        }

        //环的高度至少是2并且环的宽度至少是2才会输出下面那一行
        //cols - 1 -y：表示的是环最右边那一列的列号
        if (rows - x - 1 > x && cols - 1 - y > y) {
            //左下角已经输出，列号从cols - y - 2开始
            for (int i = cols - y - 2; i >= y; i--) {
                System.out.print(numbers[rows - 1 - x][i] + " ");
            }
        }

        //环的宽度至少是2并且环的高度至少是3才会输出最左边的那一列
        //rows-x-1：表示是环最下的那一行的行号
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            //因为最左边那一列的第一个和最后一个一个已经输出
            for (int i = rows - x - 1; i >= x + 1; i--) {
                System.out.print(numbers[i][y] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1,2,3,4,5},
                {16,17,18,19,6},
                {15,24,25,20,7},
                {14,23,22,21,8},
                {13,12,11,10,9}
        };
        printMatrixClockWisely(numbers);
        System.out.println();

        int[][] numbers2 = {
                {1,2,3,4,5}
        };
        printMatrixClockWisely(numbers2);
    }

}
