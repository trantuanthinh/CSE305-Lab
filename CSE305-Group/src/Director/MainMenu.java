package Director;

import Builder.BusRouteList;
import Builder.BusStop;
import Builder.BusRoute;
import Builder.BusStopList;
import Product.CreateBus;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class MainMenu extends javax.swing.JFrame {

    private static BusStopList busStopList = CreateBus.getBusStopList();
    private static BusRouteList busRouteList = CreateBus.getBusRouteList();

    public MainMenu() {
        initComponents();
//        System.out.println(busStopList.getBusStopList().size());
//        System.out.println(busRouteList.getBusRouteList().size());
        DefaultComboBoxModel locationStart_Model = new DefaultComboBoxModel<>();
        DefaultComboBoxModel locationEnd_Model = new DefaultComboBoxModel<>();
        for (BusStop eachBusStop : busStopList.getBusStopList()) {
//            System.out.println(eachBusStop.getName());dd
            locationStart_Model.addElement(eachBusStop.getName());
            locationEnd_Model.addElement(eachBusStop.getName());
        }
        startComboBox.setModel(locationStart_Model);
        endCombobox.setModel(locationEnd_Model);

        DefaultComboBoxModel busStopNumber_Model = new DefaultComboBoxModel<>();
        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
//            System.out.println(eachBusRoute.getRouteNumber());
            busStopNumber_Model.addElement(eachBusRoute.getRouteNumber());
        }
        busStopComboBox.setModel(busStopNumber_Model);
//-----------------------------
//      ->--Task 2
        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
            System.out.println("Route Number: " + eachBusRoute.getRouteNumber());
            List<BusStop> stops = eachBusRoute.getStops();
            System.out.println("Stops: ");
            for (BusStop eachStop : stops) {
                System.out.println(" - " + eachStop.getName());
            }
        }
//-----------------------------
//        int a = 106;
//        List<BusStop> b = findAllBusStop(a);
//        for (BusStop each : b) {
//            System.out.println(each.getName());
//        }
    }

//    -> Task 1: Input start-end Output 
    public List<BusRoute> findAllRoutes(String startLocation, String endLocation) {
        List<BusRoute> possibleRoutes = new ArrayList<>();

        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
            System.out.println(eachBusRoute.getRouteNumber());
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
        List<BusRoute> allRoutes = new ArrayList<>();
        for (BusRoute eachBusRoute : busRouteList.getBusRouteList()) {
            System.out.println("Route Number: " + eachBusRoute.getRouteNumber());
            List<BusStop> stops = eachBusRoute.getStops();

//            System.out.println("Stops: ");
//            for (BusStop eachStop : stops) {
//                System.out.println(" - " + eachStop.getName());
//                allRoutes.add(eachStop.getName());
//            }
            System.out.println(); // Add a newline for better readability between routes
        }

        return allRoutes;
    }

//    -> Task 3: Input routeNumber -> Output all Bus Stops
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
        checkButton = new javax.swing.JButton();
        BusRoutes = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        BusStop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        busStopComboBox = new javax.swing.JComboBox<>();
        Route = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startLabel.setText("Start");

        endLabel.setText("End");

        checkButton.setText("Check");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkButton)
                    .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HomeLayout.createSequentialGroup()
                            .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(endCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(HomeLayout.createSequentialGroup()
                            .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(startComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startLabel)
                    .addComponent(startComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endLabel)
                    .addComponent(endCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkButton)
                .addContainerGap(387, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Home", Home);

        jButton1.setText("Show All Routes");

        javax.swing.GroupLayout BusRoutesLayout = new javax.swing.GroupLayout(BusRoutes);
        BusRoutes.setLayout(BusRoutesLayout);
        BusRoutesLayout.setHorizontalGroup(
            BusRoutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusRoutesLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jButton1)
                .addContainerGap(331, Short.MAX_VALUE))
        );
        BusRoutesLayout.setVerticalGroup(
            BusRoutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusRoutesLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton1)
                .addContainerGap(392, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Bus Routes", BusRoutes);

        jLabel1.setText("Bus Stop Number");

        javax.swing.GroupLayout BusStopLayout = new javax.swing.GroupLayout(BusStop);
        BusStop.setLayout(BusStopLayout);
        BusStopLayout.setHorizontalGroup(
            BusStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusStopLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(busStopComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        BusStopLayout.setVerticalGroup(
            BusStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusStopLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(BusStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(busStopComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(437, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Bus Stop", BusStop);

        javax.swing.GroupLayout RouteLayout = new javax.swing.GroupLayout(Route);
        Route.setLayout(RouteLayout);
        RouteLayout.setHorizontalGroup(
            RouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );
        RouteLayout.setVerticalGroup(
            RouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Route", Route);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        String start = startComboBox.getSelectedItem().toString();
        String end = endCombobox.getSelectedItem().toString();
        List<BusRoute> routesFromAToB = findAllRoutes(start, end);
        if (!routesFromAToB.isEmpty()) {
            System.out.println("Routes found ");
            for (BusRoute route : routesFromAToB) {
                System.out.println("Route Number: " + route.getRouteNumber());
            }
        } else {
            System.out.println("No routes found from " + start + " to " + end + ".");
        }
    }//GEN-LAST:event_checkButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BusRoutes;
    private javax.swing.JPanel BusStop;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel Route;
    private javax.swing.JComboBox<String> busStopComboBox;
    private javax.swing.JButton checkButton;
    private javax.swing.JComboBox<String> endCombobox;
    private javax.swing.JLabel endLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JComboBox<String> startComboBox;
    private javax.swing.JLabel startLabel;
    // End of variables declaration//GEN-END:variables
}
