package com.example.test;

import com.example.Lion;
import com.example.Feline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    @Test
    void testGetKittens() throws Exception {
        // Создаем экземпляр хищника Feline и передаем его в Lion
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline); // Передаем зависимый объект через конструктор
        assertEquals(1, lion.getKittens());
    }

    @Test
    void testDoesHaveManeMale() throws Exception {
        Feline feline = new Feline();
        Lion maleLion = new Lion("Самец", feline);
        assertTrue(maleLion.doesHaveMane());
    }

    @Test
    void testDoesHaveManeFemale() throws Exception {
        Feline feline = new Feline();
        Lion femaleLion = new Lion("Самка", feline);
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    void testGetFood() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    void testInvalidSexThrowsException() {
        Feline feline = new Feline();
        try {
            new Lion("Неверный пол", feline);
            fail("Должно было выбросить исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}