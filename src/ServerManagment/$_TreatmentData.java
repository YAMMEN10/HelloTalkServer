package ServerManagment;

import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class $_TreatmentData {

    /**
     * Default constructor
     */

   private JSONObject json;
    public $_TreatmentData(JSONObject json) {
        this.json = json;
    }







    /**
     * @return
     */
    public void excute() {
        // TODO implement here
   $_ReciveData reciveData = new $_ReciveData(json);
   reciveData.excute();

   $_SendData sendData = new $_SendData(reciveData.getMy_json());
            sendData.excute();



    }

}