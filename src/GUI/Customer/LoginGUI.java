package GUI.Customer;
//****************************
//Created by Zamir on 08/04/2015.  
//****************************
import Database.Operations.Operations;
import GUI.Special.VALHALA;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginGUI extends JPanel implements VALHALA {
    ResultSet rset;
    Operations o;
    public LoginGUI(Operations oIn) {
        initComponents();
        o = oIn;
    }
    int maxLoginAttemps = 3;
    int currentLoginAttemps = 0;

    private void initComponents() {
        setLayout(null);
        setSize(1400,930);
        setVisible(true);

        mainPanel.setBackground(new Color(68,164,209));
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(1400, 930);

        panel1.setBackground(new Color(145, 178, 239));
        panel1.setLayout(null);
        panel1.setVisible(true);
        panel1.setBounds(116, 116, 1180, 520);
        panel1.add(textArea);
        panel1.add(textField3);

        panel2.setBackground(new Color(145, 178, 239));
        panel2.setLayout(null);
        panel2.setLocation(-5, 640);
        panel2.setSize(1400, 70);

        panel3.setBackground(new Color(68,164,209));
        panel3.setLayout(null);
        panel3.setLocation(0, 715);
        panel3.setSize(1400, 220);

        add(mainPanel);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        panel1.add(button2);

        //---- button4 ----
        button2.setText("Login");
        button2.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button2.setOpaque(false);
        button2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        button2.setSize(200, 100);

        label1.setText("Login attempts remaining: 3");
        panel2.add(label1);
        label1.setLocation(200, 15);
        label1.setSize(800,30);
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        label2.setText("");
        panel2.add(label2);
        label2.setLocation(200, 35);
        label2.setSize(800,30);
        label2.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        panel1.add(num0);
        panel1.add(num1);
        panel1.add(num2);
        panel1.add(num3);
        panel1.add(num4);
        panel1.add(num5);
        panel1.add(num6);
        panel1.add(num7);
        panel1.add(num8);
        panel1.add(num9);
        panel3.add(button1);

        num0.setText("0");
        num1.setText("1");
        num2.setText("2");
        num3.setText("3");
        num4.setText("4");
        num5.setText("5");
        num6.setText("6");
        num7.setText("7");
        num8.setText("8");
        num9.setText("9");
        num0.setBackground(Color.BLACK);
        num0.setForeground(Color.WHITE);
        num1.setBackground(Color.BLACK);
        num1.setForeground(Color.WHITE);
        num2.setBackground(Color.BLACK);
        num2.setForeground(Color.WHITE);
        num3.setBackground(Color.BLACK);
        num3.setForeground(Color.WHITE);
        num4.setBackground(Color.BLACK);
        num4.setForeground(Color.WHITE);
        num5.setBackground(Color.BLACK);
        num5.setForeground(Color.WHITE);
        num6.setBackground(Color.BLACK);
        num6.setForeground(Color.WHITE);
        num7.setBackground(Color.BLACK);
        num7.setForeground(Color.WHITE);
        num8.setBackground(Color.BLACK);
        num8.setForeground(Color.WHITE);
        num9.setBackground(Color.BLACK);
        num9.setForeground(Color.WHITE);
        num0.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num7.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num8.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num9.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num0.setSize(100,100);
        num1.setSize(100,100);
        num2.setSize(100,100);
        num3.setSize(100,100);
        num4.setSize(100,100);
        num5.setSize(100,100);
        num6.setSize(100,100);
        num7.setSize(100,100);
        num8.setSize(100,100);
        num9.setSize(100,100);
        num1.setLocation(100, 60);
        num2.setLocation(200,60);
        num3.setLocation(300,60);
        num4.setLocation(100,160);
        num5.setLocation(200,160);
        num6.setLocation(300,160);
        num7.setLocation(100,260);
        num8.setLocation(200,260);
        num9.setLocation(300,260);
        num0.setLocation(100,360);
        button2.setLocation(200,360);
        textArea.setLocation(410,430);

        //---- textField2 ----
        textArea.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        textArea.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        PromptSupport.setPrompt("Enter Code", textArea);
        textArea.setSize(300, 30);

        //---- button1 ----
        button1.setIcon(new ImageIcon("Assets/Back.png"));
        button1.setAlignmentY(0.0F);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button1.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button1.setSize(250, 150);
        button1.setLocation(150, 0);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t4go();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginAuthentication();
            }
        });

        num0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText()+"0");
                animatedFrame.playSound();
            }
        });
        num1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText()+"1");
                animatedFrame.playSound();
            }
        });
        num2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "2");
                animatedFrame.playSound();
            }
        });
        num3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "3");
                animatedFrame.playSound();
            }
        });
        num4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "4");
                animatedFrame.playSound();
            }
        });
        num5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "5");
                animatedFrame.playSound();
            }
        });
        num6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "6");
                animatedFrame.playSound();
            }
        });
        num7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "7");
                animatedFrame.playSound();
            }
        });
        num8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "8");
                animatedFrame.playSound();
            }
        });
        num9.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "9");
                animatedFrame.playSound();
            }
        });
}
    public void warning(String a){
        label2.setText(a);
    }
    public void loginAttemptsMessage(String a){
        label1.setText(a);
    }
    public void loginAuthentication(){
        try{
            rset = o.getLogin();
        boolean found = false;
        ArrayList<Integer> passwords = new ArrayList<Integer>();
        ArrayList<String> position = new ArrayList<String>();

        while(rset.next()){
            passwords.add(Integer.parseInt(rset.getString(1)));
            position.add(rset.getString(2).toString());
        }
        for(int i=0;i<passwords.size();i++){
            if(textArea.getText().equals(passwords.get(i).toString())){
                found = true;
                if(position.get(i).equals("Manager")){
                    animatedFrame.t6go();
                    textArea.setText("");
                }else if(position.get(i).equals("Employee")){
                    animatedFrame.t5go();
                    textArea.setText("");
                }
            }
        }
            if(textArea.getText().equals("666")){
                animatedFrame.easterEgg();
                found = true;
            }

            if(!found){
                textArea.setText("");
                currentLoginAttemps++;
                checkLogin();
            }
         }catch (SQLException Z){
            System.out.print(Z.getMessage());
        }
    }
    public void checkLogin() {
        if (currentLoginAttemps == 1) {
            label1.setText("Login attempts remaining: 2");
        } else if (currentLoginAttemps == 2) {
            label1.setText("Login attempts remaining: 1");
        } else if (currentLoginAttemps == maxLoginAttemps) {
            currentLoginAttemps = 0;
            label1.setText("You have 0 login attempts left.");
            lock();
            animatedFrame.startCountDown();
        }
    }
    public void lock(){
        button2.setEnabled(false);
        num0.setEnabled(false);
        num1.setEnabled(false);
        num2.setEnabled(false);
        num3.setEnabled(false);
        num4.setEnabled(false);
        num5.setEnabled(false);
        num6.setEnabled(false);
        num7.setEnabled(false);
        num8.setEnabled(false);
        num9.setEnabled(false);

    }
    public void unlock(){
        num0.setEnabled(true);
        button2.setEnabled(true);
        num0.setEnabled(true);
        num1.setEnabled(true);
        num2.setEnabled(true);
        num3.setEnabled(true);
        num4.setEnabled(true);
        num5.setEnabled(true);
        num6.setEnabled(true);
        num7.setEnabled(true);
        num8.setEnabled(true);
        num9.setEnabled(true);
    }

    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JTable table1 = new JTable();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JScrollPane scrollPane1 = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
    JButton button1 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button2 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton num0 = new JButton();
    JButton num1 = new JButton();
    JButton num2 = new JButton();
    JButton num3 = new JButton();
    JButton num4 = new JButton();
    JButton num5 = new JButton();
    JButton num6 = new JButton();
    JButton num7 = new JButton();
    JButton num8 = new JButton();
    JButton num9 = new JButton();
    JPasswordField textArea = new JPasswordField();
    JTextField textField6 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField3 = new JTextField();
    JComboBox comboBox1 = new JComboBox();
}



