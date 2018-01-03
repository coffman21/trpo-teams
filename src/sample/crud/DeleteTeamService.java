package sample.crud;

import sample.tableGateway.Gateway;

import java.sql.SQLException;

public class DeleteTeamService {
    public static void delete(int id) throws SQLException {
        Gateway.delete(id);
    }
}
