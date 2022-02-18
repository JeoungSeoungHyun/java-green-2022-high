package site.metacoding.pcrpsbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class selectDB {

    public void selectSido() {
        try {

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
            // System.out.println("DB 연결완료");

            String sql = "SELECT distinct sidoCdNm FROM HOSPITAL";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("=======================<가능한 시도>=============================");
            while (rs.next()) {
                System.out.print(rs.getString("sidoCdNm") + " ,");
            }
            System.out.println("");
            System.out.println("=================================================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectSggu(String sidoCdNm) {
        try {

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
            // System.out.println("DB 연결완료");

            String sql = "SELECT distinct sgguCdNm FROM HOSPITAL WHERE sidoCdNm = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, sidoCdNm);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("====================<가능한 시군구>=============================");
            while (rs.next()) {
                System.out.print(rs.getString("sgguCdNm") + " ,");
            }
            System.out.println("");
            System.out.println("================================================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectHospital(String sidoCdNm, String sgguCdNm) {
        try {

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
            // System.out.println("DB 연결완료");

            String sql = "SELECT addr,yadmNm FROM HOSPITAL WHERE sidoCdNm = ? AND sgguCdNm = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, sidoCdNm);
            pstmt.setString(2, sgguCdNm);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("================================================================");
            while (rs.next()) {
                System.out.println("이름 : " + rs.getString("yadmNm"));
                System.out.println("주소 : " + rs.getString("addr"));
                System.out.println("-------------------------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
