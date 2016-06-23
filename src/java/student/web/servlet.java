package student.web;
import java.sql.*;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author admin
 */
public class servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String url = "jdbc:mysql://192.168.5.11:3306/trade";
    String user = "torg";
    String password = "123456";
    
    public servlet(){
        super();
    }    
    
    protected void Responce(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) //уходит на страницу
        {
            String WhereSQL = "where "
                    + "name_subject Like '%"+     (String)request.getParameter("f-subject") +"%' "
                    + "and name_subject Like '%"+ (String)request.getParameter("f-object") +"%' "
                    + "and name_subject Like '%"+ (String)request.getParameter("f-okrug") +"%' "
                    + "and name_subject Like '%"+ (String)request.getParameter("f-type_sub") +"%' "
                    + "and name_subject Like '%"+ (String)request.getParameter("f-name_list") +"%' "
                    + "and name_subject Like '%"+ (String)request.getParameter("f-name_type_trade") +"%' "
                    + "and name_subject Like '%"+ (String)request.getParameter("f-ur-f") +"%'";
            
            String username = (String) request.getParameter("f-subject");      //перехват параметров
            //sdelat_pezdato
            ResultSet rs = DBRequest("SELECT id_list_assort, name_subject, name_object, okrug, "
                    + "name_type_subject, name_list, name_type_trade, U_F FROM the_best_pred "+WhereSQL);
            StringBuffer sb = new StringBuffer();
            sb.append("<table id='user' >");
            int columns = rs.getMetaData().getColumnCount();
            // Перебор строк с данными
            sb.append("<tr><th>ИД</th><th>Название</th><th>Объект</th><th>Округ</th><th>Тип</th>"
                    + "<th>Спеиализация</th><th>Тип торговли</th><th>Юр. лицо</th>");
            out.println();
            sb.append("</tr>");

            while (rs.next()) {
                sb.append("<tr id='list_assort-" + rs.getString("id_list_assort") + "' class='subject_str'>");
                for (int i = 1; i <= columns; i++) {
                    sb.append("<td>");
                    sb.append(rs.getString(i));
                    sb.append("</td>");
                }
                out.println();
                sb.append("</tr>");
            }
            sb.append("</table>");
            out.println(sb);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //Селективный запрос к базе
    protected ResultSet DBRequest(String querytext) {
        ResultSet result = null;
        try
        {       
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            result = st.executeQuery(querytext);    //executeUpdate 
        }
        catch(Exception e) {
            e.printStackTrace();               
        }
        return result;
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getParameter("f-subject"); 
        Responce(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getParameter("username"); 
        
        Responce(request, response);
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
