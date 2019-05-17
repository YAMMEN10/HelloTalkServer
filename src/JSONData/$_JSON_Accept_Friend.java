package JSONData;

import Operation.$_AcceptFriendOperation;
import Operation.$_AddFriendOperation;
import Operation.$_Operation;

public class $_JSON_Accept_Friend extends  $_JSON_Friend
{
    public $_JSON_Accept_Friend(String type, String idFrom, String user_name, String idTo) {
        super(type, idFrom, user_name, idTo);
    }

    @Override
    public $_Operation getOperationType() {
        return new $_AcceptFriendOperation();
    }
}
