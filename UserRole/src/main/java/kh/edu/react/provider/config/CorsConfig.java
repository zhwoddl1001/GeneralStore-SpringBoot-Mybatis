package kh.edu.react.provider.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // registry.addMapping("/**")  -> 3000 port 에서 요청하는 모든 url api 허용
                registry.addMapping("/api/**") // 3000 port 에서 /api/ 라는 주소 명칭으로 시작하는 url api 요청 허용
                       // .allowedOrigins("http://localhost:3000","http://localhost:3001") // react 서버 3000 ~ 3001 포트에서 SpringBoot 접속 허용
                        .allowedOrigins("http://localhost:3000") // react 서버 3000 포트에서 SpringBoot 접속 허용
                        .allowCredentials(true)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*"); //
            }
        };
    }
}
