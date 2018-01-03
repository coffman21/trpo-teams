package sample.crud;

import sample.tableGateway.Gateway;

import java.sql.SQLException;

public class UpdateTeamService {
    public static void update(int curId, String f, String v) throws SQLException {
        Gateway.update(curId, f, v);
    }
}
