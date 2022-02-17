package StudyNotes.hspStudy.project.HouseRent.View;

import StudyNotes.hspStudy.project.HouseRent.Service.HouseService;
import StudyNotes.hspStudy.project.HouseRent.Utils.Utility;
import StudyNotes.hspStudy.project.HouseRent.domain.House;

import java.util.Scanner;

/**
 * 1.显示界面
 * 2.接收用户输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接收用户选择
    Scanner scanner = new Scanner(System.in);
    private HouseService houseService = new HouseService(10);

    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("============房屋出租菜单===========");
            System.out.println(
                    "\t\t\t1.新增房源\n" +
                            "\t\t\t2.查找房屋\n" +
                            "\t\t\t3.删除房屋信息\n" +
                            "\t\t\t4.修改房屋信息\n" +
                            "\t\t\t5.房屋列表\n" +
                            "\t\t\t6.退出"
            );
            System.out.print("请输入你的选择(1-6)");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    System.out.println("1.新增房源");
                    break;
                case '2':
                    System.out.println("2.查找房屋");
                    break;
                case '3':
                    System.out.println("3.删除房屋信息");
                    break;
                case '4':
                    System.out.println("4.修改房屋信息");
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    System.out.println("6.退出");
                    loop = false;
                    break;
                default:
                    System.out.println("输入信息有误");
            }
        }
        while (loop);
    }

    public void listHouse() {
        System.out.println("============房屋信息===========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] HouseArr = houseService.list();
        for (int i = 0; i < HouseArr.length; i++) {
            if (HouseArr[i] == null) {
                break;
            }
            System.out.println(HouseArr[i]);
        }
        System.out.println("============房屋列表完成===========\n");
    }

    public void addHouse() {
        System.out.println("============添加房屋===========");
        System.out.println("编号");
        System.out.println("房主");
        String name = Utility.readString(8);
        System.out.println("电话");
        String phone = Utility.readString(12);
        System.out.println("地址");
        String address = Utility.readString(12);
        System.out.println("月租");
        int rent = Utility.readInt();
        System.out.println("状态(未出租/已出租)");
        String state = Utility.readString(3);
        House house = new House(0,name,phone,address,rent,state);
    }
}