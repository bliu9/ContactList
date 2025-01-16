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

    public void addContact(Person person)
    {
        contacts.add(person);
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
                    if (j+1 < contacts.size() && contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0)
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
        printStartScreen();

        Scanner input = new Scanner(System.in);
        switch(input.nextInt())
        {
            case 0:
                return;

            // Add Contact
            case 1:
                //
        }

    }

    public static void printStartScreen()
    {
        System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts By Last Name" +
                "\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search By First Name\n7. Search By Last Name" +
                "\n8. Search By Phone Number\n0. Exit");
    }
}
