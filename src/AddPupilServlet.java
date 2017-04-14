import com.aydar.sportschool.Adapters.PupilsAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddPupilServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);
        String birthday = request.getParameter("birthday");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        int sportsCategoryId = -1;
        if (request.getParameter("sportsCategoryId") != null && !request.getParameter("sportsCategoryId").equals("")) {
            sportsCategoryId = Integer.parseInt(request.getParameter("sportsCategoryId"));
        }
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
