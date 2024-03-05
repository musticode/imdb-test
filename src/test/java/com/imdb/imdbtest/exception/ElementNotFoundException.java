package com.imdb.imdbtest.exception;

import org.openqa.selenium.NoSuchElementException;

public class ElementNotFoundException extends NoSuchElementException {
    public ElementNotFoundException(String reason) {
        super(reason);
    }
}
