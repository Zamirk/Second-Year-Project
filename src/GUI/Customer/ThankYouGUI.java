package GUI.Customer;
//****************************
//Created by Zamir on 12/04/2015.  
//****************************


import Database.Operations.Operations;
import GUI.Special.VALHALA;
import Lib.api.*;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ThankYouGUI extends JPanel implements VALHALA{
    SLConfig mainCfg, p1Cfg;
    boolean show = false;
    boolean transition = true;
    Operations o;
    private final SLPanel panel = new SLPanel();
    public void refresh(){
        area.setText("");
    }
    public ThankYouGUI(Operations oIn) {
        o = oIn;
        setBackground(new Color(68,164,209));
        SLAnimator.start();
        SLAnimator.start();
        setLayout(null);
        init();
        initKeyboard();
        panel.setVisible(true);
        panel.setSize(1375, 500);
        panel.setLocation(0, 400);
        add(panel);

        mainCfg = new SLConfig(panel);


        p1Cfg = new SLConfig(panel)
                .gap(10, 10)
                .row(500).col(1350)

                .beginGrid(0, 0)
                .row(500).col(1400)
                .place(0, 0, p1)
                .endGrid();


        panel.setTweenManager(SLAnimator.createTweenManager());
        panel.initialize(mainCfg);
    }
    public void init(){
        add(panel1);
        panel1.setLayout(null);
        panel1.setLocation(20, 20);
        panel1.setSize(1355, 350);
        panel1.setBackground(new Color(145, 178, 239));

        panel1.add(label1);
        label1.setText("Thank you for shopping at Fernandos.");
        label1.setSize(1000,80);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 48));
        label1.setLocation(350,20);

        panel1.add(area);
        area.setWrapStyleWord(true);
        area.setCaretPosition(area.getDocument().getLength());
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setSize(500, 200);
        area.setFont(new Font("Tahoma", Font.PLAIN, 30));
        area.setLocation(490, 130);
        PromptSupport.setPrompt("Would you like to enter feedback?", area);
        add(button2);
        BufferedImage img;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Button.png"));
            Image newimg1 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH );
            button2.setIcon(new ImageIcon(newimg1));
            complete.setIcon(new ImageIcon(newimg1));
            cancell.setIcon(new ImageIcon(newimg1));

            img = ImageIO.read(getClass().getResourceAsStream("/Pressed.png"));
            Image newimg2 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH );
            button2.setPressedIcon(new ImageIcon(newimg2));
            complete.setPressedIcon(new ImageIcon(newimg2));
            cancell.setPressedIcon(new ImageIcon(newimg2));

            img = ImageIO.read(getClass().getResourceAsStream("/Rollover.png"));
            Image newimg3 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH );
            button2.setRolloverIcon(new ImageIcon(newimg3));
            complete.setRolloverIcon(new ImageIcon(newimg3));
            cancell.setRolloverIcon(new ImageIcon(newimg3));
        } catch (IOException e) {
            System.out.println("Could not find forum icon.");
        }
        button2.setForeground(Color.WHITE);
        button2.setSize(300, 150);
        button2.setLocation(100, 700);
        button2.setBorder(null);
        button2.setBorderPainted(false);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setText("Show Keyboard");
        button2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button2.setHorizontalTextPosition(SwingConstants.CENTER);
        button2.setFocusable(false);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(show==true){
                    p1BackAction.run();
                    show = false;
                    button2.setText("Show Keyboard");
                    button2.setEnabled(false);
                    animatedFrame.setButton();
                    complete.setVisible(true);
                    cancell.setVisible(true);
                }else{
                    p1Action.run();
                    show = true;
                    button2.setText("Hide Keyboard");
                    button2.setEnabled(false);
                    animatedFrame.setButton();
                    complete.setVisible(false);
                    cancell.setVisible(false);
                }
            }
        });

        add(complete);
        complete.setForeground(Color.WHITE);
        complete.setSize(300, 150);
        complete.setLocation(700, 600);
        complete.setBorder(null);
        complete.setBorderPainted(false);
        complete.setOpaque(false);
        complete.setContentAreaFilled(false);
        complete.setText("Complete Transaction");
        complete.setFont(new Font("Tahoma", Font.PLAIN, 20));
        complete.setHorizontalTextPosition(SwingConstants.CENTER);
        complete.setFocusable(false);

        complete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                animatedFrame.t46go();
                //o.updateFeedback(custId,area.getText());
                o.payUpdate(ActualCustID,totalPrice,custId,area.getText());
                animatedFrame.t33go();
            }
        });

        add(cancell);
        cancell.setForeground(Color.WHITE);
        cancell.setSize(300, 150);
        cancell.setLocation(400, 600);
        cancell.setBorder(null);
        cancell.setBorderPainted(false);
        cancell.setOpaque(false);
        cancell.setContentAreaFilled(false);
        cancell.setText("Cancel Transaction");
        cancell.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cancell.setHorizontalTextPosition(SwingConstants.CENTER);
        cancell.setFocusable(false);

        cancell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to cancel your order?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    o.cancelOrder(custId);
                    o.newOrder();
                    animatedFrame.t46go();
                }
            }
                });
            }

    public void button() {
        button2.setEnabled(true);
    }

    public void initKeyboard(){
        p1.setLayout(null);
        p1.setBackground(new Color(145, 178, 239));

        p1.add(shift);
        shift.setText("Caps");
        shift.setBackground(Color.BLACK);
        shift.setForeground(Color.WHITE);
        shift.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        shift.setSize(100, 100);
        shift.setLocation(200,200);

        p1.add(zz);
        zz.setText("z");
        zz.setBackground(Color.BLACK);
        zz.setForeground(Color.WHITE);
        zz.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        zz.setSize(100, 100);
        zz.setLocation(300,200);

        p1.add(xx);
        xx.setText("x");
        xx.setBackground(Color.BLACK);
        xx.setForeground(Color.WHITE);
        xx.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        xx.setSize(100, 100);
        xx.setLocation(400,200);

        p1.add(cc);
        cc.setText("c");
        cc.setBackground(Color.BLACK);
        cc.setForeground(Color.WHITE);
        cc.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        cc.setSize(100, 100);
        cc.setLocation(500,200);

        p1.add(space);
        space.setText("");
        space.setBackground(Color.BLACK);
        space.setForeground(Color.WHITE);
        space.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        space.setSize(500, 100);
        space.setLocation(500,300);

        p1.add(vv);
        vv.setText("v");
        vv.setBackground(Color.BLACK);
        vv.setForeground(Color.WHITE);
        vv.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        vv.setSize(100, 100);
        vv.setLocation(600,200);

        p1.add(bb);
        bb.setText("b");
        bb.setBackground(Color.BLACK);
        bb.setForeground(Color.WHITE);
        bb.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        bb.setSize(100, 100);
        bb.setLocation(700,200);

        p1.add(nn);
        nn.setText("n");
        nn.setBackground(Color.BLACK);
        nn.setForeground(Color.WHITE);
        nn.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        nn.setSize(100, 100);
        nn.setLocation(800,200);

        p1.add(mm);
        mm.setText("m");
        mm.setBackground(Color.BLACK);
        mm.setForeground(Color.WHITE);
        mm.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        mm.setSize(100, 100);
        mm.setLocation(900,200);

        p1.add(xxx);
        xxx.setText("Backspace");
        xxx.setBackground(Color.BLACK);
        xxx.setForeground(Color.WHITE);
        xxx.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        xxx.setSize(200, 100);
        xxx.setLocation(1000, 200);

        p1.add(qq);
        qq.setText("q");
        qq.setBackground(Color.BLACK);
        qq.setForeground(Color.WHITE);
        qq.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        qq.setSize(100, 100);
        qq.setLocation(200,0);

        p1.add(ww);
        ww.setText("w");
        ww.setBackground(Color.BLACK);
        ww.setForeground(Color.WHITE);
        ww.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        ww.setSize(100, 100);
        ww.setLocation(300,0);

        p1.add(ee);
        ee.setText("e");
        ee.setBackground(Color.BLACK);
        ee.setForeground(Color.WHITE);
        ee.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        ee.setSize(100, 100);
        ee.setLocation(400,0);

        p1.add(rr);
        rr.setText("r");
        rr.setBackground(Color.BLACK);
        rr.setForeground(Color.WHITE);
        rr.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        rr.setSize(100, 100);
        rr.setLocation(500,0);

        p1.add(tt);
        tt.setText("t");
        tt.setBackground(Color.BLACK);
        tt.setForeground(Color.WHITE);
        tt.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        tt.setSize(100, 100);
        tt.setLocation(600,0);

        p1.add(yy);
        yy.setText("y");
        yy.setBackground(Color.BLACK);
        yy.setForeground(Color.WHITE);
        yy.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        yy.setSize(100, 100);
        yy.setLocation(700,0);

        p1.add(uu);
        uu.setText("u");
        uu.setBackground(Color.BLACK);
        uu.setForeground(Color.WHITE);
        uu.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        uu.setSize(100, 100);
        uu.setLocation(800,0);

        p1.add(ii);
        ii.setText("i");
        ii.setBackground(Color.BLACK);
        ii.setForeground(Color.WHITE);
        ii.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        ii.setSize(100, 100);
        ii.setLocation(900, 0);

        p1.add(oo);
        oo.setText("o");
        oo.setBackground(Color.BLACK);
        oo.setForeground(Color.WHITE);
        oo.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        oo.setSize(100, 100);
        oo.setLocation(1000,0);

        p1.add(pp);
        pp.setText("p");
        pp.setBackground(Color.BLACK);
        pp.setForeground(Color.WHITE);
        pp.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pp.setSize(100, 100);
        pp.setLocation(1100,0);

        //
        p1.add(aa);
        aa.setText("a");
        aa.setBackground(Color.BLACK);
        aa.setForeground(Color.WHITE);
        aa.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        aa.setSize(100, 100);
        aa.setLocation(220,100);

        p1.add(ss);
        ss.setText("s");
        ss.setBackground(Color.BLACK);
        ss.setForeground(Color.WHITE);
        ss.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        ss.setSize(100, 100);
        ss.setLocation(320,100);

        p1.add(dd);
        dd.setText("d");
        dd.setBackground(Color.BLACK);
        dd.setForeground(Color.WHITE);
        dd.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        dd.setSize(100, 100);
        dd.setLocation(420,100);

        p1.add(ff);
        ff.setText("f");
        ff.setBackground(Color.BLACK);
        ff.setForeground(Color.WHITE);
        ff.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        ff.setSize(100, 100);
        ff.setLocation(520,100);

        p1.add(gg);
        gg.setText("g");
        gg.setBackground(Color.BLACK);
        gg.setForeground(Color.WHITE);
        gg.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        gg.setSize(100, 100);
        gg.setLocation(620,100);

        p1.add(hh);
        hh.setText("h");
        hh.setBackground(Color.BLACK);
        hh.setForeground(Color.WHITE);
        hh.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        hh.setSize(100, 100);
        hh.setLocation(720,100);

        p1.add(jj);
        jj.setText("j");
        jj.setBackground(Color.BLACK);
        jj.setForeground(Color.WHITE);
        jj.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        jj.setSize(100, 100);
        jj.setLocation(820,100);

        p1.add(kk);
        kk.setText("k");
        kk.setBackground(Color.BLACK);
        kk.setForeground(Color.WHITE);
        kk.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        kk.setSize(100, 100);
        kk.setLocation(920,100);

        p1.add(ll);
        ll.setText("l");
        ll.setBackground(Color.BLACK);
        ll.setForeground(Color.WHITE);
        ll.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        ll.setSize(100, 100);
        ll.setLocation(1020,100);

        aa.setFocusable(false);
        bb.setFocusable(false);
        cc.setFocusable(false);
        dd.setFocusable(false);
        ee.setFocusable(false);
        ff.setFocusable(false);
        gg.setFocusable(false);
        hh.setFocusable(false);
        ii.setFocusable(false);
        jj.setFocusable(false);
        kk.setFocusable(false);
        ll.setFocusable(false);
        mm.setFocusable(false);
        nn.setFocusable(false);
        oo.setFocusable(false);
        pp.setFocusable(false);
        qq.setFocusable(false);
        rr.setFocusable(false);
        ss.setFocusable(false);
        tt.setFocusable(false);
        uu.setFocusable(false);
        vv.setFocusable(false);
        ww.setFocusable(false);
        xx.setFocusable(false);
        yy.setFocusable(false);
        zz.setFocusable(false);
        xxx.setFocusable(false);
        space.setFocusable(false);
        shift.setFocusable(false);

        aa.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(aa.getText()=="a") {
                    area.setText(area.getText() + "a");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "A");
                    animatedFrame.playSound();
                }
            }
        });

        bb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(bb.getText()=="b") {
                    area.setText(area.getText() + "b");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "B");
                    animatedFrame.playSound();
                }
            }
        });

        cc.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(cc.getText()=="c") {
                    area.setText(area.getText() + "c");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "C");
                    animatedFrame.playSound();
                }
            }
        });

        dd.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(dd.getText()=="d") {
                    area.setText(area.getText() + "d");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "D");
                    animatedFrame.playSound();
                }
            }
        });

        ee.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(ee.getText()=="e") {
                    area.setText(area.getText() + "e");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "E");
                    animatedFrame.playSound();
                }
            }
        });

        ff.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(ff.getText()=="f") {
                    area.setText(area.getText() + "f");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "F");
                    animatedFrame.playSound();
                }
            }
        });

        gg.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(gg.getText()=="g") {
                    area.setText(area.getText() + "g");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "G");
                    animatedFrame.playSound();
                }
            }
        });

        hh.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(hh.getText()=="h") {
                    area.setText(area.getText() + "ah");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "H");
                    animatedFrame.playSound();
                }
            }
        });

        ii.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(ii.getText()=="i") {
                    area.setText(area.getText() + "i");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "I");
                    animatedFrame.playSound();
                }
            }
        });

        jj.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(jj.getText()=="j") {
                    area.setText(area.getText() + "j");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "J");
                    animatedFrame.playSound();
                }
            }
        });

        kk.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(kk.getText()=="k") {
                    area.setText(area.getText() + "k");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "K");
                    animatedFrame.playSound();
                }
            }
        });

        ll.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(ll.getText()=="l") {
                    area.setText(area.getText() + "l");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "L");
                    animatedFrame.playSound();
                }
            }
        });

        mm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(mm.getText()=="m") {
                    area.setText(area.getText() + "m");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "M");
                    animatedFrame.playSound();
                }
            }
        });

        nn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(nn.getText()=="n") {
                    area.setText(area.getText() + "n");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "N");
                    animatedFrame.playSound();
                }
            }
        });

        oo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(oo.getText()=="o") {
                    area.setText(area.getText() + "o");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "O");
                    animatedFrame.playSound();
                }
            }
        });

        pp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(pp.getText()=="p") {
                    area.setText(area.getText() + "p");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "P");
                    animatedFrame.playSound();
                }
            }
        });

        qq.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(qq.getText()=="q") {
                    area.setText(area.getText() + "q");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "Q");
                    animatedFrame.playSound();
                }
            }
        });

        rr.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(rr.getText()=="r") {
                    area.setText(area.getText() + "r");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "R");
                    animatedFrame.playSound();
                }
            }
        });

        ss.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(ss.getText()=="s") {
                    area.setText(area.getText() + "s");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "S");
                    animatedFrame.playSound();
                }
            }
        });

        tt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(tt.getText()=="t") {
                    area.setText(area.getText() + "t");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "T");
                    animatedFrame.playSound();
                }
            }
        });

        uu.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(uu.getText()=="u") {
                    area.setText(area.getText() + "u");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "U");
                    animatedFrame.playSound();
                }
            }
        });

        vv.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(vv.getText()=="v") {
                    area.setText(area.getText() + "v");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "V");
                    animatedFrame.playSound();
                }
            }
        });

        ww.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(ww.getText()=="w") {
                    area.setText(area.getText() + "w");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "W");
                    animatedFrame.playSound();
                }
            }
        });

        xx.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(xx.getText()=="x") {
                    area.setText(area.getText() + "x");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "X");
                    animatedFrame.playSound();
                }
            }
        });

        yy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(yy.getText()=="y") {
                    area.setText(area.getText() + "y");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "Y");
                    animatedFrame.playSound();
                }
            }
        });

        zz.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(zz.getText()=="z") {
                    area.setText(area.getText() + "z");
                    animatedFrame.playSound();
                }else{
                    area.setText(area.getText() + "Z");
                    animatedFrame.playSound();
                }
            }
        });

        xxx.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(area.getDocument().getLength()!=0) {
                    area.setText(area.getText().substring(0, area.getDocument().getLength() - 1));
                    animatedFrame.playSound();
                }
                animatedFrame.playSound();
            }
        });

        space.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                area.setText(area.getText()+" ");
                animatedFrame.playSound();
            }
        });

        shift.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(shift.getText()=="Caps") {
                    animatedFrame.playSound();
                    shift.setBackground(Color.WHITE);
                    shift.setForeground(Color.BLACK);
                    shift.setText("CAPS");
                    aa.setText("A");
                    bb.setText("B");
                    cc.setText("C");
                    dd.setText("D");
                    ee.setText("E");
                    ff.setText("F");
                    gg.setText("G");
                    hh.setText("H");
                    ii.setText("I");
                    jj.setText("J");
                    kk.setText("K");
                    ll.setText("L");
                    mm.setText("M");
                    nn.setText("N");
                    oo.setText("O");
                    pp.setText("P");
                    qq.setText("Q");
                    rr.setText("R");
                    ss.setText("S");
                    tt.setText("T");
                    uu.setText("U");
                    vv.setText("V");
                    ww.setText("W");
                    xx.setText("X");
                    yy.setText("Y");
                    zz.setText("Z");
                }else{
                    animatedFrame.playSound();
                    shift.setBackground(Color.BLACK);
                    shift.setForeground(Color.WHITE);
                    shift.setText("Caps");
                    aa.setText("a");
                    bb.setText("b");
                    cc.setText("c");
                    dd.setText("d");
                    ee.setText("e");
                    ff.setText("f");
                    gg.setText("g");
                    hh.setText("h");
                    ii.setText("i");
                    jj.setText("j");
                    kk.setText("k");
                    ll.setText("l");
                    mm.setText("m");
                    nn.setText("n");
                    oo.setText("o");
                    pp.setText("p");
                    qq.setText("q");
                    rr.setText("r");
                    ss.setText("s");
                    tt.setText("t");
                    uu.setText("u");
                    vv.setText("v");
                    ww.setText("w");
                    xx.setText("x");
                    yy.setText("y");
                    zz.setText("z");
                }
            }
        });
    }

    private final Runnable p1Action = new Runnable() {@Override public void run() {

        if(transition==true) {
            panel.createTransition()
                    .push(new SLKeyframe(p1Cfg, 3)
                            .setStartSide(SLSide.BOTTOM, p1)

                            .setCallback(new SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else{
            panel.createTransition()
                    .push(new SLKeyframe(p1Cfg, 3)
                            .setCallback(new SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }
    }
    };

    private final Runnable p1BackAction = new Runnable() {
        @Override
        public void run() {

            if(transition==true) {
                panel.createTransition()
                        .push(new SLKeyframe(mainCfg, 5)
                                .setEndSide(SLSide.BOTTOM, p1)
                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {

                                    }
                                }))
                        .play();
            }else{
                panel.createTransition()
                        .push(new SLKeyframe(mainCfg, 0)
                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {

                                    }
                                }))
                        .play();
            }
        }
    };
    String ActualCustID = "";
    Double totalPrice = 0.0;
    String custId ="";
    public void setVal(String a, Double b, String c ){
        custId = a;
        ActualCustID = c;
        totalPrice = b;
    }

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton shift = new JButton();
    JButton qq = new JButton();
    JButton ww = new JButton();
    JButton ee = new JButton();
    JButton rr = new JButton();
    JButton tt = new JButton();
    JButton yy = new JButton();
    JButton uu = new JButton();
    JButton ii = new JButton();
    JButton oo = new JButton();
    JButton pp = new JButton();
    JButton space = new JButton();

    JButton aa = new JButton();
    JButton ss = new JButton();
    JButton dd = new JButton();
    JButton ff = new JButton();
    JButton gg = new JButton();
    JButton hh = new JButton();
    JButton jj = new JButton();
    JButton kk = new JButton();
    JButton ll = new JButton();

    JButton zz = new JButton();
    JButton xx = new JButton();
    JButton cc = new JButton();
    JButton vv = new JButton();
    JButton bb = new JButton();
    JButton nn = new JButton();
    JButton mm = new JButton();
    JButton xxx = new JButton();
    JButton complete = new JButton();
    JButton cancell = new JButton();
    JButton button1 = new JButton();
    JTextArea area = new JTextArea();
    JButton button2 = new JButton();
    JPanel panel3 = new JPanel();
    JPanel p1 = new JPanel();
    JLabel label1 = new JLabel();
}
