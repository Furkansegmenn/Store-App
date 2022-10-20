package furkan.storeApp.authorization;

import furkan.storeApp.person.User;
import furkan.storeApp.types.UserType;

import java.util.List;

public enum Authority {
    ADD_PRODUCT(List.of(UserType.ADMIN)), DELETE_PRODUCT(List.of(UserType.ADMIN));

    final List<UserType> userType;
    //MemberType

    Authority(List<UserType> userType) {
        this.userType = userType;
    }

    public boolean userHasPermission(User user) {
        return this.userType.contains(user.getUserType());
    }

}
