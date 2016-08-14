import java.io.*;
import java.util.*;

public class readIn
{
    private static Scanner inF;
    private static ArrayList<MemberInfo> temp;
    
    public readIn() throws FileNotFoundException
    {
        //inF = new Scanner(new File("F:\\M359 AP Computer Science\\JAVA\\FinalProject\\Members.txt"));
    }
    
    public static ArrayList<MemberInfo> readIn() throws FileNotFoundException
    {
        temp = new ArrayList<MemberInfo>();
        //Scanner lineScan = new Scanner(line);
        inF = new Scanner(new File("F:\\AP COMP SCI\\Members.txt"));
        while(inF.hasNextLine())
        {
            String name = inF.nextLine();
            //inF.nextLine();
            int id = inF.nextInt();
            //inF.nextLine();
            double owed = inF.nextDouble();
            inF.nextLine();
            temp.add(new MemberInfo(name, id, owed));
        }
        
        return temp;
    }
    
    /*public static ArrayList<Dvd> readRentals () throws FileNotFoundException
    {
        list = new ArrayList<Dvd>();
        inF2 = new Scanner (new File("E:\\Rentals.txt"));
        
        while (inF2.hasNextLine())
        {
            String line = inF2.nextLine();
            Scanner lineScan = new Scanner(line);
            
            String title = "";
            int id = lineScan.nextInt();
            int quan = lineScan.nextInt();
            String rate = lineScan.next();
            while(lineScan.hasNext())
            {
                title += lineScan.next()+ " ";
            }
            
             list.add(new Dvd(id, title, rate, quan));
        }
        return list;
        
    }*/
}
