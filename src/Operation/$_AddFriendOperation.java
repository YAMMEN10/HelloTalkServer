package Operation;

import JSONData.$_JSON;
import JSONData.$_JSON_Add_Friend;
import JSONData.$_JSON_Add_Friend_Response;
import JSONData.$_JSON_Friend_Request;
import Room.$_Client;
import Tools.$_Client_File;

import java.io.IOException;
import java.util.List;

public class $_AddFriendOperation extends  $_Operation {
    @Override
    public List<$_JSON> excuteOperation() throws IOException {
        $_JSON_Add_Friend add_friend=($_JSON_Add_Friend)my_json;
        $_JSON_Friend_Request friend_request=new $_JSON_Friend_Request("Friend_Request",add_friend.getIdTo(),add_friend.getIdFrom(),add_friend.getUser_name());
        $_JSON_Add_Friend_Response add_friend_response=new $_JSON_Add_Friend_Response("Add_Friend_Response",add_friend.getIdFrom(),true,add_friend.getIdTo());
        $_Client_File client_file=new $_Client_File();
        $_Client client_Id= ($_Client) client_file.get(add_friend.getIdFrom());
        $_Client client_Add_Id=($_Client)client_file.get(add_friend.getIdTo());
        if(client_Id!=null)
        {
            client_Id.getOutstanding_Sent_Friendship_Requests().add(add_friend.getIdTo());
            System.out.println(client_Id.getOutstanding_Sent_Friendship_Requests());
        }
        if(client_Add_Id!=null)
        {

            client_Add_Id.getOutstanding_Friendship_Requests().add(add_friend.getIdFrom());
        }
        client_file.update(client_Id);
        client_file.update(client_Add_Id);
        list_my_json.add(friend_request);
        list_my_json.add(add_friend_response);

        return list_my_json;
    }
}
