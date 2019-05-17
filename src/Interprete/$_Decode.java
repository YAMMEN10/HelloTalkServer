package Interprete;

import JSONData.*;
import ServerManagment.$_CheckOffline_Message;
import ServerManagment.$_CheckOffline_Online;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.IOException;


/**
 *
 */
public class $_Decode extends $_Interprete {
    /**
     * Default constructor
     */
    public static byte[] bytes;

    public $_Decode(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Object run() {
        // TODO implement here
        switch (jsonObject.getString("Type")) {
            case "Login_User": {
                my_json = new $_JSON_login("Login_User", jsonObject.getString("Id"), jsonObject.getString("Password"));
                break;
            }
            case "Sign_Up":

            {
                System.out.println(jsonObject.getString("User_Name") + "----------------------");
                my_json = new $_JSON_SignUp("Sign_Up", jsonObject.getString("Id"), jsonObject.getString("Password"), jsonObject.getString("User_Name"));
                break;
            }
            case "Sign_Up_Tow":
                my_json = new $_JSON_SignUp_Tow("Sign_Up", jsonObject.getString("Id"), jsonObject.getString("State"), jsonObject.getString("Image"));
                break;
            case "Message_Text": {
                System.out.println("json  = " + jsonObject);
                my_json = new $_JSON_Message_Text("Message_Text", jsonObject.getString("Id"), jsonObject.getString("IdRecive"), jsonObject.getString("MType"), jsonObject.getString("Time"), jsonObject.getString("Message"), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                break;
            }
            case "Message_Image": {
                my_json = new $_JSON_Message_Image("Message_Image", jsonObject.getString("Id"), jsonObject.getString("IdRecive"), jsonObject.getString("MType"),jsonObject.getString("Time"), (Object)jsonObject.get("Message"), jsonObject.getString($_JSONAttributes.User_Name.toString()));
                try {
                    bytes = new byte[Integer.parseInt((($_JSON_Message_Image) my_json).getBytes().toString())];
                    DataInputStream dataInputStream = new DataInputStream($_CheckOffline_Message.staticsocketMessage.getInputStream());
                    dataInputStream.readFully(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "Search_Of_User":
            {
                my_json=new $_JSON_Search_User("Search_Of_User",jsonObject.getString($_JSONAttributes.Id.toString()),jsonObject.getString($_JSONAttributes.Search_User.toString()));
                break;
            }
            case  "Add_friend":

            {
                System.out.println(jsonObject.getString($_JSONAttributes.Add_Friend_Id.toString()));
                my_json=new $_JSON_Add_Friend("Add_friend",jsonObject.getString($_JSONAttributes.Id.toString()),jsonObject.getString($_JSONAttributes.User_Name.toString()),jsonObject.getString($_JSONAttributes.Add_Friend_Id.toString()));
                break;
            }
            case "Refusal_friend":
            {
                my_json=new $_JSON_Refusal_Friend( "Refusal_friend",jsonObject.getString($_JSONAttributes.Id.toString()),jsonObject.getString($_JSONAttributes.User_Name.toString()),jsonObject.getString($_JSONAttributes.Refusal_Friend_Id.toString()));
                break;
            }
            case "Accept_Friend":
            {
                my_json=new $_JSON_Accept_Friend( "Accept_Friend",jsonObject.getString($_JSONAttributes.Id.toString()),jsonObject.getString($_JSONAttributes.User_Name.toString()),jsonObject.getString($_JSONAttributes.Accept_Friend_Id.toString()));
                break;
            }
            case "Remove_Friend":
            {
                my_json=new $_JSON_Remove_Friend( "Remove_Friend",jsonObject.getString($_JSONAttributes.Id.toString()),jsonObject.getString($_JSONAttributes.User_Name.toString()),jsonObject.getString($_JSONAttributes.Remove_Friend_Id.toString()));
                break;
            }
            case "Remove_Request":
            {
                my_json=new $_JSON_Remove_Request( "Remove_Request",jsonObject.getString($_JSONAttributes.Id.toString()),jsonObject.getString($_JSONAttributes.User_Name.toString()),jsonObject.getString($_JSONAttributes.Remove_Request_Id.toString()));

                break;
            }
            default:
                break;
        }
        return my_json;
    }


}