package com.cy.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

@Configuration
@SpringBootApplication
@MapperScan("com.cy.store.mapper")	//指定当前项目中的Mapper接口路径的位置，在项目启动时会加载所有的Mapper接口
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	/**
	 * 设置上传文件的大小限制
	 * @return
	 */
	@Bean
	public MultipartConfigElement getMultipartConfigElement(){
		MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();

		multipartConfigFactory.setMaxFileSize(DataSize.of(1, DataUnit.MEGABYTES));
		multipartConfigFactory.setMaxRequestSize(DataSize.of(10,DataUnit.MEGABYTES ));

		return multipartConfigFactory.createMultipartConfig();
	}
}
