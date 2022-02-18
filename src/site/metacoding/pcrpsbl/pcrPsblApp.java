package site.metacoding.pcrpsbl;

import java.util.Scanner;

public class pcrPsblApp {
    public static void main(String[] args) {
        String sidoCdNm;
        String sgguCdNm;

        Scanner sc = new Scanner(System.in);
        selectDB select = new selectDB();
        // new insertDB().insertData();

        System.out.println("검색 가능한 시도를 검색중입니다.");
        System.out.println("");
        select.selectSido();
        System.out.print("시도명을 입력하세요 : ");
        sidoCdNm = sc.nextLine();

        System.out.println("");
        select.selectSggu(sidoCdNm);
        System.out.print("시군구명을 입력하세요 : ");
        sgguCdNm = sc.nextLine();

        select.selectHospital(sidoCdNm, sgguCdNm);

    }
}
