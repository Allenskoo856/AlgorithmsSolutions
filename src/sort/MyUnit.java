/*
 * Copyright (C), 2015-2017
 * FileName: MyUnit
 * Author:   Administrator
 * Date:     2017/11/9 0009 16:58
 * Description: MyUnit    
 */

package sort;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈MyUnit〉
 *
 * @author Administrator
 * @create 2017/11/9 0009
 * @since 1.0.0
 */
public class MyUnit {

    public static <T> T copy(Collection< ? super T> dept, Collection<T> src) {
        T last = null;
        for (T ele :src) {
            last = ele;
            dept.add(ele);
        }
        return last;
    }

    public static void main(String[] args) {
        List<Number> ln = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(5);
        Integer last = copy(ln, li);
        System.out.println(last);
    }
}
