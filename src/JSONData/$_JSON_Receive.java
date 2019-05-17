package JSONData;

import Operation.$_Operation;

public abstract class $_JSON_Receive extends $_JSON {

    protected String idFrom;


    public $_JSON_Receive(String type, String idFrom) {
        super(type);
        this.idFrom = idFrom;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(String idFrom) {
        this.idFrom = idFrom;
    }

    @Override
    public abstract $_Operation getOperationType();

}
