package ServerManagment;

import Interprete.$_Decode;
import Interprete.$_Encode;
import JSONData.$_JSON;
import JSONData.$_JSONAttributes;
import Operation.$_Operation;
import Server.$_Server;
import javafx.util.Pair;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 *
 */
public class $_SendData extends $_Connect{

    /**
     * Default constructor
     */


    public $_SendData($_JSON json) {
        this.my_json = json;
    }






    /**
     * @return
     */
    public void excute()  {
        // TODO implement here
        Pair<Queue<JSONObject>, Pair<Socket, Socket>> pair = null;

        try {
            $_Operation my_operation = my_json.getOperationType();
            my_operation.setMy_json(my_json);
            List<$_JSON> list_of_myJson = my_operation.excuteOperation();
            $_Encode encoder = new $_Encode();
            List<JSONObject> ourListJSONobject = encoder.run(list_of_myJson);
            for (JSONObject toSend : ourListJSONobject) {
                pair= $_Server.state_clients.get(toSend.getString($_JSONAttributes.IdRecive.toString()));
                pair.getKey().offer(toSend);
                if(pair.getValue().getValue().isConnected() || !pair.getValue().getValue().isClosed()){
                DataOutputStream dataOutputStream = new DataOutputStream(pair.getValue().getValue().getOutputStream());
                dataOutputStream.writeUTF(toSend.toString());
                    if(toSend.getString("Type").equals("Message_Image")&& toSend.getString("MType").equals("R")){
                    DataOutputStream dataOutputStream1 = new DataOutputStream(pair.getValue().getValue().getOutputStream());
                    dataOutputStream1.write($_Decode.bytes);
                }
                    pair.getKey().remove(toSend);
                }else {
                    System.out.println("datsa 111= " + toSend);
                }

            }
        }catch (IOException e) {
            System.out.println("error  : " + pair.getKey().size());
            }
    }

}