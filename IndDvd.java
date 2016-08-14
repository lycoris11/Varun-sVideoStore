import java.util.*;

public class IndDvd
{
    private int copyNum;
    private boolean isRented;
    private String name;
    private ArrayList<RentalInfo> rents = new ArrayList<RentalInfo>();

    public IndDvd(int c, String n)
    {
        copyNum = c;
        name = n;
        isRented = false;
    }

    public String getName()
    {
        return name;
    }
    
    public boolean rent(MemberInfo renter)
    {
        if(isRented) 
            return false;
        
        rents.add(new RentalInfo(renter, this));
        isRented = true;
        return true;
    }

    public void returnDvd()
    {
        isRented = false;
        rents.get(rents.size()-1).setReturnedDay();
    }
    
    public boolean isRented()
    {
        return isRented;
    }
}
