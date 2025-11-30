public class Visitor extends Person {
    private String visitorId;
    private boolean isMember;  // true=会员，false=非会员

    // 默认构造器
    public Visitor() {
        super();
        this.visitorId = "VIS-000";
        this.isMember = false;
    }

    // 带参构造器
    public Visitor(String name, int age, String contact, String visitorId, boolean isMember) {
        super(name, age, contact);
        this.visitorId = visitorId;
        this.isMember = isMember;
    }

    // getter/setter
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public boolean isMember() {  // boolean类型的getter默认用isXXX命名
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    // toString()
    @Override
    public String toString() {
        return "Visitor{" +
                "visitorId='" + visitorId + '\'' +
                ", isMember=" + isMember +
                ", " + super.toString() +
                '}';
    }
}