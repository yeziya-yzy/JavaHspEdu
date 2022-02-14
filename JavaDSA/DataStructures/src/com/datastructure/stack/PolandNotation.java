package com.datastructure.stack;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/12
 * 逆波兰表达式计算器
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "323 4 + 5 * 6 - ";  //定义逆波兰表达式
        System.out.println(suffixExpression + "结果是" + newMethod(suffixExpression));//323 4 + 5 * 6 - 结果是1629
        // System.out.println(suffixExpression + "结果是" + traditionalMethod(suffixExpression));
        System.out.println(InfixToSuffix("323 + 4 * 5 - 6"));  //得到323 + 4 * 5 - 6的逆波兰表达式  323 4 5 * + 6 -
        System.out.println(InfixToSuffix("1 + ( ( 2 + 3 ) * 4 ) - 5 "));//1 2 3 + 4 * + 5 -
        System.out.println(InfixToSuffix("1 - 2 + 3 * 4"));//1 2 - 3 4 * +
        System.out.println(toListString("12-2+3*4")); //[1, -, 2, +, 3, *, 4]
        System.out.println(getListString("12 - 2 + 3 * 4")); //[1, -, 2, +, 3, *, 4]
        System.out.println(InfixToSuffix("12-2+3*4"));//1 2 - 3 4 * +
    }

    //中缀表达式转后缀表达式
    public static String InfixToSuffix(String InfixExpression) {
        //运算符栈和中间结果栈
        Stack<String> priorityStack = new Stack<>();
        //Stack<String> resultStack = new Stack<>();
        List<String> resultStack = new ArrayList<>();//resultStack没有用过到pop可以用List<String>,这样子方便后面的遍历
        List<String> infixList = toListString(InfixExpression);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < infixList.size(); i++) {
            if (infixList.get(i).equals(" ")) {
                continue;
            }
            if (infixList.get(i).matches("\\d+")) {
                resultStack.add(infixList.get(i));
            } else {
                while (true) {
                    if (priorityStack.size() == 0 || priorityStack.peek().equals("(") || infixList.get(i).equals("(")) {
                        priorityStack.push(infixList.get(i));
                        break;
                    } else if (priority(priorityStack.peek()) < priority(infixList.get(i))) {
                        priorityStack.push(infixList.get(i));
                        break;
                    } else if (infixList.get(i).equals(")")) {
                        while (true) {
                            if (priorityStack.peek().equals("(")) {
                                infixList.remove(i);
                                priorityStack.pop();
                                break;
                            } else {
                                resultStack.add(priorityStack.pop());
                            }
                        }
                    } else {
                        resultStack.add(priorityStack.pop());
                    }
                }
            }
        }
        while (priorityStack.size() > 0) {
            resultStack.add(priorityStack.pop());
        }
        for (int i = 0; i < resultStack.size(); i++) {
            stringBuffer.append(resultStack.get(i) + " ");
        }
        return stringBuffer.toString();
    }

    //把suffixExpression用split(" ")再换成ArrayList后用(正则匹配数)用Stack(栈)操作;
    public static int newMethod(String suffixExpression) {
        List<String> listString = getListString(suffixExpression);
        return calculate(listString);
    }

    //不需要带上空格
    public static List<String> toListString(String suffixExpression) {
        List<String> list = new ArrayList<>();
        int index = 0;
        String str = "";
        char c;
        while (index < suffixExpression.length()) {
            if ((c = suffixExpression.charAt(index)) < 48 || (c = suffixExpression.charAt(index)) > 57) {
                list.add(c + "");
                index++;
            } else {
                str = "";
                while (index < suffixExpression.length() && (c = suffixExpression.charAt(index)) >= 48 && (c = suffixExpression.charAt(index)) <= 57) {
                    str += c;
                    index++;
                }
                list.add(str);
            }
        }
        return list;
    }

    //需要带上空格
    public static List<String> getListString(String suffixExpression) {
        String[] s = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        //Collections.addAll(list, s);代替下面代码
        for (String element : s) {
            list.add(element);
        }
        return list;
    }

    public static int calculate(List<String> list) {
        //创建栈,只要一个
        Stack<String> stack = new Stack<>();
        for (String string : list) {
            //用正则来判断是否是数
            if (string.matches("\\d+")) {
                stack.push(string);
            } else {
                int pop2 = Integer.parseInt(stack.pop()); //顶元素
                int pop1 = Integer.parseInt(stack.pop()); //次顶元素
                int result = 0;
                if (string.equals("+")) {
                    result = pop1 + pop2;
                } else if (string.equals("-")) {
                    result = pop1 - pop2;
                } else if (string.equals("*")) {
                    result = pop1 * pop2;
                } else if (string.equals("/")) {
                    result = pop1 / pop2;
                } else {
                    throw new RuntimeException("请输入正确的运算符");
                }
                stack.push("" + result);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //返回运算符的优先级,数字越大优先级越高
    public static int priority(String o) {
        o = o.trim();
        if (o.equals("*") || o.equals("/")) {
            return 1;
        } else if (o.equals("+") || o.equals("-")) {
            return 0;
        } else {
            return -1;  //有问题运算符优先级为-1
        }
    }

    //传统方法(未解决多位数)
    public static int traditionalMethod(String suffixExpression) {
        //数栈
        ArraySymbolStack numberStack = new ArraySymbolStack(2);
        for (int i = 0; i < suffixExpression.length(); i++) {
            char c = suffixExpression.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (numberStack.isPriority(c)) {
                int pop1 = numberStack.pop();  //顶元素
                int pop2 = numberStack.pop();  //次顶元素
                numberStack.push(numberStack.cal(pop2, pop1, c));
            } else {
                numberStack.push(c - 48);
            }
        }
        return numberStack.pop();
    }
}