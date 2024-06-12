package org.edu.vsu;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
/**
 * Класс ListMeasure измеряет время выполнения различных операций над списками.
 */
public class ListMeasure {
    /**
     * Количество выполнений каждой операции.
     */
    private final int exeCount;
    /**
     * Конструктор класса ListMeasure.
     *
     * @param executionCount Количество выполнений каждой операции.
     */
    public ListMeasure(int executionCount) {
        this.exeCount = executionCount;
    }
    /**
     * Создает и возвращает строку в виде таблицы
     * с результатами измерений времени выполнения операций над списками.
     *
     * @return Строка с таблицей результатов измерений.
     */
    public String viewResTable(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-".repeat(100)).append('\n');
        stringBuilder.append(String.format("%-25s%-50s%-40s%n","Method","LinkedList Time, ns","ArrayList Time, ns"));
        stringBuilder.append("-".repeat(100)).append('\n');
        List<String> methods = new ArrayList<>(Arrays.asList(
                "addToHead", "deleteFromHead",
                "addToTail", "deleteFromTail",
                "addToMidd", "deleteFromMidd",
                "addToRandom",  "sort",
                "contains", "getAtRandomPosition",
                "deleteFromRandom",
                "addByValue",   "deleteByValue",
                "addToRandom", "clear"
                ));
        try {
            ListMethods linkedListMethods = new ListMethods(LinkedList.class, exeCount);
            ListMethods arrayListMethods = new ListMethods(ArrayList.class, exeCount);
            for(String methodName: methods){
                stringBuilder.append(methodName).
                        append(String.format("%n%40d%40d%n",
                                measure(linkedListMethods, ListMethods.class.getMethod(methodName)),
                                measure(arrayListMethods, ListMethods.class.getMethod(methodName)))).
                        append('\n');
                //System.out.println(methodName);
                //System.out.println("linked" + linkedListMethods.list.size());
                //System.out.println("array" + arrayListMethods.list.size());
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
    /**
     * Измеряет время выполнения заданного метода для указанного объекта ListMethods.
     *
     * @param list   Объект ListMethods, для которого выполняется метод.
     * @param method Метод, время выполнения которого измеряется.
     * @return Время выполнения метода в наносекундах.
     */
    private long measure(ListMethods list, Method method){
        long start = System.nanoTime();
        try {
            method.invoke(list);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        long end = System.nanoTime();
        return end - start;
    }
}
