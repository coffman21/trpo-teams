package sample.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.crud.DeleteTeamService;
import sample.crud.ReadTeamService;
import sample.model.Team;
import sample.tableGateway.Gateway;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadUI {

    private final ObservableList<Team> data = FXCollections.observableArrayList();
    public TableView<Team> tableView;
    public TableColumn C1;
    public TableColumn C2;
    public TableColumn C3;
    public TableColumn C4;
    public TableColumn C5;
    public TableColumn C6;

    public static int curId = 0;

    @FXML
    public void initialize() throws SQLException {

        C1.setCellValueFactory(new PropertyValueFactory<Team,String>("name"));
        C2.setCellValueFactory(new PropertyValueFactory<Team,String>("country"));
        C3.setCellValueFactory(new PropertyValueFactory<Team,String>("arena"));
        C4.setCellValueFactory(new PropertyValueFactory<Team,String>("conference"));
        C5.setCellValueFactory(new PropertyValueFactory<Team,String>("division"));
        C6.setCellValueFactory(new PropertyValueFactory<Team,String>("date_created"));

        ArrayList<Team> teams = ReadTeamService.getTeams();

        data.clear();
        data.addAll(teams);
        tableView.setItems(data);

    }


    @FXML
    public void create(ActionEvent actionEvent) throws SQLException {
        newWindow("create/create.fxml", 339, 237);
        initialize();
    }

    @FXML
    public void delete(ActionEvent actionEvent) throws SQLException {
        Team team = tableView.getSelectionModel().getSelectedItem();
        try {
            int id = team.getId();
            DeleteTeamService.delete(id);
        }
        catch (Throwable t) {
            System.err.println("Row not selected");
        }
    }

    @FXML
    public void update(ActionEvent actionEvent) {
        Team team = tableView.getSelectionModel().getSelectedItem();
        try {
            curId = team.getId();

            newWindow("update/update.fxml", 197, 178);

            System.out.println(team.getArena());
        }
        catch (Throwable t) {
            System.err.println("Row not selected");
        }
    }



    private void newWindow(String path, int width, int height ) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, width, height));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
