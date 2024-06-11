package org.edu.vsu;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ListMethods {
    List<Integer> list;
    static int COUNT;


    public ListMethods(Class listClass, int countToRun) {
        try {
            this.list = (List<Integer>) listClass.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        COUNT = countToRun;
    }


    private void deleteToIndex(int index){
        for(int i = 0; i<COUNT; i++) {
            list.add(index, i);
        }
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
            list.remove(i);
        }
    }
}
