package Operation;

import JSONData.*;
import Room.$_Client;
import Tools.$_Client_File;

import java.io.IOException;
import java.util.List;

public class $_RefusalOperation extends $_Operation {
    @Override
    public List<$_JSON> excuteOperation() throws IOException {
        $_JSON_Refusal_Friend add_friend=($_JSON_Refusal_Friend)my_json;
        $_JSON_Friend_Refusal_Request friend_refusal_request=new $_JSON_Friend_Refusal_Request("Friend_Refusal_Request",add_friend.getIdTo(),add_friend.getIdFrom(),add_friend.getUser_name());
        $_JSON_Refusal_Friend_Response Refusal_friend_response=new $_JSON_Refusal_Friend_Response("Refusal_Friend_Response",add_friend.getIdFrom(),true,add_friend.getIdTo());
        $_Client_File client_file=new $_Client_File();
        $_Client client_Id= ($_Client) client_file.get(add_friend.getIdFrom());
        $_Client client_Refusal_Id=($_Client)client_file.get(add_friend.getIdTo());
        if(client_Id!=null)
        {
            client_Id.getOutstanding_Friendship_Requests().remove(add_friend.getIdTo());
            System.out.println(client_Id.getOutstanding_Sent_Friendship_Requests());
        }
        if(client_Refusal_Id!=null)
        {

            client_Refusal_Id.getOutstanding_Sent_Friendship_Requests().remove(add_friend.getIdFrom());
        }
        client_file.update(client_Id);


        client_file.update(client_Refusal_Id);
        list_my_json.add(friend_refusal_request);
        list_my_json.add(Refusal_friend_response);

        return list_my_json;
    }
}
