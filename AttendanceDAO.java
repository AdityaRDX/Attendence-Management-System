package dao;
import model.User;
import java.sql.*;


public class AttendanceDAO {
	
	private Connection conn;

    public AttendanceDAO() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle","c##hr","hr");
    }

    public User validateUser(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
        }
        return null;
    }

    public void markAttendance(int userId) throws SQLException {
        String sql = "INSERT INTO attendance (user_id, attendance_date) VALUES (?, SYSDATE)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);
        stmt.executeUpdate();
    }
}
