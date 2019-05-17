package Room;

import Information.$_GroupInformation;

import java.io.Serializable;
import java.util.*;

/**
 *
 */
public class $_Group implements Serializable {

    public $_Group() {
    }
    private  $_GroupInformation group_information;

    private List<$_Client> clients;


    public $_GroupInformation getGroup_information() {
        return group_information;
    }

    public void setGroup_information($_GroupInformation group_information) {
        this.group_information = group_information;
    }

    public List<$_Client> getClients() {
        return clients;
    }

    public void setClients(List<$_Client> clients) {
        this.clients = clients;
    }
}