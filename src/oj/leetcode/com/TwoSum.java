package oj.leetcode.com;

import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		twoSum(new int[]{1,2,2,7,9},4); 
	}
	
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,String> data = new HashMap<Integer,String>(); 
        
        int index1 = 0, index2 =0; 
        String value; 
        for (int i = 0; i < numbers.length; ++i){
            value  = data.get(target - numbers[i]); 
            if (value != null){ //binggo!
                index1 = Integer.parseInt(value.substring(value.indexOf("$")+1)); 
                index2 = i; 
                break; 
            }else {
                data.put(numbers[i],numbers[i]+"$"+ i); 
            }
        }
        //sjj test 001 I made some change 
        System.out.println("index1:" + index1 + " index2:" + index2); 
        int[] ret = new int[2]; 
        ret[0] = index1; 
        ret[1] = index2;
        
        //sjj make another change for testing 
        return ret; 
    }
}
