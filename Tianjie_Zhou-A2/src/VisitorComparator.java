import java.util.Comparator;

// 实现Comparator<Visitor>接口，确保Visitor类可正确引用
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 1. 先按年龄升序排序（小的在前）
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) { // 年龄不同，直接返回年龄比较结果
            return ageCompare;
        }
        // 2. 年龄相同，按访客ID升序排序（字典序）
        return v1.getVisitorId().compareTo(v2.getVisitorId());
    }
}