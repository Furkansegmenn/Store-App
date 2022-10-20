package furkan.storeApp.person;

import furkan.storeApp.types.UserType;

public class Admin extends User {

    private int Id;

    public Admin(String name, int id) {
        super(name, UserType.ADMIN);
        this.name = name;
        Id = id;
        this.userType = UserType.ADMIN;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
