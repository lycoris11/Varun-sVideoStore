import java.util.*;
import java.io.*;

public class Searcher
{
    private static ArrayList<Dvd> endlist;
    public Searcher()
    {
        endlist = new ArrayList<Dvd>();
    }
    
    public static ArrayList<Dvd> findName(String key, ArrayList<Dvd> searchList)
    {
        for(Dvd temp : searchList)
        {
            //endlist = new ArrayList<Dvd>();
            
            if(temp.getTitle().indexOf(key) > -1)
            {
                endlist.add(temp);
            }
        }       
        
        return endlist;
    }  
}
