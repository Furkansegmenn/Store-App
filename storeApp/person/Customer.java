package furkan.storeApp.person;

import furkan.storeApp.visit.Visit;
import furkan.storeApp.entity.Product;
import furkan.storeApp.types.MemberType;
import furkan.storeApp.types.UserType;

public class Customer extends User {
    private double point = 0;
    private MemberType memberType;
    private Visit visit;

    public Customer(String name, MemberType memberType) {
        super(name, UserType.CUSTOMER);
        this.memberType = memberType;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public void addPoint(double point) {
        this.point += point;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public void checkOut() {
        for (Product current : this.visit.getProductList()) {
            if (this.userType == UserType.CUSTOMER && this.getMemberType() == MemberType.MEMBER) {
                this.addPoint(current.getExpense() * 0.10);
            }
        }
    }
}




