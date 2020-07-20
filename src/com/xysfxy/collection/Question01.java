package com.xysfxy.collection;

/**
 * @Auther: �ܱ���
 * @Date: 2020/7/15 14:06
 * @Description:�ж��ַ����е�С�����Ƿ�ƥ������
 */
public class Question01 {

    public static void main(String[] args) {
        String str1 = "(����(����)(sa))";
        String str2 = "(a(s(s)f)";
        String str3 = "(2)s(,)����)";
        String str4 = "(1+2)(9-5)";
        System.out.println(isFun(str1));
        System.out.println(isFun(str2));
        System.out.println(isFun(str3));
        System.out.println(isFun(str4));
    }

    public static boolean isFun(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(temp == '('){
                stack.pop(temp);
            }else if(temp == ')'){
                Character push = stack.push();
                if(push == null){
                    return false;
                }
            }
        }
        return stack.isEampty();
    }

}