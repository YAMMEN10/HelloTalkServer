package JSONData;

import Operation.$_Operation;

    public abstract class $_JSON_Group_Response extends $_JSON_Response {
    public $_JSON_Group_Response(String type, String idReceived) {
        super(type, idReceived);
    }
    @Override
    public abstract $_Operation getOperationType();
}
