package Tools;

import Room.$_Client;

import java.io.*;
import java.util.ArrayList;

public class $_Client_File extends $_Storage {
    //--------------------------------------------Attribute's------------------------------------------------------//
    private String folder_clients_name = "Clients";
    private String clients_path = storage_path + File.separator + folder_clients_name;
    public String getFolder_clients_name() {
        return folder_clients_name;
    }
    public void setFolder_clients_name(String folder_clients_name) {
        this.folder_clients_name = folder_clients_name;
    }
    public String getClients_path() {
        return clients_path;
    }
    public void setClients_path(String clients_path) {
        this.clients_path = clients_path;
    }

    //--------------------------------------------Method's------------------------------------------------------//
    @Override
    public boolean add(Object client) throws IOException {
        $_Client my_client = ($_Client) client;
        String file_name = my_client.getClient_information().getID();
        if (isExist(file_name)) return false;
        File client_file = new File(clients_path + File.separator + file_name + ".cl");
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(client_file));
            out.writeObject(my_client);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
        return true;

    }

    //--------------------------------------------------------------------------------------------------//
    @Override
    public boolean update(Object client) throws IOException {
        $_Client my_client = ($_Client) client;
        String id = my_client.getClient_information().getID();
        if (!isExist(id)) return false;
        delete(id);
        add(my_client);
        return true;
    }

    //--------------------------------------------------------------------------------------------------//
    @Override
    public boolean delete(String id) {
        if (!isExist(id)) return false;
        File client_file = new File(clients_path + File.separator + id + ".cl");
        client_file.delete();
        return true;
    }

    //--------------------------------------------------------------------------------------------------//
    @Override
    public boolean isExist(String file_name) {
        File client_folder = new File(clients_path);
        for (File client : client_folder.listFiles()) {
            if (client.getName().equals(file_name + ".cl")) return true;
        }
        return false;
    }

    @Override
    public ArrayList<$_Client> getIdOfUserName(String user_name) {
        File client_folder = new File(clients_path);
        ArrayList<$_Client> clients = new ArrayList<>();
        for (File client : client_folder.listFiles()) {
            File client_file = new File(clients_path + File.separator + client.getName());
            System.out.println("path = " + clients_path + File.separator + client.getName());
            if (client_file == null) {
                System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");}
                ObjectInputStream in = null;
                try {
                    in = new ObjectInputStream(new FileInputStream(client_file));
                    $_Client clientobj = ($_Client) in.readObject();
                    System.out.println(clientobj.getClient_information().getUser_name());
                    if (clientobj.getClient_information().getUser_name().startsWith(user_name)) {
                        clients.add(clientobj);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return clients;
}
        




    //--------------------------------------------------------------------------------------------------//
    @Override
    public Object get(String id) throws IOException {
        $_Client client = null;
        if (!isExist(id)) return null;
        File client_file = new File(clients_path + File.separator + id + ".cl");
        ObjectInputStream in = null;
        ;
        try {
            in = new ObjectInputStream(new FileInputStream(client_file));
            client = ($_Client) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return client;
    }

    public Object get(File client_file) throws IOException {

        if(client_file == null)return null ;
        $_Client client = null;
        ObjectInputStream in = null;
        ;
        try {
            in = new ObjectInputStream(new FileInputStream(client_file));
            client = ($_Client) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return client;
    }
}
