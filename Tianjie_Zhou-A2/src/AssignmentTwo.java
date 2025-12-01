public class AssignmentTwo {
    // 程序入口：调用partSix演示导出功能
    public static void main(String[] args) {
        System.out.println("PRWMS主题公园管理系统启动");
        AssignmentTwo demo = new AssignmentTwo();
        // 调用Part6：导出骑行历史功能（取消注释下方行即可运行）
        demo.partSix();
        // 如需运行其他部分，可取消对应注释
        // demo.partThree();   // 调用Part3：等待队列功能
        // demo.partFourA();   // 调用Part4A：骑行历史基础功能
        // demo.partFourB();   // 调用Part4B：骑行历史排序功能
        // demo.partFive();    // 调用Part5：运行骑行周期功能
    }

    // Part3：等待队列功能演示
    public void partThree() {
        System.out.println("\n=== Part3：等待队列功能演示 ===");

        // 1. 创建操作员
        Employee operator = new Employee("张三", 30, "13800138000", "EMP-001", "过山车区域");

        // 2. 创建Ride对象
        Ride rollerCoaster = new Ride("过山车", 4, operator);
        System.out.println("创建游乐项目：" + rollerCoaster.getRideName() + "（最大载客量：" + rollerCoaster.getMaxRider() + "人）");

        // 3. 创建5个Visitor对象
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

    // Part4A：骑行历史功能演示
    public void partFourA() {
        System.out.println("\n=== Part4A：骑行历史功能演示 ===");

        // 1. 创建Ride对象
        Ride thunderstorm = new Ride("激流勇进", 2, null);

        // 2. 创建5个Visitor对象
        Visitor v1 = new Visitor("Alice", 22, "18800188001", "VIS-101", true);
        Visitor v2 = new Visitor("Bob", 28, "18800188002", "VIS-102", false);
        Visitor v3 = new Visitor("Charlie", 25, "18800188003", "VIS-103", true);
        Visitor v4 = new Visitor("David", 32, "18800188004", "VIS-104", false);
        Visitor v5 = new Visitor("Eve", 19, "18800188005", "VIS-105", true);

        // 3. 添加访客到历史
        System.out.println("\n=== 添加访客到历史 ===");
        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);
        thunderstorm.addVisitorToHistory(v5);

        // 4. 检查访客是否在历史中
        System.out.println("\n=== 检查历史中的访客 ===");
        thunderstorm.checkVisitorFromHistory(v3); // 存在
        Visitor vNotFound = new Visitor("Frank", 30, "18800188006", "VIS-106", false);
        thunderstorm.checkVisitorFromHistory(vNotFound); // 不存在

        // 5. 打印历史总人数
        System.out.println("\n=== 历史总人数 ===");
        thunderstorm.numberOfVisitors();

        // 6. 打印历史
        System.out.println("\n=== 打印骑行历史 ===");
        thunderstorm.printRideHistory();
    }

    // Part4B：骑行历史排序演示（核心功能：使用VisitorComparator排序）
    public void partFourB() {
        System.out.println("\n=== Part4B：骑行历史排序演示 ===");

        // 1. 创建Ride对象（旋转木马）
        Ride carousel = new Ride("旋转木马", 6, null);

        // 2. 创建5个访客（年龄故意打乱，便于演示排序）
        Visitor v1 = new Visitor("Zoe", 25, "17700177001", "VIS-201", true);    // 25岁
        Visitor v2 = new Visitor("Yoyo", 22, "17700177002", "VIS-202", false);   // 22岁
        Visitor v3 = new Visitor("Xander", 25, "17700177003", "VIS-203", true);  // 25岁（与v1同岁）
        Visitor v4 = new Visitor("Will", 30, "17700177004", "VIS-204", false);   // 30岁
        Visitor v5 = new Visitor("Vivian", 22, "17700177005", "VIS-205", true);  // 22岁（与v2同岁）

        // 3. 添加到历史
        carousel.addVisitorToHistory(v1);
        carousel.addVisitorToHistory(v2);
        carousel.addVisitorToHistory(v3);
        carousel.addVisitorToHistory(v4);
        carousel.addVisitorToHistory(v5);

        // 4. 打印排序前的历史
        System.out.println("\n=== 排序前 ===");
        carousel.printRideHistory();

        // 5. 排序（使用VisitorComparator）
        carousel.sortRideHistory();

        // 6. 打印排序后的历史（验证排序效果）
        System.out.println("\n=== 排序后 ===");
        carousel.printRideHistory();
        // 预期排序：v2(22,VIS-202) → v5(22,VIS-205) → v1(25,VIS-201) → v3(25,VIS-203) → v4(30,VIS-204)
    }

    // Part5：运行骑行周期演示
    public void partFive() {
        System.out.println("\n=== Part5：运行骑行周期演示 ===");

        Employee operator = new Employee("李师傅", 35, "13700137000", "EMP-002", "旋转木马区域");
        Ride carousel = new Ride("旋转木马", 3, operator);
        System.out.println("创建游乐项目：" + carousel.getRideName() + "（最大载客量：" + carousel.getMaxRider() + "人）");

        for (int i = 1; i <= 10; i++) {
            String name = "访客" + i;
            int age = 18 + (i % 10);
            String contact = "1360013600" + i;
            String visitorId = "VIS-30" + i;
            boolean isMember = (i % 2 == 0);
            Visitor v = new Visitor(name, age, contact, visitorId, isMember);
            carousel.addVisitorToQueue(v);
        }

        System.out.println("\n=== 运行前的队列 ===");
        carousel.printQueue();

        carousel.runOneCycle();

        System.out.println("\n=== 运行后的队列 ===");
        carousel.printQueue();

        System.out.println("\n=== 运行后的骑行历史 ===");
        carousel.printRideHistory();

        // 再次运行周期验证计数
        carousel.runOneCycle();
        System.out.println("\n=== 再次运行1个周期后 ===");
        System.out.println("总运行周期数：" + carousel.getNumOfCycles());
        System.out.println("当前历史总人数：" + carousel.numberOfVisitors());
    }

    // Part6：导出骑行历史到文件演示
    public void partSix() {
        System.out.println("\n=== Part6：导出骑行历史到文件演示 ===");

        // 1. 创建Ride对象并添加5个访客到历史
        Ride rollerCoaster = new Ride("过山车", 4, null);
        Visitor v1 = new Visitor("张三", 20, "13800138001", "VIS-401", true);
        Visitor v2 = new Visitor("李四", 25, "13800138002", "VIS-402", false);
        Visitor v3 = new Visitor("王五", 18, "13800138003", "VIS-403", true);
        Visitor v4 = new Visitor("赵六", 30, "13800138004", "VIS-404", false);
        Visitor v5 = new Visitor("孙七", 22, "13800138005", "VIS-405", true);
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);

        // 2. 定义文件路径（根据操作系统选择路径）
        // Windows系统路径示例
        String filePath = "C:/rideHistory.csv";
        // Mac/Linux系统路径示例（替换为你的用户名）
        // String filePath = "/Users/yourusername/rideHistory.csv";

        // 3. 执行导出
        rollerCoaster.exportRideHistory(filePath);

        // 4. 提示用户查看文件
        System.out.println("请在路径[" + filePath + "]查看导出的CSV文件");
    }

    // Part7演示方法（后续实现）
    public void partSeven() {}
}