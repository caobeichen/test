package com.study.springcloud.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ListOperator<T> {

    /**
     * 过滤某些元素
     *
     * @param list
     * @param predicate 过滤策略 过滤不匹配
     * @return
     */
    public List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>(list);
        Iterator<T> it = result.iterator();
        while (it.hasNext()) {
            T element = it.next();
            if (!predicate.test(element)) {
                it.remove();
            }
        }
        return result;
    }

    /**
     * 操作全部元素
     *
     * @param list
     * @param operator 操作策略
     * @return
     */
    public List<T> operator(List<T> list, UnaryOperator<T> operator) {
        List<T> result = new ArrayList<>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            T element = it.next();
            result.add(operator.apply(element));
        }
        return result;
    }

    /**
     * 操作过滤后的元素
     *
     * @param list
     * @param predicate 过滤策略
     * @param operator  操作策略 过滤不匹配
     * @return
     */
    public List<T> filterOperator(List<T> list, Predicate<T> predicate, UnaryOperator<T> operator) {
        List<T> op = new ArrayList<>(list);
        List<T> result = new ArrayList<>();
        Iterator<T> it = op.iterator();
        while (it.hasNext()) {
            T element = it.next();
            if (predicate.test(element)) {
                result.add(operator.apply(element));
            }
        }
        return result;
    }


    /**
     * 过滤操作后的元素
     *
     * @param list
     * @param operator  操作策略
     * @param predicate 过滤策略
     * @return
     */
    public List<T> operatorFilter(List<T> list, UnaryOperator<T> operator, Predicate<T> predicate) {
        List<T> op = new ArrayList<>(list);
        List<T> result = new ArrayList<>();
        Iterator<T> it = op.iterator();
        while (it.hasNext()) {
            T element = operator.apply(it.next());
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

}
