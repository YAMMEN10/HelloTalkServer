package Room;

import Information.$_AccountInformation;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class $_Client implements Serializable {

    private $_AccountInformation client_information;
    private List<$_Group> groups;
    private List<String> freind;
    private List<String> Outstanding_Friendship_Requests;
    private List<String> Outstanding_Sent_Friendship_Requests;

    public List<String> getFreind() {
        return freind;
    }

    public void setFreind(List<String> freind) {
        this.freind = freind;
    }

    public List<String> getOutstanding_Friendship_Requests() {
        return Outstanding_Friendship_Requests;
    }

    public void setOutstanding_Friendship_Requests(List<String> outstanding_Friendship_Requests) {
        Outstanding_Friendship_Requests = outstanding_Friendship_Requests;
    }

    public List<String> getOutstanding_Sent_Friendship_Requests() {
        return Outstanding_Sent_Friendship_Requests;
    }

    public void setOutstanding_Sent_Friendship_Requests(List<String> outstanding_Sent_Friendship_Requests) {
        Outstanding_Sent_Friendship_Requests = outstanding_Sent_Friendship_Requests;
    }

    public $_Client($_AccountInformation account_info , List<$_Group> groups ,List<String> freind,List<String> Outstanding_Friendship_Requests, List<String> Outstanding_Sent_Friendship_Requests){
        client_information = account_info ;
        this.groups = groups ;
        this.freind=freind;
        this.Outstanding_Friendship_Requests=Outstanding_Friendship_Requests;
        this.Outstanding_Sent_Friendship_Requests=Outstanding_Sent_Friendship_Requests;

    }

    public $_AccountInformation getClient_information() {
        return client_information;
    }

    public void setClient_information($_AccountInformation client_information) {
        this.client_information = client_information;
    }
}