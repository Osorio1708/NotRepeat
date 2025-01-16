package com.exercise.no.repeat.services;

import org.springframework.stereotype.Service;

@Service
public interface RemoveDuplicatesServiceImpl {
    public String removeDuplicates(String input);
}
