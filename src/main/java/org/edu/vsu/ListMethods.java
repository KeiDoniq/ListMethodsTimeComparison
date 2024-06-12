package org.edu.vsu;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ListMethods {
    List<Integer> list;
    static int COUNT;
    public ListMethods(Class listClass, int countToRun) {
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

    public void addToHead(){
        for(int i = 0; i<COUNT; i++)
            list.add(0, i);
    }

    public void addToTail(){
        for(int i = 0; i < COUNT; i++)
            list.add(i, i);
    }

    public void addToMidd(){
        for(int i = 0; i < COUNT; i++)
            list.add(i%2, i);
    }
    public void addToRandom(){
        for(int i = 0; i<COUNT;i++) {
            list.add(ThreadLocalRandom.current().nextInt(list.size()), i);
        }
    }
    public void addByValue(){
        for(int i = 0; i<COUNT;i++) {
            list.add(i);
        }
    }
    public void deleteByValue(){
        for(int i = 0; i<COUNT;i++) {
            list.remove(i);
        }
    }
    public void deleteFromHead(){
        for(int i = 0; i<COUNT;i++) {
            list.remove(0);
        }
    }
    public void deleteFromMidd(){
        for(int i = 0; i<COUNT;i++) {
            list.remove((list.size() % 2));
        }
    }
    public void deleteFromTail(){
        for(int i = 0; i<COUNT;i++) {
            list.remove(list.size() - i);
        }
    }
    public void deleteFromRandom(){
        for(int i = 0; i<COUNT;i++) {
            list.remove(ThreadLocalRandom.current().nextInt(list.size()));
        }
    }
    public void contains(){
        for(int i = 0; i<COUNT;i++) {
            list.contains(ThreadLocalRandom.current().nextInt(COUNT));
        }
    }
    public void clear(){
        list.clear();
    }
    public void getAtRandomPosition(){
        for(int i = 0; i <COUNT; i++){
            list.get(ThreadLocalRandom.current().nextInt(list.size()));
        }
    }
    public void sort(){
        list.sort(ListMethods::compare);
    }
    private static int compare(Integer a, Integer b) {
        if (a < b) return 1;
        else if (a == b) return 0;
        else return -1;
    }
}
