package com.example.test;

import com.example.Animal;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParametrizedTest {

    // Параметризованный тест проверки исключений при передаче неправильных типов животных
    @ParameterizedTest
    @ValueSource(strings = {"Неправильно", "Неважно", "Еще одно неверное значение"})
    public void testAnimalInvalidTypes(String invalidType) {
        Animal animal = new Animal();
        assertThrows(Exception.class, () -> animal.getFood(invalidType));
    }

    // Параметризованный тест проверки исключений при передаче недопустимых значений пола льва
    @ParameterizedTest
    @ValueSource(strings = {"Другой неправильный", "И снова некорректно", "Последний пример"})
    public void testLionInvalidSex(String wrongSex) {
        assertThrows(Exception.class, () -> new Lion(wrongSex));
    }
}