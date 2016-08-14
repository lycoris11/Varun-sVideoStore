import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.io.*;
import java.util.*;

public class loginScreen extends JFrame
{
    private JLabel label1;
    private JPasswordField passwordBox;
    private JLabel label2;
    private JButton newUserButton, searchButton, login;
    protected int randID;
    private ArrayList<MemberInfo> checkID;

    public loginScreen()
    {
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkID = new ArrayList<MemberInfo>();
        try
        {
            checkID = readIn.readIn();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void setupGUI()
    {
        label1 = new JLabel();
        label1.setLocation(50,31);
        label1.setSize(600,50);
        label1.setForeground( new Color(-1) );
        label1.setOpaque(true);
        label1.setBackground(Color.BLACK);
        label1.setText("Varun's Video Store");
        label1.setToolTipText("");
        label1.setFont(new java.awt.Font("Eurostile", 1, 48));
        getContentPane().add(label1);

        passwordBox = new JPasswordField();
        passwordBox.setLocation(50,168);
        passwordBox.setSize(157,25);
        passwordBox.setText("");
        passwordBox.setColumns(10);
        passwordBox.setToolTipText("Enter Password Here");
        passwordBox.setOpaque(true);
        passwordBox.setForeground( new Color(-1) );
        passwordBox.setBackground(Color.BLACK);
        getContentPane().add(passwordBox);

        label2 = new JLabel();
        label2.setLocation(50,133);
        label2.setSize(157,25);
        label2.setForeground( new Color(-1) );
        label2.setOpaque(true);
        label2.setBackground(Color.BLACK);
        label2.setText("Enter ID/Password:");
        getContentPane().add(label2);

        newUserButton = new JButton();
        newUserButton.setLocation(50,214);
        newUserButton.setSize(100,50);
        newUserButton.setText("New User?");
        newUserButton.setToolTipText("Click if you want to create a new user account.");
        getContentPane().add(newUserButton);

        newUserButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    newUserButtonActionPerformed(evt);
                }
            }
        );

        login = new JButton();
        login.setLocation(220,168);
        login.setSize(75,25);
        login.setText("Login");
        login.setToolTipText("Click to login.");
        getContentPane().add(login);

        login.addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    loginActionPerformed(evt);
                }
            }
        );

        setTitle("Login Screen");
        setSize(600,350);
        setForeground( new Color(-1) );
        getContentPane().setBackground(Color.BLACK);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
        setResizable(true);

    }

    public void newUserButtonActionPerformed(ActionEvent evt) 
    {                                         
        new newCustomerAccount();
        dispose();
    } 

    public void loginActionPerformed(ActionEvent evt)
    { 
        String password = new String(passwordBox.getPassword());
        int passw = Integer.parseInt(password);
        for(MemberInfo temp : checkID)
        {
            if(passw == temp.getID())
            {   
                new searchScreen(temp);
                dispose();
            }
        }
    }
}  