package JSONData;

public class $_JSON_Friend_Accept_Response extends  $_JSON_Friend_Response {
    public $_JSON_Friend_Accept_Response(String type, String idReceived, String Id_user, String user_friend_request) {
        super(type, idReceived, true, Id_user);
        this.user_friend_request=user_friend_request;
    }
    private  String user_friend_request;

    public String getUser_friend_request() {
        return user_friend_request;
    }

    public void setUser_friend_request(String user_friend_request) {
        this.user_friend_request = user_friend_request;
    }
}
