package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.Product;

import java.util.List;

public interface ProductService {
// 모든 제품 조회
/* public 사용 X */ List<Product> findAllProducts();


// 제품 검색 (상품명 또는 카테고리)
/* public 사용 X */ List<Product> searchProducts(String keyword);

// 특정 제품 상세 조회(ID 기반으로 검색)
//               자료형 단일 제품만 조회하기 때문에 Product
/* public 사용 X */ Product findProductById(int productId);


// 제품 저장
// 자료형 두가지를 제안 -> void, int -> 자료형을 통해 마지막에 데이터가 들어간 갯수를 확인 int
//                                   자료형을 통해 return 을 사용해서 확인 X void
/* public 사용 X */ void saveProduct(Product product);
}
