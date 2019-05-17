package JSONData;

import Operation.$_MessageImageOperation;
import Operation.$_Operation;

public class $_JSON_Message_Image extends $_JSON_Message {
    private Object bytes;

    public $_JSON_Message_Image(String type, String idFrom, String idTo, String MType, String time, Object bytes, String username) {
        super(type, idFrom, idTo, MType, time, username);
        this.bytes = bytes;
    }

    public Object getBytes() {
        return bytes;
    }

    public void setBytes(Object bytes) {
        this.bytes = bytes;
    }
    @Override
    public $_Operation getOperationType() {
        return new $_MessageImageOperation();
    }
}
