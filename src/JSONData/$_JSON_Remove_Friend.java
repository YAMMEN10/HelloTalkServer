package JSONData;

import Operation.$_Operation;
import Operation.$_RemoveFriendOperation;

public class $_JSON_Remove_Friend extends $_JSON_Friend {
    public $_JSON_Remove_Friend(String type, String idFrom, String user_name, String idTo) {
        super(type, idFrom, user_name, idTo);
    }

    @Override
    public $_Operation getOperationType() {
        return new $_RemoveFriendOperation();
    }
}
