package sample.crud;

import sample.model.Team;
import sample.tableGateway.Gateway;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReadTeamService {
    public static ArrayList<Team> getTeams() throws SQLException {
        return Gateway.read();
    }
}
