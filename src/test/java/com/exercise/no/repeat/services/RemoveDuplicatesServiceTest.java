package com.exercise.no.repeat.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveDuplicatesServiceTest {

    private RemoveDuplicatesService removeDuplicatesService;

    @BeforeEach
    public void setUp() {
        removeDuplicatesService = new RemoveDuplicatesService();
    }

    @Test
    public void shouldRemoveDuplicates() {
        assertEquals("ABCD123", removeDuplicatesService.removeDuplicates("AABBCCD112233"));
    }

    @Test
    public void shouldReturnSameStringIfItDoesNotHaveDuplicates() {
        assertEquals("ABC123", removeDuplicatesService.removeDuplicates("ABC123"));
    }


    @Test
    public void shouldHandleRemoveDuplicatesWithSpecialCharacters() {
        assertEquals("A!@#$%", removeDuplicatesService.removeDuplicates("AA!!@@##$$%%"));
    }

    @Test
    public void shouldHandleRemoveDuplicatesWithNumericOnly() {
        assertEquals("123", removeDuplicatesService.removeDuplicates("112233"));
    }

    @Test
    public void shouldAlsoRemoveDuplicatesEmptyStrings() {
        assertEquals("A BCD123", removeDuplicatesService.removeDuplicates("AA BB  CC  DD  112233"));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfInputIsNullOrEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            removeDuplicatesService.removeDuplicates(null);
        });
        assertEquals("Input cannot be null or empty", exception.getMessage());
    }
}
