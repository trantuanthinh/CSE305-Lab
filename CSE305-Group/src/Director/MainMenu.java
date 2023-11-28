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
        pay = new javax.swing.JButton();
        checkTypeOfBus = new javax.swing.JTextField();
        checkLocation = new javax.swing.JTextField();
        checkNumberOfPeople = new javax.swing.JTextField();
        checkBusName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Booking.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N

        startLabel.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        startLabel.setText("Start");

        endLabel.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        endLabel.setText("End");

        task1Button.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        task1Button.setText("Find Route");
        task1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task1ButtonActionPerformed(evt);
            }
        });

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

        complainTextArea.setColumns(20);
        complainTextArea.setRows(5);
        jScrollPane5.setViewportView(complainTextArea);

        complainButton.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        complainButton.setText("Submit");
        complainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complainButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel3.setText("Complain");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(task1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(complainButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(task1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startLabel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(complainButton)
                .addGap(27, 27, 27))
        );

        Booking.addTab("Home", Home);

        task2Button.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        task2Button.setText("Show All Routes");
        task2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task2ButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout BusRoutesLayout = new javax.swing.GroupLayout(BusRoutes);
        BusRoutes.setLayout(BusRoutesLayout);
        BusRoutesLayout.setHorizontalGroup(
            BusRoutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusRoutesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BusRoutesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(task2Button)
                .addGap(80, 80, 80))
        );
        BusRoutesLayout.setVerticalGroup(
            BusRoutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusRoutesLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(task2Button)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        Booking.addTab("Bus Routes", BusRoutes);

        jLabel2.setBackground(new java.awt.Color(255, 153, 153));
        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Route Number");

        task3Button.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        task3Button.setText("Show Routes");
        task3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task3ButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout RouteLayout = new javax.swing.GroupLayout(Route);
        Route.setLayout(RouteLayout);
        RouteLayout.setHorizontalGroup(
            RouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RouteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(busStopNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(task3Button)
                .addGap(208, 208, 208))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RouteLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        RouteLayout.setVerticalGroup(
            RouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RouteLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(RouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busStopNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(task3Button)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        Booking.addTab("Route", Route);

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
                .addContainerGap(50, Short.MAX_VALUE))
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
                .addContainerGap(141, Short.MAX_VALUE))
        );

        Booking.addTab("Bus Stop", BusStop);

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(select))
                .addContainerGap(23, Short.MAX_VALUE))
        );

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

        totalCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalCostActionPerformed(evt);
            }
        });

        recelpt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        recelpt.setText("Recelpt");
        recelpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recelptActionPerformed(evt);
            }
        });

        pay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pay.setText("Pay");

        checkNumberOfPeople.setForeground(new java.awt.Color(204, 204, 204));
        checkNumberOfPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNumberOfPeopleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(231, 231, 231))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkOrName, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(checkRtName)
                            .addComponent(checkRtPhone)
                            .addComponent(checkOrPhone)
                            .addComponent(checkDate))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(totalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(checkNumberOfPeople))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkTypeOfBus, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                            .addComponent(checkLocation)
                                            .addComponent(checkBusName, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))))
                                .addGap(61, 61, 61))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(recelpt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pay)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(checkOrName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(checkBusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(checkRtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(checkTypeOfBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(checkRtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(checkLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(checkOrPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(checkNumberOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(checkDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(totalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recelpt)
                    .addComponent(pay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Booking.addTab("Booking", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Booking))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Booking, javax.swing.GroupLayout.Alignment.TRAILING)
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
