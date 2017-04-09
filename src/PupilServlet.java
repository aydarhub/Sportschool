import db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PupilServlet extends HttpServlet {
    private static String id = "id";
    private ResultSet rs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        try {
            rs = DBConnection.getDbConnection().getStatement().executeQuery("SELECT count(*) FROM SPORTSCHOOL.KindOfSport");
            while (rs.next()) {
                id = Integer.toString(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("id", id);
        req.getRequestDispatcher("pupils.jsp").forward(req, resp);
    }
}
