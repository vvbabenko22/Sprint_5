package com.example.test;

import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {

    @Mock
    private Feline mockFeline;

    private Cat cat;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(mockFeline);
    }

    // Проверяем, что кошка говорит Мяу
    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    // Проверяем, что кошка хищник
    @Test
    public void testGetFood() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> foodList = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foodList);
    }
}