public class BestFriend extends Person
{
    private String birthday;
    private int daysBestFriend;

    public BestFriend(String firstName, String lastName, String phoneNumber, String birthday, int daysBestFriend)
    {
        super(firstName,lastName,phoneNumber);
        this.birthday = birthday;
        this.daysBestFriend = daysBestFriend;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public int getDaysBestFriend()
    {
        return daysBestFriend;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Birthday: " + birthday + " Days Best Friend: " + daysBestFriend;
    }
}
