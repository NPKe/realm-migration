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

import io.realm.Realm;
import io.realm.RealmConfiguration;
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

    private ListView listView;
    private List<String> data = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configRealm();

        //initData();

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

    void initData() {
//        Person student = null;
//
//        realm.beginTransaction();
//
//        student = new Person("Tuan", "Nguyen", 19);
//        realm.copyToRealm(student);
//
//        student = new Person("Huynh", "Phan", 20);
//        realm.copyToRealm(student);
//
//        student = new Person("Huy", "Nguyen", 80);
//        realm.copyToRealm(student);
//
//        realm.commitTransaction();
    }

    void query() {
        personList = realm.where(Person.class)
                .findAll();
    }

    void addData() {
        for (Person p : personList) {
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
