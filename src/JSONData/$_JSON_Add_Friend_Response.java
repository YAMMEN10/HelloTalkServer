package JSONData;


import Operation.$_Operation;

public class $_JSON_Add_Friend_Response extends $_JSON_Friend_Response {
    public $_JSON_Add_Friend_Response(String type, String idReceived, boolean Done,String Add_Friend_Id) {
        super(type, idReceived, Done,Add_Friend_Id);
    }


    @Override
    public $_Operation getOperationType() {
        return null;
    }


}
