package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.User;

// 서비스 목록
public interface UserService {

    // 유저 로그인
    User getUserById(String userId);

    // 로그인한 유저 정보 가져오기
    User loginUser(String userId, String userPassword);

}
