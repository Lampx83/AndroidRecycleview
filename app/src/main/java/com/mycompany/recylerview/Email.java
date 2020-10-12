package com.mycompany.recylerview;

import java.io.Serializable;

public class Email implements Serializable {
    String title;
    String description;

    public Email(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
