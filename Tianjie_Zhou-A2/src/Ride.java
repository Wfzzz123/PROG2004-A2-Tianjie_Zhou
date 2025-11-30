public class Ride {
    // 1. 3个实例变量（名称、单周期最大载客量、操作员）
    private String rideName;
    private int maxRider;  // 后续Part5会用到，提前定义
    private Employee operator;  // 操作员（Employee类型）

    // 2. 默认构造器
    public Ride() {
        this.rideName = "未知项目";
        this.maxRider = 2;  // 默认单周期载2人
        this.operator = null;  // 默认无操作员
    }

    // 3. 带参构造器
    public Ride(String rideName, int maxRider, Employee operator) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.operator = operator;
    }

    // 4. getter/setter（含操作员赋值方法）
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
        System.out.println("已为[" + rideName + "]分配操作员：" + operator.getEmployeeId() + "-" + operator.getName());
    }

    // 5. toString()
    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", maxRider=" + maxRider +
                ", operator=" + (operator != null ? operator.getEmployeeId() + "-" + operator.getName() : "无") +
                '}';
    }
}