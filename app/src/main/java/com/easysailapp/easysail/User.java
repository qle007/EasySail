package com.easysailapp.easysail;

import java.util.UUID;

/**
 * Created by Quoc on 2/4/2018.
 */

public class User {
    String name;
    UUID id;
    String message;

    public User(String name, String message) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
