package JSONData;

import Operation.$_Operation;
import Operation.$_RemoveRequestOperation;

public class $_JSON_Remove_Request extends  $_JSON_Friend {
    public $_JSON_Remove_Request(String type, String idFrom, String user_name, String idTo) {
        super(type, idFrom, user_name, idTo);
    }

    @Override
    public $_Operation getOperationType() {
        return new $_RemoveRequestOperation();
    }
}
