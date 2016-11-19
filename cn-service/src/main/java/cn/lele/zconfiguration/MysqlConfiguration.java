package cn.lele.zconfiguration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.beans.PropertyVetoException;

/**
 * 基于注解的spring配置
 * mysql数据库spring配置
 */

//mysql配置
@Configuration
public class MysqlConfiguration {

    @Value("${mysql.user}")
    private String user ;

    @Value("${mysql.password}")
    private String password ;

    @Value("${mysql.driver}")
    private String driver  ;

    @Value("${mysql.dbcUrl}")
    private String jdbcUrl  ;

    @Value("${mysql.initPoolSize}")
    private int initPoolSize ;

    @Value("${mysql.macPoolSize}")
    private int macPoolSize ;

    @Value("${mysql.minPoolSize}")
    private int minPoolSize;

    @Value("${mysql.maxPoolSize}")
    private int maxPoolSize;

    @Value("${mysql.initialPoolSize}")
    private int initialPoolSize;

    @Value("${mysql.idleConnectionTestPeriod}")
    private int idleConnectionTestPeriod;

    /**
     * mysql数据源spring配置
     */
    @Bean
    public ComboPooledDataSource dataSource(){

        ComboPooledDataSource data = new ComboPooledDataSource();

        data.setUser(user);
        data.setPassword(password);
        data.setJdbcUrl(jdbcUrl);
        data.setInitialPoolSize(initPoolSize);
        data.setMaxPoolSize(macPoolSize);
        data.setMinPoolSize(minPoolSize);
        data.setMaxPoolSize(maxPoolSize);
        data.setInitialPoolSize(initialPoolSize);
        data.setIdleConnectionTestPeriod(idleConnectionTestPeriod);

        try {
            data.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 使用spring的JDBCTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());

        return jdbcTemplate;
    }

    /**
     * mysql事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }



}
