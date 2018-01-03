package sample.UI.update;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.UI.ReadUI;
import sample.crud.UpdateTeamService;

import java.sql.SQLException;

public class UpdateUI {

    public TextField field;
    public TextField value;

    public void update(ActionEvent actionEvent) throws SQLException {
        String f = field.getText();
        String v = value.getText();
        UpdateTeamService.update(ReadUI.curId, f, v);

        Stage stage = (Stage) field.getScene().getWindow();
        stage.close();
    }
}
