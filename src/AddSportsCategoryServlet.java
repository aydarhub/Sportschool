import com.aydar.sportschool.Adapters.SportsCategoriesAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddSportsCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);

        try {
            new SportsCategoriesAdapter().addSportsCategory(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/sports_categories");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
