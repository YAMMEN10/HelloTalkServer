package GUI;
import GUI.Design.Button_Style;
import GUI.Design.Buttons_Designer;
import Room.$_Client;
import Server.$_Server;
import Tools.$_Client_File;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowControler implements Initializable {

    // ********************************** Variables ***************************************** //

    @FXML
    private ResourceBundle resources;

    @FXML
    private Pane AllClientsContainer;

    @FXML
    private URL location;

    ScrollPane Online_scrollPane;
    VBox Online_Clients_List ;
    ScrollPane All_scrollPane ;
    VBox All_Clients_List ;

    @FXML
    private Button ProgressWindowBtn;

    @FXML
    private Button AllClientsBtn;

    @FXML
    private Button OnlineClientsBtn;

    @FXML
    private Button EditBtn;

    @FXML
    private Button ExitBtn;

    @FXML
    private AnchorPane MainPane;

    @FXML
    private VBox ConnectedClientsWindow;

    @FXML
    private Label NoClientsRegisteredLbl;

    @FXML
    private Pane ClientsContainer;

    @FXML
    private Button Refresh_btn;

    @FXML
    private VBox ProgressWindow;

    @FXML
    private VBox AllClientsWindow ;
    @FXML
    private Label NoOnlineClientsLbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initialize Online_Clients_List Vbox  :

        Online_Clients_List = new VBox() ;
        Online_Clients_List.setSpacing(5);
        Online_Clients_List.setPadding(new Insets(7 , 2 , 7 , 2));
        Online_Clients_List.setStyle("-fx-background-color: rgba(0, 0, 0 , 1)");
        Online_Clients_List.setPrefWidth(1110);
        Online_Clients_List.setPrefHeight(270);

        // Initialize All_Clients_List Vbox  :

        All_Clients_List = new VBox() ;
        All_Clients_List.setSpacing(5);
        All_Clients_List.setPadding(new Insets(7 , 2 , 7 , 2));
        All_Clients_List.setStyle("-fx-background-color: rgba(0, 0, 0 , 1)");
        All_Clients_List.setPrefWidth(1110);
        All_Clients_List.setPrefHeight(270);

        // Define ScrollPane For The Clients Vbox :

        Online_scrollPane = new ScrollPane() ;
        Online_scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        All_scrollPane = new ScrollPane() ;
        All_scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        // ************************** //

        // TODO
    }


    public void Fill_Online_Clients_List() throws IOException {

        // Make The Vbox Empty :
        if(!Online_Clients_List.getChildren().isEmpty())Online_Clients_List.getChildren().clear();
        ClientsContainer.getChildren().clear();

        // Defines Helper Variables :
        List onlineClients = $_Server.getOnline_clients();
        $_Client_File temp_file_client = null;
        $_Client temp_client = null;

        // Check If there are no clients Online :
    if(onlineClients.size()==0){NoClientsRegisteredLbl.setVisible(true);return;}
     else NoClientsRegisteredLbl.setVisible(false);

        // Fill The Vbox With The Online Clients :

        for (int i = 0 ;  i < onlineClients.size() ;  i++) {
            Pair s = (Pair) onlineClients.get(i);
            String clientId = (String) s.getKey();
            temp_client = ($_Client) temp_file_client.get(clientId);
            if (temp_client == null) continue;
            Button btn = new Button(temp_client.getClient_information().getID());
            Buttons_Designer bd = new Buttons_Designer();
            bd.AddStyle(btn, Button_Style.List_Element_Style);
            Online_Clients_List.getChildren().add(btn);
            Online_scrollPane.setContent(Online_Clients_List);

        }

  // Test ::::::
    /*    for (int i = 0; i <100 ; i++) {
            Button btn = new Button("Oday Mourad" + i);
            Buttons_Designer bd = new Buttons_Designer();
            bd.AddStyle(btn, Button_Style.List_Element_Style);
            Online_Clients_List.getChildren().add(btn);
            Online_scrollPane.setContent(Online_Clients_List);
        }*/


        // Adding The Scroll and the Vbox to The Clients Container (In SceneBuilder):
        ClientsContainer.getChildren().addAll(Online_scrollPane) ;
        System.out.println("Done .. ");
    }

    public void Fill_All_Clients_List() throws IOException {

        // Make The Vbox Empty :
        if(!All_Clients_List.getChildren().isEmpty())All_Clients_List.getChildren().clear();
        AllClientsContainer.getChildren().clear();

        // Getting Clients From Clients Folder :

        $_Client_File clients_folder_management = new $_Client_File() ;
        String clients_folder_path = clients_folder_management.getClients_path() ;
        File Clients_Folder = new File(clients_folder_path) ;
        File[] AllClients =Clients_Folder.listFiles() ;

        // Check If there are no clients Online :
  if(AllClients.length ==0){NoOnlineClientsLbl.setVisible(true);return;}
        else NoOnlineClientsLbl.setVisible(false);

        $_Client temp_client = null ;
        $_Client_File clients_file_management = new $_Client_File() ;

        for (int i = 0; i < AllClients.length ; i++) {

            temp_client = ($_Client) clients_file_management.get(AllClients[i]);
            Button btn = new Button(temp_client.getClient_information().getID()) ;
            Buttons_Designer bd = new Buttons_Designer() ;
            bd.AddStyle(btn , Button_Style.List_Element_Style);
            All_Clients_List.getChildren().add(btn) ;
            All_scrollPane.setContent(All_Clients_List);
        }

        // Test ::::::
  /*      for (int i = 0; i <100 ; i++) {
            Button btn = new Button("Oday Mourad" + i);
            Buttons_Designer bd = new Buttons_Designer();
            bd.AddStyle(btn, Button_Style.List_Element_Style);
            All_Clients_List.getChildren().add(btn);
            All_scrollPane.setContent(All_Clients_List);
        }*/

        AllClientsContainer.getChildren().addAll(All_scrollPane) ;
        System.out.println("Done .. ");

    }

    public void Refresh_button() throws IOException {
        System.out.println("Clicked !!");
        Fill_Online_Clients_List();
    }

    public void All_Clients_Btn() throws IOException {
        ConnectedClientsWindow.setVisible(false);
        ProgressWindow.setVisible(false);
        AllClientsWindow.setVisible(true);
        Fill_All_Clients_List();
    }


    public void Progress_Window_Btn()
    {
        ConnectedClientsWindow.setVisible(false);
        ProgressWindow.setVisible(true);
        AllClientsWindow.setVisible(false);
    }

    public void Connected_Clients_Btn() throws IOException {
        ConnectedClientsWindow.setVisible(true);
        ProgressWindow.setVisible(false);
        AllClientsWindow.setVisible(false);

        Fill_Online_Clients_List();

    }
    public void Exit_Btn()
    {
        Platform.exit();
    }
}
