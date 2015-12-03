package org.lukedowell.supernat.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
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
public class JasperConfig {

    @Bean
    public JasperReportsViewResolver getJasperReportsViewResolver() {
        JasperReportsViewResolver resolver = new JasperReportsViewResolver();
        resolver.setPrefix("classpath:/static/report/");
        resolver.setSuffix(".jasper");
        resolver.setViewNames("rpt_*");
        resolver.setViewClass(JasperReportsMultiFormatView.class);
        resolver.setJdbcDataSource(getMySqlDataSource());
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    MysqlDataSource getMySqlDataSource() {
        MysqlDataSource source = new MysqlDataSource();
        source.setURL("jdbc:mysql://localhost:3306/supernat");
        source.setUser("root");
        source.setPassword("password");
        return source;
    }
}
