public class AssignmentTwo {
    // 程序入口（main方法）
    public static void main(String[] args) {
        System.out.println("PRVMS主题公园管理系统启动");
        AssignmentTwo demo = new AssignmentTwo(); // 创建实例
        demo.partThree(); // 调用partThree演示队列功能
    }

    // Part3：等待队列功能演示
    public void partThree() {
        System.out.println("\n===== Part3：等待队列功能演示 =====");

        // 1. 创建操作员（按Employee构造器参数顺序：name, age, contact, employeeId, assignedArea）
        Employee operator = new Employee("张三", 30, "13800138000", "EMP-001", "过山车区域");

        // 2. 创建Ride对象（参数：rideName, maxRider, operator）
        Ride rollerCoaster = new Ride("过山车", 4, operator);
        System.out.println("创建游乐项目：" + rollerCoaster.getRideName() + "（最大载客量：" + rollerCoaster.getMaxRider() + "人）");

        // 3. 创建5个Visitor对象（参数：name, age, contact, visitorId, isMember）
        Visitor v1 = new Visitor("李四", 20, "13900139001", "VIS-001", true);
        Visitor v2 = new Visitor("王五", 25, "13900139002", "VIS-002", false);
        Visitor v3 = new Visitor("赵六", 18, "13900139003", "VIS-003", true);
        Visitor v4 = new Visitor("孙七", 30, "13900139004", "VIS-004", false);
        Visitor v5 = new Visitor("周八", 22, "13900139005", "VIS-005", true);

        // 4. 添加访客到队列
        System.out.println("\n=== 添加访客到队列 ===");
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // 5. 打印队列
        System.out.println("\n=== 添加后打印队列 ===");
        rollerCoaster.printQueue();

        // 6. 移除2名访客
        System.out.println("\n=== 移除队列中的访客 ===");
        rollerCoaster.removeVisitorFromQueue();
        rollerCoaster.removeVisitorFromQueue();

        // 7. 再次打印队列
        System.out.println("\n=== 移除后打印队列 ===");
        rollerCoaster.printQueue();
    }

    // Part4A演示方法（后续实现）
    public void partFourA() {}

    // Part4B演示方法（后续实现）
    public void partFourB() {}

    // Part5演示方法（后续实现）
    public void partFive() {}

    // Part6演示方法（后续实现）
    public void partSix() {}

    // Part7演示方法（后续实现）
    public void partSeven() {}
}