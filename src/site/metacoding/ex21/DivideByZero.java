package site.metacoding.ex21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {

        // InputMismatchException

        // 통신, 사용자입력 예외처리!
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 계속 catch문을 타는 이유 스캐너에 버퍼가 비워지지 않은 상태로 다시 스캐너를 사용하려고 하니까 바로 catch문을 타는거야!
            // Scanner sc = new Scanner(System.in); 1번 while할때마다 스캐너를 new해줘서 스캐너를 비운다.
            // nextLine()을 사용하여 버퍼를 비워준다.
            sc.nextLine();
            try {
                System.out.println("숫자를 입력하세요");
                int x = sc.nextInt();
                int result = x / 0;
                System.out.println("받은 값 : " + x);

            } catch (InputMismatchException e) {
                System.out.println("==============");
                System.out.println("문자 넣지 마세요");
                System.out.println("==============");
                e.printStackTrace();
            } catch (ArithmeticException e) {
                System.out.println("==============");
                System.out.println("0 나누지마 좀");
                System.out.println("==============");
                e.printStackTrace();
            }
        }
    }
}
