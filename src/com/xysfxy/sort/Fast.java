package com.xysfxy.sort;

/**
 * @Auther: ÷‹±¶ª‘
 * @Date: 2020/7/13 23:49
 * @Description:øÏÀŸ≈≈–Ú
 */
public class Fast implements Comparable<Fast>{
    private String name;
    private int age;

    public Fast(){}

    public Fast(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
    public int compareTo(Fast o) {
        return this.age - o.age;
    }

    public void sort(Comparable[] a, int lo, int hi) {
        if (lo < hi) {
            int part = partition(a, lo, hi);
            sort(a, lo, part - 1);
            sort(a, part + 1, hi);
        }
    }

    private int partition(Comparable[] a, int lo, int hi) {
        Comparable key = a[lo];
        int left = lo, right = hi+1;
        while (true) {
            while(a[--right].compareTo(key)>0){
                if(right == lo){
                    break;
                }
            }
            while(a[++left].compareTo(key)<0){
                if(left == hi){
                    break;
                }
            }
            if(left >= right){
                break;
            }else{
                swap(a, left, right);
            }
        }
        swap(a, lo, right);
        return right;
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Fast s1 = new Fast("f", 78);
        Fast s2 = new Fast("b", 18);
        Fast s3 = new Fast("i", 38);
        Fast s4 = new Fast("a", 10);
        Fast s5 = new Fast("h", 56);
        Fast s6 = new Fast("g", 24);
        Fast[] arr = {s1, s2, s3, s4, s5, s6};
        new Fast().sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}