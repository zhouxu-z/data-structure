package com.xysfxy.sort;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/13 14:28
 * @Description:定义一个学生类，有学生姓名和年龄，实现Comparable接口，定义比较规则
 */
public class TestComparable implements Comparable<TestComparable>{
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "Fast{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(TestComparable o) {
        return this.age - o.getAge();
    }

    public static void main(String[] args) {
        TestComparable s1 = new TestComparable();
        TestComparable s2 = new TestComparable();
        s1.setName("张三");
        s1.setAge(18);
        s2.setName("李四");
        s2.setAge(20);
        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1, Comparable c2){
        /*
        compareTo方法用于比较两个对象，返回的结果时一个整数
        结果大于0，c1大于c2
        结果小于0，c1小于c2
        结果等于0，c1等于c2
         */
        int result = c1.compareTo(c2);
        if(result >= 0){
            return c1;
        }else{
            return c2;
        }
    }
}