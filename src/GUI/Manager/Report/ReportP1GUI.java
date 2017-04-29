package GUI.Manager.Report;
//****************************
//Created by Zamir on 08/04/2015.  
//****************************

import Database.Operations.Operations;
import GUI.Special.CellToButton;
import GUI.Special.GreyedOutButtons;
import GUI.Special.VALHALA;
import Lib.api.*;
import Model.Books.Report;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ReportP1GUI extends JPanel implements CellToButton, GreyedOutButtons, VALHALA {
    boolean transition = true;
    Operations o = new Operations();
    Report rModel = new Report(o);

    public void setrModel(Report rModel) {
        this.rModel = rModel;
    }

    public void refresh(){
        Report rModela = new Report(o);
        setrModel(rModela);
        rModel.getStockR2();
        rModel.getStockR3();
        rModel.getStockR4();
        rModel.getStockR5();
        rModel.getStockR6();
        rModel.getStockR7();
        charts();
    }

    private final SLPanel panel = new SLPanel();
    float speed = .8f;

    public void setTransitionOn() {
        transition = true;
    }
    public void setTransitionOff() {
        transition = false;
    }
    boolean chart1 = false;
    boolean chart2 = false;
    boolean chart3 = false;
    boolean chart4 = false;
    boolean chart5 = false;
    boolean chart6 = false;

    ThePanel p1 = new ThePanel();
    ThePanel p2 = new ThePanel();
    ThePanel p3 = new ThePanel();
    ThePanel p4 = new ThePanel();
    ThePanel p5 = new ThePanel();
    ThePanel p6 = new ThePanel();
    ThePanel p7 = new ThePanel();
    public void charts(){
        ArrayList<String> listOfBarcodes2 = new ArrayList<String>();
        ArrayList<Integer> listOfRatings = new ArrayList<Integer>();
        listOfBarcodes2= rModel.getBarcodes2();
        listOfRatings = rModel.getRatings();

        ArrayList<String> barcodes;
        ArrayList<Integer> quantities;
        barcodes=rModel.getBarcodes();
        quantities=rModel.getQuantities();

        ArrayList<String> customer;
        ArrayList<Integer> points;
        customer=rModel.getCustomer();
        points=rModel.getPoints();

        ArrayList<String> coupons ;
        ArrayList<Double> discounts;
        coupons=rModel.getCoupons();
        discounts=rModel.getDiscounts();


        JButton button1 = new JButton();
        JPanel panel3 = new JPanel();
        add(panel3);
        panel3.add(button1);

        panel3.setBackground(new Color(68,164,209));
        panel3.setLayout(null);
        panel3.setLocation(0, 715);
        panel3.setSize(1400, 220);

        //---- button1 ----
        button1.setIcon(new ImageIcon("Assets/Back.png"));
        button1.setAlignmentY(0.0F);
        button1.setMargin(new Insets(0, 0, 0, 0));
        button1.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button1.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button1.setBorder(null);
        button1.setBorderPainted(false);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setSize(250,150);
        button1.setLocation(150,0);

        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                animatedFrame.t24go();
            }
        });

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for(int i=0;i<listOfBarcodes2.size();i++) {
            pieDataset.setValue(listOfBarcodes2.get(i), new Integer((listOfRatings.get(i))));
        }
        final JFreeChart chart = ChartFactory.createPieChart("Ratings of Items", pieDataset, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
        ChartPanel panela = new ChartPanel(chart);
        panela.setVisible(true);
        p1.add(panela);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i=0;i<barcodes.size();i++){
            dataset.setValue(Integer.parseInt(quantities.get(i).toString()),"Stock",barcodes.get(i).toString());
        }
        JFreeChart charta = ChartFactory.createBarChart("Stock Levels", "Barcode", "Marks", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = charta.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartPanel panelo = new ChartPanel(charta);
        panelo.setVisible(true);
        p2.add(panelo);

        DefaultCategoryDataset datasetd = new DefaultCategoryDataset();
        for (int i=0;i<customer.size();i++){
            datasetd.setValue(Integer.parseInt(points.get(i).toString()),"Stock",customer.get(i).toString());
        }
        JFreeChart chartad = ChartFactory.createBarChart("Points Earned", "CustID", "Points", datasetd, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot pd = chartad.getCategoryPlot();
        pd.setRangeGridlinePaint(Color.black);
        ChartPanel panelod = new ChartPanel(chartad);
        panelod.setVisible(true);
        p3.add(panelod);


        DefaultCategoryDataset datasetk = new DefaultCategoryDataset();
        for (int i=0;i<coupons.size();i++){
            datasetk.setValue(Double.parseDouble(discounts.get(i).toString()),"Stock",coupons.get(i).toString());
        }
        JFreeChart chartk = ChartFactory.createBarChart("Discounts Per Coupon", "CouponID", "Discounts (%)", datasetk, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot pk = chartk.getCategoryPlot();
        pk.setRangeGridlinePaint(Color.black);
        ChartPanel kk = new ChartPanel(chartk);

        p4.add(kk);







        DefaultPieDataset zpieDatasetuu = new DefaultPieDataset();
        for(int i=0;i<10;i++) {
            zpieDatasetuu.setValue("One"+i, new Integer((10)));
        }
        JFreeChart zchartuu = ChartFactory.createPieChart("Pie Chart", zpieDatasetuu, true, true, true);
        PiePlot zPuu = (PiePlot) zchartuu.getPlot();
        ChartPanel zpanelauu = new ChartPanel(zchartuu);
        zpanelauu.setVisible(true);
        p5.add(zpanelauu);

        DefaultPieDataset tzpieDatasetuu = new DefaultPieDataset();
        for(int i=0;i<10;i++) {
            tzpieDatasetuu.setValue("One"+i, new Integer((10)));
        }
        JFreeChart tzchartuu = ChartFactory.createPieChart("Pie Chart", tzpieDatasetuu, true, true, true);
        PiePlot tzPuu = (PiePlot) tzchartuu.getPlot();
        ChartPanel tzpanelauu = new ChartPanel(tzchartuu);
        tzpanelauu.setVisible(true);
        p6.add(tzpanelauu);


        panela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if(chart1==false) {
                    p1Action.run();
                    chart1 = true;
                }else{
                    p1BackAction.run();
                    chart1 = false;
                }
            }
        });

        panelo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if(chart2==false) {
                    p2Action.run();
                    chart2 = true;
                }else{
                    p2BackAction.run();
                    chart2 = false;
                }
            }
        });

        panelod.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if(chart3==false) {
                    p3Action.run();
                    chart3 = true;
                }else{
                    p3BackAction.run();
                    chart3 = false;
                }
            }
        });

        kk.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if(chart4==false) {
                    p4Action.run();
                    chart4 = true;
                }else{
                    p4BackAction.run();
                    chart4 = false;
                }
            }
        });

        zpanelauu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if(chart5==false) {
                    p5Action.run();
                    chart5 = true;
                }else{
                    p5BackAction.run();
                    chart5 = false;
                }
            }
        });

        tzpanelauu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if(chart6==false) {
                    p6Action.run();
                    chart6 = true;
                }else{
                    p6BackAction.run();
                    chart6 = false;
                }
            }
        });
    }
    SLConfig mainCfg, p1Cfg, p2Cfg, p3Cfg, p4Cfg, p5Cfg, p6Cfg;
    public ReportP1GUI(Operations o) {
        Description.setWrapStyleWord(true);
        Description.setCaretPosition(Description.getDocument().getLength());
        Description.setLineWrap(true);
        Description.setWrapStyleWord(true);
        Description.setLocation(900, 100);
        Description.setSize(300, 100);
        Description.setBackground(Color.WHITE);
        Description.setForeground(Color.BLACK);
        Description.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        Description.setOpaque(true);
        Description.setEditable(false);
        p7.add(Description);
        refresh();
        setBackground(new Color(68,164,209));
        charts();
        SLAnimator.start();
        SLAnimator.start();
        setLayout(null);
        panel.setVisible(true);
        panel.setSize(1400, 660);
        panel.setLocation(0, 60);
        add(panel);
        p6.setVisible(false);
        p5.setVisible(false);
        mainCfg = new SLConfig(panel)
                .gap(10, 10)
                .row(660).col(320).col(320).col(320).col(320)

                .beginGrid(0, 0)
                .row(320).row(320).col(320)
                .place(0, 0, p1)
                .place(1, 0, p2)
                .endGrid()

                .beginGrid(0, 1)
                .row(320).row(320).col(320)
                .place(0, 0, p3)
                .place(1, 0, p4)
                .endGrid()

                .beginGrid(0, 2)
                .row(320).row(320).col(320)
                .place(0, 0, p5)
                .place(1, 0, p6)
                .endGrid()

                .beginGrid(0, 3)
                .row(650).row(320).col(320)
                .place(0, 0, p7)
                .endGrid();

        p1Cfg = new SLConfig(panel)
                .gap(10, 10)
                .row(640).col(850).col(450)
                .place(0, 0, p1)
                .place(0, 1, p7);

        p2Cfg = new SLConfig(panel)
                .gap(10, 10)
                .row(640).col(850).col(450)
                .place(0, 0, p2)
                .place(0, 1, p7);

        p3Cfg = new SLConfig(panel)
                .gap(10, 10)
                .row(640).col(850).col(450)
                .place(0, 0, p3)
                .place(0, 1, p7);

        p4Cfg = new SLConfig(panel)
                .gap(10, 10)
                .row(640).col(850).col(450)
                .place(0, 0, p4)
                .place(0, 1, p7);

        p5Cfg = new SLConfig(panel)
                .gap(10, 10)
                .row(640).col(850).col(450)
                .place(0, 0, p5)
                .place(0, 1, p7);

        p6Cfg = new SLConfig(panel)
                .gap(10, 10)
                .row(640).col(850).col(450)
                .place(0, 0, p6)
                .place(0, 1, p7);

        panel.setTweenManager(SLAnimator.createTweenManager());
        panel.initialize(mainCfg);
    }


    private final Runnable p1Action = new Runnable() {@Override public void run() {
        Description.setText("On this pie chart you can see the items on the menu. It displays items with their barcodes, along with their current rating.");
        if(transition==true) {
            panel.createTransition()
                    .push(new SLKeyframe(p1Cfg, speed)
                            .setEndSide(SLSide.BOTTOM, p2, p4, p6)
                            .setEndSide(SLSide.RIGHT, p3, p4, p5, p6)
                            .setCallback(new SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else{
            panel.createTransition()
                    .push(new SLKeyframe(p1Cfg, 0)
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
                        .push(new SLKeyframe(mainCfg, speed)
                                .setStartSide(SLSide.BOTTOM, p2, p4, p6)
                                .setStartSide(SLSide.RIGHT, p3, p4, p5, p6)
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

    private final Runnable p2Action = new Runnable() {
        @Override
        public void run() {
            Description.setText("On this barchart, you can see the current stock levels of the items on the mene. The highest bar shows the item with the largest stock, the lowest represents the item with the lowest stock. You can identify the items with their barcodes.");
            if(transition==true) {
                panel.createTransition()
                        .push(new SLKeyframe(p2Cfg, speed)
                                .setEndSide(SLSide.RIGHT, p3, p4, p5, p6)
                                .setEndSide(SLSide.TOP, p1, p3, p5)
                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {


                                    }
                                }))
                        .play();
            }else{
                panel.createTransition()
                        .push(new SLKeyframe(p2Cfg, 0)
                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {
                                    }
                                }))
                        .play();
            }
        }
    };

    private final Runnable p2BackAction = new Runnable() {
        @Override
        public void run() {
            if(transition==true) {
                panel.createTransition()
                        .push(new SLKeyframe(mainCfg, speed)
                                .setStartSide(SLSide.RIGHT, p3, p4, p5, p6)
                                .setStartSide(SLSide.TOP, p1, p3, p5)
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

    private final Runnable p3Action = new Runnable() {
        @Override
        public void run() {
            Description.setText("On this bar chart, it is displayed which customers have earned the most points. Points can be exchanged for coupons to get discounts on items.");
            if(transition==true) {
                panel.createTransition()
                        .push(new SLKeyframe(p3Cfg, speed)
                                .setEndSide(SLSide.LEFT, p1)
                                .setEndSide(SLSide.RIGHT, p5)
                                .setEndSide(SLSide.LEFT, p2)
                                .setEndSide(SLSide.BOTTOM, p2)
                                .setEndSide(SLSide.BOTTOM, p4)
                                .setEndSide(SLSide.BOTTOM, p6)
                                .setEndSide(SLSide.RIGHT, p6)


                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {


                                    }
                                }))
                        .play();
            }else{
                panel.createTransition()
                        .push(new SLKeyframe(p3Cfg, 0)
                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {
                                    }
                                }))
                        .play();
            }
        }
    };

    private final Runnable p3BackAction = new Runnable() {
        @Override
        public void run() {

            if(transition==true) {
                panel.createTransition()
                        .push(new SLKeyframe(mainCfg, speed)
                                .setStartSide(SLSide.LEFT, p1)
                                .setStartSide(SLSide.RIGHT, p5)
                                .setStartSide(SLSide.LEFT, p2)
                                .setStartSide(SLSide.BOTTOM, p2)
                                .setStartSide(SLSide.BOTTOM, p4)
                                .setStartSide(SLSide.BOTTOM, p6)
                                .setStartSide(SLSide.RIGHT, p6)

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

    private final Runnable p4Action = new Runnable() {
        @Override
        public void run() {
            Description.setText("On this barchart, you can view the differnt coupons, and their discount.");

            if(transition==true) {
                panel.createTransition()
                        .push(new SLKeyframe(p4Cfg, speed)
                                .setEndSide(SLSide.TOP, p1, p3, p5)
                                .setEndSide(SLSide.LEFT, p1, p2)
                                .setEndSide(SLSide.RIGHT, p5, p6)
                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {


                                    }
                                }))
                        .play();
            }else{
                panel.createTransition()
                        .push(new SLKeyframe(p4Cfg, 0)
                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {
                                    }
                                }))
                        .play();
            }
        }
    };

    private final Runnable p4BackAction = new Runnable() {
        @Override
        public void run() {

            if(transition==true) {
                panel.createTransition()
                        .push(new SLKeyframe(mainCfg, speed)
                                .setStartSide(SLSide.TOP, p1, p3, p5)
                                .setStartSide(SLSide.LEFT, p1, p2)
                                .setStartSide(SLSide.RIGHT, p5, p6)
                                .setCallback(new SLKeyframe.Callback() {@Override public void done() {

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

    private final Runnable p5Action = new Runnable() {
        @Override
        public void run() {

            if(transition==true) {
                panel.createTransition()
                        .push(new SLKeyframe(p5Cfg, speed)
                                .setEndSide(SLSide.LEFT, p1, p2, p3, p4)
                                .setEndSide(SLSide.BOTTOM, p2, p4, p6)
                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {


                                    }
                                }))
                        .play();
            }else{
                panel.createTransition()
                        .push(new SLKeyframe(p5Cfg, 0)
                                .setCallback(new SLKeyframe.Callback() {
                                    @Override
                                    public void done() {


                                    }
                                }))
                        .play();
            }
        }
    };

    private final Runnable p5BackAction = new Runnable() {
        @Override
        public void run() {

            if(transition==true) {
                panel.createTransition()
                        .push(new SLKeyframe(mainCfg, speed)
                                .setStartSide(SLSide.LEFT, p1, p2, p3, p4)
                                .setStartSide(SLSide.BOTTOM, p2, p4, p6)
                                .setCallback(new SLKeyframe.Callback() {@Override public void done() {

                                }}))
                        .play();
            }else{
                panel.createTransition()
                        .push(new SLKeyframe(mainCfg, 0)
                                .setCallback(new SLKeyframe.Callback() {@Override public void done() {

                                }}))
                        .play();
            }
        }};

    private final Runnable p6Action = new Runnable() {@Override public void run() {

        if(transition==true) {
            panel.createTransition()
                    .push(new SLKeyframe(p6Cfg, speed)
                            .setEndSide(SLSide.LEFT, p1, p2, p3, p4)
                            .setEndSide(SLSide.TOP, p1, p3, p5)
                            .setCallback(new SLKeyframe.Callback() {
                                @Override
                                public void done() {


                                }
                            }))
                    .play();
        }else{
            panel.createTransition()
                    .push(new SLKeyframe(p6Cfg, 0)
                            .setCallback(new SLKeyframe.Callback() {
                                @Override
                                public void done() {


                                }
                            }))
                    .play();
        }
    }};

    private final Runnable p6BackAction = new Runnable() {@Override public void run() {

        if(transition==true) {
            panel.createTransition()
                    .push(new SLKeyframe(mainCfg, speed)
                            .setStartSide(SLSide.LEFT, p1, p2, p3, p4)
                            .setStartSide(SLSide.TOP, p1, p3, p5)
                            .setCallback(new SLKeyframe.Callback() {@Override public void done() {

                            }}))
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
    }};
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JTextArea Description = new JTextArea();
}
