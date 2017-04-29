package GUI.Special;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Header extends JPanel implements VALHALA{
    public Header() {
        initComponents();
    }
    JPanel header = new JPanel();
    JButton button = new JButton();
    JButton help = new JButton();
    JButton sound = new JButton();
    JButton animate = new JButton();
    boolean clicked = true;
    boolean animateClicked = true;

    JButton login = new JButton();
    private void initComponents() {
        setLayout(null);
        setSize(1400, 120);
        setVisible(true);

        header.setBackground(new Color(68, 164, 209));
        header.setLayout(null);
        header.setVisible(true);
        header.setLocation(0, 0);
        header.setSize(1400, 120);
        add(header);
        header.add(button);
        header.add(help);
        header.add(sound);
        header.add(animate);
        header.add(login);

        button.setForeground(Color.WHITE);
        button.setSize(600, 150);
        button.setLocation(-50, 0);
        button.setBorder(null);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setFocusable(false);

        help.setText("Help");
        help.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        help.setForeground(Color.WHITE);
        help.setSize(250, 150);
        help.setLocation(1150, -15);
        help.setBorder(null);
        help.setBorderPainted(false);
        help.setOpaque(false);
        help.setContentAreaFilled(false);
        help.setHorizontalTextPosition(SwingConstants.CENTER);
        help.setFocusable(false);

        sound.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        sound.setForeground(Color.WHITE);
        sound.setSize(120, 120);
        sound.setLocation(825, 0);
        sound.setBorder(null);
        sound.setBorderPainted(false);
        sound.setOpaque(false);
        sound.setContentAreaFilled(false);
        sound.setHorizontalTextPosition(SwingConstants.CENTER);
        sound.setFocusable(false);

        animate.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        animate.setForeground(Color.WHITE);
        animate.setSize(120, 120);
        animate.setLocation(720, 9);
        animate.setBorder(null);
        animate.setBorderPainted(false);
        animate.setOpaque(false);
        animate.setContentAreaFilled(false);
        animate.setHorizontalTextPosition(SwingConstants.CENTER);
        animate.setFocusable(false);

        login.setText("Login");
        login.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        login.setForeground(Color.WHITE);
        login.setSize(250, 150);
        login.setLocation(920, -15);
        login.setBorder(null);
        login.setBorderPainted(false);
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setHorizontalTextPosition(SwingConstants.CENTER);

        BufferedImage img;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Button.png"));
            Image newimg1 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH);
            help.setIcon(new ImageIcon(newimg1));
            login.setIcon(new ImageIcon(newimg1));
            img = ImageIO.read(getClass().getResourceAsStream("/noMute1.png"));
            Image newimg1o = img.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
            sound.setIcon(new ImageIcon(newimg1o));
            img = ImageIO.read(getClass().getResourceAsStream("/on.png"));
            Image newimg1a = img.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
            animate.setIcon(new ImageIcon(newimg1a));

            img = ImageIO.read(getClass().getResourceAsStream("/Pressed.png"));
            Image newimg2 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH);
            help.setPressedIcon(new ImageIcon(newimg2));
            login.setPressedIcon(new ImageIcon(newimg2));

            img = ImageIO.read(getClass().getResourceAsStream("/Rollover.png"));
            Image newimg3 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH);
            help.setRolloverIcon(new ImageIcon(newimg3));

            login.setRolloverIcon(new ImageIcon(newimg3));
            img = ImageIO.read(getClass().getResourceAsStream("/Logo.png"));
            Image logo = img.getScaledInstance(480, 90, java.awt.Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(logo));
        } catch (IOException e) {
            System.out.println("Could not find forum icon.");
        }
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t3go();
            }
        });
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t36go();
            }
        });

        sound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedImage img;
                try {
                    if (clicked == true) {
                        img = ImageIO.read(getClass().getResourceAsStream("/mute.png"));
                        Image newimg1o = img.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                        sound.setIcon(new ImageIcon(newimg1o));
                        clicked = false;
                    } else {
                        img = ImageIO.read(getClass().getResourceAsStream("/noMute1.png"));
                        Image newimg1o = img.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                        sound.setIcon(new ImageIcon(newimg1o));
                        clicked = true;
                    }
                } catch (IOException eo) {
                    System.out.println("Could not find forum icon.");
                }
            }
        });

        animate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedImage img;
                try {
                    if (animateClicked == true) {
                        img = ImageIO.read(getClass().getResourceAsStream("/off.png"));
                        Image newimg1a = img.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                        animate.setIcon(new ImageIcon(newimg1a));
                        animateClicked = false;
                        animatedFrame.animationsReportOff();
                    } else {
                        img = ImageIO.read(getClass().getResourceAsStream("/on.png"));
                        Image newimg1a = img.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                        animate.setIcon(new ImageIcon(newimg1a));
                        animateClicked = true;
                        animatedFrame.animationsReportOn();
                    }
                } catch (IOException eo) {
                    System.out.println("Could not find forum icon.");
                }
            }
        });


    }
    public void helpOff(){
        help.setEnabled(false);
    }
    public void helpOn(){
        help.setEnabled(true);
    }
    public boolean isClicked() {
        return clicked;
    }
    public boolean isAnimateClicked(){
        return animateClicked;
    }

    public void setLoginVisible(){
        login.setEnabled(true);
    }
    public void setLoginInvisible(){
        login.setEnabled(false);
    }
}
