package ServerManagment;

import Server.$_Server;
import com.sun.xml.internal.ws.api.message.stream.InputStreamMessage;
import javafx.util.Pair;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;

public class $_CheckOffline_Online extends $_Background {

    private Pair<Socket, Socket> sockets;
public static Socket staticsocketMessage;

    public $_CheckOffline_Online(Pair<Socket, Socket> sockets) {
        this.sockets = sockets;
        my_thread = new Thread(this);
        my_thread.start();

    }
    JSONObject jsonObject;
    @Override
    public void run() {
        DataInputStream dis;
        try {
            dis = new DataInputStream(sockets.getKey().getInputStream());
            while (true) {
                String json = dis.readUTF();
                jsonObject = new JSONObject(json);
                //if (!jsonObject.getString("Type").equals("Check")) {
                   staticsocketMessage = sockets.getKey();
                   // $_TreatmentData treatmentData = new $_TreatmentData(jsonObject);
                    //treatmentData.excute();
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
            if (sockets.getKey().isConnected()) {
                System.out.println("closed");
                $_Server.getOnline_clients().remove(new Pair<>(jsonObject.getString("Id"), sockets));
            } else System.out.println("aaaa");
        }
    }

    @Override
    public void excute() {

    }
}
