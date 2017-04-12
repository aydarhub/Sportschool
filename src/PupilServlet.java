import com.aydar.sportschool.Labs.PupilsLab;
import com.aydar.sportschool.Pupil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
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
        try {
            pupils.addAll(PupilsLab.get().getPupils());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Pupil pupil : pupils) {
            System.out.println(pupil.getName());
        }
        req.setAttribute("pupils", pupils);
        req.getRequestDispatcher("WEB-INF/pupils.jsp").forward(req, resp);
    }
}
