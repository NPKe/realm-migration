package com.example.kenguyen.realmigration.model;

/**
 * Created by Ke Nguyen on 4/14/2016.
 */

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

public class Person extends RealmObject {

    private String firstName;
    private String lastName;

    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {

    }
}

