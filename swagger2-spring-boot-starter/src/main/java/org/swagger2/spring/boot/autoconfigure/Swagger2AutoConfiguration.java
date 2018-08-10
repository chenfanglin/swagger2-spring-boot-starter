package org.swagger2.spring.boot.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * 注入Swagger2配置
 * 
 * @author monkeychen
 * @date: 2018年8月10日 下午2:23:46
 * @version v1.0.0
 */
@Configuration
@ConditionalOnProperty(name = "spring.swagger2.enabled", matchIfMissing = true)
@EnableConfigurationProperties(Swagger2Properties.class)
@Import({ Swagger2DocumentationConfiguration.class })
public class Swagger2AutoConfiguration {

	@Autowired
	private Swagger2Properties swagger2Properties;

	/**
	 * 创建API应用 apiInfo() 增加API相关信息
	 * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
	 * 扫描注解了@ApiOperation的方法生成API接口文档
	 *
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any())
				.build();
	}

	/**
	 * 创建该API的基本信息（这些基本信息会展现在文档页面中）。 访问地址：http://项目实际地址/swagger-ui.html
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(swagger2Properties.getTitle())
				.description(swagger2Properties.getDescription()).contact(new Contact(swagger2Properties.getName(),
						swagger2Properties.getUrl(), swagger2Properties.getEmail()))
				.version(swagger2Properties.getVersion()).build();
	}
}
