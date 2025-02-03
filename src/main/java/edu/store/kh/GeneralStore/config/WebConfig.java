package edu.store.kh.GeneralStore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 웹 관련 설정 Springboot 프로젝트가 컴퓨터에 직접적으로 접근할 수 있도록 설정
public class WebConfig  implements WebMvcConfigurer {
    @Value("${upload-img}")
    private String uploadImg;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       // resource 경로에 저장된 파일을 직접적으로 접근
        registry.addResourceHandler("/images/**") // 외부에서 보여질 이미지 경로
                .addResourceLocations("file:"+uploadImg); // 실제 저장되는 이미지 경로
        // 여러 경로 설정시 .addResourceLocations(); 내부에 ,로 구분
    }
}
