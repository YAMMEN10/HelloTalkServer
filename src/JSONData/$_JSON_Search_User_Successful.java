package JSONData;

import Operation.$_Operation;
import org.json.JSONArray;

import java.util.ArrayList;

public class $_JSON_Search_User_Successful extends $_JSON_Account_Response {

    public $_JSON_Search_User_Successful(String type, String idReceived, boolean Done,ArrayList<String> Ids,ArrayList<String> Users_Name,ArrayList<String> state_users) {
        super(type, idReceived, Done);
        this.Users_Name=Users_Name;
        this.Ids= Ids;
        this.state_users=state_users;
    }

    private ArrayList<String> Ids;
    private ArrayList<String> Users_Name;
    private ArrayList<String> state_users;

    public ArrayList<String> getState_users() {
        return state_users;
    }

    public void setState_users(ArrayList<String> state_users) {
        this.state_users = state_users;
    }

    public ArrayList<String> getIds() {
        return Ids;
    }

    public void setIds(ArrayList<String> isd) {
        this.Ids = isd;
    }

    public ArrayList<String> getUsers_Name() {
        return Users_Name;
    }

    public void setUsers_Name(ArrayList<String> users_Name) {
        Users_Name = users_Name;
    }

    @Override
    public $_Operation getOperationType() {
        return null;
    }
}
