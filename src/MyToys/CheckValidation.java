/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyToys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author QUANG HUY
 */
public class CheckValidation {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String message, String chui) {
        int a;
        while (true) {
            try {
                System.out.print(message);
                a = Integer.parseInt(sc.nextLine());
                if (a < 0) {
                    throw new Exception();
                }
                return a;
            } catch (Exception e) {
                System.out.println(chui);
            }
        }
    }

    //check số có khoảng min-max
    public static int inputInt(String msg, int min, int max, String chui) {
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }
        int data;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
                if (data >= min && data <= max) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(chui);
            }

        } while (true);
        return data;
    }

    //get an String with no condition
    public static String getAnString(String message, String chui) {
        String a;
        while (true) {
            try {
                System.out.print(message);
                a = sc.nextLine();
                if (a.equals("")) {
                    throw new Exception();
                }
                return a;
            } catch (Exception e) {
                System.out.println(chui);
            }
        }
    }

    //get an non blank String
    public static String inputNonBlankStr(String msg, String chui) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (data.length() == 0);
        return data;
    }

    public static String inputPattern(String msg, String pattern, String chui) {
        String data = null;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
            try {
                if (!data.matches(pattern)) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(chui);
            }

        } while (true);
        return data;
    }
    public static String CheckTime(String msg,String time) {
        boolean check = true;
        Date now;
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        d.setLenient(false);
        do {
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print(msg);
                    time = sc.nextLine();
                    if (!time.matches("^\\d{1,2}[/]\\d{1,2}[/]\\d{4}$")) {
                        throw new Exception();
                    }
                    check = false;
                } catch (Exception e) {
                    System.err.println("Invalid Time!(DD/MM/YYYY)");
                }
            } while (check);
            try {
                now = d.parse(time);
                check = false;
            } catch (ParseException e) {
                System.err.println("Invalid Time!(The Input'Data not suitable!) ");;
                check = true;
            }
        } while (check);

        return time;
    }
}
