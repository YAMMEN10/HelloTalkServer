package ServerManagment;

import JSONData.$_JSONAttributes;
import Server.$_Server;
import javafx.util.Pair;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 *
 */
public class $_CheckOnline  extends  $_Background{

    /**
     * Default constructor
     */
    public $_CheckOnline() {
        my_thread = new Thread(this);
        my_thread.start();
    }
    public void excute() {
        // TODO implement here
    }

    @Override
    public synchronized void run() {
        while (true){
            System.out.println("*");
            try {
                Socket socketOnline = $_Server.server_socker.accept();
                Socket socketMessage = $_Server.server_socker.accept();
                System.out.println("Client Connect");
                DataInputStream inputOnline=new DataInputStream(socketOnline.getInputStream());
                DataInputStream inputMessage=new DataInputStream(socketMessage.getInputStream());
                socketOnline.setSoTimeout(5000);
                String s =(String) inputMessage.readUTF();
                JSONObject jsonObject = new JSONObject(s);
                $_Server.getOnline_clients().add(new Pair<String, Pair<Socket, Socket>>(jsonObject.getString($_JSONAttributes.Id.toString()),  new Pair<Socket, Socket>(socketOnline, socketMessage)));
                String id = jsonObject.getString($_JSONAttributes.Id.toString());
                Pair<Queue<JSONObject>,Pair<Socket, Socket>>  pair;
                if(!$_Server.getState_clients().containsKey(id)) {
                    pair=new Pair<Queue<JSONObject>, Pair<Socket, Socket>>(new LinkedList<>(), new Pair<Socket, Socket>(socketOnline, socketMessage));
                    $_Server.getState_clients().put(id, pair);
                }
                else {
                    pair = new Pair<Queue<JSONObject>, Pair<Socket, Socket>>($_Server.getState_clients().get(id).getKey(),new Pair<Socket, Socket>(socketOnline, socketMessage));
                    $_Server.getState_clients().put(id,pair);
                }
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        check_unsand_message(pair);
                    }
                });
                thread.start();
                new $_CheckOffline_Online(pair.getValue());
                new $_CheckOffline_Message(pair.getValue());
                $_TreatmentData treatmentData = new $_TreatmentData(jsonObject);
                treatmentData.excute();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void check_unsand_message(  Pair<Queue<JSONObject>,Pair<Socket, Socket>> pair)
    {
       int size= pair.getKey().size();
        for (int i = 0; i <size; i++) {
            JSONObject jsonObject=pair.getKey().poll();
            System.out.println(jsonObject);
            try {
                DataOutputStream dataOutputStream=new DataOutputStream(pair.getValue().getValue().getOutputStream());
                dataOutputStream.writeUTF(jsonObject.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Size of our list"+pair.getKey().size());

    }

}