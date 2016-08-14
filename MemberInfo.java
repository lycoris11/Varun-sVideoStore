import java.io.*;
import java.util.*;

public class MemberInfo
{
    private int idNum;
    private String name;
    private double owed;
    private ArrayList<Dvd> rentList;
    private ArrayList<IndDvd> rentals = new ArrayList<IndDvd>();
    
    public MemberInfo()
    {
        idNum = -1;
    }
    
    public MemberInfo(String n, int num, double o)
    {
        name = n;
        idNum = num;
        owed = o;
        rentList = new ArrayList<Dvd>();
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getID()
    {
        return idNum; 
    }
    
    public double getOwed()
    {
        return owed;
    }
    
    public ArrayList<IndDvd> getList()
    {
        return rentals;
    }
    
    public boolean rent(Dvd desired)
    {
        boolean isDone = desired.rent(this);
        
        if(isDone)
            owed += 1;
            
        return isDone;
    }
    
    public void addRental(IndDvd rental)
    {
        rentals.add(rental);
    }
}
