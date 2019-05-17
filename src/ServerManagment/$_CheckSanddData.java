package ServerManagment;

import Server.$_Server;
import javafx.util.Pair;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

/**
 * 
 */
public class $_CheckSanddData  extends Thread{

    /**
     * Default  constructor
     */





    @Override
    public void run() {
        while (true){
            for(int i = 0 ; i < $_Server.getOnline_clients().size(); i++){
                Pair<Queue<JSONObject>,Pair<Socket, Socket>> pair = $_Server.getState_clients().get($_Server.getOnline_clients().get(i).getKey());
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0 ; i  <pair.getKey().size(); i++){
                            try {
                                JSONObject jsonObject = (JSONObject)pair.getKey().toArray()[i];
                                DataOutputStream dataOutputStream = new DataOutputStream(pair.getValue().getValue().getOutputStream());
                                dataOutputStream.writeUTF(jsonObject.toString());
                                pair.getKey().poll();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        }
    }

    /**
     * @return
     */
    public void excute() {
        // TODO implement here


    }

}