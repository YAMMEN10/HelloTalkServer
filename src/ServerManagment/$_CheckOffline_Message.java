package ServerManagment;

import Server.$_Server;
import javafx.util.Pair;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class $_CheckOffline_Message extends $_Background {

    private Pair<Socket, Socket> sockets;
public static Socket staticsocketMessage;

    public $_CheckOffline_Message(Pair<Socket, Socket> sockets) {
        this.sockets = sockets;
        my_thread = new Thread(this);
        my_thread.start();

    }
    JSONObject jsonObject;
    @Override
    public void run() {
        DataInputStream dis;
        try {
            dis = new DataInputStream(sockets.getValue().getInputStream());
            while (true) {
                String json = dis.readUTF();
                jsonObject = new JSONObject(json);
                //if (!jsonObject.getString("Type").equals("Check")) {
                   staticsocketMessage = sockets.getValue();
                    $_TreatmentData treatmentData = new $_TreatmentData(jsonObject);
                    treatmentData.excute();
              //  }
            }
        } catch (IOException e) {
            try {
                sockets.getKey().close();
                sockets.getValue().close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            // TODO Auto-generated catch block
            if (sockets.getValue().isConnected()) {
                System.out.println("closed");
                $_Server.getOnline_clients().remove(new Pair<>(jsonObject.getString("Id"), sockets));
            } else System.out.println("aaaa");
        }
    }

    @Override
    public void excute() {

    }
}
