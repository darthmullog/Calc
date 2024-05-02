import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите арифметическое выражение");
        System.out.println("ВАЖНО: ПОСЛЕ КАЖДОГО ЧИСЛА ИЛИ АРИФМЕТИЧЕСКОГО ДЕЙСТВИЯ НЕОБХОДИМ ПРОБЕЛ, например [2 + 2](это указано в требовании к калькулятору и в примерах рассчётов)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char pl = '+';
        char mi = '-';
        char um = '*';
        char de = '/';
        int count = 0;
        for (int i=0;i<input.length();i++){
            if (input.charAt(i)==pl||input.charAt(i)==mi||input.charAt(i)==um||input.charAt(i)==de){
                count++;
            }
        }if (count>1){
            try {
                throw new Exception("не более одного арифметического действия!");
            }catch (Exception d){
                throw new RuntimeException(d);
            }
        }
        String[] parts = input.split(" ");
        String per = parts[0];
        if (Objects.equals(per, "1") ||Objects.equals(per, "2") ||Objects.equals(per, "3") ||Objects.equals(per, "4") ||Objects.equals(per, "5") ||Objects.equals(per, "6") ||Objects.equals(per, "7") ||Objects.equals(per, "8") ||Objects.equals(per, "9") ||Objects.equals(per, "10")){
            int a = Integer.parseInt(parts[0]);
            String op = parts[1];
            int b = Integer.parseInt(parts[2]);
            if (a>10 || a<1|| b>10|| b<1){
                try {
                    throw new Exception("можно вводить лишь числа от 1 до 10 (от I до Х)");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else  System.out.println("Результат = " + operation(a, b, op));
        }else {
            //String ra = per;
            String op = parts[1];
            String rb = parts[2];
            //System.out.println(ra);
            //System.out.println(op);
            //System.out.println(rb);
            int a = romanToInt(per);
            int b = romanToInt(rb);
            int ans = operation(a, b, op);
            int hundreds = ans / 100;
            //System.out.println("сотен " + hundreds);
            int tens = (ans - (100 * hundreds)) / 10;
            //System.out.println("десятков " + tens);
            int units = ans - (100 * hundreds) - (10 * tens);
            //System.out.println("единиц " + units);
            String s1 = "";
            String s2 = "";
            String s3 = "";
            if (a>10 || a<1|| b>10|| b<1){
                try {
                    throw new Exception("можно вводить лишь числа от 1 до 10 (от I до Х)");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }//else  System.out.println("Результат = " + operation(a, b, op));
            if (ans<1) {
                try {
                    throw new Exception("в римских числах нет отрицательных и ноля");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            switch (hundreds) {
                case 1:
                    s1 = "C";
                    break;
                case 0:
                    s1 = "";
            }
            switch (tens) {
                case 1:
                    s2 = "X";
                    break;
                case 2:
                    s2 = "XX";
                    break;
                case 3:
                    s2 = "XXX";
                    break;
                case 4:
                    s2 = "XL";
                    break;
                case 5:
                    s2 = "L";
                    break;
                case 6:
                    s2 = "LX";
                    break;
                case 7:
                    s2 = "LXX";
                    break;
                case 8:
                    s2 = "LXXX";
                    break;
                case 9:
                    s2 = "XC";
                    break;
                case 0:
                    s2 = "";
            }
            switch (units) {
                case 1:
                    s3 = "I";
                    break;
                case 2:
                    s3 = "II";
                    break;
                case 3:
                    s3 = "III";
                    break;
                case 4:
                    s3 = "IV";
                    break;
                case 5:
                    s3 = "V";
                    break;
                case 6:
                    s3 = "VI";
                    break;
                case 7:
                    s3 = "VII";
                    break;
                case 8:
                    s3 = "VIII";
                    break;
                case 9:
                    s3 = "IX";
                    break;
                case 0:
                    s3 = "";
            }
            System.out.println("результат=" + s1 + s2 + s3);}
    }
    private static int operation(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                System.out.println("недопустимая операция");
                return 0;
        }
    }
    private static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        int result = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curValue = map.get(s.charAt(i));
            if (curValue >= prevValue) {
                result += curValue;
            } else {
                result -= curValue;
            }
            prevValue = curValue;
        }
        return result;
    }
}

