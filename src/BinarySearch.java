/**
 *
 * 折半查找
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
//        test_bsv2();

        int[] data = {1,2,3,4,5};
        int N = 10000000;

//        long startTime = System.currentTimeMillis();
//        int total = 0;
//        for (int i = 0; i<N; ++i) {
//            total += bsv1(data,0,data.length - 1, 5 );
//        }
//        System.out.println("v1 time: " + (System.currentTimeMillis() - startTime));
//
//
//        startTime = System.currentTimeMillis();
//        total = 0;
//        for (int i = 0; i<N; ++i) {
//            total += bsv2(data, 5 );
//        }
//
//        System.out.println("v2 time: " + (System.currentTimeMillis() - startTime));

        test_bsv2();
    }

    public static void test_bsv1() {
        int[] data = {1,2,3,4,5};

        System.out.println(bsv1(data,0,data.length - 1, 5 ));
        System.out.println(bsv1(data,0,data.length - 1, 0 ));
        System.out.println(bsv1(data,0,data.length - 1, 1 ));
    }

    public static void  test_bsv2() {
        int[] data = {1,2,3,4,5};
        System.out.println(bsv2(data, 5 ));
        System.out.println(bsv2(data, 0 ));
        System.out.println(bsv2(data, 1 ));
    }

    /**
     * 自己的版本；有问题：尾部的边界没有考虑清楚；
     * 比如data [1,2] 查的元素是2； 每次计算mid的值都是0，然后继续计算[0,1],会一直计算[0,1]永远都不能
     * 正常返回，导致 stackoverflow错误；
     *
     * @param data
     * @param start
     * @param end
     * @param e
     * @return
     */
    public static int bs(int [] data, int start, int end, int e) {
        if (start == end) {
            return  (data[start] == e) ? start : -1;
        }

        int mid = start + (end - start) /2 ;
        if (data[mid] == e) {
            return mid;
        }else if (data[mid] < e) {
            return bs(data,mid,end,e);
        }else {
            return bs(data,start,mid,e);
        }
    }


    /**
     * 自己改进版： 没有问题
     * @param data
     * @param start
     * @param end
     * @param e
     * @return
     */
    public static int bsv1(int [] data, int start, int end, int e) {
        if (start > end) {return -1 ; }

        if (start == end) {
            return  (data[start] == e) ? start : -1;
        }

        int mid = start + (end - start) /2 ;
        if (data[mid] == e) {
            return mid;
        }else if (data[mid] < e) {
            return bsv1(data,mid + 1,end,e);
        }else {
            return bsv1(data,start,mid - 1,e);
        }
    }


    /**
     * 非递归 ： 没有问题
     * @param data
     * @param e
     * @return
     */
    public static int bsv2(int [] data, int e) {
        int sIndex = 0;
        int eIndex = data.length - 1;
        int midIndex;

        while (sIndex <= eIndex) {
            midIndex = sIndex + (eIndex - sIndex) / 2;
            if (data[midIndex] == e) {
                return midIndex;
            }
            if (data[midIndex] < e) {
                sIndex = midIndex + 1;
            }
            if (data[midIndex] > e) {
                eIndex = midIndex - 1;
            }
        }

        return - 1;
    }
}
