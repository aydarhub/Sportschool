import com.aydar.sportschool.Adapters.GroupsAdapter;
import com.aydar.sportschool.Adapters.TrainersAdapter;
import com.aydar.sportschool.Group;
import com.aydar.sportschool.Trainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Group> groups = new ArrayList<>();
        List<Trainer> trainers = new ArrayList<>();
        try {
            groups.addAll(new GroupsAdapter().getGroups());
            trainers.addAll(new TrainersAdapter().getTrainers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("groups", groups);
        request.setAttribute("trainers", trainers);
        request.getRequestDispatcher("WEB-INF/groups.jsp").forward(request, response);
    }
}
