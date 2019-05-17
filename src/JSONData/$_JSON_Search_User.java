package JSONData;

import Operation.$_Operation;
import Operation.$_SearchUserOperation;

import javax.imageio.ImageIO;
import javax.swing.text.html.ImageView;

public class $_JSON_Search_User extends $_JSON_Account {
    private  String Search_User;
    public $_JSON_Search_User(String type, String idFrom,String user_name) {
        super(type, idFrom,user_name);
        this.Search_User = user_name;
    }

    public String getSearch_User() {
        return Search_User;
    }

    public void setSearch_User(String search_User) {
        Search_User = search_User;
    }

    @Override
    public $_Operation getOperationType() {
        return new $_SearchUserOperation();
    }
}
