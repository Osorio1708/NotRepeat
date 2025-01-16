package com.exercise.no.repeat.services;

import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class RemoveDuplicatesService implements RemoveDuplicatesServiceImpl {
    @Override
    public String removeDuplicates(String input) {

        if (input == null || input.isEmpty()) {
          throw new IllegalArgumentException("Input cannot be null or empty");
        }

        // Using LinkedHashSet to maintain the order of the characters and uniqueness
        Set<Character> uniqueChars = new LinkedHashSet<>();
        for (char c : input.toCharArray()) {
            uniqueChars.add(c);
        }

        // Building the result string
        StringBuilder result = new StringBuilder();
        for (char c : uniqueChars) {
            result.append(c);
        }

        return result.toString();
    }
}
