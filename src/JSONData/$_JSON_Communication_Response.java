package JSONData;

import Operation.$_Operation;

public abstract class $_JSON_Communication_Response extends $_JSON_Response {

    public $_JSON_Communication_Response(String type, String idReceived) {
        super(type, idReceived);
    }
    @Override
    public abstract $_Operation getOperationType();
}
