// Bryan Liu for CS2

import java.util.ArrayList;
import java.util.Scanner;

public class ContactList
{
    private ArrayList<Person> contacts;

    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts()
    {
        return contacts;
    }

    public void printContacts()
    {
        for (Person person : contacts)
        {
            System.out.println(person);
        }
    }

    public void sort(int sortBy)
    {
        // Sort the contacts by firstName
        if (sortBy == 0)
        {
            for (int i = 0; i < contacts.size(); i++)
            {
                for (int j = 0; j < contacts.size()-i-1; j++)
                {
                    if (j+1 < contacts.size() && contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0)
                    {
                        Person toSwap = contacts.get(j);
                        contacts.set(j,contacts.get(j+1));
                        contacts.set(j+1, toSwap);
                    }
                }
            }
        }

        // Sort by lastName
        else if (sortBy == 1)
        {
            for (int i = 0; i < contacts.size(); i++)
            {
                for (int j = 0; j < contacts.size()-i-1; j++)
                {
                    if (j+1 < contacts.size() && contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()) > 0)
                    {
                        Person toSwap = contacts.get(j);
                        contacts.set(j,contacts.get(j+1));
                        contacts.set(j+1, toSwap);
                    }
                }
            }
        }

        // Sort by phoneNumber
        else if (sortBy == 2)
        {
            for (int i = 0; i < contacts.size(); i++)
            {
                for (int j = 0; j < contacts.size()-i-1; j++)
                {
                    if (j+1 < contacts.size() && Integer.valueOf(contacts.get(j).getPhoneNumber()) > Integer.valueOf(contacts.get(j+1).getPhoneNumber()))
                    {
                        Person toSwap = contacts.get(j);
                        contacts.set(j,contacts.get(j+1));
                        contacts.set(j+1, toSwap);
                    }
                }
            }
        }
    }

    public Person searchByFirstName(String firstName)
    {
        for (Person person : contacts)
        {
            if (person.getFirstName().equals(firstName))
            {
                return person;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName)
    {
        for (Person person : contacts)
        {
            if (person.getLastName().equals(lastName))
            {
                return person;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber)
    {
        for (Person person : contacts)
        {
            if (person.getPhoneNumber().equals(phoneNumber))
            {
                return person;
            }
        }
        return null;
    }

    public void listStudents()
    {
        for (Person person : contacts)
        {
            if (person instanceof Student)
            {
                System.out.println(person);
            }
        }
    }

    public void run()
    {
        Scanner input = new Scanner(System.in);
        while (true)
        {
            printMenuScreen();
            switch (input.nextInt())
            {
                // Exit
                case 0:
                    return;

                // Add contact
                case 1:
                    // Handles the entire process for adding a new contact (prompting user, extracting info, and creating person)
                    addContact();
                    break;

                    // List all contacts by first name
                case 2:
                    sort(0);
                    printContacts();
                    break;

                    // List all contacts by last name
                case 3:
                    sort(1);
                    printContacts();
                    break;

                    // List all contacts by phone number
                case 4:
                    sort(2);
                    printContacts();
                    break;

                    // List all students
                case 5:
                    listStudents();
                    break;

                    // Search by first name
                case 6:
                    Scanner newInput = new Scanner(System.in);
                    System.out.println("Enter a name:");
                    String name = newInput.nextLine();
                    Person person = searchByFirstName(name);

                    if (person != null) {
                        System.out.println(person);
                    } else {
                        System.out.println(name + " is not on the list");
                    }
                    break;

                    // Search by last name
                case 7:
                    newInput = new Scanner(System.in);
                    System.out.println("Enter a name:");
                    name = newInput.nextLine();
                    person = searchByLastName(name);

                    if (person != null) {
                        System.out.println(person);
                    } else {
                        System.out.println(name + " is not on the list");
                    }
                    break;

                    // Search by phone number
                case 8:
                    newInput = new Scanner(System.in);
                    System.out.println("Enter a phone number:");
                    name = newInput.nextLine();
                    person = searchByPhoneNumber(name);

                    if (person != null) {
                        System.out.println(person);
                    } else {
                        System.out.println(name + " is not on the list");
                    }
                    break;
            }
        }
    }

    public void addContact()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Select a type of contact add:\n1. Person\n2. Student\n3. Best Friend");
        int selection = input.nextInt();
        contacts.add(makeContact(selection));
    }

    public Person makeContact(int contactType)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please fill in the following information.\nFirst Name:");
        String firstName = input.nextLine();
        System.out.println("Last Name:");
        String lastName = input.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = input.nextLine();

        int grade;
        String birthday;
        int daysBestFriend;

        if (contactType == 2)
        {
            System.out.println("Grade:");
            grade = input.nextInt();
            return new Student(firstName,lastName,phoneNumber,grade);
        }
        else if (contactType == 3)
        {
            System.out.println("Birthday: ");
            birthday = input.nextLine();
            System.out.println("Days Best Friend");
            daysBestFriend = input.nextInt();
            return new BestFriend(firstName,lastName,phoneNumber,birthday,daysBestFriend);
        }

        return new Person(firstName,lastName,phoneNumber);
    }

    public static void printMenuScreen()
    {
        System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts By Last Name" +
                "\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search By First Name\n7. Search By Last Name" +
                "\n8. Search By Phone Number\n0. Exit");
    }

    public static void main(String[] args)
    {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}