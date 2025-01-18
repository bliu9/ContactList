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
            // Exit
            case 0:
                return;

            // Add contact
            case 1:
                // Handles the entire process for adding a new contact (prompting user, extracting info, and creating person)
                contactAdding();

            // List all contacts by first name
            case 2:
                sort(0);
                printContacts();

            // List all contacts by last name
            case 3:
                sort(1);
                printContacts();

            // List all contacts by phone number
            case 4:
                sort(2);
                printContacts();

            // List all students
            case 5:
                listStudents();

            // Search by first name
            case 6:
                Scanner newInput = new Scanner(System.in);
                System.out.println("Which contact would you like to find?");
                Person person = searchByFirstName(newInput.nextLine());

                if (person != null)
                {
                    System.out.println(person);
                }
                else
                {
                    System.out.println("Contact not found");
                }

            // Search by last name
            case 7:
                Scanner newInput = new Scanner(System.in);
                System.out.println("Which contact would you like to find?");
                person = searchByFirstName(newInput.nextLine());

                if (person != null)
                {
                    System.out.println(person);
                }
                else
                {
                    System.out.println("Contact not found");
                }
        }

    }

    public void contactAdding()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the following contact information, separated by commas: First Name, Last Name, Phone Number");
        String personInfo = input.nextLine();

        System.out.println("Enter the following contact information, separated by commas. If no info, write 'none': Grade, Birthday, Days Best Friend");
        String subPersonInfo = input.nextLine();

        // Extracts first name, last name, phone number, grade, birthday, and days best friend from input and makes person
        addContact(makePerson(personInfo,subPersonInfo));
    }

    public Person makePerson(String personInfo, String subPersonInfo)
    {
        ArrayList<String> personInfoSeparated = new ArrayList<String>();

        String totalInfo = personInfo + ", " + subPersonInfo;

        extractInfo(totalInfo,personInfoSeparated,totalInfo,0);

        if (personInfoSeparated.get(3).equals("none"))
        {
            if (personInfoSeparated.get(4).equals("none"))
            {
                Person person = new Person(personInfoSeparated.get(0), personInfoSeparated.get(1), personInfoSeparated.get(2));
                return person;
            }
            else
            {
                BestFriend person = new BestFriend(personInfoSeparated.get(0), personInfoSeparated.get(1), personInfoSeparated.get(2), personInfoSeparated.get(4), Integer.parseInt(personInfoSeparated.get(5)));
                return person;
            }
        }
        else
        {
            Student person = new Student(personInfoSeparated.get(0), personInfoSeparated.get(1), personInfoSeparated.get(2), Integer.parseInt(personInfoSeparated.get(3)));
            return person;
        }
    }

    public void extractInfo(String rawInfo, ArrayList<String> separatedInfo, String ogInfo, int index)
    {
        // Base case: if the rawInfo has been completely parsed, return
        if (rawInfo.length() == 0)
        {
            return;
        }

        if (rawInfo.charAt(0) != ',')
        {
            if (rawInfo.length()-1 == 0)
            {
                separatedInfo.add(ogInfo);
                return;
            }
            extractInfo(rawInfo.substring(1),separatedInfo,ogInfo,index+1);
        }

        else if (rawInfo.charAt(0) == ',')
        {
            separatedInfo.add(ogInfo.substring(0,index));
            extractInfo(rawInfo.substring(1),separatedInfo,ogInfo.substring(index+1),0);
        }
    }

    public static void printStartScreen()
    {
        System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts By Last Name" +
                "\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search By First Name\n7. Search By Last Name" +
                "\n8. Search By Phone Number\n0. Exit");
    }
}
