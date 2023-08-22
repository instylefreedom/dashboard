package dashboard.configuration;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@EnableTransactionManagement
@Slf4j
public class DataSourceConfiguration {

    @Autowired
    private Environment env;

//    @Value("spring.datasource.driverClassName")
//    private String driverClassName;
//
//    @Value("spring.datasource.jdbcUrl")
//    private String jdbcUrl;
//    @Value("spring.datasource.username")
//    private String username;
//    @Value("spring.datasource.password")
//    private String password;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(jdbcUrl);
//        hikariConfig.setDriverClassName(driverClassName);
//        hikariConfig.setUsername(username);
//        hikariConfig.setPassword(password);
        log.info("this is HikariConfig info: " + hikariConfig.getDataSource());
        log.info("this is HikariConfig info: " + hikariConfig.getJdbcUrl());
        return hikariConfig;
    }
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource(hikariConfig());
        return dataSource;
//        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory  sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/*/**/*.xml")); // env.getProperty("spring.mybatis.mapper-locations");
        String mybatisConfigLocation ="classpath:mybatis/mybatis_config.xml"; // env.getProperty("spring.mybatis.config-locations");

        if (mybatisConfigLocation!=null) {
            sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(mybatisConfigLocation));
        }
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory )  throws Exception {
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
