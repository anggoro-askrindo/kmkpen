package id.co.askrindo.kmkpen.configuration.database;

/**
 * Created by Anggoro Biandono on 10/10/2020.
 */

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource({ "classpath:application.properties"})
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "id.co.askrindo.kmkpen.repository.sybase",
        entityManagerFactoryRef = "sybaseSqlEntityManager",
        transactionManagerRef = "sybaseSqlTransactionManager")
public class SybaseDBConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean sybaseSqlEntityManager() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(sybaseSqlDataSource());
        factoryBean.setPackagesToScan(
                new String[]{"id.co.askrindo.kmkpen.model.sybase"}
        );
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(sybaseSqlHibernateProperties());

        return factoryBean;
    }

//    @Bean
//    public DataSource userDataSource() {
//
//        DriverManagerDataSource dataSource
//                = new DriverManagerDataSource();
//        dataSource.setDriverClassName(
//                env.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(env.getProperty("user.jdbc.url"));
//        dataSource.setUsername(env.getProperty("jdbc.user"));
//        dataSource.setPassword(env.getProperty("jdbc.pass"));
//
//        return dataSource;
//    }

    @Bean
    @ConfigurationProperties(prefix = "sybase")
    public DataSource sybaseSqlDataSource() {
//        return DataSourceBuilder
//                .create()
//                .build();
        HikariDataSource ds = (HikariDataSource) DataSourceBuilder.create().build();

        ds.setConnectionTestQuery("SELECT 1");

        return ds;
    }

//    @Bean
//    public DataSourceProperties dataSourceProperties() {
//        final DataSourceProperties dataSourceProperties = new DataSourceProperties();
//        dataSourceProperties.setUrl(env.getProperty("sybase.url"));
//        dataSourceProperties.setUsername(env.getProperty("sybase.username"));
//        dataSourceProperties.setPassword(env.getProperty("sybase.password"));
//        return dataSourceProperties;
//    }

    @Bean(name = "sybaseSqlTransactionManager")
    public PlatformTransactionManager sybaseSqlTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(sybaseSqlEntityManager().getObject());

        return transactionManager;
    }

    private Properties sybaseSqlHibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("sybase.jpa.properties.hibernate.dialect"));
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));

        return hibernateProperties;
    }
}