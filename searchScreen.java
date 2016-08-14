import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class searchScreen extends JFrame
{
    private JButton searchButton, rentButton, returnButt, returnButtReal, logout;
    private JTextField searchBar;
    private JComboBox<String> jayCombo, jayCombo2;
    private static ArrayList<Dvd> stock, list;
    private JLabel serch, name, rent;
    private WriteOut writer;
    private MemberInfo current = new MemberInfo();
    
    //@SuppressWarnings("unchecked") 
    public searchScreen(MemberInfo temp)
    {
        current = temp;
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try
        {
            writer = new WriteOut();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    //@SuppressWarnings("unchecked") 
    public void setupGUI()
    {
        searchButton = new JButton();
        searchButton.setLocation(551,68);
        searchButton.setSize(80 ,25);
        searchButton.setText("Search");
        searchButton.setToolTipText("Click here to search for the movie of your choice");
        getContentPane().add(searchButton);

        searchButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    try
                    {
                        searchButtonActionPerformed(evt);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        );
        
        rentButton = new JButton();
        rentButton.setLocation(551,128);
        rentButton.setSize(80 ,25);
        rentButton.setText("Rent");
        rentButton.setToolTipText("Click here to rent the movie of your choice");
        getContentPane().add(rentButton);
        
        rentButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    try
                    {
                        rentButtonActionPerformed(evt);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        );
        
        returnButt = new JButton();
        returnButt.setLocation(551,151);
        returnButt.setSize(80,25);
        returnButt.setText("Rentals");
        returnButt.setToolTipText("Click to get your list of rentals.");
        getContentPane().add(returnButt);

        returnButt.addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    returnButtActionPerformed(evt);
                }
            }
        );
        
        returnButtReal = new JButton();
        returnButtReal.setLocation(631,151);
        returnButtReal.setSize(80,25);
        returnButtReal.setText("Return");
        returnButtReal.setToolTipText("Click to return.");
        getContentPane().add(returnButtReal);

        returnButtReal.addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    returnButtActionPerformed(evt);
                }
            }
        );
        
        logout = new JButton();
        logout.setLocation(631,10);
        logout.setSize(80,25);
        logout.setText("Logout");
        logout.setToolTipText("Click to login.");
        getContentPane().add(logout);
        
        logout.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    try
                    {
                        logoutActionPerformed(evt);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        );
        
        searchBar = new JTextField();
        searchBar.setLocation(101,68);
        searchBar.setSize(450,25);
        searchBar.setText("");
        searchBar.setColumns(10);
        searchBar.setToolTipText("Type the name of the movie you want to search for");
        searchBar.setOpaque(true);
        searchBar.setForeground( new Color(-1) );
        searchBar.setBackground(Color.BLACK);
        getContentPane().add(searchBar);

        jayCombo = new JComboBox<String>();
        jayCombo.setLocation(101,128);
        jayCombo.setSize(450,25);
        jayCombo.setEditable(false );
        rentButton.setToolTipText("Select the movie of your choice");
        getContentPane().add(jayCombo);
                
        jayCombo2 = new JComboBox<String>();
        jayCombo2.setLocation(101,151);
        jayCombo2.setSize(450,25);
        jayCombo2.setEditable(false );
        getContentPane().add(jayCombo2);
        
        serch = new JLabel();
        serch.setLocation(101,43);
        serch.setSize(107,25);
        serch.setForeground( new Color(-1) );
        serch.setOpaque(true);
        serch.setBackground(Color.BLACK);
        serch.setText("Search:");
        serch.setFont(new java.awt.Font("Eurostile", 1, 22));
        getContentPane().add(serch);
        
        name = new JLabel();
        name.setLocation(10, 10);
        name.setSize(200, 25);
        name.setForeground( new Color(-1) );
        name.setOpaque(true);
        name.setBackground(Color.BLACK);
        name.setText(current.getName() + "-" + current.getID());
        name.setFont(new java.awt.Font("Eurostile", 1, 22));
        getContentPane().add(name);
        
        rent = new JLabel();
        rent.setLocation(500,95);
        rent.setSize(200,25);
        rent.setForeground( new Color(-1) );
        rent.setOpaque(true);
        rent.setBackground(Color.BLACK);
        rent.setText(" ");
        rent.setFont(new java.awt.Font("Eurostile", 1, 22));
        getContentPane().add(rent);
        
        setTitle("Search Screen");
        setSize(741,220);
        setForeground(new Color(-1));
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    //@SuppressWarnings("unchecked") 
    public void searchButtonActionPerformed(ActionEvent evt) throws IOException
    {
        jayCombo.removeAllItems();
        stock = new ArrayList<Dvd>();
        stock = StartUp.readTxt();
        Searcher a = new Searcher();
        list = new ArrayList<Dvd>();
        list = a.findName(searchBar.getText(), stock);
        for(Dvd temp : list)
        {
            jayCombo.addItem(temp.getTitle());
        }
        //repaint();
    }
    
    public void rentButtonActionPerformed(ActionEvent evt) throws IOException
    {
        boolean isComplete = false;
        String x = String.valueOf(jayCombo.getSelectedItem());
        
        for(Dvd temp : stock)
        {
            if(x.equals(temp.getTitle()))
            {   
                isComplete = current.rent(temp);
            }
        }
        
        for(int i=0; i < jayCombo.getItemCount(); i++)
        {
            if(x = combo.getItemAt(i));
                
        }
        
        if(isComplete)
            rent.setText("Success!");
        else
            rent.setText("Unavailable");
    }

    public ArrayList<Dvd> getStock()
    {
        return stock;
    }

    public void returnButtActionPerformed(ActionEvent evt)
    {
        jayCombo2.removeAllItems();
        for(IndDvd temp : current.getList())
        {
            jayCombo2.addItem(temp.getName());
        }
    }
    
    public void logoutActionPerformed(ActionEvent evt) throws IOException
    {
        new loginScreen();
        dispose();
    }
}
