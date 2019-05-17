package Server;

import ServerManagment.$_CheckOnline;
import javafx.util.Pair;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 *
 */
public class $_Server   {


    /**
     * Default constructor
     */
    public $_Server() {
    }
    public static ServerSocket server_socker;
    public static Map<String, Pair<Queue<JSONObject>,Pair<Socket, Socket>>> state_clients;
    public static List<Pair<String,Pair<Socket, Socket>> > online_clients;
    public $_CheckOnline check_online;
    public  final int SERVER_PORT = 5000;

    public synchronized static Map<String, Pair<Queue<JSONObject>,Pair<Socket, Socket>>> getState_clients() {
        return state_clients;
    }

    public synchronized static List<Pair<String, Pair<Socket, Socket>>> getOnline_clients() {
        return online_clients;
    }

    public void initServer(){
        try {
            online_clients = new ArrayList<>();
            state_clients = new HashMap<>();
            File file=new File("DataBase") ;
            file.mkdir() ;
            file=new File("DataBase/Clients") ;
            file.mkdir();
            file=new File("DataBase/Groups") ;
            file.mkdir();

            server_socker = new ServerSocket(SERVER_PORT);
            System.out.println("Server Running...");
            check_online = new $_CheckOnline();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runServer() {
        // TODO implement here
        initServer();
    }



}