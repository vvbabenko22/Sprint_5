package com.example.test;

import com.example.Feline;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class FelineTest {

    private final Feline feline = new Feline();

    // Проверяем рацион хищника
    @Test
    public void testEatMeat() throws Exception {
        List<String> meatList = feline.eatMeat();
        assertTrue(meatList.containsAll(List.of("Животные", "Птицы", "Рыба")));
    }

    // Проверяем принадлежность к семейству кошек
    @Test
    public void testGetFamily() {
        String familyName = feline.getFamily();
        assertEquals("Кошачьи", familyName);
    }

    // Проверяем реализацию количества детенышей
    @Test
    public void testGetKittensDefault() {
        int kittenCount = feline.getKittens();
        assertEquals(1, kittenCount);
    }

    // Проверяем передачу параметра количества детенышей
    @Test
    public void testGetKittensWithParam() {
        int customKittenCount = feline.getKittens(3);
        assertEquals(3, customKittenCount);
    }
}