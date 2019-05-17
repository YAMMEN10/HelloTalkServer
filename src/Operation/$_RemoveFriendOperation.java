package Operation;

import JSONData.*;
import Room.$_Client;
import Tools.$_Client_File;

import java.io.IOException;
import java.util.List;

public class $_RemoveFriendOperation extends $_Operation{
    @Override
    public List<$_JSON> excuteOperation() throws IOException {
        $_JSON_Remove_Friend add_friend=($_JSON_Remove_Friend)my_json;
        $_JSON_Remove_Friend_Response remove_friend_respons=new $_JSON_Remove_Friend_Response("Remove_Friend_Response",add_friend.getIdFrom(),true,add_friend.getIdTo());
        $_JSON_Friend_Remove remove_friend_respons1=new $_JSON_Friend_Remove("Friend_Remove_Response",add_friend.getIdTo(),add_friend.getIdFrom(),add_friend.getUser_name());
        $_Client_File client_file=new $_Client_File();
        $_Client client_Id= ($_Client) client_file.get(add_friend.getIdFrom());
        $_Client client_Add_Id=($_Client)client_file.get(add_friend.getIdTo());
        if(client_Id!=null)
        {
            client_Id.getFreind().remove(add_friend.getIdTo());
            System.out.println(client_Id.getOutstanding_Sent_Friendship_Requests());
        }
        if(client_Add_Id!=null)
        {

            client_Add_Id.getFreind().remove(add_friend.getIdFrom());
        }
        client_file.update(client_Id);
        client_file.update(client_Add_Id);
        list_my_json.add(remove_friend_respons);
        list_my_json.add(remove_friend_respons1);

        return list_my_json;
    }
}
