package com.sky.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;


@Configuration
@Profile({"dev","test"})        // 避免生产环境暴露API文档
public class SwaggerOpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        // =====安全方案======
        // TODO
        
        // =====正常配置=====
        // 联系人信息(contact)
        Contact contact = new Contact()
                .name("神秘魔女伊蕾娜")
                // .url(null)
                .email("377877931@qq.com");
        // // 授权许可信息(license)
        // License license = new License()
        //         .name("Apache 2.0") // 授权名称
        //         .url("https://www.apache.org/licenses/LICENSE-2.0.html")    // 授权信息
        //         .identifier("Apache-2.0");   // 授权标识
        // 文档描述信息(info)
        Info info = new Info()
                .title("苍穹外卖API文档")
                .description("基于SpringBoot + Swagger3接口文档")
                .version("1.0.0")
                .contact(contact);   // 设置联系人信息
                // .license(license);   // 设置许可信息
        // 返回OpenAPI对象
        return new OpenAPI()
                .info(info);
    }   

}
