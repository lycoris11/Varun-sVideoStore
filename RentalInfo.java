import java.util.*;

public class RentalInfo
{
    public static final int MAXDAYS = 7; 
    private GregorianCalendar cal;
    private MemberInfo renter;
    private Date rentOut = new Date();
    private Date returnDay = new Date();
    
    public RentalInfo(MemberInfo m, IndDvd d)
    {
        m.addRental(d);
        cal = new GregorianCalendar();
        renter = m;
    }
    
    public void setRentOutDay()
    {
        rentOut = cal.getTime();
    }
    
    public void setReturnedDay()
    {
         cal.add(Calendar.DAY_OF_MONTH,MAXDAYS);
         returnDay = cal.getTime();
         
         int days = (int)( (returnDay.getTime() - rentOut.getTime()) / (1000 * 60 * 60 * 24));
    }
}