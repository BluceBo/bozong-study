package com.banggood.bozong.study.javathink.chapter18;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by admin on 2018/4/3.
 * 容器默认的toString()方法会在单个行中打印容器中的所有元素，
 * 对于大型集合来说这会变得难以阅读，因此你可能希望使用可替换的格式化机制。
 * 下面是一个可以添加新行并缩排所有元素的工具：
 */
public class PPrint {
    public static String pformat(Collection<?> c) {
        if (c.size() == 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        for (Object elem : c) {
            if (c.size() != 1) {
                result.append("\n ");
            }
            result.append(elem);
        }
        if (c.size() != 1) {
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }
    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }
    public static void pprint(Object[] c) {
        System.out.println(pformat(Arrays.asList(c)));
    }
}
