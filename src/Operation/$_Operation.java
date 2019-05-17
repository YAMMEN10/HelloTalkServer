package Operation;

import JSONData.$_JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  abstract class $_Operation {

    protected List<$_JSON> list_my_json;
    protected $_JSON my_json;

    public List<$_JSON> getList_my_json() {
        return list_my_json;
    }

    public void setList_my_json(List<$_JSON> list_my_json) {
        this.list_my_json = list_my_json;
    }

    public $_JSON getMy_json() {
        return my_json;
    }

    public void setMy_json($_JSON my_json) {
        this.my_json = my_json;
    }

    public $_Operation() {
        list_my_json=new ArrayList<>();
    }

    public  abstract List<$_JSON> excuteOperation() throws IOException;

}