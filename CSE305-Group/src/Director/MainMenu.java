package Director;

import Builder.BusName;
import Builder.BusNameList;
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
    private static BusNameList busNameList = CreateBus.getBusNameList();
    private static List<String> commentList = new ArrayList<>();

    public MainMenu() {
        initComponents();
        checkOrName.setEnabled(false);
        checkOrPhone.setEnabled(false);
        checkRtName.setEnabled(false);
        checkRtPhone.setEnabled(false);
        checkDate.setEnabled(false);
        checkBusName.setEnabled(false);
        checkTypeOfBus.setEnabled(false);
        checkNumberOfPeople.setEnabled(false);
        checkLocation.setEnabled(false);
        totalCost.setEnabled(false);
        for (int i = 1; i < 13; i++) {
            monthComboBox.addItem(String.valueOf(i));
        }

        for (int i = 2023; i < 2040; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }

        DefaultComboBoxModel locationStart_Model = new DefaultComboBoxModel<>();
        DefaultComboBoxModel locationEnd_Model = new DefaultComboBoxModel<>();
        DefaultComboBoxModel location1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel location2 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel busStopNumber_Model = new DefaultComboBoxModel<>();
        DefaultComboBoxModel busName_Model = new DefaultComboBoxModel<>();

        for (BusStop eachBusStop : busStopList.getBusStopList()) {
            locationStart_Model.addElement(eachBusStop.getName());
            locationEnd_Model.addElement(eachBusStop.getName());
            location1.addElement(eachBusStop.getName());
            location2.addElement(eachBusStop.getName());
        }
        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
            busStopNumber_Model.addElement(eachBusRoute.getRouteNumber());
        }

        for (BusName eachBusName : busNameList.getBusNameList()) {
            busName_Model.addElement(eachBusName.getBusName());
        }

        startComboBox.setModel(locationStart_Model);
        endCombobox.setModel(locationEnd_Model);
        busStopNameComboBox.setModel(location1);
        locationComboBox.setModel(location2);
        routeNumberComboBox.setModel(busStopNumber_Model);

        DefaultComboBoxModel busNameCheck_Model = new DefaultComboBoxModel<>();
        List<BusRoute> checkBusRoute = findAllRoutes(locationComboBox.getSelectedItem().toString());
        List<BusName> checkBusName = new ArrayList<>();

        for (BusRoute eachBusRoute : checkBusRoute) {
            BusName checkName = eachBusRoute.getBusName();
            if (!checkBusName.contains(checkName)) {
                checkBusName.add(checkName);
            }
        }
        for (BusName eachBusName : checkBusName) {
            busNameCheck_Model.addElement(eachBusName.getBusName());
        }
        busNameComboBox.setModel(busNameCheck_Model);
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
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

