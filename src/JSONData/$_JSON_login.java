package JSONData;

import Operation.$_LoginAccount;
import Operation.$_Operation;

public class $_JSON_login extends $_JSON_Account {

   private  String Password;

    public $_JSON_login(String type, String idFrom, String password) {
        super(type, idFrom,"");
        this.Password=password;
    }


    @Override
    public $_Operation getOperationType() {
        return new $_LoginAccount();
    }
}
