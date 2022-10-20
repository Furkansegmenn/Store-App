package furkan.storeApp.person;

import furkan.storeApp.types.UserType;

public class User {
    String name;
    protected UserType userType;

    public User(String name, UserType userType) {
        this.name = name;
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
