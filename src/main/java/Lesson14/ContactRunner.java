package Lesson14;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static Lesson14.ContactUtils.*;

public class ContactRunner {
    @SneakyThrows
    public static void main(String[] args) {
        Path path = Path.of("src", "main", "resources", "contacts.txt");
        List<String> names = Files.readAllLines(path, StandardCharsets.UTF_8);
        int count = 10_000;
        int linkedCount = 100;
        ContactWithOthers[] contacts = getArrayContact(names, count);
        List<ContactWithOthers> contactList = getListContact(names, count);
        Set<ContactWithOthers> contactSet = getSetContact(names, count);
        contacts = generateLinkedContacts(contacts, linkedCount);
        contactList = generateLinkedContacts(contactList, linkedCount);
        contactSet = generateLinkedContacts(contactSet, linkedCount);
        System.out.println("Часто встречающийся контакт у контактов из массива: ");
        getPopularContact(contacts);
        System.out.println("Часто встречающийся контакт у контактов из списка: ");
        getPopularContact(contactList);
        System.out.println("Часто встречающийся контакт у контактов из множества: ");
        getPopularContact(contactSet);
    }





}
