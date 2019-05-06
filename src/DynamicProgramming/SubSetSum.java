package DynamicProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
*   问题描述：
*   给定一个数组，数组中的数字为整形数字； 给定另外一个数字K； 求数组中所有的满足加和等于K的所有组合；
*
*   举例： a [0, 3, 2, 4, 1] ;  K = 5;
*   输出为： [3,2] , [4, 1] 结果无顺序要求；
*
* */
public class SubSetSum {

    public static int K = 5;

    public static void main(String[] args) {
        int [] a = new int[]{0, 3, 2, 4, 1};
        List<Set<Integer>> list = bruteForce(a, a.length,K);
        System.out.println(list);
    }

    /*暴力求解法*/
    public static List<Set<Integer>> bruteForce(int[] a, int size, int sum){
        if (a.length < 1 ) throw new RuntimeException("invalid param!");

        List<Set<Integer>> list = new ArrayList<>();
        //先初始化list，放入第一个元素的set
        Set<Integer> s = new HashSet<>();
        s.add(a[0]);
        list.add(s);

        //处理剩余的元素
        for (int i = 1; i < size; ++i){ //i：表示当前正在处理的元素
          List<Set<Integer>> l1 = getListOfCurrentElement(list,a[i]);
          System.out.println("list for " + a[i] + " is :" + l1 );
          list.addAll(l1);
        }

        return getMatchedList(list,K);
    }

    /*
    *
    * */
    private static List<Set<Integer>> getListOfCurrentElement(List<Set<Integer>> list, Integer currentElement){
        List<Set<Integer>> resultList = new ArrayList<>();
        //先加入只有当前元素的set
        Set<Integer> s1 = new HashSet<>();
        s1.add(currentElement);
        resultList.add(s1);

        //再遍历当前的list，把当前元素添加到每个set的尾部
        for (Set<Integer> s : list){
            Set<Integer> s2 = new HashSet<>(s);
            s2.add(currentElement);
            resultList.add(s2);
        }

        return resultList;
    }

    private static List<Set<Integer>> getMatchedList(List<Set<Integer>> list, int sum){
       return list.stream().filter(new Predicate<Set<Integer>>() {
           @Override
           public boolean test(Set<Integer> integers) {
               return integers.stream().mapToInt(Integer::intValue).sum() == sum;
           }
       }).collect(Collectors.toList());
    }


}


