package Interprete;

import JSONData.$_JSON;
import org.json.JSONObject;

/**
 * 
 */
public abstract class $_Interprete {
    protected JSONObject jsonObject;
    protected $_JSON my_json;

    public $_Interprete() {
    }

    public abstract Object run()  ;


}