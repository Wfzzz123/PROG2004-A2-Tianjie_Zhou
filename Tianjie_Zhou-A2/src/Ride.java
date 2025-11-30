import java.util.Queue;
import java.util.LinkedList;
import java.util.LinkedList; // 确保导入正确

public class Ride implements RideInterface {
    // 原有变量（rideName、maxRider等）
    private String rideName;
    private int maxRider;
    private Employee operator;
    private int numOfCycles = 0;

    // 只需创建这1个等待队列（Part3核心）
    private Queue<Visitor> waitingLine = new LinkedList<>();

    // 骑行历史（Part4A用，非Part3队列）
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    // 构造器（已有）
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

    // 新增：getter方法（解决之前的错误）
    public String getRideName() {
        return rideName;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public Employee getOperator() {
        return operator;
    }

    // Part3的三个队列操作方法
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
        System.out.println("=== [" + rideName + "]等待队列（共" + waitingLine.size() + "人）===");
        if (waitingLine.isEmpty()) {
            System.out.println("队列无访客");
            return;
        }
        int index = 1;
        for (Visitor v : waitingLine) {
            System.out.println(index + ". " + v);
            index++;
        }
        System.out.println("======================");
    }

    // 其他接口方法（Part4A、Part5等，后续补充）
    @Override
    public void addVisitorToHistory(Visitor visitor) {}

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return 0;
    }

    @Override
    public void printRideHistory() {}

    @Override
    public void runOneCycle() {}
}