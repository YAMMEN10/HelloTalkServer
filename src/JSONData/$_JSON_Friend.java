package JSONData;

import Operation.$_Operation;

public abstract class $_JSON_Friend extends $_JSON_Account {
    public $_JSON_Friend(String type, String idFrom, String user_name,String idTo) {
        super(type, idFrom, user_name);
        this.idTo=idTo;
    }
    private String idTo;

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }

    @Override
    public abstract $_Operation getOperationType();
}
