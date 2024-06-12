package org.edu.vsu;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Класс-обертка, содержащий методы для работы с List.
 */
public class ListMethods {
    List<Integer> list;
    static int COUNT;
    /**
     * Конструктор, создающий экземпляр списка указанного типа и устанавливающий количество операций.
     *
     * @param listClass Класс, реализующий интерфейс List.
     * @param countToRun Количество операций для выполнения.
     */
    public ListMethods(Class<? extends List> listClass, int countToRun) {
        try {
            this.list = (List<Integer>) listClass.getConstructor().newInstance();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        COUNT = countToRun;
    }

    /**
     * Добавляет элементы в начало списка.
     */
    public void addToHead(){
        for(int i = 0; i<COUNT; i++)
            list.addFirst(i);
    }
    /**
     * Добавляет элементы в конец списка.
     */
    public void addToTail(){
        for(int i = 0; i < COUNT; i++)
            list.add(i, i);
    }
    /**
     * Добавляет элементы в середину списка.
     */
    public void addToMidd(){
        for(int i = 0; i < COUNT; i++)
            list.add(i%2, i);
    }
    /**
     * Добавляет элементы в рандомные позиции списка.
     */
    public void addToRandom(){
        for(int i = 0; i<COUNT;i++) {
            list.add(ThreadLocalRandom.current().nextInt(list.size()), i);
        }
    }
    /**
     * Добавление элементов.
     */
    public void addByValue(){
        for(int i = 0; i<COUNT;i++) {
            list.add(i);
        }
    }
    /**
     * Удаление элементов.
     */
    public void deleteByValue(){
        for(int i = 0; i<COUNT;i++) {
            list.remove(i);
        }
    }
    /**
     * Удаление элементов из начала списка.
     */
    public void deleteFromHead(){
        for(int i = 0; i<COUNT;i++) {
            list.removeFirst();
        }
    }
    /**
     * Удаление элементов из середины списка.
     */
    public void deleteFromMidd(){
        for(int i = 0; i<COUNT;i++) {
            list.remove((list.size() % 2));
        }
    }
    /**
     * Удаление элементов с конца списка.
     */
    public void deleteFromTail(){
        for(int i = 1; i <= COUNT;i++) {
            list.remove(COUNT - i);
        }
    }
    /**
     * Удаление элементов из рандомных позиций.
     */
    public void deleteFromRandom(){
        for(int i = 0; i<COUNT;i++) {
            list.remove(ThreadLocalRandom.current().nextInt(list.size()));
        }
    }
    /**
     * Проверяет наличие случайных значений в списке.
     */
    public void contains(){
        for(int i = 0; i<COUNT;i++) {
            list.contains(ThreadLocalRandom.current().nextInt(COUNT));
        }
    }
    /**
     * Очищает список.
     */
    public void clear(){
        list.clear();
    }
    /**
     * Получает элементы.
     */
    public void getAtRandomPosition(){
        for(int i = 0; i <COUNT; i++){
            list.get(ThreadLocalRandom.current().nextInt(list.size()));
        }
    }
    /**
     * Сортирует список в порядке убывания.
     */
    public void sort(){
        list.sort(ListMethods::compare);
    }
    /**
     * Сравнивает два элемента списка.
     *
     * @param a Первый элемент для сравнения.
     * @param b Второй элемент для сравнения.
     * @return Результат сравнения.
     */
    static int compare(Integer a, Integer b) {
        return b.compareTo(a);
    }
}
