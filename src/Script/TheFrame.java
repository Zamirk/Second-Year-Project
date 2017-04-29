package Script;

import Database.Operations.Operations;
import GUI.Customer.*;
import GUI.Customer.PayScreen.FinishAndPayScreenGUI;
import GUI.Customer.StartScreen.ButtonGUI;
import GUI.Customer.StartScreen.LogoGui;
import GUI.Customer.StartScreen.SimpleMessage;
import GUI.Customer.StartScreen.Welcome;
import GUI.Employee.*;
import GUI.Manager.CouponManagementGUI;
import GUI.Manager.EmployeeManagementGUI;
import GUI.Manager.ManagementGUI;
import GUI.Manager.MenuManagementGUI;
import GUI.Manager.Report.ReportP1GUI;
import GUI.Special.Header;
import GUI.Special.VALHALA;
import Lib.api.SLAnimator;
import Lib.api.SLConfig;
import Lib.api.SLPanel;
import Lib.api.SLSide;
import sun.tools.jar.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
//4012888888881881
//4444444444444448
public class TheFrame extends JFrame implements VALHALA {
    Operations o = new Operations();
    boolean nOrder = true;
    String productID;
    private final SLPanel panel = new SLPanel();

     //Welcome Screen Panels
    //Speed of transitions
    float a =4f;

    Header h = new Header();
    private final ButtonGUI p1B = new ButtonGUI();
    private final Welcome p1W = new Welcome();
    private final LogoGui p1L = new LogoGui();
    private final SimpleMessage p1Sm = new SimpleMessage();
    private final MenuScreenGUI p2 = new MenuScreenGUI(o);
    private final LoginGUI p3 = new LoginGUI(o);
    private final ManagementGUI p4 = new ManagementGUI();
    private final EmployeeGUI p5 = new EmployeeGUI();
    private final MenuManagementGUI p6 = new MenuManagementGUI(o);
    private final CouponManagementGUI p7 = new CouponManagementGUI(o);
    private final StockControlGUI p8 = new StockControlGUI(o);
    private final CustomerManagementGUI p9 = new CustomerManagementGUI(o);
    private final OrderHistoryGUI p10 = new OrderHistoryGUI(o);
    private final EmployeeManagementGUI p11 = new EmployeeManagementGUI(o);
    private final FeedbackManagementGUI p12 = new FeedbackManagementGUI(o);
    private final ReportP1GUI p13 = new ReportP1GUI(o);
    private final CustomerHistoryGUI p14 = new CustomerHistoryGUI(o);
    private final FinishAndPayScreenGUI p15 = new FinishAndPayScreenGUI(o);
    private final CreditCardGUI p16 = new CreditCardGUI();
    private final ThankYouGUI p17 = new ThankYouGUI(o);
    private final FoodInfo p18 = new FoodInfo();
    private final Help p19 = new Help();

    private final SLConfig startSc, menuSc, loginSc, empSc, manSc, menuMSc, coupMSc, stockMSc, custMSc, ordHSc, empMSc
            ,feedBSc, reportSc, credSc, feedbSc, itemSc, helpSc, custSpec, finishPay;

