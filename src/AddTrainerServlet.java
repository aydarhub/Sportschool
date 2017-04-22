import com.aydar.sportschool.Adapters.TrainersAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddTrainerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);
        String birthday = request.getParameter("birthday");
        int kindOfSportId = Integer.parseInt(request.getParameter("kindOfSportId"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int sportsCategoryId = Integer.parseInt(request.getParameter("sportsCategoryId"));

        try {
            new TrainersAdapter().addTrainer(name, birthday, kindOfSportId, sportsCategoryId, phone, address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/trainers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
