package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private static DataSource ds;

    static {
        try {
            ds = new ComboPooledDataSource();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() {
        //��ȡ�󶨵��̵߳�����
        try {
            Connection con = tl.get();
            if (con == null) {
                con = ds.getConnection();
                con.setAutoCommit(false);
            }
            tl.set(con);
            return con;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void startTransaction() {
        try {
            Connection con = getConnection();
            con.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void commitTranscation() {
        try {
            Connection con = getConnection();
            if (con != null) {
                con.commit();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeCon() {
        Connection con = null;
        try {
            con = getConnection();
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            tl.remove();
        }
    }
}
