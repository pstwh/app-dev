package com.pstwh.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        String[] contacts = {"Paulo", "Ricardo", "Pedro", "Anna"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);

        ListView contactsView = (ListView) findViewById(R.id.contacts);
        contactsView.setAdapter(adapter);

    }
}
