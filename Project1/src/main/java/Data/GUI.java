package Data;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;


public class GUI extends Application implements Initializable {
    public static OracleDataSource ods;
    public static Connection conn;

    @FXML TextField username;
    @FXML TextField password;
    @FXML Button signin;
    @FXML Button SEARCH;
    @FXML Button ACTIVATE;
    @FXML Label connected;

    @FXML private TableColumn<Table, String> access;
    @FXML private TableColumn<Table, String> fn;
    @FXML private TableColumn<Table, Integer> id;
    @FXML private TableColumn<Table, String> ln;
    @FXML private TableColumn<Table, String> status;
    @FXML private TableView<Table> table_users;
    @FXML private TableColumn<Table, LocalDate> time;
    @FXML private TableColumn<Table, String> user;


    public ObservableList<Table> getPeople(){
        ObservableList<Table> people = FXCollections.observableArrayList();
        people.add(new Table("Frank","Jobbs","958587272","Active","FJ99","Student",LocalDate.now()));

        return people;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (fn == null || ln == null || id == null || time == null || access == null || status == null || user == null) {
            System.out.print("Null");
        } else {
            fn.setCellValueFactory(new PropertyValueFactory<Table, String>("First Name"));
            ln.setCellValueFactory(new PropertyValueFactory<Table, String>("Last Name"));
            id.setCellValueFactory(new PropertyValueFactory<Table, Integer>("ID"));
            time.setCellValueFactory(new PropertyValueFactory<Table, LocalDate>("Time"));
            access.setCellValueFactory(new PropertyValueFactory<Table, String>("Access Level"));
            status.setCellValueFactory(new PropertyValueFactory<Table, String>("Status"));
            user.setCellValueFactory(new PropertyValueFactory<Table, String>("Username"));

            table_users.setItems(getPeople());
        }
    }
    @FXML
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root,1080, 640);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void ACTIVATEACTION(ActionEvent event) throws Exception {
        Stage stage = (Stage) ACTIVATE.getScene().getWindow();
    }
    @FXML
    public void SEARCHACTION(ActionEvent event) throws Exception {
        Stage stage = (Stage) SEARCH.getScene().getWindow();
        Statement stmt = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username=sc.nextLine();

        ResultSet rset = stmt.executeQuery("SELECT * FROM DATABASE "+" WHERE username = '"+username+"'");

        ResultSetMetaData rsmd = rset.getMetaData();
        for(int i=1; i<= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + "\t\t");
        }
        System.out.print("\n");
        while (rset.next()) {
            System.out.println(rset.getString(1) +"\t\t" +rset.getString(2)
                    + "\t\t"+rset.getString(3) + "\t\t"+rset.getString(4)
                    + "\t\t"+rset.getString(5) + "\t\t"+rset.getString(6)
                    + "\t\t"+rset.getString(7)  );
        }
    }
    @FXML
    public void secondInterface(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Database Interface.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root,1080,640);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void signinAction(ActionEvent event) throws Exception {
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
        ods.setUser(username.getText());
        ods.setPassword(password.getText());
        conn = ods.getConnection();
        //System.out.println("Connected ");
        if (username.getText().isBlank() && password.getText().isBlank()){
            connected.setText("Invalid username/password");
        }
        else{
            connected.setText("Connected");
            Stage stage = (Stage) signin.getScene().getWindow();
            stage.close();
            secondInterface(stage);
            stage.show();

        }
    }

    public static void main(String[] args) {
        launch();
    }
}

