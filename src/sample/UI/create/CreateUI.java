package sample.UI.create;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.UI.ReadUI;
import sample.crud.CreateTeamService;

import java.sql.SQLException;

public class CreateUI {
    public TextField name;
    public TextField country;
    public TextField arena;
    public TextField conf;
    public TextField division;
    public TextField date;

    public void addTeam(ActionEvent actionEvent) throws SQLException {
        String[] fields = {
                name.getText(),
                country.getText(),
                arena.getText(),
                conf.getText(),
                division.getText(),
                date.getText(),
        };
        CreateTeamService.create(fields);
        Stage stage = (Stage) name.getScene().getWindow();
        stage.close();
    }
}
