
public interface RideInterface {
    // 1. 队列操作（Part3实现）
    void addVisitorToQueue(Visitor visitor);  // 添加访客到队列
    void removeVisitorFromQueue();            // 从队列移除访客（FIFO）
    void printQueue();                        // 打印队列所有访客

    // 2. 骑行历史操作（Part4A实现）
    void addVisitorToHistory(Visitor visitor);        // 添加访客到历史
    boolean checkVisitorFromHistory(Visitor visitor); // 检查访客是否在历史中
    int numberOfVisitors();                           // 返回历史中访客数量
    void printRideHistory();                          // 打印历史所有访客

    // 3. 骑行周期（Part5实现）
    void runOneCycle();  // 运行一个骑行周期
}