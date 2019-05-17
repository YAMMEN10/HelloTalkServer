package Operation;

import JSONData.$_JSON;
import JSONData.$_JSON_SignUp_Tow;
import JSONData.$_JSON_SignUp_Tow_Successful;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public class $_SignUp_Operation_Tow extends $_AccountOperation {

    @Override
    public List<$_JSON> excuteOperation() throws IOException {
        $_JSON_SignUp_Tow json_signUp_tow = ($_JSON_SignUp_Tow) my_json;
        String state = json_signUp_tow.getState();
        String byteBuffer = json_signUp_tow.getByteBuffer();
        String id = json_signUp_tow.getIdFrom();
        System.out.println("datttttt =  "+  json_signUp_tow.getIdFrom());
        System.out.println("datttttt =  "+  json_signUp_tow.getState());
        System.out.println("datttttt =  "+  json_signUp_tow.getByteBuffer());
        //
        $_JSON_SignUp_Tow_Successful signUp_successful = new $_JSON_SignUp_Tow_Successful("Sign_Up_Tow_Successful",id,true, json_signUp_tow.getState(),json_signUp_tow.getByteBuffer()) ;
        list_my_json.add(signUp_successful) ;
        return list_my_json ;
    }
}
