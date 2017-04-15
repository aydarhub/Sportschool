import com.aydar.sportschool.Adapters.SportsCategoriesAdapter;
import com.aydar.sportschool.SportsCategory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportsCategoriesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SportsCategory> sportsCategories = new ArrayList<>();
        try {
            sportsCategories.addAll(new SportsCategoriesAdapter().getSportsCategories());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("sportsCategories", sportsCategories);
        request.getRequestDispatcher("WEB-INF/sports_categories.jsp").forward(request, response);
    }
}
