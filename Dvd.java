import java.util.*;

public class Dvd
{
    private int myID;
    private String myName;
    private String rating;
    private int quant;
    private ArrayList<IndDvd> ind = new ArrayList<IndDvd>();

    public Dvd(int id, String t, String r, int q)
    {
        myID = id;
        myName = t;
        rating = r;
        quant = q;

        for(int i = 1; i <= quant; i++)
        {
            ind.add(new IndDvd(i, getTitle()));
        }
    }

    public boolean rent(MemberInfo renter)
    {
        boolean isComplete = false;
        int i = 0;
        
        if(quant < 1)
            return false;

        while(!isComplete && i <= quant)
        {
            isComplete = ind.get(i).rent(renter);

        }

        quant = getQuantity();
        return true;
    }

    public IndDvd getOne(int get)
    {
        return ind.get(get);
    }

    public int getID()
    {
        return myID;
    }

    public int getQuantity()
    {
        quant = 0;
        for(IndDvd temp : ind)
            if(!temp.isRented())
                quant += 1;
        
        return quant;
    }

    public String getRating()
    {
        return rating;
    }

    public String getTitle()
    {
        return myName;
    }
    
}