import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 排序算法总结
 * 测试数据输入：第一行 N(测试数组的长度)
 *              第二行 N个测试数据
 */
public class SortMethods {
    public static void main(String[] args) throws IOException {

        //测试输入
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String SN=br.readLine();
        int N=Integer.valueOf(SN);
        int[] testArr=new int[N];

        String str=br.readLine();
        String[] strArry=str.split(" ");

        for(int i=0;i<N;i++){
            testArr[i]=Integer.valueOf(strArry[i]);
        }

        //冒泡排序测试
        //bubbleSort(testArr);

        //选择排序测试
        //selectioSort(testArr);

        //插入排序测试
        //insertionSort(testArr);

        //希尔排序测试
        //shellSort(testArr);

        //归并排序
        //mergeSort(testArr,0,testArr.length-1);

        //快排测试
        quickSort(testArr,0,testArr.length-1);

        //测试输出
        for(int i=0;i<testArr.length;i++){
            System.out.print(testArr[i]+" ");
        }

    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if(arr.length==0){
            return;
        }
        /**
         * bug:测试的时候显示数据越界，两种写法
         * 1. for(int j=1; j<arr.length-i;j++)
         *     if(arr[j]<arr[j-1])
         *     j=0是错的，j-1会超过数组下限
         *
         * 2. for(int j=0; j<arr.length-1-i;j++)
         *     if(arr[j+1]<arr[j])
         *     j可以从0开始，但是j<arr.length-1-i,否则j+1会超过数组上限
         */
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectioSort(int[] arr){
        if(arr.length==0){
            return;
        }
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr,minIndex,i);
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr){
        if(arr.length==0){
            return;
        }
        //bug: i<arr.length不对，否则current=arr[i+1]会越界
        for(int i=0;i<arr.length-1;i++){
            //不能用currentIndex=i+1
            int current=arr[i+1];
            int preIndex=i;
            while(preIndex>=0 && current<arr[preIndex]){
                //不能用currentIndex=i+1,因为preIndex+1首次移动的时候currentIndex
                //所指向的数值已经变化了
                arr[preIndex+1]=arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1]=current;
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){
        if(arr.length==0){
            return;
        }

        for(int gap=arr.length/2;gap>=1;gap=gap/2){
            for(int i=0;i<arr.length-gap;i++){
                int current=arr[i+gap];
                int preIndex=i;
                //bug: preIndex>=i错误，遍历不到前面的数据，没法对比
                while(preIndex>=0 && current<arr[preIndex]){
                    arr[preIndex+gap]=arr[preIndex];
                    preIndex=preIndex-gap;
                }
                arr[preIndex+gap]=current;
            }
        }
    }

    /**
     * 归并排序
     * @param arr
     * @param start
     * @param end
     */
    public static void mergeSort(int[] arr, int start, int end){
        int [] result=new int[arr.length];
        //bug: if(arr.length<2) return错误，因为arr长度一直不变，所以归并一直不停止
        //导致stack over flow
        if(start>=end){
            return;
        }
        int center=(start+end)/2;
        int start1=start, end1=center, start2=center+1, end2=end;
        mergeSort(arr,start1,end1);
        mergeSort(arr,start2,end2);

        int count=start1;
        while(start1<=end1 && start2<=end2){
            if(arr[start1]<arr[start2]){
                result[count++]=arr[start1++];
            }else if(arr[start2]<arr[start1]){
                result[count++]=arr[start2++];
            }
        }

        while(start1<=end1){
            result[count++]=arr[start1++];
        }
        while(start2<=end2){
            result[count++]=arr[start2++];
        }

        for(int i=start;i<=end;i++){
            arr[i]=result[i];
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int middle=partition(arr,left,right);
        quickSort(arr,left,middle-1);
        quickSort(arr,middle+1,right);
    }
    public static int partition(int[] arr, int left, int right){
        int base=arr[left];
        while(left<right){
            while(left<right&&arr[right]>base){
                right--;
            }
            if(left<right){
                swap(arr,left,right);
                left++;
            }
            while(left<right&&arr[left]<base){
                left++;
            }
            if(left<right){
                swap(arr, left,right);
                right--;
            }
        }
        return left;
    }

    /**
     * 堆排序
     */
    public static void heapSort(){

    }

    /**
     * 计数排序
     */
    public static void countingSort(){

    }

    /**
     * 桶排序
     */
    public static void bucketSort(){

    }

    /**
     * 基数排序
     */
    public static void radixSort(){

    }

    /**
     * swap函数
    public static void swap(int a, int b){
        int temp=a;
        a=b;
        b=temp;
    }
     swap(c,d);
     swap函数是不能交换原生数据类型和字符串类型的，因为java只有值传递，没有引用传递，所以调用swap（）
     函数的时候把值赋值给a,b之后和c,d就没什么关系了，c&d还是原来的值，就是值传递。
     **/

    /**
     * swap函数改进
     *     public static void swap（int[] a）{
     *         int temp=a[0];
     *         a[0]=a[1];
     *         a[1]=temp;
     *     }
     *     int[] i={3,6}
     *     swap(i);
     * 只有引用类型才能进行交换，原生数据类型是直接赋值，但是引用类型直接赋值的是地址，地址
     * 指向的是同一个对象，所以可能改变。
     */


      //swap函数改进,交换数组中的两个元素
        public static void swap(int[] arr, int indexi, int indexj){
            int temp=arr[indexi];
            arr[indexi]=arr[indexj];
            arr[indexj]=temp;
        }
}
