package org.scoula.config;

import org.springframework.context.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.multipart.support.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;

@EnableWebMvc
@ComponentScan(basePackages = {"org.scoula.controller", "org.scoula.exception",
    "org.scoula.ex03.controller"})
public class ServletConfig implements WebMvcConfigurer {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  // jsp view resolver 설정
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    InternalResourceViewResolver bean = new InternalResourceViewResolver();

    bean.setViewClass(JstlView.class);
    bean.setPrefix("/WEB-INF/views/");
    bean.setSuffix(".jsp");

    registry.viewResolver(bean);
  }

  //    Servlet 3.0 파일 업로드 사용시 - MultipartResolver 빈 등록
  @Bean
  public MultipartResolver multipartResolver() {
    StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
    return resolver;
  }

}
