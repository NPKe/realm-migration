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

    @Required
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
