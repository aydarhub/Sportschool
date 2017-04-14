import com.aydar.sportschool.Adapters.KindsOfSportAdapter;
import com.aydar.sportschool.Adapters.SportsCategoriesAdapter;
import com.aydar.sportschool.Adapters.TrainersAdapter;
import com.aydar.sportschool.KindOfSport;
import com.aydar.sportschool.SportsCategory;
import com.aydar.sportschool.Trainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Trainer> trainers = new ArrayList<>();
        List<KindOfSport> kindsOfSport = new ArrayList<>();
        List<SportsCategory> sportsCategories = new ArrayList<>();
        try {
            trainers.addAll(new TrainersAdapter().getTrainers());
            kindsOfSport.addAll(new KindsOfSportAdapter().getKindsOfSport());
            sportsCategories.addAll(new SportsCategoriesAdapter().getSportsCategories());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("trainers", trainers);
        request.setAttribute("kindOfSports", kindsOfSport);
        request.setAttribute("sportsCategories", sportsCategories);
        request.getRequestDispatcher("WEB-INF/trainers.jsp").forward(request, response);
    }
}