    public TheFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(68,164,209));
        getContentPane().setLayout(null);
        panel.setVisible(true);
        panel.setSize(1400, 930);
        panel.setLocation(0, 120);
        getContentPane().add(panel);
        getContentPane().add(h);

        //The first Screen displayed with 4 different JPanels
        startSc = new SLConfig(panel)
                .row(930).col(1400)
                .beginGrid(0, 0)
                .row(100).row(200).row(500).row(100).col(1400)
                .place(0, 0, p1W)
                .place(1, 0, p1L)
                .place(2, 0, p1B)
                .place(3, 0, p1Sm)
                .endGrid();

        //Next Panel displayed
        menuSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0, 0, p2);

        //Next Panel displayed
        loginSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p3);

        //Next Panel displayed
        empSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p5);

        //Next Panel displayed
        manSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p4);

        //Next Panel displayed
        menuMSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p6);

        //Next Panel displayed
        coupMSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p7);

        //Next Panel displayed
        stockMSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p8);

        //Next Panel displayed
        custMSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p9);

        //Next Panel displayed
        ordHSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p10);

        //Next Panel displayed
        empMSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p11);

        //Next Panel displayed
        feedBSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p12);

        //Next Panel displayed
        reportSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p13);

        //Next Panel displayed
        custSpec = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p14);

        //Next Panel displayed
        finishPay = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p15);

        //Next Panel displayed
        credSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p16);

        //Next Panel displayed
        feedbSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p17);

        //Next Panel displayed
        itemSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p18);

        //Next Panel displayed
        helpSc = new SLConfig(panel)
                .row(930).col(1400)
                .place(0,0, p19);

        panel.setTweenManager(SLAnimator.createTweenManager());
        //The Panel displayed at the beginning
        panel.initialize(startSc);
    }

    public String getProductID(){
        return productID;
    }

    // Methods which call transitions,
    // play sounds,
    // make login invisible/visible,
    // set as admin or employee,
    // instantiate a few classes,
    public void animationsReportOff(){
        p13.setTransitionOff();
    }
    public void animationsReportOn(){
        p13.setTransitionOn();
    }
    public void t1go(){
        playSound();
        startScreenToMenu.run();
        h.setLoginInvisible();
        p2.beginNewOrder();
    }
    public void t2go() {
        playSound();
        menuToStartScreen.run();
        h.setLoginVisible();

    }
    public void t3go(){
        playSound();
        startScreenToLogin.run();
        h.setLoginInvisible();
    }
    public void t4go(){
        playSound();
        loginToStartScreen.run();
        h.setLoginVisible();

    }
    public void t5go(){
        playSound();
        loginToEmployeeScreen.run();
    }
    public void t6go(){
        playSound();
        loginToManagerScreen.run();
    }
    public void t7go(){
        managerToLoginScreen.run();
        playSound();
    }
    public void t8go(){
        playSound();
        employeeToLoginScreen.run(); }
    public void t9go(){
        playSound();
        p6.refresh();
        managerToMenuManageScreen.run();
            }
    public void t10go(){
        playSound();
        p7.refresh();
        managerToMenuCouponScreen.run(); }
    public void t11go(){
        playSound();
        p8.refresh();
        managerToStockScreen.run(); }
    public void t12go(){
        playSound();
        p9.refresh();
        managerToCustomerScreen.run();}
    public void t13go(){
        playSound();
        p10.refresh();
        managerToOrderHistoryScreen.run();}
    public void t14go(){
        playSound();
        p11.refresh();
        managerToEmployeeMScreen.run();}
    public void t15go(){
        playSound();
        p12.refresh();
        managerToFeedbackMScreen.run();}
    public void t16go(){
        playSound();
        p13.refresh();
        managerToReportScreen.run();}
    public void t17go(){
        playSound();
        menuToManagerScreen.run(); }
    public void t18go(){
        playSound();
        couponToManagerScreen.run(); }
    public void t19go(){
        playSound();
        stockToManagerScreen.run(); }
    public void t20go(){
        playSound();
        customerToManagerScreen.run(); }
    public void t21go(){
        playSound();
        orderHistoryToManagerScreen.run(); }
    public void t22go(){
        playSound();
        employeesToManagerScreen.run(); }
    public void t23go(){
        playSound();
        feedbackToManagerScreen.run(); }
    public void t24go(){
        playSound();
        reportToManagerScreen.run();
    }
    public String getCVal(){
        String cVal = o.currVal();
        return cVal;
    }
    public void t25go(String a){
        playSound();
        p14.setUniqueCustomer(a);
        customerManagementToCustomerHistory.run(); }
    public void t26go(){
        playSound();
        customerHistoryToCustomerManagement.run(); }
    public void t27go(String a){
        playSound();
        menuToPayScreen.run();
        p15.setCurVal(a);
        p15.setPrice();
        p15.refresh();
    }
    public void t28go(){
        playSound();
        payScreenToMenu.run(); }
    public void t29go(){
        nOrder = false;
        playSound();
        payToStartScreen.run();
        h.setLoginVisible();
    }
    public void t30go(){
        playSound();
        p16.refresh();
        payToCreditCard.run();
    }
    public void t31go(){
        playSound();
        credToPay.run();
        p16.refresh();
    }
    public void t32go(){
        playSound();
        creditCardToFeedback.run();
        p16.refresh();
    }
    public void t33go(){
        playSound();
        feedbackToStart.run();
        p17.refresh();
        h.setLoginVisible();
    }
    public void t34go(){
        p18.setCurBarcode(productID);
        p18.fillTable();
        playSound();
        menuToItemSc.run();
    }
    public void setProdID(String productID){
        this.productID = productID;
    }


    public void t35go(){
        playSound();
        itemScToMenu.run();
    }
    public void t36go(){
        playSound();
        h.setLoginInvisible();
        allToHelp.run();
        h.helpOff();
    }
    public void t37go(){
        playSound();
        helpToAll.run();
        h.helpOn();
        h.setLoginVisible();
    }
    public void t38go(){
        playSound();
        finishToFeedback.run();
    }
    public void t39go(String a){
        playSound();
        p14.setUniqueCustomer(a);
        customerToCustomerScreen.run();
        p14.setCustTrue();
    }
    public void t40go(){
        playSound();
        myHistoryToPay.run();
    }
    public void t41go(){
        employeeToStock.run();
        playSound();
    }
    public void t42go(){
        backToEmployee.run();
        playSound();
    }
    public void t43go(){
        employeeToFeedback.run();
        playSound();
    }
    public void t44go(){
        employeeToOrderHistoryScreen.run();
        playSound();
    }
    public void t45go(){
        employeeToCustScreen.run();
        playSound();
    }
    public void t46go(){
        tyToStartScreen.run();
        h.setLoginVisible();
        playSound();
    }

    public void setAsEmployee(){
        p9.setAsEmployee();
        p12.setAsEmployee();
        p10.setAsEmployee();
        p8.setAsEmployee();
    }
    public void setAsAdmin(){
        p9.setAsAdmin();
        p12.setAsAdmin();
        p10.setAsAdmin();
        p8.setAsAdmin();
    }
    public void transferCvalToFeedback(String a,Double b,String c){
        p17.setVal(a,b,c);
    }

    //The transitions between screens

    private final Runnable employeeToOrderHistoryScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(ordHSc, a)
                            .setEndSide(SLSide.RIGHT, p5)
                            .setStartSide(SLSide.LEFT, p10)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(ordHSc, a))
                    .play();
        }
    }};
    private final Runnable employeeToCustScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(custMSc, a)
                            .setEndSide(SLSide.RIGHT, p5)
                            .setStartSide(SLSide.LEFT, p9)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(custMSc, a))
                    .play();
        }
    }};

    final Runnable startScreenToMenu = new Runnable() {@Override public void run() {

        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(menuSc, a)
                            //Direction of sliding,

                            .setEndSide(SLSide.LEFT, p1L, p1Sm)
                            .setEndSide(SLSide.RIGHT, p1W, p1B)
                            .setStartSide(SLSide.BOTTOM, p2)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(menuSc, a))
                    .play();
        }
    }};
    private final Runnable employeeToStock = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(stockMSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.BOTTOM, p5)
                            .setStartSide(SLSide.TOP, p8)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(stockMSc, a))
                    .play();
        }
    }};

    private final Runnable employeeToFeedback = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(feedBSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.BOTTOM, p5)
                            .setStartSide(SLSide.TOP, p12)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(feedBSc, a))
                    .play();
        }
    }};


    private final Runnable backToEmployee = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(empSc, a)
                            //Direction of sliding,
                            .setStartSideForNewCmps(SLSide.BOTTOM)
                            .setEndSideForOldCmps(SLSide.LEFT)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(empSc, a))
                    .play();
        }
    }};
    private final Runnable menuToStartScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(startSc, a)
                        //Direction of sliding,
                        .setEndSide(SLSide.BOTTOM, p2)
                        .setStartSide(SLSide.TOP, p1L, p1Sm)
                        .setStartSide(SLSide.BOTTOM, p1W, p1B)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a))
                    .play();
        }
    }};

    private final Runnable startScreenToLogin = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(loginSc, a)
                        //Direction of sliding,
                        .setEndSide(SLSide.LEFT, p1L, p1Sm)
                        .setEndSide(SLSide.RIGHT, p1W, p1B)
                        .setStartSide(SLSide.BOTTOM, p3)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(loginSc, a))
                    .play();
        }
    }};

    private final Runnable loginToStartScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(startSc, a)
                        //Direction of sliding,
                        .setEndSide(SLSide.BOTTOM, p3)
                        .setStartSide(SLSide.LEFT, p1L, p1Sm)
                        .setStartSide(SLSide.RIGHT, p1W, p1B)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a))
                    .play();
        }
    }};
    private final Runnable loginToEmployeeScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(empSc, a)
                        //Direction of sliding,
                        .setEndSide(SLSide.BOTTOM, p3)
                        .setStartSide(SLSide.RIGHT, p5)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(empSc, a))
                    .play();
        }
    }};
    private final Runnable loginToManagerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(manSc, a)
                        //Direction of sliding,
                        .setEndSide(SLSide.BOTTOM, p3)
                        .setStartSide(SLSide.RIGHT, p4)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(manSc, a))
                    .play();
        }
    }};
    private final Runnable managerToLoginScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(loginSc, a)
                        .setEndSide(SLSide.LEFT, p4)
                        .setStartSide(SLSide.BOTTOM, p3)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(loginSc, a))
                    .play();
        }
    }};

    private final Runnable employeeToLoginScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(loginSc, a)
                        .setEndSide(SLSide.LEFT, p5)
                        .setStartSide(SLSide.BOTTOM, p3)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(loginSc, a))
                    .play();
        }
    }};
    private final Runnable managerToMenuManageScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(menuMSc, a)
                        .setEndSide(SLSide.LEFT, p4)
                        .setStartSide(SLSide.BOTTOM, p6)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(menuMSc, a))
                    .play();
        }
    }};

    private final Runnable managerToMenuCouponScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(coupMSc, a)
                        .setEndSide(SLSide.RIGHT, p4)
                        .setStartSide(SLSide.LEFT, p7)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(coupMSc, a))
                    .play();
        }
    }};

    private final Runnable managerToStockScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(stockMSc, a)
                        .setEndSide(SLSide.RIGHT, p4)
                        .setStartSide(SLSide.LEFT, p8)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(stockMSc, a))
                    .play();
        }
    }};

    private final Runnable managerToCustomerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(custMSc, a)
                        .setEndSide(SLSide.RIGHT, p4)
                        .setStartSide(SLSide.LEFT, p9)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(custMSc, a))
                    .play();
        }
    }};

    private final Runnable customerToCustomerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(custSpec, a)
                            .setEndSide(SLSide.BOTTOM, p15)
                            .setStartSide(SLSide.TOP, p14)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(custSpec, a))
                    .play();
        }
    }};

    private final Runnable managerToOrderHistoryScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(ordHSc, a)
                        .setEndSide(SLSide.RIGHT, p4)
                        .setStartSide(SLSide.LEFT, p10)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(ordHSc, a))
                    .play();
        }
    }};

    private final Runnable managerToEmployeeMScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(empMSc, a)
                        .setEndSide(SLSide.RIGHT, p4)
                        .setStartSide(SLSide.LEFT, p11)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(empMSc, a))
                    .play();
        }
    }};

    private final Runnable managerToFeedbackMScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(feedBSc, a)
                        .setEndSide(SLSide.RIGHT, p4)
                        .setStartSide(SLSide.LEFT, p12)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(feedBSc, a))
                    .play();
        }
    }};

    private final Runnable managerToReportScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(reportSc, a)
                        .setEndSide(SLSide.RIGHT, p4)
                        .setStartSide(SLSide.LEFT, p13)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(reportSc, a))
                    .play();
        }
    }};

    private final Runnable menuToManagerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(manSc, a)
                        .setEndSide(SLSide.RIGHT, p6)
                        .setStartSide(SLSide.LEFT, p4)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(manSc, a))
                    .play();
        }
    }};

    private final Runnable couponToManagerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(manSc, a)
                        .setEndSide(SLSide.RIGHT, p7)
                        .setStartSide(SLSide.LEFT, p4)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(manSc, a))
                    .play();
        }
    }};

    private final Runnable stockToManagerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(manSc, a)
                        .setEndSide(SLSide.RIGHT, p8)
                        .setStartSide(SLSide.LEFT, p4)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(manSc, a))
                    .play();
        }
    }};

    private final Runnable customerToManagerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(manSc, a)
                        .setEndSide(SLSide.RIGHT, p9)
                        .setStartSide(SLSide.LEFT, p4)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(manSc, a))
                    .play();
        }
    }};

    private final Runnable orderHistoryToManagerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(manSc, a)
                        .setEndSide(SLSide.RIGHT, p10)
                        .setStartSide(SLSide.LEFT, p4)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(manSc, a))
                    .play();
        }
    }};

    private final Runnable feedbackToManagerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(manSc, a)
                        .setEndSide(SLSide.RIGHT, p12)
                        .setStartSide(SLSide.LEFT, p4)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(manSc, a))
                    .play();
        }
    }};

    private final Runnable employeesToManagerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(manSc, a)
                        .setEndSide(SLSide.RIGHT, p11)
                        .setStartSide(SLSide.LEFT, p4)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(manSc, a))
                    .play();
        }
    }};

    private final Runnable reportToManagerScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(manSc, a)
                        .setEndSide(SLSide.TOP, p13)
                        .setStartSide(SLSide.BOTTOM, p4)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(manSc, a))
                    .play();
        }
    }};


    private final Runnable customerManagementToCustomerHistory = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(custSpec, a)
                        .setEndSide(SLSide.RIGHT, p9)
                        .setStartSide(SLSide.LEFT, p14)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(custSpec, a))
                    .play();
        }
    }};

    private final Runnable customerHistoryToCustomerManagement = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(custMSc, a)
                        .setEndSide(SLSide.RIGHT, p14)
                        .setStartSide(SLSide.LEFT, p9)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(custMSc, a))
                    .play();
        }
    }};


    private final Runnable menuToPayScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(finishPay, a)
                        .setEndSide(SLSide.LEFT, p2)
                        .setStartSide(SLSide.RIGHT, p15)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(finishPay, a))
                    .play();
        }
    }};

    private final Runnable payScreenToMenu = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
        panel.createTransition()
                //Selecting which Screen to display next, the speed of movement
                .push(new Lib.api.SLKeyframe(menuSc, a)
                        .setEndSide(SLSide.RIGHT, p15)
                        .setStartSide(SLSide.LEFT, p2)
                        .setCallback(new Lib.api.SLKeyframe.Callback() {
                            @Override
                            public void done() {
                            }
                        }))
                .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(menuSc, a))
                    .play();
        }
    }};

    private final Runnable payToStartScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.BOTTOM, p15)
                            .setStartSide(SLSide.TOP, p1L, p1Sm)
                            .setStartSide(SLSide.BOTTOM, p1W, p1B)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a))
                    .play();
        }
    }};

    private final Runnable tyToStartScreen = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.BOTTOM, p17)
                            .setStartSide(SLSide.TOP, p1L, p1Sm)
                            .setStartSide(SLSide.BOTTOM, p1W, p1B)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a))
                    .play();
        }
    }};
    private final Runnable payToCreditCard = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(credSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.TOP, p15)
                            .setStartSide(SLSide.BOTTOM, p16)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(credSc, a))
                    .play();
        }
    }};

    private final Runnable creditCardToFeedback = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(feedbSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.TOP, p16)
                            .setStartSide(SLSide.BOTTOM, p17)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(feedbSc, a))
                    .play();
        }
    }};

    private final Runnable feedbackToStart = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.TOP, p17)
                            .setStartSide(SLSide.TOP, p1L, p1Sm)
                            .setStartSide(SLSide.BOTTOM, p1W, p1B)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a))
                    .play();
        }
    }};

    private final Runnable menuToItemSc = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(itemSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.BOTTOM, p2)
                            .setStartSide(SLSide.TOP, p18)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(itemSc, a))
                    .play();
        }
    }};

    private final Runnable itemScToMenu = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(menuSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.BOTTOM, p18)
                            .setStartSide(SLSide.TOP, p2)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(menuSc, a))
                    .play();
        }
    }};

    private final Runnable allToHelp = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(helpSc, a)
                            //Direction of sliding,
                            .setEndSideForOldCmps(SLSide.TOP)
                            .setStartSide(SLSide.BOTTOM, p19)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(helpSc, a))
                    .play();
        }
    }};

    private final Runnable helpToAll = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a)
                            //Direction of sliding,
                            .setEndSideForOldCmps(SLSide.BOTTOM)
                            .setStartSide(SLSide.TOP, p1L, p1Sm)
                            .setStartSide(SLSide.BOTTOM, p1W, p1B)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(startSc, a))
                    .play();
        }
    }};

    private final Runnable finishToFeedback = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(feedbSc, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.BOTTOM, p15)
                            .setStartSide(SLSide.TOP, p17)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(feedbSc, a))
                    .play();
        }
    }};
    private final Runnable credToPay = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(finishPay, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.BOTTOM, p16)
                            .setStartSide(SLSide.TOP, p15)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(finishPay, a))
                    .play();
        }
    }};

    private final Runnable myHistoryToPay = new Runnable() {@Override public void run() {
        if (h.isAnimateClicked()) {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(finishPay, a)
                            //Direction of sliding,
                            .setEndSide(SLSide.TOP, p14)
                            .setStartSide(SLSide.BOTTOM, p15)
                            .setCallback(new Lib.api.SLKeyframe.Callback() {
                                @Override
                                public void done() {
                                }
                            }))
                    .play();
        }else {
            panel.createTransition()
                    //Selecting which Screen to display next, the speed of movement
                    .push(new Lib.api.SLKeyframe(finishPay, a))
                    .play();
        }
    }




    };
    //Countdown for login
    public void startCountDown() {
        Thread threadA = new Thread(new Countdown(), "Thread A");
        threadA.start();
    }
    class Countdown implements Runnable {
        public void run() {
            for (int n = 30; n != 0; n--){
                p3.warning("Locked. Time to unlock: " + (n - 1) + " seconds.");
                try {
                    Thread.currentThread();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            p3.unlock();
            p3.warning("");
            p3.loginAttemptsMessage("Login attempts remaining: 3");
        }
    }
    //The beeps
    public synchronized void playSound() {
        if (h.isClicked()==true) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                                Main.class.getResourceAsStream("/beep.wav"));
                        clip.open(inputStream);
                        clip.start();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
            }).start();
        }
    }
    //The easter egg
    public static synchronized void easterEgg() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Main.class.getResourceAsStream("/song.wav"));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
    public synchronized void setButton() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    try {
                        Thread.sleep(500);                 //1000 milliseconds is one second.
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    p17.button();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
    public static void main(String[] args) {
        SLAnimator.start();
        animatedFrame.setResizable(false);
        animatedFrame.setSize(1400, 1050);
        animatedFrame.setLocationRelativeTo(null);
        animatedFrame.setVisible(true);
    }
}
