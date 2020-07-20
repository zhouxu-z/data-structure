package com.xysfxy.sort;

/**
 * @Auther: �ܱ���
 * @Date: 2020/7/13 14:28
 * @Description:����һ��ѧ���࣬��ѧ�����������䣬ʵ��Comparable�ӿڣ�����ȽϹ���
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
        s1.setName("����");
        s1.setAge(18);
        s2.setName("����");
        s2.setAge(20);
        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1, Comparable c2){
        /*
        compareTo�������ڱȽ��������󣬷��صĽ��ʱһ������
        �������0��c1����c2
        ���С��0��c1С��c2
        �������0��c1����c2
         */
        int result = c1.compareTo(c2);
        if(result >= 0){
            return c1;
        }else{
            return c2;
        }
    }
}