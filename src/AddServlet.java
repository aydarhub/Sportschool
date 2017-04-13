import com.aydar.sportschool.Adapters.PupilsAdapter;
import com.aydar.sportschool.Labs.PupilsLab;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);
        String birthday = request.getParameter("birthday");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        int sportsCategoryId = Integer.parseInt(request.getParameter("sportsCategoryId"));
        String rewards = request.getParameter("rewards");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        try {
            new PupilsAdapter().addPupil(name, birthday, groupId, phone, address, sportsCategoryId, rewards);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/pupils");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
