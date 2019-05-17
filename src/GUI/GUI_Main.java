package GUI;

import Server.$_Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI_Main extends Application {
    public static void main(String[] args) {
        $_Server server = new $_Server();
        server.runServer();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Hello Talk Server Management");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 1231, 642));
        primaryStage.show();
    }
}
