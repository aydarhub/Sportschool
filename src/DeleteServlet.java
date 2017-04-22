import com.aydar.sportschool.Adapters.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        int id = Integer.parseInt(request.getParameter("id"));

        switch (table) {
            case "Group":
                try {
                    GroupsAdapter.deleteItem(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("/groups");
                break;
            case "KindOfSport":
                try {
                    KindsOfSportAdapter.deleteItem(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("/kinds_of_sport");
                break;
            case "Pupil":
                try {
                    PupilsAdapter.deleteItem(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("/pupils");
                break;
            case "SportsCategory":
                try {
                    SportsCategoriesAdapter.deleteItem(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("/sports_categories");
                break;
            case "Trainer":
                try {
                    TrainersAdapter.deleteItem(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("/trainers");
                break;
        }


    }
}
