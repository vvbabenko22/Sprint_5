package com.example.test;

import com.example.Lion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LionTest {

    // Проверяем наличие гривы у льва-самца
    @Test
    public void testMaleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    // Проверяем отсутствие гривы у львицы
    @Test
    public void testFemaleLionNoMane() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    // Проверяем количество потомства у львов

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец");
        int kittenCount = lion.getKittens();
        assertEquals(1, kittenCount); //Стандартное поведение метода getKittens()
    }

    // Проверяет рацион питания льва
    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец");
        List<String> foodList = lion.getFood();
        assertTrue(foodList.containsAll(List.of("Животные", "Птицы", "Рыба")));
    }

    // Проверяем исключение при вводе недопустимых значений пола
    @Test
    public void testInvalidSex() {
        Throwable exception = assertThrows(Exception.class, () -> new Lion("Неправильное значение"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}