//    -> Task 5: Booking
    public double CalculateCost() {
        String checkLocation = locationComboBox.getSelectedItem().toString();
        String checkBusName = busNameComboBox.getSelectedItem().toString();
        double total = 0;
        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
            boolean check1 = eachBusRoute.getBusName().toString().equalsIgnoreCase(checkBusName);
            boolean check2 = false;
            for (BusStop eachBusStop : eachBusRoute.getStops()) {
                if (eachBusStop.getName().equalsIgnoreCase(checkLocation)) {
                    check2 = true;
                    break;
                }
            }
            if (check1 && check2) {
                total = eachBusRoute.getTotalFare();
            }
        }
        return total;
    }

    public void SetDate() {
        int endDate = 0;
        switch (monthComboBox.getSelectedItem().toString()) {
            case "1", "3", "5", "7", "8", "10", "12": {
                endDate = 31;
                break;
            }

            case "4", "6", "9", "11": {
                endDate = 30;
                break;
            }

            case "2": {
                int year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
                if (isLeapYear(year)) {
                    endDate = 29;
                } else {
                    endDate = 28;
                }
                break;
            }
        }
        for (int i = 1; i < endDate + 1; i++) {
            dateComboBox.addItem(String.valueOf(i));
        }
        dateComboBox.setEnabled(true);
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
        jLabel7 = new javax.swing.JLabel();
        jNumberOfPeople = new javax.swing.JTextField();
        typeOfBusComboBox = new javax.swing.JComboBox<>();
        busNameComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        locationComboBox = new javax.swing.JComboBox<>();
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
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        dateComboBox = new javax.swing.JComboBox<>();
        monthComboBox = new javax.swing.JComboBox<>();
        yearComboBox = new javax.swing.JComboBox<>();
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
        checkTypeOfBus = new javax.swing.JTextField();
        checkLocation = new javax.swing.JTextField();
        checkNumberOfPeople = new javax.swing.JTextField();
        checkBusName = new javax.swing.JTextField();
        pay = new javax.swing.JButton();
        Comments = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        complainButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        commentTable = new javax.swing.JTable();

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
        jLabel2.setText("Bus Stop");
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
        BusStop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel1.setText("Route Number");
        BusStop.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 39, 108, -1));

        BusStop.add(routeNumberComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 38, 164, -1));

        task4Button.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        task4Button.setText("Show Bus Stops");
        task4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task4ButtonActionPerformed(evt);
            }
        });
        BusStop.add(task4Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 36, -1, -1));

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

        BusStop.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 84, 722, 263));

        Booking.addTab("Bus Stop", BusStop);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Bus Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Type Of Bus");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Number Of People");

        typeOfBusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Luxury", "Popular" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Location");

        locationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jNumberOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typeOfBusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(busNameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(typeOfBusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(busNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jNumberOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 180));

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
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Month");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("Year");

        monthComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthComboBoxMouseClicked(evt);
            }
        });
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        yearComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yearComboBoxMouseClicked(evt);
            }
        });
        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
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
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jOrPhone))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(reset)
                        .addGap(38, 38, 38)
                        .addComponent(select)))
                .addGap(20, 20, 20))
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
                    .addComponent(jLabel27)
                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 0, 650, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        jLabel12.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel12.setText("Check Organization Information");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Organization's Name");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Representative's Name");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Representative's Phone");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Organization's Phone");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Date");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Bus Name");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Type Of Bus");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Location");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Number Of People");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Total Cost");

        checkNumberOfPeople.setForeground(new java.awt.Color(204, 204, 204));

        pay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pay.setText("Pay");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel15)
                .addGap(44, 44, 44)
                .addComponent(checkOrName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(checkBusName, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel16)
                .addGap(30, 30, 30)
                .addComponent(checkRtName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(checkTypeOfBus, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addGap(27, 27, 27)
                .addComponent(checkRtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel22)
                .addGap(86, 86, 86)
                .addComponent(checkLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel18)
                .addGap(41, 41, 41)
                .addComponent(checkOrPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(checkNumberOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(checkDate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jLabel24)
                .addGap(59, 59, 59)
                .addComponent(totalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(830, 830, 830)
                .addComponent(pay))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(checkOrName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel20))
                    .addComponent(checkBusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(checkRtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(checkTypeOfBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(checkRtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(checkLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(checkOrPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(checkNumberOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(checkDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(totalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(pay))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 198, -1, -1));

        Booking.addTab("Booking", jPanel1);

        Comments.setBackground(new java.awt.Color(204, 204, 255));
        Comments.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        commentTextArea.setColumns(20);
        commentTextArea.setRows(5);
        jScrollPane5.setViewportView(commentTextArea);

        Comments.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 782, -1));

        complainButton.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        complainButton.setText("Submit");
        complainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complainButtonActionPerformed(evt);
            }
        });
        Comments.add(complainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Complain");
        Comments.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        commentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        commentTable.setAutoscrolls(false);
        jScrollPane6.setViewportView(commentTable);

        Comments.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 780, 270));

        Booking.addTab("Complain", Comments);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
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
//        JOptionPane.showMessageDialog(this, commentTextArea.getText());
        String comment = commentTextArea.getText();
        commentList.add(comment);
        if (commentList.size() != 0) {
            DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tableModel.addColumn("Index");
            tableModel.addColumn("Comment");

            for (int i = 0; i < commentList.size(); i++) {
                int index = i + 1;
                comment = commentList.get(i);
                Object[] rowData = {
                    index,
                    comment};
                tableModel.addRow(rowData);
            }
            commentTable.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(this, "None");
        }
    }//GEN-LAST:event_complainButtonActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        busNameComboBox.setSelectedIndex(0);
        typeOfBusComboBox.setSelectedIndex(0);
        locationComboBox.setSelectedIndex(0);
        jNumberOfPeople.setText("");
        jOrName.setText("");
        jOrPhone.setText("");
        jRtName.setText("");
        jRtPhone.setText("");
        dateComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_resetActionPerformed

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
            tableModel.addColumn("Bus Name");
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
                    eachRoute.getBusName(),
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

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        try {
            int number = Integer.parseInt(jNumberOfPeople.getText());
            if (number >= 30) {
                double total = CalculateCost();
                String.valueOf(total);
                checkOrName.setText(jOrName.getText());
                checkOrPhone.setText(jOrPhone.getText());
                checkRtName.setText(jRtName.getText());
                checkRtPhone.setText(jRtPhone.getText());
                checkBusName.setText(busNameComboBox.getSelectedItem().toString());
                checkTypeOfBus.setText(typeOfBusComboBox.getSelectedItem().toString());
                checkNumberOfPeople.setText(jNumberOfPeople.getText());
                checkLocation.setText(locationComboBox.getSelectedItem().toString());
                String date = dateComboBox.getSelectedItem().toString();
                String month = monthComboBox.getSelectedItem().toString();
                String year = yearComboBox.getSelectedItem().toString();
                checkDate.setText(date + "/" + month + "/" + year);
                totalCost.setText(String.valueOf(total));
            } else {
                JOptionPane.showMessageDialog(this, "Over 30");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_selectActionPerformed

    private void locationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationComboBoxActionPerformed
        DefaultComboBoxModel busNameCheck_Model = new DefaultComboBoxModel<>();
        List<BusRoute> checkBusRoute = findAllRoutes(locationComboBox.getSelectedItem().toString());
        List<BusName> checkBusName = new ArrayList<>();

        for (BusRoute eachBusRoute : checkBusRoute) {
            BusName checkName = eachBusRoute.getBusName();
            if (!checkBusName.contains(checkName)) {
                checkBusName.add(checkName);
            }
        }
        for (BusName eachBusName : checkBusName) {
            busNameCheck_Model.addElement(eachBusName.getBusName());
        }
        busNameComboBox.setModel(busNameCheck_Model);
    }//GEN-LAST:event_locationComboBoxActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        JOptionPane.showMessageDialog(this, "Done");
    }//GEN-LAST:event_payActionPerformed

    private void monthComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthComboBoxMouseClicked
        SetDate();
    }//GEN-LAST:event_monthComboBoxMouseClicked

    private void yearComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearComboBoxMouseClicked
        SetDate();
    }//GEN-LAST:event_yearComboBoxMouseClicked

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        SetDate();
    }//GEN-LAST:event_yearComboBoxActionPerformed

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed
        SetDate();
    }//GEN-LAST:event_monthComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Booking;
    private javax.swing.JPanel BusRoutes;
    private javax.swing.JPanel BusStop;
    private javax.swing.JPanel Comments;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel Route;
    private javax.swing.JTable allRouteTable;
    private javax.swing.JTable associateBusStopTable;
    private javax.swing.JTable associateRouteTable;
    private javax.swing.JComboBox<String> busNameComboBox;
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
    private javax.swing.JTable commentTable;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JButton complainButton;
    private javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JComboBox<String> endCombobox;
    private javax.swing.JLabel endLabel;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JComboBox<String> locationComboBox;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JButton pay;
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
    private javax.swing.JComboBox<String> typeOfBusComboBox;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}
