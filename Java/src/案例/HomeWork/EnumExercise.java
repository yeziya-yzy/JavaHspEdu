package 案例.HomeWork;

/**
 -*- coding: utf-8 -*-
 * @version 1.0
 */
public class EnumExercise {
    public static void main(String[] args) {
        Week[] values = Week.values();
        for (Week  value : values){
            System.out.println(value);
        }
    }
}

enum Week {
    MONDAY("星期一"),TUSDAY("星期二"),THURSDAY("星期三");

    private Week(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}