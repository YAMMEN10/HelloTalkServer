package JSONData;

import Operation.$_Change_Image;
import Operation.$_Operation;

public class $_JSON_Change_Image_Successful extends $_JSON_Account_Response {
    public $_JSON_Change_Image_Successful(String type, String idReceived, boolean Done) {
        super(type, idReceived, Done);
    }

    @Override
    public $_Operation getOperationType() {
        return new $_Change_Image();
    }
}
