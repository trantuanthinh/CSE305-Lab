package builder;

public interface User {
    User setUserID(long userID);
    User setUserFirstName(String userFirstName);
    User setUserLastName(String userLastName);
    User setUserEmail(String userEmail);
    User setPassword(String password);
    product.User build();
}