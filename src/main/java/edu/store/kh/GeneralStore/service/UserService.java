package edu.store.kh.GeneralStore.service;

import edu.store.kh.GeneralStore.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface UserService {
    // 유저 로그인 유저 정보를 가져올 것
    User findUserId(@Param("userId") String userId);

    User loginUser(@Param("userId")String userId,
                   @Param("userPassword")String password);
    /*
    만약에 값이 달라서 발생하는 오류라며 아래와 같은 명칭 변경 요청
    컬럼명     /    변수명 /  파        라      미  터  명 칭   /    name에 작성한 변수 이름 이나 상태 관리 명칭
    SQL 컬럼명 -> DTO -> Mapper -> ServiceImpl -> Controller => html or javascript
    에서 명칭이 다른 것끼리 전달하려 하지 않았는지 확인
      User findUserId(@Param("userID")String userId);
    User loginUser(@Param("userID")String userId,@Param("password")String password);
    */
}
