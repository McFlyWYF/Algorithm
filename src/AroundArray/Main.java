package AroundArray;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，称为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2} 为 {1,2,3,4,5}的一个旋转，该数组的最小值是1.
 */

public class Main {
    public static int min(int[] numbers) {
        //判断输入是否合法
        if (numbers == null || numbers.length == 0) {
            throw new RuntimeException("Invalid input");
        }

        //开始处理的第一个位置
        int lo = 0;
        //开始处理的最后一个元素
        int hi = numbers.length - 1;
        //设置初始值
        int mi = lo;

        //确保lo在前一个排好序的部分，hi在排好序的后一个部分
        while (numbers[lo] >= numbers[hi]) {
            //当处理范围只有两个数据时，返回一个结果
            if (hi - lo == 1) {
                return numbers[hi];
            }

            //取中间的值
            mi = lo + (hi - lo) / 2;

            //如果三个数都相等，则需要进行顺序处理，从头到尾找最小的值
            if (numbers[mi] == numbers[lo] && numbers[hi] == numbers[mi]) {
                return minInorder(numbers, lo, hi);
            }

            // 如果中间位置对应的值在前一个排好序的部分，将lo设置为新的处理位置
            if (numbers[mi] >= numbers[lo]) {
                lo = mi;
            }

            // 如果中间位置对应的值在后一个排好序的部分，将hi设置为新的处理位置
            else if (numbers[mi] <= numbers[hi]) {
                hi = mi;
            }
        }

        //返回结果
        return numbers[mi];
    }

    /**
     * 找数组中最小值
     */

    public static int minInorder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i = start + 1; i <= end; i++){
            if (result > numbers[i]){
                result = numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {3,4,5,1,2};
        System.out.println(min(array1));

        int[] array2 = {3,4,5,1,1,2};
        System.out.println(min(array2));

        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(min(array3));

        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(min(array4));

        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(min(array5));

        int[] array6 = {2};
        System.out.println(min(array6));

        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(min(array7));
        System.out.println(min(array6));

        System.out.println(min(null));
    }
}
