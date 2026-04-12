package com.likelion.likelionassignmentcrud.common.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {


    @Bean
    public OpenAPI swaggerConfig() {

        Info info = new Info()
                .title("국가 대전쟁")
                .description("description : 나라를 고르고 직업을 정해 다른 나라와 사우는 국가 대전쟁 게임입니다.")
                .version("1.0");


        // 서버 정보
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Development Server");


        // 4SecurityScheme (Bearer JWT)
        Components components = new Components()
                .addSecuritySchemes("bearer-key", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"));

        // SecurityRequirement (Bearer 적용)
        SecurityRequirement securityRequirement = new SecurityRequirement()
                .addList("bearer-key"); // scheme 이름과 일치해야 함

        // OpenAPI 최종 반환
        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer))
                .components(components)
                .addSecurityItem(securityRequirement);


    }

}
