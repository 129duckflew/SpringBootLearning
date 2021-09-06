package cn.duckflew.config;

import cn.duckflew.anno.MySwaggerAnnotation;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

@Configuration
public class SwaggerConfig
{

    /**
     *
     * 创建Docket类型对象  Docket是Swagger中的全局配置对象
     * @return
     */
    @Bean
    public Docket docket()
    {
       Docket docket=new Docket(DocumentationType.SWAGGER_2);
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        ApiInfo apiInfo = apiInfoBuilder.contact(
                /**
                 * 设置联系方式
                 */
                new Contact(
                        "开发文档测试",
                        "http://duckflew.cn",
                        "129duckflew@gmail.com")
                ).title("开发文档标题")
                .description("开发文档描述")
                .version("1.0.1")
                .build();
        docket.apiInfo(apiInfo);
        /**
         * 获取Docket中的选择器  范湖ApiSelectorBuilder  构造选择器 如：扫描什么包的注解
         */
        docket.select()
                /**
                 *  withMethodAnnotation加一个注解类表示 有这个注解的方法会返回真  在前面加一个not就是取反
                 *  所以这个语句的意思  有这个注解的  不显示这个方法的接口文档
                 */
                .apis(Predicates.not(withMethodAnnotation(MySwaggerAnnotation.class)))
                /**
                 * 设置扫描的包 这样可以让BasicController不显示文档
                 */
                .apis(RequestHandlerSelectors.basePackage("cn.duckflew.controller"))
                /**
                 * 使用正则表示生成Api文档的路径地址
                 */
//                .paths(PathSelectors.regex("/swagger/.*"))
                .build();
        return docket;
    }
}
