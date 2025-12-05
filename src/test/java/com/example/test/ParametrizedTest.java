package com.example.test;

import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParametrizedTest {

    // Проверка, что кот говорит мяу
    @ParameterizedTest
    @ValueSource(strings = {"Простая проверка", "Ещё одна проверка", "Финальная проверка"})
    public void testCatSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound(), "Звук кота должен быть \"Мяу\"");
    }

    // Параметризованный тест проверки исключений при передаче неправильных типов животных
    @ParameterizedTest
    @ValueSource(strings = {"Неправильно", "Неважно", "Еще одно неверное значение"})
    public void testAnimalInvalidTypes(String invalidType) {
        com.example.Animal animal = new com.example.Animal();
        assertThrows(Exception.class, () -> animal.getFood(invalidType));
    }

    // Параметризованный тест проверки исключений при передаче недопустимых значений пола льва
    @ParameterizedTest
    @ValueSource(strings = {"Другой неправильный", "И снова некорректно", "Последний пример"})
    public void testLionInvalidSex(String wrongSex) {
        Feline feline = new Feline();
        assertThrows(Exception.class, () -> new Lion(wrongSex, feline));
    }
}