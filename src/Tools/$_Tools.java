package Tools;

import Room.$_Client;

import java.io.IOException;
import java.util.ArrayList;

interface  $_Tools {

    boolean update(Object object) throws IOException;
    boolean add(Object object) throws IOException;
    boolean delete(String id) ;
    boolean isExist(String file_name) ;
    Object get(String id) throws IOException;
    ArrayList<$_Client> getIdOfUserName(String id);
}
