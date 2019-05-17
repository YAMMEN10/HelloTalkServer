package JSONData;
import Operation.$_Operation;


public abstract class $_JSON {

    /// Type ...

    protected String Type ;

    public $_JSON(String type) {
        Type = type;
    }
/// Get And Set for Type ...

    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }

    public abstract $_Operation getOperationType();


}
