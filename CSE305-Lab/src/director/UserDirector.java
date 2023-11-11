package director;

import builder.User;

public class UserDirector {
    private User userBuilder;

    public UserDirector(User userBuilder) {
        this.userBuilder = userBuilder;
    }

    public product.User constructUser(long userID, String userFirstName, String userLastName, String userEmail, String password) {
        return userBuilder
                .setUserID(userID)
                .setUserFirstName(userFirstName)
                .setUserLastName(userLastName)
                .setUserEmail(userEmail)
                .setPassword(password)
                .build();
    }
}