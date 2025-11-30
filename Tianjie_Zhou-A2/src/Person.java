public abstract class Person {
    // 1. 定义3个实例变量（姓名、年龄、联系方式）
    private String name;
    private int age;
    private String contact;

    // 2. 默认构造器（无参）
    public Person() {
        this.name = "未知";
        this.age = 0;
        this.contact = "未提供";
    }

    // 3. 带参构造器（初始化所有变量）
    public Person(String name, int age, String contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    // 4. 全getter/setter方法（右键 → Generate → Getter and Setter → 全选变量 → OK）
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // 可选：重写toString()，便于打印对象信息（右键 → Generate → toString() → 全选变量 → OK）
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                '}';
    }
}