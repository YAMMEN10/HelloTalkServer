package Operation;

import JSONData.$_JSON;
import JSONData.$_JSON_Search_User;
import JSONData.$_JSON_Search_User_Successful;
import JSONData.$_JSON_SignUp;
import Room.$_Client;
import Tools.$_Client_File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class $_SearchUserOperation extends $_Operation {
    @Override
    public List<$_JSON> excuteOperation() throws IOException {

        $_JSON_Search_User Search_User=($_JSON_Search_User) my_json;
        String id = Search_User.getIdFrom() ;
        String Search_User_Name=Search_User.getSearch_User();
        System.out.println("search:"+Search_User_Name);
        $_Client_File cl_file = new $_Client_File() ;
        ArrayList<$_Client> clients=cl_file.getIdOfUserName(Search_User_Name);
        if (clients==null)
        {
            $_JSON_Search_User_Successful json_search_user_successful=new $_JSON_Search_User_Successful("Search_User_Successful",id,false,null,null,null);
            list_my_json.add(json_search_user_successful);
        }
        else {
            ArrayList<String> Ids=new ArrayList<>();
            ArrayList<String> Users_Search=new ArrayList<>();
            ArrayList<String>  state_users=new ArrayList<>();
            for($_Client client:clients)
            {
                if(!client.getClient_information().getID().equals(id)) {
                    Ids.add(client.getClient_information().getID());
                    Users_Search.add(client.getClient_information().getUser_name());
                    if(client.getFreind().contains(id))
                    {
                        state_users.add("Remove");
                    }
                    else if(client.getOutstanding_Friendship_Requests().contains(id))
                    {
                        state_users.add("Remove Request");


                    }
                    else if (client.getOutstanding_Sent_Friendship_Requests().contains(id)){
                        state_users.add("Refusal");

                    }
                    else   {

                        state_users.add("Add");
                    }

                }

            }
            $_JSON_Search_User_Successful json_search_user_successful=new $_JSON_Search_User_Successful("Search_User_Successful",id,true,Ids,Users_Search,state_users);
            list_my_json.add(json_search_user_successful);

        }
        return list_my_json;
    }
}
