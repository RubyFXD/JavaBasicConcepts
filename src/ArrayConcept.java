/**
 * Java数组：
 *  1. 用来存储固定大小的同类型元素，在内存空间中是连续的
 *  2. Java数组可以使用for-each循环或者for()基本循环遍历
 *  3. 数组可以作为函数的参数或者返回值
 */

public class ArrayConcept {
    public static void main(String[] args) {
        /**
         * 一维数组
         */
        //1. 数组变量声明 int[] intList; 或者 int intList[];
        int[] intList;

        //2. 创建数组 intList=new int[size]; 或者 int[] intList={1,2,3,4,5}
        int size = 10;
        intList = new int[10];

        /**
         * 多维数组（以二维数组为例子）
         */
        //创建和声明,直接为每一维度分配空间
        String [][] str = new String [3][4];
        //创建和声明，动态为每一维分配空间
        String [][] str1 = new String[2][];
        str1[0] = new String[2];
        str1[1] = new String[3];

        /**
         * Array, List, ArrayList
         */
    }
}
