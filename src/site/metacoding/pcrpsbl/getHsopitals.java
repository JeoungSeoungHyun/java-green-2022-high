package site.metacoding.pcrpsbl;

import java.util.ArrayList;
import java.util.List;

import site.metacoding.pcrpsbl.pcrPsblDto.Response.Body.Items.Item;

public class getHsopitals {

    public static List<hospital> get() {

        List<Item> result = dtoDownload.getDto();
        List<hospital> hospitals = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            hospital h = new hospital(
                    result.get(i).getAddr(),
                    result.get(i).getMgtStaDd(),
                    result.get(i).getPcrPsblYn(),
                    result.get(i).getRatPsblYn(),
                    result.get(i).getRecuClCd(),
                    result.get(i).getRprtWorpClicFndtTgtYn(),
                    result.get(i).getSgguCdNm(),
                    result.get(i).getSidoCdNm(),
                    result.get(i).getTelno(),
                    result.get(i).getXPos(),
                    result.get(i).getXPosWgs84(),
                    result.get(i).getYPos(),
                    result.get(i).getYPosWgs84(),
                    result.get(i).getYadmNm(),
                    result.get(i).getYkihoEnc());

            hospitals.add(h);
        }
        return hospitals;
    }
}
