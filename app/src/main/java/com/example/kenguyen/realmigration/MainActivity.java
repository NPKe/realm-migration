package com.example.kenguyen.realmigration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kenguyen.realmigration.model.MyMigration;
import com.example.kenguyen.realmigration.model.Person;
import com.example.kenguyen.realmigration.model.Pet;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Realm realm;
    private RealmConfiguration config;
    private RealmResults<Person> personList;
    private RealmResults<Pet> petList;

    private ListView listView;
    private List<String> data = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configRealm();

        //initData();

        addPets();

        query();

        addData();

        showInList();
    }

    void configRealm() {
        config = new RealmConfiguration.Builder(this)
                .name("DemoMigration.realm")
                .schemaVersion(2)
                .migration(new MyMigration())
                .build();

        realm = Realm.getInstance(config);
    }

    void addPets() {
        Person p = realm.where(Person.class)
                        .equalTo("fullName", "Tuan Nguyen")
                        .findFirst();

        realm.beginTransaction();

        p.getPets().add(new Pet("Jimbo", "dog"));
        p.getPets().add(new Pet("Cubin", "cat"));

        realm.commitTransaction();
    }

    void initData() {
        Pet pet = null;

        realm.beginTransaction();

        pet = new Pet("Jimbo", "dog");
        realm.copyToRealm(pet);

        pet = new Pet("Cubin", "cat");
        realm.copyToRealm(pet);

        pet = new Pet("Baboo", "pig");
        realm.copyToRealm(pet);

        realm.commitTransaction();
    }

    void query() {
        personList = realm.where(Person.class).findAll();
        petList = realm.where(Pet.class).findAll();
    }

    void addData() {
        for (Person p : personList) {
            data.add(p.toString());
        }
        for (Pet p : petList) {
            data.add(p.toString());
        }
    }

    void showInList() {
        listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
    }
}
