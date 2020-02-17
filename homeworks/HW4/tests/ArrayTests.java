package telran.util.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.Array;

class ArrayTests {

    @Test
    void testAddGetSize() {
        Array array = new Array(4);
        int numbers[] = { 10, -8, 70, 75, 30 };
        for (int i = 0; i < numbers.length; i++) {
            array.add(numbers[i]);
        }
        for (int i = 0; i < array.size(); i++) {
            assertEquals(numbers[i], array.get(i));
        }
        assertNull(array.get(array.size()));

    }

    @Test
    void testAddByIndex() {
        Array array = new Array(4);
        int numbers[] = { 10, -8, 70, 75, 30 };
        Array expected = new Array(4);
        expected.add(1);
        Array expected2 = new Array(4);
        expected2.add(1);
        for (int i = 0; i < numbers.length; i++) {
            array.add(numbers[i]);
            expected.add(numbers[i]);
            expected2.add(numbers[i]);
        }

        array.add(0, 1);
        expected2.add(1);

        for (int i = 0; i < array.size(); i++) {
            assertEquals(expected.get(i), array.get(i));
        }
        array.add(array.size(), 1);
        
        for (int i = 0; i < array.size(); i++) {
            assertEquals(expected2.get(i), array.get(i));
        }
        assertFalse(array.add(-1, 10));

    }
    
    @Test
    void testRemoveByIndex() {
        Array array = new Array(4);
        int numbers[] = { 10, -8, 70, 75, 30 };
        Array expected = new Array(4);
        Array expected2 = new Array(4);
        for (int i = 0; i < numbers.length; i++) {
            array.add(numbers[i]);
            if (i != 0) {
                expected.add(numbers[i]);
            }
            if (i != 0 && i != numbers.length - 1) {
                expected2.add(numbers[i]);
            }
        }
        
        array.remove(0);
                
        for (int i = 0; i < array.size(); i++) {
            assertEquals(expected.get(i), array.get(i));
        }
        
        array.remove(array.size() - 1);
        
        for (int i = 0; i < array.size(); i++) {
            assertEquals(expected2.get(i), array.get(i));
        }
    }
    
    @Test
    void testSetElementByIndex() {
        Array array = new Array(4);
        int numbers[] = { 10, -8, 70, 75, 30 };
        Array expected = new Array(4);
        expected.add(11);
        
        for (int i = 0; i < numbers.length; i++) {
            array.add(numbers[i]);
            if(i!=0) {
                expected.add(numbers[i]);
            }
        }
        
        array.set(0, 11);
        
        for (int i = 0; i < array.size(); i++) {
            assertEquals(expected.get(i), array.get(i));
        }
    }
    
}

