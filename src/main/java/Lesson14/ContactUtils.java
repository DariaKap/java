package Lesson14;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContactUtils {

    public static ContactWithOthers[] getArrayContact(List<String> names, int count){
        long startTime = System.currentTimeMillis();
        ContactWithOthers[] contacts = new ContactWithOthers[count];
        for (int i = 0; i < count; i++) {
            ContactWithOthers contact = new ContactWithOthers();
            contact.setFullName(names.get(new Random().nextInt(names.size())));
            contact.setPhone(PhoneUtils.generatePhone());
            contacts[i] = contact;
        }
        long stopTime = System.currentTimeMillis();
        System.out.printf("Массив заполнялся %.2f сек. \n" , (stopTime - startTime)/1000f);
        return contacts;
    }

    public static List<ContactWithOthers> getListContact(List<String> names, int count){
        long startTime = System.currentTimeMillis();
        List<ContactWithOthers> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ContactWithOthers contact = new ContactWithOthers();
            contact.setFullName(names.get(new Random().nextInt(names.size())));
            contact.setPhone(PhoneUtils.generatePhone());
            contacts.add(contact);
        }
        long stopTime = System.currentTimeMillis();
        System.out.printf("Список заполнялся %.2f сек. \n" , (stopTime - startTime)/1000f);
        return contacts;
    }

    public static Set<ContactWithOthers> getSetContact(List<String> names, int count){
        long startTime = System.currentTimeMillis();
        Set<ContactWithOthers> contacts = new HashSet<>();
        for (int i = 0; i < count; i++) {
            ContactWithOthers contact = new ContactWithOthers();
            contact.setFullName(names.get(new Random().nextInt(names.size())));
            contact.setPhone(PhoneUtils.generatePhone());
            contacts.add(contact);
        }
        long stopTime = System.currentTimeMillis();
        System.out.printf("Множество заполнялось %.2f сек. \n" , (stopTime - startTime)/1000f);
        return contacts;
    }

    public static ContactWithOthers[] generateLinkedContacts(ContactWithOthers[] contacts, int count){
        for (ContactWithOthers cont:contacts){
            for (int i = 0; i < count; i++) {
                ContactWithOthers contact;
                do {
                    contact = contacts[new Random().nextInt(contacts.length)];
                }
                while (cont.checkExistLinkedContact(contact) || cont.equals(contact));
                cont.addLinkedContact(contact);
            }
        }
        return contacts;
    }

    public static List<ContactWithOthers> generateLinkedContacts(List<ContactWithOthers> contacts, int count){
        ContactWithOthers[] newContacts = generateLinkedContacts(contacts.toArray(new ContactWithOthers[contacts.size()]), count);
        return Arrays.stream(newContacts).toList();
    }

    public static Set<ContactWithOthers> generateLinkedContacts(Set<ContactWithOthers> contacts, int count){
        ContactWithOthers[] newContacts = generateLinkedContacts(contacts.toArray(new ContactWithOthers[contacts.size()]), count);
        return new HashSet<>(Arrays.asList(newContacts));
    }

    public static void getPopularContact(ContactWithOthers[] contacts){
        long startTime = System.currentTimeMillis();
        Collection<Contact> linkedContacts = new ArrayList<>();
        for (ContactWithOthers cont:contacts) {
            linkedContacts.addAll(cont.getLinkedContact());
        }
        linkedContacts.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);
        long stopTime = System.currentTimeMillis();
        System.out.printf("Массив обрабатывался %.2f сек. \n" , (stopTime - startTime)/1000f);
    }

    public static void getPopularContact(List<ContactWithOthers> contacts){
        long startTime = System.currentTimeMillis();
        Collection<Contact> linkedContacts = new ArrayList<>();
        for (ContactWithOthers cont:contacts) {
            linkedContacts.addAll(cont.getLinkedContact());
        }
        linkedContacts.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);long stopTime = System.currentTimeMillis();
        System.out.printf("Список обрабатывался %.2f сек. \n" , (stopTime - startTime)/1000f);
    }

    public static void getPopularContact(Set<ContactWithOthers> contacts){
        long startTime = System.currentTimeMillis();
        Collection<Contact> linkedContacts = new ArrayList<>();
        for (ContactWithOthers cont:contacts) {
            linkedContacts.addAll(cont.getLinkedContact());
        }
        linkedContacts.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);
        long stopTime = System.currentTimeMillis();
        System.out.printf("Множество обрабатывалось %.2f сек. \n" , (stopTime - startTime)/1000f);
    }
}
