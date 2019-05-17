package JSONData;

import Operation.$_Operation;

public class $_JSON_SignUp_Successful extends $_JSON_Account_Response {


    public $_JSON_SignUp_Successful(String type, String idReceived, boolean Done) {
        super(type, idReceived, Done);
    }

    @Override
    public $_Operation getOperationType() {
        return null;
    }
}
