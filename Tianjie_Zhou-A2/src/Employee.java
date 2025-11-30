public class Employee extends Person {
    // 1. 新增2个专属变量（员工ID、负责区域）
    private String employeeId;
    private String assignedArea;

    // 2. 默认构造器（需调用父类默认构造器）
    public Employee() {
        super();  // 隐式调用，可省略，但显式写更清晰
        this.employeeId = "EMP-000";
        this.assignedArea = "未分配";
    }

    // 3. 带参构造器（初始化父类+子类变量）
    public Employee(String name, int age, String contact, String employeeId, String assignedArea) {
        super(name, age, contact);  // 调用父类带参构造器
        this.employeeId = employeeId;
        this.assignedArea = assignedArea;
    }

    // 4. 全getter/setter
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAssignedArea() {
        return assignedArea;
    }

    public void setAssignedArea(String assignedArea) {
        this.assignedArea = assignedArea;
    }

    // 5. 重写toString()（包含父类信息）
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", assignedArea='" + assignedArea + '\'' +
                ", " + super.toString() +  // 调用父类toString()
                '}';
    }
}
