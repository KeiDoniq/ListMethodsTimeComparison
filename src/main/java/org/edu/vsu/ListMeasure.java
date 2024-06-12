package org.edu.vsu;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ListMeasure {
    public ListMeasure(int executionCount) {
        this.linkedListMethods = new ListMethods(LinkedList.class, executionCount);
        this.arrayListMethods = new ListMethods(ArrayList.class, executionCount);
    }
    public static String viewResTable(){
        StringBuilder stringBuilder = new StringBuilder(
                "Method");
        //TableStringBuilder

        stringBuilder.append("");
        return "";
    }
    private long measure(Class list, Method method){
        long start = System.nanoTime();
        try {
            Object invoke = method.invoke(list);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return System.nanoTime() - start;
    }
    private final ListMethods linkedListMethods;
    private final ListMethods arrayListMethods;
}
