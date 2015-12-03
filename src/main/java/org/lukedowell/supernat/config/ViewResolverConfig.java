package org.lukedowell.supernat.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ldowell on 12/3/15.
 */
@Configuration
public class ViewResolverConfig {

    @Bean
    public JasperReportsViewResolver getJasperReportsViewResolver() {
        JasperReportsViewResolver resolver = new JasperReportsViewResolver();
        resolver.setPrefix("classpath:/static/report/");
        resolver.setSuffix(".jasper");
        resolver.setViewNames("rpt_*");
        resolver.setViewClass(JasperReportsMultiFormatView.class);
        resolver.setOrder(1);
        return resolver;
    }

//    @Bean
//    public FreeMarkerViewResolver viewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(true);
//        resolver.setPrefix("classpath:/templates/");
//        resolver.setSuffix(".ftl");
//        resolver.setOrder(0);
//        return resolver;
//    }
}
