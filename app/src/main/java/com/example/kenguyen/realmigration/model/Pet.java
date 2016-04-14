package com.example.kenguyen.realmigration.model;

import io.realm.RealmObject;
import io.realm.RealmObjectSchema;
import io.realm.annotations.Required;

/**
 * Created by Ke Nguyen on 4/14/2016.
 */
public class Pet extends RealmObject {
    @Required
    private String name;

    private int type;

    public Pet(String n, int t) {
        name = n; type = t;
    }

    public Pet() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
