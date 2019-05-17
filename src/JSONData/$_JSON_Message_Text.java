package JSONData;

import Operation.$_MessageTextOperation;
import Operation.$_Operation;

public class $_JSON_Message_Text extends $_JSON_Message {
    private  String message;
    public $_JSON_Message_Text(String type, String idFrom, String idTo, String MType, String time, String message, String username) {
        super(type, idFrom, idTo,MType, time, username);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public $_Operation getOperationType() {
        return new  $_MessageTextOperation();
    }
}
