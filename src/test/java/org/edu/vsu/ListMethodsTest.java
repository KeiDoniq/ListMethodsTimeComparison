package org.edu.vsu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ListMethodsTest {
    @BeforeAll
    static void beforeAll() {
        ListMethods linkedListMethods = new ListMethods(LinkedList.class,25);
        ListMethods arrayListMethods = new ListMethods(ArrayList.class,25);
    }

    @BeforeEach
    void setUp() {

    }
}