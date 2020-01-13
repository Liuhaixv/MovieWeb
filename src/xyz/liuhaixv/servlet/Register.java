package xyz.liuhaixv.servlet;

import xyz.liuhaixv.dao.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "Register",urlPatterns = "/register")
public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        req.setCharacterEncoding("utf-8");
        res.setContentType("utf-8");
        res.setCharacterEncoding("utf-8");
        PrintWriter writer = res.getWriter();
        if(parameterMap.containsKey("t_name")&&parameterMap.containsKey("t_account")&&parameterMap.containsKey("t_password")&&parameterMap.containsKey("t_age")&&parameterMap.containsKey("t_sfz")){
            String t_name = parameterMap.get("t_name")[0];
            String t_account = parameterMap.get("t_account")[0];
            String t_password = parameterMap.get("t_password")[0];
            String t_age = parameterMap.get("t_age")[0];
            String t_sfz = parameterMap.get("t_sfz")[0];
            if(UserDao.hasUser(t_name)){
                //重复用户
                writer.println("<!DOCTYPE html>\n" +
                        "<html lang=\"zh\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Title</title>\n" +
                        "</head>\n" +
                        "<body>");
                writer.println("<h1 align=\"center\">重复用户!添加失败</h1>");
                writer.println("</body>\n" +
                        "</html>");
            }else{
                if(t_name==""||t_password==""){
                    writer.println("<!DOCTYPE html>\n" +
                            "<html lang=\"zh\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "</head>\n" +
                            "<body>");
                    writer.println("<h1 align=\"center\">参数不能为空</h1>");
                    writer.println("</body>\n" +
                            "</html>");
                    return;
                }
                boolean result = UserDao.addUser(t_age,t_name,t_account,t_password,t_sfz);
                if(result){
                    //添加用户成功
                    writer.println("<!DOCTYPE html>\n" +
                            "<html lang=\"zh\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "</head>\n" +
                            "<body>");
                    writer.println("<h1 align=\"center\">添加用户成功</h1>");
                    writer.println("</body>\n" +
                            "</html>");
                }else{
                    //添加用户失败
                    writer.println("<!DOCTYPE html>\n" +
                            "<html lang=\"zh\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "</head>\n" +
                            "<body>");
                    writer.println("<h1 align=\"center\">添加用户失败</h1>");
                    writer.println("</body>\n" +
                            "</html>");
                }
            }
        }else{
            //参数列表错误
            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"zh\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>");
            writer.println("<h1 align=\"center\">参数错误</h1>");
            writer.println("</body>\n" +
                    "</html>");
        }
        writer.close();
    }
}
