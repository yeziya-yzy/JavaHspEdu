package com.datastructure.stack;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/12
 * 计算器
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "70+2*6-4";//计算表达式
        //数栈和符号栈
        ArraySymbolStack numberStack = new ArraySymbolStack(10);
        ArraySymbolStack operaStack = new ArraySymbolStack(10);
        int index = 0;//定义扫描索引
        int num1 = 0; //左值
        int num2 = 0; //右值
        int o = 0;   //运算符
        int result = 0;
        String keepNumber = "";  //用于拼接多位数
        char ch = ' '; //将每次扫描得到的char保存到ch中
        //开始循环扫描
        while (true) {
            //得到每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断
            if (operaStack.isPriority(ch)) {   //运算符
                if (!operaStack.isEmpty()) {  //不空
                    if (operaStack.priority(ch) <= operaStack.priority(operaStack.look())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        o = operaStack.pop();
                        //这里要相反
                        numberStack.push(numberStack.cal(num2, num1, o));
                        operaStack.push(ch); //当前符号放入符号栈
                    } else {
                        operaStack.push(ch); //当前符号放入符号栈
                    }
                } else {
                    //空
                    operaStack.push(ch);
                }
            } else {
                keepNumber += ch;
                //最后一位或者下一位是符号位或者已经到了最后一位
                if (index == expression.length() - 1 || operaStack.isPriority(expression.substring(index + 1, index + 2).charAt(0))) {
                    numberStack.push(Integer.parseInt(keepNumber)); //入数栈  把ASCII码减去
                    keepNumber = "";
                }
            }
            //index后移,并判断是否结束
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        while (!operaStack.isEmpty()) {
            //符号栈为空
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            o = operaStack.pop();
            //这里要相反
            numberStack.push(numberStack.cal(num2, num1, o));
        }
        System.out.printf("表达式%s的值为%d", expression, numberStack.pop());
    }
}

/**
 * 定义一个类ArraySymbolStack表示栈
 */
class ArraySymbolStack {
    private final int maxSize;//栈的最大值
    private final int[] stack;//数组模拟栈,数据就放在该数组中
    private int top = -1;

    //构造器
    public ArraySymbolStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //返回栈顶的值,但是不弹出
    public int look() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈已经满了");
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    //显示栈的情况[遍历]
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        //遍历是从上往下的
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级,数字越大优先级越高
    public int priority(int o) {
        if (o == '*' || o == '/') {
            return 1;
        } else if (o == '+' || o == '-') {
            return 0;
        } else {
            return -1;  //有问题运算符优先级为-1
        }
    }

    //判断是否是一个运算符
    public boolean isPriority(char o) {
        return o == '+' || o == '-' || o == '*' || o == '/';
    }

    //运算方法
    public int cal(int left, int right, int o) {
        if (o == '+') {
            return left + right;
        } else if (o == '-') {
            return left - right;
        } else if (o == '*') {
            return left * right;
        } else if (o == '/') {
            return left / right;
        } else {
            throw new RuntimeException("运算符输入错误");
        }

    }
}

