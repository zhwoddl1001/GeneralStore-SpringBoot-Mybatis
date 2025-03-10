package kh.edu.react.provider.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AirQualityService {

    // 요청주소 http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth
    private final String API_AIR_URL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
    /*
     private final String API_AIR_URL = 상수 처리한 명칭
     상수 = 상시적으로 일정한 값을 유지하는 명칭
     변수와 다르게 최초 1회 작성한 값으로 유지되며 추후에 명칭 내에 들어있는 값을 변경할 수 없음
     ↓ 아래와 같이 URL 주소 변경을 작성하면 에러 발생
     API_AIR_URL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc";
     */
    // 일반 인증키 (Encoding)
    // RlrMNFCsyGmkQQqIJ9pI5aDYSEh5TrqYUKrRtPBOysCzwa%2FrmgSlGQbRZp4%2FHpyw0k4Z2QACgWDBUzeCJqUJZw%3D%3D
    private final String SERVICE_KEY = "\t\n" +
            "ZvzYbu5pEV3ZVKFB7TjJ7TZwFAGAQNXyGSuFmOoLVUpGrKpXMnyvjR8Y4T%2B1vh8J6f80S6nTUCI%2Fh7Zq7e5Z4g%3D%3D";

    public String getAirQuality(String searchDate) {
        // RestTemplate HTTP 요청을 보낼 때 사용
        // RESTful API 통신할 때 사용
        // GET POST PUT DELETE 등의 HTTP 메서드를 사용할 수 있음
        // JSON, XML 데이터 받을 수 있음
        RestTemplate restTemplate = new RestTemplate();

        // UriComponentsBuilder
        // URI = URL 과 URN을 포함하는 개념
        // 주소로 자주 부르는 URL 은 URI 의 한 종류
        /*
        *           URI = URN URL
        * ┌──────────┴───────────┐
        * URN                    URL
        *  번호                    번호에 대한 모든 정보
        * 위치종류가 없는          위치 주소를 나타냄
        * 고유한 이름              어디서 어떤 정보가 사용자들이 볼 수 있도록
        * 책이름, 코드번호          전달되는지
        * 와 같이 이름만 존재        정보가 전달되고ㅡ 전달하는 위치가 어디인지
        *
        * 예) 배달서비스 http://baedal.com/
        *
        * URI  =  http://baedal.com/order/ABC고객/12345    12345 주문을 식별하는 고유 식별자
        *         배달/주문/ABC고객/12345                    ->12345 번으로 고객이 주문
        * URL = http://baedal.com/store/77/menu    가게에서 77번 음식점의 메뉴를 가져오는 위치
        *       77번 가게에서 메뉴를 모두 가져오는 것
        * URN   order:12345                         주문번호 12345를 나타내는 주문 번호
         *      몇 번 주문오더 주문번호만 확인
         *
         * Component

            Builder

            queryParam = url api endpoint 주소 ?key=value 설정
         *
         *  */
        String apiURl = UriComponentsBuilder.fromHttpUrl(API_AIR_URL)
                .queryParam("serviceKey",SERVICE_KEY)
                .queryParam("returnType","json")
                .queryParam("searchDate",searchDate)
                .queryParam("numOfRows",10)
                .queryParam("pageNo",1)
                .toUriString();

        ResponseEntity<String> response = restTemplate.getForEntity(apiURl, String.class);
        return response.getBody();

    }
}