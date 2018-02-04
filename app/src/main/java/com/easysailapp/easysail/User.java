package com.easysailapp.easysail;

/**
 * Created by Quoc on 2/4/2018.
 */

public class User {
    String name;
    String message;

    public User(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
