package Operation;

import Information.$_AccountInformationById;
import JSONData.*;
import Room.$_Client;
import Tools.$_Client_File;

import java.util.List;

public class $_LoginAccount extends $_AccountOperation {
    @Override
    public List<$_JSON> excuteOperation() {
        $_JSON_login signIn_json=($_JSON_login)my_json;

        String id = signIn_json.getIdFrom() ;
        $_Client_File cl_file = new $_Client_File() ;
        if(cl_file.isExist(id))
        {
            $_JSON_Login_Successful signIn_successful = new $_JSON_Login_Successful("Login_User_Successful",id,true) ;
            list_my_json.add(signIn_successful) ;
            return list_my_json ;
        }else{
            $_JSON_Login_Successful signIn_successful = new $_JSON_Login_Successful("Login_User_Successful",id,false) ;
            list_my_json.add(signIn_successful) ;
            return list_my_json ;
        }
    }
}
