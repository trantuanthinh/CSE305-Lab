package cse305.lab;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class CSE305Lab {

    public static void main(String[] args) {

    }

    private static class User {

        long userID;
        String userFirstName;
        String userLastName;
        String userEmail;
        String password;

        public User(long userID, String userFirstName, String userLastName, String userEmail, String password) {
            super();
            this.userID = userID;
            this.userFirstName = userFirstName;
            this.userLastName = userLastName;
            this.userEmail = userEmail;
            this.password = password;
        }

        public void register() {

        }

        public void login() {

        }

        public void updateProfile() {

        }

        public void resetPassword() {

        }
    }

    private static class PropertyOwner {

        List<Property> propertyOwner = new ArrayList<>();

        public void listProperty() {

        }

        public void createProperty() {

        }

        public void udateProperty() {

        }

        public void deleteProperty() {

        }
    }

    private static class Tenant {

        private List<RetalContract> tanant = new ArrayList<>();

        private void createRentalContract() {

        }

        private void TerminateRentalContract() {

        }

    }

    private static class Property {

        long propertyID;
        String description;
        float rentalRate;

        public Property(long propertyID, String description, float rentalRate) {

            this.propertyID = propertyID;
            this.description = description;
            this.rentalRate = rentalRate;
        }

        public void createProperty() {

        }

        public void updateProperty() {

        }

        public void deteleProperty() {

        }
    }

    private static class RetalContract {

        long contracyID;
        long propertyID;
        long tenantID;
        String startDate;
        String endDate;
        float renAmount;

        public RetalContract(long contracyID, long propertyID, long tenantID, String startDate, String endDate,
                float renAmount) {
            super();
            this.contracyID = contracyID;
            this.propertyID = propertyID;
            this.tenantID = tenantID;
            this.startDate = startDate;
            this.endDate = endDate;
            this.renAmount = renAmount;
        }

        public void createContract() {

        }

        public void terminateContract() {

        }
    }
