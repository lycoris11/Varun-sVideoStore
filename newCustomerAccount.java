import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class newCustomerAccount extends JFrame
{
    private JLabel label1, label2;
    private JButton makeUser, loginScrn;
    private JTextField enterName;
    private static ArrayList<MemberInfo> allMembers;
    private WriteOut writer;
    private int i = 0;

    public newCustomerAccount()
    {
        getRandNum();
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        allMembers = new ArrayList<MemberInfo>();

        try
        {
            writer = new WriteOut();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void setupGUI()  
    {
        label1 = new JLabel();
        label1.setLocation(50,21);
        label1.setSize(60,50);
        label1.setForeground( new Color(-1) );
        label1.setOpaque(true);
        label1.setBackground(Color.BLACK);
        label1.setText("Name:");
        label1.setToolTipText("");
        label1.setFont(new java.awt.Font("Eurostile", 1, 18));
        getContentPane().add(label1);

        makeUser = new JButton();
        makeUser.setLocation(50,74);
        makeUser.setSize(150,20);
        makeUser.setText("Make New Account");
        makeUser.setToolTipText("Click to make new account.");
        getContentPane().add(makeUser);

        makeUser.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)  
                {
                    try
                    {
                        makeUserActionPerformed(evt);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        );

        loginScrn = new JButton();
        loginScrn.setLocation(50,134);
        loginScrn.setSize(150,20);
        loginScrn.setText("Login Screen");
        loginScrn.setToolTipText("Click to go to Login Screen.");
        getContentPane().add(loginScrn);

        loginScrn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    try
                    {
                        loginScrnActionPerformed(evt);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        );

        setSize(400,200);
        setForeground(new Color(-1));
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
        setResizable(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        enterName = new JTextField();
        enterName.setLocation(120,31);
        enterName.setSize(157,25);
        enterName.setText("");
        enterName.setColumns(10);
        enterName.setToolTipText("Enter Your Name Here");
        enterName.setOpaque(true);
        enterName.setForeground( new Color(-1) );
        enterName.setBackground(Color.BLACK);
        getContentPane().add(enterName);
    }

    public void makeUserActionPerformed(ActionEvent evt) throws IOException
    {
        //allMembers = readIn.readIn();
        label2 = new JLabel();
        label2.setLocation(50,91);
        label2.setSize(350,50);
        label2.setForeground( new Color(-1) );
        label2.setOpaque(true);
        label2.setBackground(Color.BLACK);
        label2.setText(enterName.getText() + "'s ID Number is: " + i);
        label2.setToolTipText("");
        label2.setFont(new java.awt.Font("Eurostile", 1, 18));
        getContentPane().add(label2);

        MemberInfo member = new MemberInfo(enterName.getText(),i,0);
        allMembers.add(member);
        writer.writeMembers(allMembers);
        //allMembers = readIn.readIn();
        repaint();
    }
    
    public static ArrayList<MemberInfo> checkthisshit()
    {
        return allMembers;
    }

    public void loginScrnActionPerformed(ActionEvent evt) throws IOException
    {
        new loginScreen();
        dispose();
    }

    public void getRandNum()
    {
        i = (int) (Math.random()*9000+1000);
    }

    public static void main()
    {
        new newCustomerAccount();
    }
}
