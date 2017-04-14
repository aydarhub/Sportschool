import com.aydar.sportschool.Adapters.GroupsAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);
        int trainerId = Integer.parseInt(request.getParameter("trainerId"));

        try {
            new GroupsAdapter().addGroup(name, trainerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
