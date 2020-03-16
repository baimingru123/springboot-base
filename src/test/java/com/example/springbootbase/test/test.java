package com.example.springbootbase.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-01-14 17:06
 */
public class test {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(5,"d");
        map.put(7,"e");
        map.put(9,"f");
        Map change = change(map, 9, 3);
        System.out.println(change);

    }
    private static Map change(Map map,Integer source,Integer target){
        //跳出递归的时机，当目标和自身相等的时候
        if (source.equals(target)){
            return map;
        }
        //目标不为空时，交换两个角标对应元素的位置。目标为空时，也是交换。但是可以直接结束递归，节省空间消耗
        if (map.get(target)!=null){
            map.put(0,map.get(source));
            map.put(source,map.get(target));
            map.put(target,map.get(0));
            map.remove(0);
        }else{
            map.put(target,map.get(source));
            map.remove(source);
            return map;
        }
        //目标值+1
        change(map,source,target+1);
        return map;
    }
}
