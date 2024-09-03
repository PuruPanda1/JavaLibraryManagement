public class Borrower {
    String name,contact,membershipId;

    public Borrower(String name, String contact, String membershipId) {
        this.name = name;
        this.contact = contact;
        this.membershipId = membershipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Contact: " + contact + ", membershipId: " + membershipId;
    }
}
