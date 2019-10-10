public class User {

    //this is plain old java object used to send data of cvs file in object format for database entry
    String firstName, lastName , email,gender,image,cardType,cost,bolValue1,bolValue2,place;

    public User( String firstName, String lastName, String email, String gender, String image, String cardType, String cost,String bolValue1 ,String bolValue2 ,String place )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.image = image;
        this.cardType = cardType;
        this.cost = cost;
        this.bolValue1 = bolValue1;
        this.bolValue2 = bolValue2;
        this.place = place;
    }


    public boolean isComplete()
    {
        if(firstName.length()<1 || lastName.length()<1 || email.length()<1 || gender.length()<1 || image.length()<1 || cardType.length() <1
        || cost.length()<1 || bolValue1.length()<1 || bolValue2.length() < 1 || place.length() < 1)
            return true;
        else
            return false;
    }

    public String toString()
    {
        return firstName+ ","+ lastName+","+email+","+gender+","+image+","+cardType+","+cost+","+bolValue1+","+bolValue2+","+place;
    }
}
