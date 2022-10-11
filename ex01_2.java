package PD.WEEK1;

import java.util.Scanner;

public class ex01_2 {
    public static void main(String[] args) {
        int flag = 0;
        while (true){
            //获取会员号
            Scanner user_input = new Scanner(System.in);
            System.out.println("请输入你的会员号(六位)");
            String vip_id = user_input.next();
            //检测是否为六位数字 ---> onlyNum方法
            while (onlyNum(vip_id)){
                //生成整型的随机数，范围时0~99
                int price_num = (int)(Math.random()*100);
                //处理当随机出1，2，3，4等个位数时，无法形成两位数
                String price_str = Integer.toString(price_num);
                if (price_num <= 9 && price_num >= 0){
                    String str = "0%s";
                    String format = String.format(str,price_num);
                    price_str = format;
                }
                System.out.println("中奖码为" + price_str);
                //获取中奖码的十位和个位
                char font = price_str.charAt(0);
                char back = price_str.charAt(1);
                //获取会员号的第2位和第3位
                char sec = vip_id.charAt(1);
                char thr = vip_id.charAt(2);
                //判断获得奖项
                if (sec+thr == font+back){
                    System.out.println("一等奖");
                } else if (sec+thr == back+font) {
                    System.out.println("二等奖");
                } else if (sec == back || thr == back || sec ==font || thr == font) {
                    System.out.println("三等奖");
                } else {
                    System.out.println("下次一定");
                }
                System.out.println("===================\n");
                flag += 1;
                break;
            }
            //输入一次成功后，结束程序
            if (flag == 1){
                break;
            }
        }
    }



    public static boolean onlyNum(String str){
        //判断用户输入的会员号是否合法
        char str_num[] = str.toCharArray();
        //判断是不是六位
        if (str_num.length != 6){
            System.out.println("非法输入，输入的位数不是六位");
            return false;
        }
        //判断是不是纯数字
        for(int i = 0;i <= str_num.length-1;i++){
            char ch_str = str.charAt(i);
            if (ch_str < 48 || ch_str > 57){
                System.out.println("非法输入，输入的内容不是纯数字");
                return false;
            }
        }
        return true;


    }
}
