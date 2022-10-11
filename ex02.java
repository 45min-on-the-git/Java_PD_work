package PD.WEEK1;

import java.util.Scanner;

public class ex02 {
    /*
    编写程序，要求用户输入会员的生日和会员的E-mail，验证用户输入的生日和E-mail是否合法。会员生日的形式必须是“年/月/日”的格式，
    年需要在“1900-2022”之间，月份在0-12之间，日在0-31之间，需要根据年和月来确定日。比如2月份闰年的日，在0-29之间。
    E-mail必须有“@”和“.”，并且“.”在“@”后面。
     */
    public static void main(String[] args) {
        int flag = 0;
        while (true){
            //获取生日和邮箱
            Scanner user_input = new Scanner(System.in);
            System.out.println("请输入你的生日，格式：年/月/日");
            String birth = user_input.next();
            System.out.println("请输入你的邮箱");
            String email = user_input.next();
            //检测生日和邮箱是否符合规范
            while (legal(birth,email)){
                flag += 1;
                break;
            }
            if (flag == 1){
                break;
            }
        }
        

    }

    public static boolean legal(String birth,String email) {
        int years = 0;
        int month = 0;
        int day = 0;
        char[] birth_array = birth.toCharArray();
        int font_gang = birth.indexOf('/');
        int back_gang = birth.lastIndexOf('/');

        //判断有没有反斜杠
        if (font_gang == back_gang) {
            System.out.println("非法参数，年月日之间未用 “/” 隔开");
            return false;
        } else {
            //若格式输入均无误，则记下年月日
            years = Integer.parseInt(birth.substring(0, 4));
            month = Integer.parseInt(birth.substring(font_gang + 1, back_gang));
            day = Integer.parseInt(birth.substring(back_gang + 1));
        }

        //判断年月日
        if (years < 1900 || years > 2022) {
            System.out.println("非法参数，年份不在1900~2022之间");
            return false;
        }
        if (month < 1 || month > 12) {
            System.out.println("非法参数，月份不在1~12之间");
            return false;
        }
        if (findday(years, month, day)) {
            System.out.println("非法参数，日期输入错误");
            return false;
        }
        System.out.println("日期录入完毕");

        //检查email
        int at = email.indexOf('@');
        int doc = email.indexOf('.');

        if (at > doc){
            System.out.println("非法参数，邮箱输入错误");
            return false;
        } else if (at == -1 || doc == -1) {
            System.out.println("非法参数，邮箱输入错误");
            return false;
        }
        System.out.println("邮箱录入完毕");
        return true;



    }
    public static boolean findday(int years,int month,int day){
        //判断日期的输入是否正确
        //若日期错误，则返回true
        int feb = 28;
        if ((years%4 == 0 && years%100 != 0) || years%400 == 0) {
            feb = 29;
        }
        switch (month){
            case 1:
                if (day <= 31 || day >= 1){
                    return false;
                }
                break;
            case 2:
                if (day <= feb || day >= 1){
                    return false;
                }
                break;
            case 3:
                if (day <= 31 || day >= 1){
                    return false;
                }
                break;
            case 4:
                if (day <= 30 || day >= 1){
                    return false;
                }
                break;
            case 5:
                if (day <= 31 || day >= 1){
                    return false;
                }
                break;
            case 6:
                if (day <= 30 || day >= 1){
                    return false;
                }
                break;
            case 7:
                if (day <= 31 || day >= 1){
                    return false;
                }
                break;
            case 8:
                if (day <= 31 || day >= 1){
                    return false;
                }
                break;
            case 9:
                if (day <= 30 || day >= 1){
                    return false;
                }
                break;
            case 10:
                if (day <= 31 || day >= 1){
                    return false;
                }
                break;
            case 11:
                if (day <= 30 || day >= 1){
                    return false;
                }
                break;
            case 12:
                if (day <= 31 || day >= 1){
                    return false;
                }
                break;
        }
        return true;
    }
}

