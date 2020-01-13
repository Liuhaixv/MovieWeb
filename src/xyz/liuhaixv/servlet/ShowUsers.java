package xyz.liuhaixv.servlet;

import xyz.liuhaixv.dao.User;
import xyz.liuhaixv.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowUsersServlet", urlPatterns = "/showUsers")
public class ShowUsers extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        req.setCharacterEncoding("utf-8");
        res.setContentType("utf-8");
        res.setCharacterEncoding("utf-8");
        PrintWriter writer = res.getWriter();
        try {
            users = UserDao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"zh\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>");
        writer.println("<table align='center'>");
        writer.println("<th>");
        writer.println("            <tr>\n" +
                "                <td>id</td>\n" +
                "                <td>姓名</td>\n" +
                "                <td>账号</td>\n" +
                "                <td>密码</td>\n"+
                "                <td>年龄</td>\n"+
                "                <td>身份证</td>\n"+
                "                <td>注册日期</td>\n"+
                "            </tr>");
        writer.println("</th>");
        for (int i = 0; i < users.size(); i++) {
            writer.println("<tr>");
            writer.println(users.get(i).toTdString());
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("</body>\n" +
                "</html>");
    }
}
