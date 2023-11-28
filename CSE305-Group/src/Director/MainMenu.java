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

        jTabbedPane3 = new javax.swing.JTabbedPane();
        Home = new javax.swing.JPanel();
        startLabel = new javax.swing.JLabel();
        startComboBox = new javax.swing.JComboBox<>();
        endLabel = new javax.swing.JLabel();
        endCombobox = new javax.swing.JComboBox<>();
        task1Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        routeAtoBTable = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startLabel.setText("Start");

        endLabel.setText("End");

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

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(task1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(endCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(task1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startLabel))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Home", Home);

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
                .addGroup(BusRoutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BusRoutesLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(task2Button))
                    .addGroup(BusRoutesLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        BusRoutesLayout.setVerticalGroup(
            BusRoutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusRoutesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(task2Button)
                .addGap(63, 63, 63)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Bus Routes", BusRoutes);

        jLabel2.setText("Route Number");

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
                .addGap(56, 56, 56)
                .addGroup(RouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RouteLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(busStopNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(task3Button)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        RouteLayout.setVerticalGroup(
            RouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RouteLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(RouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(busStopNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(task3Button))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Route", Route);

        jLabel1.setText("Route Number");

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
                .addGap(56, 56, 56)
                .addGroup(BusStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BusStopLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(routeNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(task4Button)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        BusStopLayout.setVerticalGroup(
            BusStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusStopLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(BusStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(routeNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(task4Button))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Bus Stop", BusStop);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BusRoutes;
    private javax.swing.JPanel BusStop;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel Route;
    private javax.swing.JTable allRouteTable;
    private javax.swing.JTable associateBusStopTable;
    private javax.swing.JTable associateRouteTable;
    private javax.swing.JComboBox<String> busStopNameComboBox;
    private javax.swing.JComboBox<String> endCombobox;
    private javax.swing.JLabel endLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable routeAtoBTable;
    private javax.swing.JComboBox<String> routeNumberComboBox;
    private javax.swing.JComboBox<String> startComboBox;
    private javax.swing.JLabel startLabel;
    private javax.swing.JButton task1Button;
    private javax.swing.JButton task2Button;
    private javax.swing.JButton task3Button;
    private javax.swing.JButton task4Button;
    // End of variables declaration//GEN-END:variables
}
