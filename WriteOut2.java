import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class WriteOut2
{
    FileWriter writeDvds;
    FileWriter writeMembers;
    PrintWriter outD;
    PrintWriter outM;
    File logD;
    File logM;
    public WriteOut2() throws FileNotFoundException, IOException
    {
        logD = new File("F:\\AP COMP SCI\\Dvds.txt");
        logM = new File("F:\\AP COMP SCI\\Members.txt");
        writeDvds = new FileWriter(logD, true);
        writeMembers = new FileWriter(logM, true);
        outD = new PrintWriter(writeDvds);
        outM = new PrintWriter(writeMembers);
    }

    public void writeStockMinusOne(ArrayList<Dvd> list)
    {
        for(Dvd temp : list)
        {
            outD.println(temp.getID()); 
            outD.println(temp.getQuantity()-1);
            outD.println(temp.getRating() + temp.getTitle());
            outD.close();
        }
    }
    
    public void writeStock(ArrayList<Dvd> list)
    {
        for(Dvd temp : list)
        {
            outD.println(temp.getID()); 
            outD.println(temp.getQuantity());
            outD.println(temp.getRating() + temp.getTitle());
            outD.close();
        }
    }

    public void writeMembers(ArrayList<MemberInfo> members, ArrayList<IndDvd> rental)
    {
        for (int i = 0; i <members.size();i++)
        {
            //String s = members.get(i).getName();
            //System.out.print(members.get(i).getName());
            outM.println(members.get(i).getName());
            outM.println(members.get(i).getID());
            outM.println(members.get(i).getOwed());
            outM.close();
        }

        for (IndDvd temp : rental)
        {
            outD.print(temp.getName());
            outD.close();
        }
    }
}
