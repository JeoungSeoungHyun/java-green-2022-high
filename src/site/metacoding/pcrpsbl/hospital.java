package site.metacoding.pcrpsbl;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class hospital {
    private String addr;
    private String mgtStaDd;
    private String pcrPsblYn;
    private String ratPsblYn;
    private String recuClCd;
    private String rprtWorpClicFndtTgtYn;
    private String sgguCdNm;
    private String sidoCdNm;
    private String telno;
    private String XPos;
    private String XPosWgs84;
    private String YPos;
    private String YPosWgs84;
    private String yadmNm;
    private String ykihoEnc;
}
