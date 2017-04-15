import com.aydar.sportschool.Adapters.KindsOfSportAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddKindOfSportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);

        try {
            new KindsOfSportAdapter().addKindOfSport(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/kinds_of_sport");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
