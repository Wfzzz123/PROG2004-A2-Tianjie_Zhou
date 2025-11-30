import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections; // 用于排序

public class Ride implements RideInterface {
    // 原有变量
    private String rideName;
    private int maxRider;
    private Employee operator;
    private int numOfCycles = 0;

    // 等待队列（Part3核心）
    private Queue<Visitor> waitingLine = new LinkedList<>();

    // 骑行历史（Part4A/4B用）
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

    // Part3：队列操作方法
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

    // Part4A：历史相关方法
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
        System.out.println("=== [" + rideName + "]骑行历史（共" + rideHistory.size() + "人）===");
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
        System.out.println("======================");
    }

    // Part4B：历史排序方法（使用VisitorComparator）
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("[" + rideName + "]历史为空，无需排序！");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("[" + rideName + "]历史排序完成（按年龄升序，年龄相同则按ID升序）");
    }

    // Part5：骑行周期方法
    @Override
    public void runOneCycle() {}
}