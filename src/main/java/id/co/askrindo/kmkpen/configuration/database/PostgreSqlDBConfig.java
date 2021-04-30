package id.co.askrindo.kmkpen.configuration.database;

/**
 * Created by Anggoro Biandono on 10/10/2020.
 */

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackages = "id.co.askrindo.kmkpen.repository.postgreSql",
        entityManagerFactoryRef = "postgreSqlEntityManager",
        transactionManagerRef = "postgreSqlTransactionManager")
public class PostgreSqlDBConfig {
    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean postgreSqlEntityManager() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(postgreSqlDataSource());
        factoryBean.setPackagesToScan(
                new String[]{"id.co.askrindo.kmkpen.model.postgreSql"}
        );
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(postgreSqlHibernateProperties());

        return factoryBean;
    }

//    @Primary
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

    @Primary
    @Bean(name = "postgreSqlDataSource")
    @ConfigurationProperties(prefix = "postgre")
    public DataSource postgreSqlDataSource() {
//        return DataSourceBuilder
//                .create()
//                .build();
        HikariDataSource ds = (HikariDataSource) DataSourceBuilder.create().build();

        ds.setConnectionTestQuery("SELECT 1");

        return ds;
    }

    @Bean(name = "postgreSqlEMF")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("postgreSqlDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("id.co.askrindo.kmkpen.model.postgreSql")
                .persistenceUnit("postgreSqlDataSource")
                .build();
    }

//    @Bean
//    @Primary
//    public DataSourceProperties dataSourceProperties() {
//        final DataSourceProperties dataSourceProperties = new DataSourceProperties();
//        dataSourceProperties.setUrl(env.getProperty("sybase.url"));
//        dataSourceProperties.setUsername(env.getProperty("sybase.username"));
//        dataSourceProperties.setPassword(env.getProperty("sybase.password"));
//        return dataSourceProperties;
//    }

    @Primary
    @Bean(name = "postgreSqlTransactionManager")
    public PlatformTransactionManager postgreSqlTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(postgreSqlEntityManager().getObject());

        return transactionManager;
    }

    private Properties postgreSqlHibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("postgre.jpa.properties.hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.generate_statistics", env.getProperty("spring.jpa.properties.hibernate.generate_statistics"));
        hibernateProperties.setProperty("hibernate.jdbc.batch_size", env.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size"));
        hibernateProperties.setProperty("hibernate.order_inserts", env.getProperty("spring.jpa.properties.hibernate.order_inserts"));
        hibernateProperties.setProperty("hibernate.order_updates", env.getProperty("spring.jpa.properties.hibernate.order_updates"));
        hibernateProperties.setProperty("hibernate.batch_versioned_data", env.getProperty("spring.jpa.properties.hibernate.batch_versioned_data"));
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));

        return hibernateProperties;
    }
}