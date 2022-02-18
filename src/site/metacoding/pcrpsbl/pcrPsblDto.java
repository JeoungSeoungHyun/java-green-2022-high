package site.metacoding.pcrpsbl;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class pcrPsblDto {
    private Response response;

    @Data
    @AllArgsConstructor
    class Response {

        private Header headr;
        private Body body;

        @Data
        @AllArgsConstructor
        class Header {

            private String resultCode;
            private String resultMsg;
        }

        @Data
        @AllArgsConstructor
        class Body {

            private Items items;
            private int numOfRows;
            private int pageNo;
            private int totalCount;

            @Data
            @AllArgsConstructor
            class Items {
                private List<Item> item;

                @Data
                @AllArgsConstructor
                class Item {
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
            }
        }
    }

}
