package sample.tableGateway;

import sample.model.Team;

import java.sql.*;
import java.util.ArrayList;

public class Gateway {
    private static Connection conn = createConnection("jdbc:mysql://localhost/nhl1", "root", "1");

    private static Connection createConnection(String url, String user, String pswd) {
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, user, pswd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }


    public static ArrayList<Team> read() throws SQLException {
        String nativeQ = "SELECT * FROM team;";
        ResultSet rs = conn.createStatement().executeQuery(nativeQ);
        System.out.println("executed query: " + nativeQ);
        return rsHelper(rs);
    }


    public static void create(Team team) throws SQLException {

        String[] params = {
                team.getName(),
                team.getCountry(),
                team.getArena(),
                team.getConference(),
                team.getDivision(),
                team.getDate_created(),
        };

        String nativeQ = "insert into team (name, country, arena, conference, division, date_created) values ('" +
                params[0] + "', '" +
                params[1] + "', '" +
                params[2] + "', '" +
                params[3] + "', '" +
                params[4] + "', '" +
                params[5] + "');";

        conn.createStatement().executeUpdate(nativeQ);
        System.out.println("executed query: " + nativeQ);
    }

    public static void update(int id, String param, String value) throws SQLException {

        String nativeQ = "update team set " +
                param + " = '" +
                value + "' where id = " +
                id +";";
        conn.createStatement().executeUpdate(nativeQ);
        System.out.println("executed query: " + nativeQ);
    }

    public static void delete(int id) throws SQLException {

        String nativeQ = "delete from team " +
                " where id = " +
                id +";";
        conn.createStatement().executeUpdate(nativeQ);
        System.out.println("executed query: " + nativeQ);
    }

    private static ArrayList<Team> rsHelper(ResultSet rs) throws SQLException {
        ArrayList<Team> arr = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String country = rs.getString("country");
            String arena = rs.getString("arena");
            String conference = rs.getString("conference");
            String division = rs.getString("division");
            String date_created = rs.getString("date_created");

            Object[] o = {id, name, country, arena, conference, division, date_created};

            Team r = new Team( o );
            arr.add(r);
        }
        return arr;
    }
}
