package JSONData;


import Operation.$_AddFriendOperation;
import Operation.$_Operation;

public class $_JSON_Add_Friend extends $_JSON_Friend {

    public $_JSON_Add_Friend(String type, String idFrom, String user_name,String Add_Friend_Id) {
        super(type, idFrom, user_name,Add_Friend_Id);

    }



    @Override
    public $_Operation getOperationType() {
        return new $_AddFriendOperation();
    }
}
