package com.pstwh.contacts;

import android.content.Intent;
import android.net.Uri;
import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.pstwh.contacts.dao.ContactDAO;
import com.pstwh.contacts.models.Contact;

import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    private ListView contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_index);

        contacts = (ListView) findViewById(R.id.contacts);

        contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Contact contact = (Contact) contacts.getItemAtPosition(position);
                Intent intent = new Intent(ContactsActivity.this, ContactsCreateActivity.class);

                intent.putExtra("contact", contact);
                startActivity(intent);
            }
        });

        Button createContact = (Button) findViewById(R.id.contacts_index_save);
        createContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactsActivity.this, ContactsCreateActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(contacts);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getContacts();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Contact contact = (Contact) contacts.getItemAtPosition(info.position);

        String w = contact.getWebsite();
        if (!w.startsWith("http://")) w = "http://"+w;

        MenuItem website = menu.add("Website").setIntent(
                new Intent(Intent.ACTION_VIEW).setData(Uri.parse(w))
        );

        MenuItem sms = menu.add("SMS").setIntent(
                new Intent(Intent.ACTION_VIEW).setData(Uri.parse("sms:"+contact.getTelephone()))
        );

        MenuItem map = menu.add("Map").setIntent(
                new Intent(Intent.ACTION_VIEW).setData(Uri.parse("geo:0,0?q="+contact.getAddress()))
        );

        MenuItem call = menu.add("Call").setIntent(
                new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+contact.getTelephone()))
        );

        MenuItem delete = menu.add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                ContactDAO contactDAO = new ContactDAO(ContactsActivity.this);
                contactDAO.remove(contact);
                contactDAO.close();

                getContacts();

                Toast.makeText(ContactsActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
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
