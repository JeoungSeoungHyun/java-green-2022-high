package site.metacoding.pcrpsbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class insertDB {

    private List<hospital> hospitals = getHsopitals.get();
    // System.out.println("Dto다운 병원 개수 :" + hospitals.size());

    public void insertData() {
        int result = 0;

        try {

            // 1. connection 연결 (세션생성) port,ip,id,password,protocol
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
            System.out.println("DB 연결완료");

            // 2. 버퍼 달아서 통신(프로토콜에 맞게->라이브러리가 해줌)
            String sql = "INSERT INTO HOSPITAL(addr,mgtStaDd,pcrPsblYn,ratPsblYn,recuClCd,rprtWorpClicFndtTgtYn,sgguCdNm,sidoCdNm,telno,XPos,XPosWgs84,YPos,YPosWgs84,yadmNm,ykihoEnc) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            for (int i = 0; i < hospitals.size(); i++) {

                pstmt.setString(1, hospitals.get(i).getAddr());
                pstmt.setString(2, hospitals.get(i).getMgtStaDd());
                pstmt.setString(3, hospitals.get(i).getPcrPsblYn());
                pstmt.setString(4, hospitals.get(i).getRatPsblYn());
                pstmt.setString(5, hospitals.get(i).getRecuClCd());
                pstmt.setString(6, hospitals.get(i).getRprtWorpClicFndtTgtYn());
                pstmt.setString(7, hospitals.get(i).getSgguCdNm());
                pstmt.setString(8, hospitals.get(i).getSidoCdNm());
                pstmt.setString(9, hospitals.get(i).getTelno());
                pstmt.setString(10, hospitals.get(i).getXPos());
                pstmt.setString(11, hospitals.get(i).getXPosWgs84());
                pstmt.setString(12, hospitals.get(i).getYPos());
                pstmt.setString(13, hospitals.get(i).getYPosWgs84());
                pstmt.setString(14, hospitals.get(i).getYadmNm());
                pstmt.setString(15, hospitals.get(i).getYkihoEnc());

                result = result + pstmt.executeUpdate(); // INSERT,UPDATE,DELETE시 사용
            }

            // System.out.println("DB INSERT 개수 :" + result);

        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }

}
