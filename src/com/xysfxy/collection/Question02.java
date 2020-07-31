package com.xysfxy.collection;

/**
 * @Auther: �ܱ���
 * @Date: 2020/7/15 14:24
 * @Description:�沨��ʽ
 */
public class Question02 {

    public static void main(String[] args) {
        //��׺���ʽ  3*(17-15)+18/6
        String[] str = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        System.out.println(fun(str));
    }

    public static int fun(String[] str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String temp = str[i];
            int push1, push2;
            switch (temp) {
                case "+":
                    push1 = stack.push();
                    push2 = stack.push();
                    stack.pop(push1 + push2);
                    break;
                case "-":
                    push1 = stack.push();
                    push2 = stack.push();
                    stack.pop(push2 - push1);
                    break;
                case "*":
                    push1 = stack.push();
                    push2 = stack.push();
                    stack.pop(push1 * push2);
                    break;
                case "/":
                    push1 = stack.push();
                    push2 = stack.push();
                    stack.pop(push2 / push1);
                    break;
                default:
                    stack.pop(Integer.parseInt(temp));
                    break;
            }
        }
        return stack.push();
    }

}