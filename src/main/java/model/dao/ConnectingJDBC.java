package model.dao;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectingJDBC {

    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if(dataSource==null){
            synchronized (ConnectingJDBC.class){
                if(dataSource == null){
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl("jdbc:oracle:thin:@//localhost:1522/orcl");
                    ds.setUsername("SYS AS SYSDBA");
                    ds.setPassword("19982506vitmus");
                    ds.setMinIdle(50);
                    ds.setMaxIdle(50);
                    ds.setMaxOpenPreparedStatements(100);
                    ds.setDriverClassName("oracle.jdbc.OracleDriver");
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

}
