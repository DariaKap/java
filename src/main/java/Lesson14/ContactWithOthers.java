package Lesson14;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;


public class ContactWithOthers extends Contact{
    @Getter
    private Collection<Contact> linkedContact = new ArrayList<>();

    public boolean checkExistLinkedContact(ContactWithOthers cont){
        return this.linkedContact.contains(cont);
    }

    public void addLinkedContact(ContactWithOthers cont){
        this.linkedContact.add(cont);
    }

    @Override
    public String toString() {
        return super.toString() +  " ContactWithOthers{" +
                "linkedContact=" + linkedContact.size() +
                '}';
    }
}

