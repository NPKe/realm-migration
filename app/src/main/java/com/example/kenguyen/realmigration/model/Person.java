package com.example.kenguyen.realmigration.model;

/**
 * Created by Ke Nguyen on 4/14/2016.
 */

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.Required;

public class Person extends RealmObject {

    @Required
    private String fullName;
    private String email;
    private int age;
    private RealmList<Pet> pets;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public Person() {

    }
}

