import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Ride implements RideInterface {
    private String rideName;
    private int maxRider;
    private Employee operator;
    private int numOfCycles = 0; // 周期计数变量
    private Queue<Visitor> waitingLine = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    // 构造器
    public Ride() {
        this.rideName = "未知项目";
        this.maxRider = 2;
        this.operator = null;
    }

    public Ride(String rideName, int maxRider, Employee operator) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.operator = operator;
    }

    // getter方法
    public String getRideName() {
        return rideName;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public Employee getOperator() {
        return operator;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    // Part3: 队列操作方法
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor);
            System.out.println("访客[" + visitor.getVisitorId() + "-" + visitor.getName() + "]已加入[" + rideName + "]队列，当前队列长度：" + waitingLine.size());
        } else {
            System.out.println("错误：访客对象为空，无法加入队列！");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removed = waitingLine.poll();
            System.out.println("访客[" + removed.getVisitorId() + "-" + removed.getName() + "]已离开[" + rideName + "]队列");
        } else {
            System.out.println("错误：[" + rideName + "]队列为空，无法移除访客！");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("=== [" + rideName + "]等待队列（共" + waitingLine.size() + "人） ===");
        if (waitingLine.isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        int index = 1;
        for (Visitor v : waitingLine) {
            System.out.println(index + ". " + v);
            index++;
        }
        System.out.println("===========================");
    }

    // Part4A: 历史相关方法
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("访客[" + visitor.getVisitorId() + "-" + visitor.getName() + "]已加入[" + rideName + "]历史，历史总人数：" + rideHistory.size());
        } else {
            System.out.println("错误：访客对象为空，无法加入历史！");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("错误：访客对象为空，无法检查！");
            return false;
        }
        for (Visitor v : rideHistory) {
            if (v.getVisitorId().equals(visitor.getVisitorId())) {
                System.out.println("访客[" + visitor.getVisitorId() + "-" + visitor.getName() + "]在[" + rideName + "]历史中");
                return true;
            }
        }
        System.out.println("访客[" + visitor.getVisitorId() + "-" + visitor.getName() + "]不在[" + rideName + "]历史中");
        return false;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("[" + rideName + "]骑行历史总人数：" + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        System.out.println("=== [" + rideName + "]骑行历史（共" + rideHistory.size() + "人） ===");
        if (rideHistory.isEmpty()) {
            System.out.println("历史无访客");
            return;
        }
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            System.out.println(index + ". " + v);
            index++;
        }
        System.out.println("===========================");
    }

    // Part4B: 历史排序方法
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("[" + rideName + "]历史为空，无需排序！");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("[" + rideName + "]历史排序完成（按年龄升序，年龄相同则按ID升序）");
    }

    // Part5: 骑行周期方法
    @Override
    public void runOneCycle() {
        System.out.println("\n=== 开始运行[" + rideName + "]的骑行周期 ===");
        if (this.operator == null) {
            System.out.println("错误：[" + rideName + "]未分配操作员，无法运行周期");
            return;
        }
        if (waitingLine.isEmpty()) {
            System.out.println("错误：[" + rideName + "]等待队列为空，无法运行周期");
            return;
        }

        int available = waitingLine.size();
        int takeCount = Math.min(available, this.maxRider);
        System.out.println("本次周期可搭载访客数：" + takeCount + "（队列共" + available + "人，最大容量" + maxRider + "人）");

        for (int i = 0; i < takeCount; i++) {
            Visitor v = waitingLine.poll();
            this.addVisitorToHistory(v);
        }

        this.numOfCycles++;
        System.out.println("=== [" + rideName + "]第" + this.numOfCycles + "个周期运行完成 ===");
    }

    // 导出骑行历史到CSV文件
    public void exportRideHistory(String filePath) {
        System.out.println("\n=== 开始导出[" + rideName + "]骑行历史到文件：" + filePath + " ===");
        if (rideHistory.isEmpty()) {
            System.out.println("警告：[" + rideName + "]骑行历史为空，无需导出");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // 写入CSV表头
            bw.write("访客ID,姓名,年龄,联系方式,是否会员");
            bw.newLine();

            // 写入每条访客记录
            for (Visitor v : rideHistory) {
                String line = v.getVisitorId() + "," +
                        v.getName() + "," +
                        v.getAge() + "," +
                        v.getContact() + "," +
                        (v.isMember() ? "是" : "否");
                bw.write(line);
                bw.newLine();
            }
            System.out.println("导出成功！共导出" + rideHistory.size() + "条访客记录");
        } catch (IOException e) {
            System.err.println("导出失败：" + e.getMessage());
        }
    }

    // 从CSV文件导入骑行历史
    public void importRideHistory(String filePath) {
        System.out.println("\n=== 开始从文件[" + filePath + "]导入[" + rideName + "]骑行历史 ===");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int importedCount = 0;
            boolean isFirstLine = true; // 标记是否为表头行

            while ((line = br.readLine()) != null) {
                // 跳过表头行
                if (isFirstLine) {
                    System.out.println("跳过表头行：" + line);
                    isFirstLine = false;
                    continue;
                }

                // 分割CSV行
                String[] parts = line.split(",");
                // 检查字段数量
                if (parts.length != 5) {
                    System.out.println("跳过无效行（字段数量错误）：" + line);
                    continue;
                }

                // 解析每个字段
                try {
                    String visitorId = parts[0].trim();
                    String name = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String contact = parts[3].trim();
                    boolean isMember = parts[4].trim().equals("是");

                    // 创建Visitor对象并添加到历史
                    Visitor v = new Visitor(name, age, contact, visitorId, isMember);
                    this.addVisitorToHistory(v);
                    importedCount++;
                } catch (NumberFormatException e) {
                    System.out.println("跳过无效行（格式错误）：" + line + "，错误：" + e.getMessage());
                }
            }

            System.out.println("导入完成！共成功导入" + importedCount + "条访客记录");
        } catch (IOException e) {
            System.err.println("导入失败：" + e.getMessage());
        }
    }
}