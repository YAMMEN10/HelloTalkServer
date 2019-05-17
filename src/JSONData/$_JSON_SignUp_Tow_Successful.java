package JSONData;

import Operation.$_Operation;

import java.nio.ByteBuffer;

public class $_JSON_SignUp_Tow_Successful extends $_JSON_Account_Response {
    String state;
    String byteBuffer;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getByteBuffer() {
        return byteBuffer;
    }

    public void setByteBuffer(String byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public $_JSON_SignUp_Tow_Successful(String type, String idReceived, boolean Done, String state, String byteBuffer) {
        super(type, idReceived, Done);
        this.state =state;
        this.byteBuffer = byteBuffer;
    }

    @Override
    public $_Operation getOperationType() {
        return null;
    }
}
