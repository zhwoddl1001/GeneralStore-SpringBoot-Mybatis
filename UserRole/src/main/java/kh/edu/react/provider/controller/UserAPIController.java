package kh.edu.react.provider.controller;


import jakarta.servlet.http.HttpSession;
import kh.edu.react.provider.dto.User;
import kh.edu.react.provider.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
public class UserAPIController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user,
                                                     HttpSession session) {
        Map<String, Object> loginResult = userService.loginUser(user.getUserId(), user.getUserPassword());
        // 만약에 서비스에서 무사히 로그인한 결과를 가져왔다면
        if ("success".equals(loginResult.get("status"))) {
            User loggedInuser = (User) loginResult.get("user");
            session.setAttribute("user", loggedInuser); // 로그인한 유저 정보를 세션에 user 라는 명칭으로  저장
            return ResponseEntity.ok(loginResult);
            // ok = 200 = 리액트에서 전달받은 데이터 값이 존재할 때 뜨는 숫자
        } else { // 무사히 성공하지 못했다면
            return ResponseEntity.status(401).body(loginResult);
        }
    }
    //로그아웃
    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpSession session) {
        session.invalidate();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "logout");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/checkLogin")
    public ResponseEntity<?> checkLogin(HttpSession session) {
        User loginUser = (User) session.getAttribute("user");
        if (loginUser != null) {
            return ResponseEntity.ok(loginUser);
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "로그인 상태가 아닙니다."));
        }

    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") String userId) {
        User user = userService.getUserById(userId);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "로그인 상태가 아닙니다."));
        }
    }
}