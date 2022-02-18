package site.metacoding.pcrpsbl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import site.metacoding.pcrpsbl.pcrPsblDto.Response.Body.Items.Item;

public class dtoDownload {

    public static List<Item> getDto() {

        List<Item> result = new ArrayList<>();

        try {
            URL url = new URL(
                    "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?serviceKey=LIqv%2F8heOoyddG4p%2FF8IZOXKJ5BKYBrTStXTKwrDT4%2BIB1fxJFKf8vPU4CUdID94Ctqlk3a6MMNlwAKC%2BASMHA%3D%3D&pageNo=1&numOfRows=10&_type=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));

            String responseJson = br.readLine();

            Gson gson = new Gson();

            pcrPsblDto dto = gson.fromJson(responseJson, pcrPsblDto.class);

            int totalCount = dto.getResponse().getBody().getTotalCount();

            URL url2 = new URL(
                    "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?serviceKey=LIqv%2F8heOoyddG4p%2FF8IZOXKJ5BKYBrTStXTKwrDT4%2BIB1fxJFKf8vPU4CUdID94Ctqlk3a6MMNlwAKC%2BASMHA%3D%3D&pageNo=1&numOfRows="
                            + totalCount + "&_type=json");
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();

            BufferedReader br2 = new BufferedReader(
                    new InputStreamReader(conn2.getInputStream(), "utf-8"));

            String responseJson2 = br2.readLine();

            pcrPsblDto dto2 = gson.fromJson(responseJson2, pcrPsblDto.class);
            result = dto2.getResponse().getBody().getItems().getItem();
            // System.out.println(dto.toString());

        } catch (Exception e) {
            System.out.println("오류가 발생하였습니다 : " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}