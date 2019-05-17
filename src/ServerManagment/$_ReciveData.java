package ServerManagment;

import Interprete.$_Decode;
import Interprete.$_Interprete;
import JSONData.$_JSON;
import org.json.JSONObject;


/**
 *
 */
public class $_ReciveData extends  $_Connect{

    /**
     * Default constructor
     */

    private JSONObject json;
    public $_ReciveData(JSONObject json) {
        this.json = json;
    }


    public void excute() {
        // TODO implement here
        $_Interprete interprete = new $_Decode(json);
        my_json= ($_JSON) interprete.run();

    }

}