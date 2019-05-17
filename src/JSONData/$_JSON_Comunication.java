package JSONData;

import Operation.$_Operation;

public abstract class $_JSON_Comunication extends $_JSON_Receive {

    protected String idTo ;

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }

    public $_JSON_Comunication(String type, String idFrom, String idTo) {
        super(type,idFrom);
        this.idTo=idTo;
    }

    @Override
    public abstract $_Operation getOperationType();
}
