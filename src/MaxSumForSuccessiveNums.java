import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/*
*  算法输入： int类型数组；
*  算法输出： 相邻数字的最大和
* **/
public class MaxSumForSuccessiveNums {
    public static void main(String[] args) {
        int[] data = {2,-3,1,4,-3,90};
        int sum = maxSumForSuccessiveNums(data);
        System.out.println(sum);
    }

    public static int maxSumForSuccessiveNums(int[] data){
       int max = Integer.MIN_VALUE;
       int[] tmp = new int[data.length];
       tmp[0] = data[0];
       max = Integer.max(max,tmp[0]);
       for(int i=1; i<data.length; ++i){
           tmp[i] = Integer.max(tmp[i-1]+data[i],data[i]);
           max = Integer.max(max,tmp[i]);
       }
       return max;
    }
}
