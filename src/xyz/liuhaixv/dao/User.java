package xyz.liuhaixv.dao;

public class User {
    String t_id,t_age,t_name,t_account,t_password,t_sfz,t_registerdate;

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_age() {
        return t_age;
    }

    public void setT_age(String t_age) {
        this.t_age = t_age;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_account() {
        return t_account;
    }

    public void setT_account(String t_account) {
        this.t_account = t_account;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public String getT_sfz() {
        return t_sfz;
    }

    public void setT_sfz(String t_sfz) {
        this.t_sfz = t_sfz;
    }

    public String getT_registerdate() {
        return t_registerdate;
    }

    public void setT_registerdate(String t_registerdate) {
        this.t_registerdate = t_registerdate;
    }

    public String toTdString() {
        return "<td>"+t_id+"</td>"+
                "<td>"+t_name+"</td>"+
                "<td>"+t_account+"</td>"+
                "<td>"+t_password+"</td>"+
                "<td>"+t_age+"</td>"+
                "<td>"+t_sfz+"</td>"+
                "<td>"+t_registerdate+"</td>";
    }
}
