package JSONData;

import Operation.$_Operation;
import Operation.$_RefusalOperation;

public class $_JSON_Refusal_Friend extends  $_JSON_Friend{
    public $_JSON_Refusal_Friend(String type, String idFrom, String user_name,String idTo) {
        super(type, idFrom, user_name,idTo);
    }

    @Override
    public $_Operation getOperationType() {
        return new $_RefusalOperation();
    }
}
