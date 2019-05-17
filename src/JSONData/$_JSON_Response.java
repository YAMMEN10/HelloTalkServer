package JSONData;

import Operation.$_Operation;

public abstract class $_JSON_Response extends $_JSON {

    protected String idReceived;

    public String getIdReceived() {
        return idReceived;
    }

    public void setIdReceived(String idReceived) {
        this.idReceived = idReceived;
    }

    public $_JSON_Response(String type, String idReceived) {
        super(type);
        this.idReceived = idReceived;
    }

    @Override
    public abstract $_Operation getOperationType();


}
