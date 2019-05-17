package JSONData;

import Operation.$_Operation;

public class $_JSON_Login_sucssful extends $_JSON {

   private String Recive;

    public $_JSON_Login_sucssful(String type) {
        super(type);
    }
    public String getRecive() {
        return Recive;
    }
    public void setRecive(String recive) {
        Recive = recive;
    }

    @Override
    public $_Operation getOperationType() {
        return null;
    }
}
