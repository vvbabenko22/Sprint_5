package com.example.test;

import com.example.Animal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AnimalTest {

    private final Animal animal = new Animal();

    // Проверяем рацион травоядного
    @Test
    public void testGetFoodHerbivore() throws Exception {
        List<String> foodList = animal.getFood("Травоядное");
        assertTrue(foodList.containsAll(List.of("Трава", "Различные растения")));
    }

    // Проверяем рацион хищника
    @Test
    public void testGetFoodCarnivore() throws Exception {
        List<String> foodList = animal.getFood("Хищник");
        assertTrue(foodList.containsAll(List.of("Животные", "Птицы", "Рыба")));
    }

    // Проверяем обработку исключения при передаче неправильного типа животного
    @Test
    public void testGetFoodInvalidType() {
        Throwable exception = assertThrows(Exception.class, () -> animal.getFood("Некорректный тип"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    // Проверяем получение семейства животных
    @Test
    public void testGetFamily() {
        String familyInfo = animal.getFamily();
        assertNotNull(familyInfo);
        assertTrue(familyInfo.contains("кошачьи"));
    }
}