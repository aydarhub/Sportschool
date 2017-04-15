import com.aydar.sportschool.Adapters.KindsOfSportAdapter;
import com.aydar.sportschool.KindOfSport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KindsOfSportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KindOfSport> kindsOfSport = new ArrayList<>();
        try {
            kindsOfSport.addAll(new KindsOfSportAdapter().getKindsOfSport());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("kindsOfSport", kindsOfSport);
        request.getRequestDispatcher("WEB-INF/kinds_of_sport.jsp").forward(request, response);
    }
}
