package xyz.liuhaixv.dao;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private static QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());

    public static boolean hasUser(String name) {
        User query=null;
        try {
            query = queryRunner.query("select * from t_user where t_name=?", new BeanHandler<>(User.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return query != null;
    }

    public static boolean addUser(String t_age, String t_name, String t_account, String t_password, String t_sfz) {
        int update;
        Date date=null;
        try {
          date = queryRunner.query("SELECT DATE_FORMAT(NOW(),'%Y-%m-%d') as date",new BeanHandler<>(Date.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            update = queryRunner.update("insert into t_user (t_age,t_name,t_account,t_password,t_sfz,t_registerdate) values (?,?,?,?,?,?)",
                    t_age, t_name, t_account, t_password, t_sfz,date.getDate());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return update > 0;
    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = queryRunner.query("select * from t_user", new BeanListHandler<>(User.class));
        return users;
    }
}