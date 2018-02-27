package com.pstwh.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_index);

        String[] contacts = {"Paulo", "Ricardo", "Pedro", "Anna"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);

        ListView contactsView = (ListView) findViewById(R.id.contacts);
        contactsView.setAdapter(adapter);

        Button createContact = (Button) findViewById(R.id.contacts_index_save);
        createContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactsActivity.this, ContactsCreateActivity.class);
                startActivity(intent);
            }
        });


    }
}
