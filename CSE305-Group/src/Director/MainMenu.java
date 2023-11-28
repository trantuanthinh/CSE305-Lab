package Director;

import Builder.BusRouteList;
import Builder.BusStop;
import Builder.BusRoute;
import Builder.BusStopList;
import Product.CreateBus;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainMenu extends javax.swing.JFrame {

    private static BusStopList busStopList = CreateBus.getBusStopList();
    private static BusRouteList busRouteList = CreateBus.getBusRouteList();

    public MainMenu() {
        initComponents();

//        System.out.println(busStopList.getBusStopList().size());
//        System.out.println(busRouteList.getBusRouteList().size());
        DefaultComboBoxModel locationStart_Model = new DefaultComboBoxModel<>();
        DefaultComboBoxModel locationEnd_Model = new DefaultComboBoxModel<>();
        DefaultComboBoxModel location = new DefaultComboBoxModel<>();

        for (BusStop eachBusStop : busStopList.getBusStopList()) {
//            System.out.println(eachBusStop.getName());dd
            locationStart_Model.addElement(eachBusStop.getName());
            locationEnd_Model.addElement(eachBusStop.getName());
            location.addElement(eachBusStop.getName());
        }
        startComboBox.setModel(locationStart_Model);
        endCombobox.setModel(locationEnd_Model);
        busStopNameComboBox.setModel(location);

        DefaultComboBoxModel busStopNumber_Model = new DefaultComboBoxModel<>();
        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
//            System.out.println(eachBusRoute.getRouteNumber());
            busStopNumber_Model.addElement(eachBusRoute.getRouteNumber());
        }
        routeNumberComboBox.setModel(busStopNumber_Model);
    }

//    -> Task 1: Input start-end -> Output all Routes from start-end
    public List<BusRoute> findAllRoutes(String startLocation, String endLocation) {
        List<BusRoute> possibleRoutes = new ArrayList<>();
        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
            List<BusStop> stops = eachBusRoute.getStops();
            int indexA = findStopIndex(stops, startLocation);
            int indexB = findStopIndex(stops, endLocation);
            if (indexA != -1 && indexB != -1 && indexA < indexB) {
                possibleRoutes.add(eachBusRoute);
            }
        }
        return possibleRoutes;
    }

    private int findStopIndex(List<BusStop> stops, String stopName) {
        for (int i = 0; i < stops.size(); i++) {
            if (stops.get(i).getName().equalsIgnoreCase(stopName)) {
                return i;
            }
        }
        return -1;
    }

//    -> Task 2: Output all Routes
    public List<BusRoute> findAllRoutes() {
        return busRouteList.getBusRouteList();
    }

    //    -> Task 3: Input busStopName -> Output all Routes
    public List<BusRoute> findAllRoutes(String busStopName) {
        List<BusRoute> possibleRoutes = new ArrayList<>();
        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
            for (BusStop eachBusStop : eachBusRoute.getStops()) {
                if (eachBusStop.getName().equalsIgnoreCase(busStopName)) {
                    possibleRoutes.add(eachBusRoute);
                }
            }
        }
        return possibleRoutes;
    }

