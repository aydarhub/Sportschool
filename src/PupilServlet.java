import com.aydar.sportschool.Adapters.GroupsAdapter;
import com.aydar.sportschool.Adapters.PupilsAdapter;
import com.aydar.sportschool.Adapters.SportsCategoriesAdapter;
import com.aydar.sportschool.Group;
import com.aydar.sportschool.Pupil;
import com.aydar.sportschool.SportsCategory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PupilServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Pupil> pupils = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        List<SportsCategory> sportsCategories = new ArrayList<>();
        try {
            pupils.addAll(new PupilsAdapter().getPupils());
            groups.addAll(new GroupsAdapter().getGroups());
            sportsCategories.addAll(new SportsCategoriesAdapter().getSportsCategories());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("pupils", pupils);
        req.setAttribute("groups", groups);
        req.setAttribute("sportsCategories", sportsCategories);
        req.getRequestDispatcher("WEB-INF/pupils.jsp").forward(req, resp);
    }
}
