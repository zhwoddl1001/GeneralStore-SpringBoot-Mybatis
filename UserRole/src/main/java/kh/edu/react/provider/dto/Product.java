package kh.edu.react.provider.dto;

import lombok.*;

import java.time.LocalDateTime;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private int productPrice;
    private String productCategory;
    private int productStock;
    private String productImageUrl;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    // 부분적으로 커스텀이 필요하거나 필수 작성해야하는 필드명 / 필수로 넣어도 되지 않는 필드명
    // 구분지어 사용하는 생성자

    // 하지만 기본생성자랑 전체 파라미터를 작성하는 생성자만으로도 충분히 코딩
}
