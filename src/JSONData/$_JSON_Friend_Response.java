package JSONData;

import Operation.$_Operation;

public class $_JSON_Friend_Response extends $_JSON_Account_Response  {
    public $_JSON_Friend_Response(String type, String idReceived, boolean Done,String Id_user) {
        super(type, idReceived, Done);
        this.Id_user=Id_user;
    }

    public String getId_user() {
        return Id_user;
    }

    public void setId_user(String id_user) {
        Id_user = id_user;
    }

    private  String Id_user;

    @Override
    public $_Operation getOperationType() {
        return null;
    }
}
