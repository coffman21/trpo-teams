package sample.crud;

import sample.model.Team;
import sample.tableGateway.Gateway;

import java.sql.SQLException;

public class CreateTeamService {
    public static void create(String[] fields) throws SQLException {
        Team team = new Team(fields);
        Gateway.create(team);
    }
}
