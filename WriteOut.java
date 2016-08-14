import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class WriteOut
{
    FileWriter writeDvds;
    FileWriter writeMembers;
    FileWriter writeRental;
    FileWriter writeStock;
    PrintWriter outD;
    PrintWriter outM;
    PrintWriter outR, outS;
    File logD;
    File logM;
    
    public WriteOut() throws FileNotFoundException, IOException
    {
        logD = new File("F:\\AP COMP SCI\\Dvds.txt");
        logM = new File("F:\\AP COMP SCI\\Members.txt");
        writeDvds = new FileWriter(logD, true);
        writeMembers = new FileWriter(logM, true);
        writeRental = new FileWriter("F:\\AP COMP SCI\\Rentals.txt");
        writeStock = new FileWriter("F:\\AP COMP SCI\\Stock.txt");
        outD = new PrintWriter(writeDvds);
        outM = new PrintWriter(writeMembers);
        outR = new PrintWriter(writeRental);
        outS = new PrintWriter(writeStock);
    }

    public void writeOriStock(ArrayList<Dvd> list)
    {
        for(Dvd temp : list)
        {
            outD.println(temp.getID()); 
            outD.println(temp.getQuantity());
            outD.println(temp.getRating() + temp.getTitle());
            outD.println();
            outD.close();
        }
    }

    public void writeMembers(ArrayList<MemberInfo> members)
    {
        for (int i = 0; i <members.size();i++)
        {
            outM.println(members.get(i).getName());
            outM.println(members.get(i).getID());
            outM.println(members.get(i).getOwed());
            writeRentals(members.get(i).getList());
            outM.close();
        }
    }

    public void writeRentals(ArrayList<IndDvd> rental)
    {
        //outR.println(m.getName());
        
        for (IndDvd temp : rental)
        {
            outR.print(temp.getName()+ " ");
            outR.println();
            outR.close();
        }
    }

    public void writeStock(ArrayList<Dvd> stock)
    {
        for (Dvd temp : stock)
        {
            outS.print(temp.getTitle()+ " ");
            outS.print(temp.getQuantity()+ " ");
            outS.print(temp.getRating());
            outS.println();
            outS.close();
        }
    }
}
