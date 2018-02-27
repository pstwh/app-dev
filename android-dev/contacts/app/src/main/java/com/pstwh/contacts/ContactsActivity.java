package com.pstwh.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.pstwh.contacts.dao.ContactDAO;
import com.pstwh.contacts.models.Contact;

import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_index);

        getContacts();

        Button createContact = (Button) findViewById(R.id.contacts_index_save);
        createContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactsActivity.this, ContactsCreateActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getContacts();
    }

    private void getContacts() {
        ContactDAO contactDAO = new ContactDAO(this);
        List<Contact> contacts = contactDAO.getContacts();
        contactDAO.close();

        ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, contacts);

        ListView contactsView = (ListView) findViewById(R.id.contacts);
        contactsView.setAdapter(adapter);
    }
}
