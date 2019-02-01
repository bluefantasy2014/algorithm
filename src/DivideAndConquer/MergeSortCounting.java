package DivideAndConquer;

import com.sun.scenario.effect.Merge;

/*
* 给定一个包含数字的数组； 求这个数组中的数字的逆序数；
* 比如 【1，4，2，3】 的逆序数就是 2;
*
* 思路就是借助mergesort来实现。
* */
public class MergeSortCounting {
    public static void main(String[] args) {
        int[] data = {6,4,5,3};
        System.out.println(mergeSortAndCount(data,0,data.length-1));
    }

    /*
    * 功能： 对data数组中【start,end】范围进行merge排序并返回逆序数
    * @param data[] : 数组
    * @param start : 开始为止
    * @param end  :结束位置
    *
    * @return 逆序数
    * */
    public static int mergeSortAndCount(int [] data, int start, int end){
       if (start >= end){
           return 0;
       }

       int mid = (start + end)/2;
       int lSum = mergeSortAndCount(data,start,mid);
       int rSum = mergeSortAndCount(data,mid + 1,end);
       return lSum + rSum + merge(data,start,mid,end);
    }

    /*
    * 功能： 对数组的[start,mid]和[mid+1,end]部分进行归并并返回这两部分归并过程中的逆序数；
    * */
    public static int merge(int [] data, int start,int mid, int end){
       int count = 0;
       int i = start;
       int j = mid + 1;
       int k = 0;
       int[] tmp = new int[end - start +1];

       while(i <= mid && j <= end){
           if (data[i] <= data[j]){
             tmp[k++] = data[i++] ;
           }else {
               count += mid - i + 1;
               tmp[k++] = data[j++];
           }
       }

       while(i <= mid){
           tmp[k++] = data[i++];
       }

       while(j <= end){
           tmp[k++] = data[j++];
       }

       for (int a =start; a <=end-start; ++a){
           data[a] = tmp[a];
       }

       return count;
    }
}
