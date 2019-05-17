package JSONData;

import Operation.$_Operation;
import Operation.$_SignUp_Operation_Tow;

import java.nio.ByteBuffer;

public class $_JSON_SignUp_Tow extends $_JSON_Account {
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

    public $_JSON_SignUp_Tow(String type, String idFrom, String state, String byteBuffer) {
        super(type, idFrom,"");
        this.state = state;
        this.byteBuffer = byteBuffer;
    }

    @Override
    public $_Operation getOperationType() {
        return new $_SignUp_Operation_Tow();
    }
}
