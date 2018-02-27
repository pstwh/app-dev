package com.pstwh.contacts;

import android.widget.EditText;
import android.widget.RatingBar;

import com.pstwh.contacts.models.Contact;

/**
 * Created by pstwh on 27/02/2018.
 */

public class ContactsHelper {
    private EditText nameField;
    private EditText addressField;
    private EditText telephoneField;
    private EditText websiteField;
    private RatingBar ratingField;

    public ContactsHelper(ContactsCreateActivity activity) {
        this.nameField = (EditText) activity.findViewById(R.id.contacts_create_name);
        this.addressField = (EditText) activity.findViewById(R.id.contacts_create_address);
        this.telephoneField = (EditText) activity.findViewById(R.id.contacts_create_telephone);
        this.websiteField = (EditText) activity.findViewById(R.id.contacts_create_website);
        this.ratingField = (RatingBar) activity.findViewById(R.id.contacts_create_ratingbar);
    }

    public Contact getContact() {
        Contact contact = new Contact();
        contact.setName(nameField.getText().toString());
        contact.setAddress(addressField.getText().toString());
        contact.setTelephone(telephoneField.getText().toString());
        contact.setWebsite(websiteField.getText().toString());
        contact.setRating(Double.valueOf(ratingField.getProgress()));

        return contact;
    }
}
