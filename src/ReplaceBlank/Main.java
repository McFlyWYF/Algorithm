package ReplaceBlank;

public class Main {

    /**
     * 实现一个函数，把字符串中的每个空格替换成"%20"，例如"We are happy."，则输出"We%20are%20happy"
     */

    public int replaceBlank(char[] string,int usedLength) {

        //判断输入是否合法
        if (string == null || string.length < 0) {
            return -1;
        }

        //统计字符数组中的空白字符数
        int whiteCount = 0;
        for (int j = 0; j < string.length; j++) {
            if (string[j] == ' ') {
                whiteCount++;
            }
        }

        // 计算转换后的字符长度是多少
        int targetLength = whiteCount * 2 + usedLength;
        int tmp = targetLength; // 保存长度结果用于返回
        if (targetLength > string.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
            return -1;
        }

        // 如果没有空白字符就不用处理
        if (whiteCount == 0) {
            return usedLength;
        }

        //字符中没有空白字符，一直处理到所以的空白字符处理完
        while (usedLength >= 0 && usedLength < targetLength) {

            //如果当前字符是空白字符，进行替换

            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else {//否则移动字符
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }
        return tmp;
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = 'W';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = 'a';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = 'h';
        string[8] = 'a';
        string[9] = 'p';
        string[10] = 'p';
        string[11] = 'y';

        Main main = new Main();
        int length = main.replaceBlank(string,12);
        System.out.println(new String(string,0,length));
    }
}

