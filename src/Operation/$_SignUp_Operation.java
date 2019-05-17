package Operation;


import Information.$_AccountInformationById;
import JSONData.$_JSON;
import JSONData.$_JSON_SignUp;
import JSONData.$_JSON_SignUp_Successful;
import Room.$_Client;
import Tools.$_Client_File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class $_SignUp_Operation extends $_AccountOperation {


    @Override
    public List<$_JSON> excuteOperation() throws IOException {
        $_JSON_SignUp signUp_json=($_JSON_SignUp)my_json;
        String id = signUp_json.getIdFrom() ;
        String pass = signUp_json.getPassword() ;
        $_Client_File cl_file = new $_Client_File() ;


        if(cl_file.isExist(id))
        {
            $_JSON_SignUp_Successful signUp_successful = new $_JSON_SignUp_Successful("Sign_Up_Successful",id,false) ;
            list_my_json.add(signUp_successful) ;
            return list_my_json ;
        }
String user_name = signUp_json.getUser_name();
        cl_file.add(new $_Client(new $_AccountInformationById(id ,null , null  , null , pass , user_name) , null,new ArrayList<String>(),new ArrayList<String>(),new ArrayList<String>())  ) ;
        $_JSON_SignUp_Successful signUp_successful = new $_JSON_SignUp_Successful("Sign_Up_Successful",id, true) ;
        list_my_json.add(signUp_successful) ;
        return list_my_json ;
    }
}
