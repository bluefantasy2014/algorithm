/**
 *
 * 折半查找
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};

        System.out.println(bsv1(data,0,data.length - 1, 5 ));
        System.out.println(bsv1(data,0,data.length - 1, 0 ));
        System.out.println(bsv1(data,0,data.length - 1, 1 ));
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
}
