package Operation;

import JSONData.*;
import Room.$_Client;
import Tools.$_Client_File;

import java.io.IOException;
import java.util.List;

public class $_RemoveRequestOperation extends $_Operation {
    @Override
    public List<$_JSON> excuteOperation() throws IOException {
        $_JSON_Remove_Request add_friend=($_JSON_Remove_Request)my_json;
        $_JSON_Remove_Request_Response remove_request_response=new $_JSON_Remove_Request_Response("Remove_Request_Response",add_friend.getIdFrom(),true,add_friend.getIdTo());
        $_JSON_Friend_Remove_Request remove_request_respons1=new $_JSON_Friend_Remove_Request("Friend_Remove_Request",add_friend.getIdTo(),add_friend.getIdFrom(),add_friend.getUser_name());
        $_Client_File client_file=new $_Client_File();
        $_Client client_Id= ($_Client) client_file.get(add_friend.getIdFrom());
        $_Client client_Add_Id=($_Client)client_file.get(add_friend.getIdTo());
        if(client_Id!=null)
        {
            client_Id.getOutstanding_Sent_Friendship_Requests().remove(add_friend.getIdTo());
            System.out.println(client_Id.getOutstanding_Sent_Friendship_Requests());
        }
        if(client_Add_Id!=null)
        {

            client_Add_Id.getOutstanding_Friendship_Requests().remove(add_friend.getIdFrom());
        }
        client_file.update(client_Id);
        client_file.update(client_Add_Id);
        list_my_json.add(remove_request_response);
        list_my_json.add(remove_request_respons1);

        return list_my_json;
    }
}