//    -> Task 4: Input routeNumber -> Output all Bus Stops
    public List<BusStop> findAllBusStop(int routeNumber) {
        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
            if (eachBusRoute.getRouteNumber() == routeNumber) {
                return eachBusRoute.getStops();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Booking = new javax.swing.JTabbedPane();
        Home = new javax.swing.JPanel();
        startLabel = new javax.swing.JLabel();
        startComboBox = new javax.swing.JComboBox<>();
        endLabel = new javax.swing.JLabel();
        endCombobox = new javax.swing.JComboBox<>();
        task1Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        routeAtoBTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        complainTextArea = new javax.swing.JTextArea();
        complainButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        BusRoutes = new javax.swing.JPanel();
        task2Button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        allRouteTable = new javax.swing.JTable();
        Route = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        busStopNameComboBox = new javax.swing.JComboBox<>();
        task3Button = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        associateBusStopTable = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        BusStop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        routeNumberComboBox = new javax.swing.JComboBox<>();
        task4Button = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        associateRouteTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLocation = new javax.swing.JTextField();
        jBusName = new javax.swing.JTextField();
        jNumberOfPeople = new javax.swing.JTextField();
        jTypeOfBus = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        select = new javax.swing.JButton();
        jOrName = new javax.swing.JTextField();
        jRtName = new javax.swing.JTextField();
        jRtPhone = new javax.swing.JTextField();
        jOrPhone = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        checkOrName = new javax.swing.JTextField();
        checkOrPhone = new javax.swing.JTextField();
        checkRtName = new javax.swing.JTextField();
        checkRtPhone = new javax.swing.JTextField();
        checkDate = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        totalCost = new javax.swing.JTextField();
        recelpt = new javax.swing.JButton();
        checkTypeOfBus = new javax.swing.JTextField();
        checkLocation = new javax.swing.JTextField();
        checkNumberOfPeople = new javax.swing.JTextField();
        checkBusName = new javax.swing.JTextField();
        pay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Booking.setBackground(new java.awt.Color(0, 51, 51));
        Booking.setForeground(new java.awt.Color(255, 255, 255));
        Booking.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N

        Home.setBackground(new java.awt.Color(153, 255, 255));
        Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startLabel.setBackground(new java.awt.Color(255, 255, 153));
        startLabel.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        startLabel.setText("Start");
        Home.add(startLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        Home.add(startComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 162, -1));

        endLabel.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        endLabel.setText("End");
        Home.add(endLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 37, -1));

        Home.add(endCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 162, -1));

        task1Button.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        task1Button.setText("Find Route");
        task1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task1ButtonActionPerformed(evt);
            }
        });
        Home.add(task1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 118, 20));

        routeAtoBTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(routeAtoBTable);

        Home.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 710, 167));

        complainTextArea.setColumns(20);
        complainTextArea.setRows(5);
        jScrollPane5.setViewportView(complainTextArea);

        Home.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 782, -1));

        complainButton.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        complainButton.setText("Submit");
        complainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complainButtonActionPerformed(evt);
            }
        });
        Home.add(complainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 480, -1, -1));

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Complain");
        Home.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon("E:\\CSE305\\fe9943bf-e33e-45da-b9ed-c65bf5a5fd50.jpg")); // NOI18N
        Home.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 960, 450));

        Booking.addTab("Home", Home);

        BusRoutes.setBackground(new java.awt.Color(255, 255, 204));
        BusRoutes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        task2Button.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        task2Button.setText("Show All Routes");
        task2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task2ButtonActionPerformed(evt);
            }
        });
        BusRoutes.add(task2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        allRouteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(allRouteTable);

        BusRoutes.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 733, 253));

        Booking.addTab("Bus Routes", BusRoutes);

        Route.setBackground(new java.awt.Color(204, 255, 204));
        Route.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 153, 153));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Route Number");
        Route.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 130, -1));

        Route.add(busStopNameComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 157, -1));

        task3Button.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        task3Button.setText("Show Routes");
        task3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task3ButtonActionPerformed(evt);
            }
        });
        Route.add(task3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        associateBusStopTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(associateBusStopTable);

        Route.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 759, 366));
        Route.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 24, 43, -1));

        Booking.addTab("Route", Route);

        BusStop.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel1.setText("Route Number");

        task4Button.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        task4Button.setText("Show Bus Stops");
        task4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task4ButtonActionPerformed(evt);
            }
        });

        associateRouteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(associateRouteTable);

        javax.swing.GroupLayout BusStopLayout = new javax.swing.GroupLayout(BusStop);
        BusStop.setLayout(BusStopLayout);
        BusStopLayout.setHorizontalGroup(
            BusStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusStopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(routeNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(task4Button)
                .addGap(189, 189, 189))
            .addGroup(BusStopLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        BusStopLayout.setVerticalGroup(
            BusStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusStopLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(BusStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(routeNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(task4Button))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        Booking.addTab("Bus Stop", BusStop);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Bus Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Type Of Bus");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Location");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Number Of People");

        jNumberOfPeople.setForeground(new java.awt.Color(204, 204, 204));
        jNumberOfPeople.setText("Over 30");
        jNumberOfPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNumberOfPeopleActionPerformed(evt);
            }
        });

        jTypeOfBus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Luxury", "Popular" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTypeOfBus, 0, 143, Short.MAX_VALUE)
                            .addComponent(jBusName)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jNumberOfPeople, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(jLocation))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jBusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTypeOfBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jNumberOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel8.setFont(new java.awt.Font("Papyrus", 1, 16)); // NOI18N
        jLabel8.setText("Organizational Information");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Organization's Name");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Representative's Name");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Representative's Phone");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Date");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Organization's Phone");

        reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        select.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        select.setText("Select");

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRtPhone))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRtName))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jOrName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(reset)
                        .addGap(38, 38, 38)
                        .addComponent(select))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jOrPhone)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jOrName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jOrPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jRtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jRtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reset)
                    .addComponent(select))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel12.setText("Check Organization Information");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Organization's Name");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 47, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Representative's Name");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 91, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Representative's Phone");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 131, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Organization's Phone");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 171, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Date");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 211, 43, -1));
        jPanel4.add(checkOrName, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 47, 137, -1));
        jPanel4.add(checkOrPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 171, 137, -1));
        jPanel4.add(checkRtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 91, 137, -1));
        jPanel4.add(checkRtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 131, 137, -1));
        jPanel4.add(checkDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 211, 137, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Bus Name");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 49, 70, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Type Of Bus");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 91, 91, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Location");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 131, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Number Of People");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 171, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Total Cost");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 211, -1, -1));

        totalCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalCostActionPerformed(evt);
            }
        });
        jPanel4.add(totalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 211, 77, -1));

        recelpt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        recelpt.setText("Recelpt");
        recelpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recelptActionPerformed(evt);
            }
        });
        jPanel4.add(recelpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, -1, -1));
        jPanel4.add(checkTypeOfBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 91, 407, -1));
        jPanel4.add(checkLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 131, 407, -1));

        checkNumberOfPeople.setForeground(new java.awt.Color(204, 204, 204));
        checkNumberOfPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNumberOfPeopleActionPerformed(evt);
            }
        });
        jPanel4.add(checkNumberOfPeople, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 171, 407, -1));
        jPanel4.add(checkBusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 47, 407, -1));

        pay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pay.setText("Pay");
        jPanel4.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        Booking.addTab("Booking", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void task1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task1ButtonActionPerformed
        String start = startComboBox.getSelectedItem().toString();
        String end = endCombobox.getSelectedItem().toString();
        List<BusRoute> allRoutesFromAToB = findAllRoutes(start, end);
        if (allRoutesFromAToB.size() != 0) {
            DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tableModel.addColumn("Route Number");
            tableModel.addColumn("Start Time");
            tableModel.addColumn("Stops");
            tableModel.addColumn("End Time");
            tableModel.addColumn("Total Fare");

            for (BusRoute eachRoute : allRoutesFromAToB) {
                List<BusStop> stops = eachRoute.getStops();
                String startTime = "";
                String endTime = "";
                for (int i = 0; i < stops.size(); i++) {
                    BusStop check = stops.get(i);
                    if (check.getName().equalsIgnoreCase(start)) {
                        startTime = check.getTime();
                    }
                    if (check.getName().equalsIgnoreCase(end)) {
                        endTime = check.getTime();
                    }
                }

                Object[] rowData = {
                    eachRoute.getRouteNumber(),
                    startTime,
                    eachRoute.toString(),
                    endTime,
                    eachRoute.getTotalFare(),};
                tableModel.addRow(rowData);
            }

            routeAtoBTable.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(this, "None");
        }
    }//GEN-LAST:event_task1ButtonActionPerformed

    private void task2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task2ButtonActionPerformed
        List<BusRoute> allRoutes = findAllRoutes();
        if (allRoutes.size() != 0) {
            DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tableModel.addColumn("Route Number");
            tableModel.addColumn("Start Time");
            tableModel.addColumn("Stops");
            tableModel.addColumn("End Time");
            tableModel.addColumn("Total Fare");

            for (BusRoute eachRoute : allRoutes) {
                List<BusStop> stops = eachRoute.getStops();
                String startTime = stops.get(0).getTime();
                String endTime = stops.get(stops.size() - 1).getTime();

                Object[] rowData = {
                    eachRoute.getRouteNumber(),
                    startTime,
                    eachRoute.toString(),
                    endTime,
                    eachRoute.getTotalFare(),};
                tableModel.addRow(rowData);
            }
            allRouteTable.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(this, "None");
        }
    }//GEN-LAST:event_task2ButtonActionPerformed

    private void task3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task3ButtonActionPerformed
        String busStopName = busStopNameComboBox.getSelectedItem().toString();
        List<BusRoute> busRouteList = findAllRoutes(busStopName);
        if (busRouteList.size() != 0) {
            DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tableModel.addColumn("Route Number");
            tableModel.addColumn("Start Time");
            tableModel.addColumn("Stops");
            tableModel.addColumn("End Time");

            for (BusRoute eachRoute : busRouteList) {
                List<BusStop> stops = eachRoute.getStops();
                String startTime = stops.get(0).getTime();
                String endTime = stops.get(stops.size() - 1).getTime();

                Object[] rowData = {
                    eachRoute.getRouteNumber(),
                    startTime,
                    eachRoute.toString(),
                    endTime,
                    eachRoute.getTotalFare(),};
                tableModel.addRow(rowData);
            }
            associateBusStopTable.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(this, "None");
        }
    }//GEN-LAST:event_task3ButtonActionPerformed

    private void task4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task4ButtonActionPerformed
        int routeNumber = Integer.parseInt(routeNumberComboBox.getSelectedItem().toString());
        List<BusStop> busStopList = findAllBusStop(routeNumber);
        if (busStopList.size() != 0) {
            DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tableModel.addColumn("Route Number");
            tableModel.addColumn("Start Time");
            tableModel.addColumn("Stops");
            tableModel.addColumn("End Time");

            for (BusStop eachBusStop : busStopList) {
                String startTime = eachBusStop.getTime();
                String endTime = eachBusStop.getTime();
                Object[] rowData = {
                    routeNumber,
                    startTime,
                    eachBusStop.getName(),
                    endTime,};
                tableModel.addRow(rowData);
            }
            associateRouteTable.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(this, "None");
        }
    }//GEN-LAST:event_task4ButtonActionPerformed

    private void complainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complainButtonActionPerformed
        JOptionPane.showMessageDialog(this, complainTextArea.getText());
    }//GEN-LAST:event_complainButtonActionPerformed

    private void jNumberOfPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNumberOfPeopleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNumberOfPeopleActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

    private void checkNumberOfPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNumberOfPeopleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNumberOfPeopleActionPerformed

    private void totalCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalCostActionPerformed

    private void recelptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recelptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recelptActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Booking;
    private javax.swing.JPanel BusRoutes;
    private javax.swing.JPanel BusStop;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel Route;
    private javax.swing.JTable allRouteTable;
    private javax.swing.JTable associateBusStopTable;
    private javax.swing.JTable associateRouteTable;
    private javax.swing.JComboBox<String> busStopNameComboBox;
    private javax.swing.JTextField checkBusName;
    private javax.swing.JTextField checkDate;
    private javax.swing.JTextField checkLocation;
    private javax.swing.JTextField checkNumberOfPeople;
    private javax.swing.JTextField checkOrName;
    private javax.swing.JTextField checkOrPhone;
    private javax.swing.JTextField checkRtName;
    private javax.swing.JTextField checkRtPhone;
    private javax.swing.JTextField checkTypeOfBus;
    private javax.swing.JButton complainButton;
    private javax.swing.JTextArea complainTextArea;
    private javax.swing.JTextField date;
    private javax.swing.JComboBox<String> endCombobox;
    private javax.swing.JLabel endLabel;
    private javax.swing.JTextField jBusName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLocation;
    private javax.swing.JTextField jNumberOfPeople;
    private javax.swing.JTextField jOrName;
    private javax.swing.JTextField jOrPhone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jRtName;
    private javax.swing.JTextField jRtPhone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JComboBox<String> jTypeOfBus;
    private javax.swing.JButton pay;
    private javax.swing.JButton recelpt;
    private javax.swing.JButton reset;
    private javax.swing.JTable routeAtoBTable;
    private javax.swing.JComboBox<String> routeNumberComboBox;
    private javax.swing.JButton select;
    private javax.swing.JComboBox<String> startComboBox;
    private javax.swing.JLabel startLabel;
    private javax.swing.JButton task1Button;
    private javax.swing.JButton task2Button;
    private javax.swing.JButton task3Button;
    private javax.swing.JButton task4Button;
    private javax.swing.JTextField totalCost;
    // End of variables declaration//GEN-END:variables
}
