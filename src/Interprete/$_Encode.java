package Interprete;

import JSONData.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

/**
 *
 */
public class $_Encode extends $_Interprete {

    /**
     * Default constructor
     */
    public $_Encode() {
    }

    @Override
    public Object run() {
        return null;
    }

    public List<JSONObject> run(List<$_JSON> ourListJSON) {

        List<JSONObject> ListJSONObjectToSend = new ArrayList<>();
        int i = 0;
        for ($_JSON js : ourListJSON) {
            switch (js.getType()) {
                case "Login_User_Successful": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.IdRecive.toString(), (($_JSON_Login_Successful) js).getIdReceived())
                            .put($_JSONAttributes.Type.toString(), "Login_User_Successful")
                            .put($_JSONAttributes.Done.toString(), (($_JSON_Login_Successful) js).isDone());
                    ListJSONObjectToSend.add(temp);
                }
                break;
                case "Sign_Up_Successful": {

                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.IdRecive.toString(), (($_JSON_SignUp_Successful) js).getIdReceived())
                            .put($_JSONAttributes.Type.toString(), "Sign_Up_Successful")
                            .put($_JSONAttributes.Done.toString(), (($_JSON_SignUp_Successful) js).isDone());
                    ListJSONObjectToSend.add(temp);

                }
                break;

                case "Sign_Up_Tow_Successful": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.IdRecive.toString(), (($_JSON_SignUp_Tow_Successful) js).getIdReceived())
                            .put($_JSONAttributes.Type.toString(), "Sign_Up_Tow_Successful")
                            .put($_JSONAttributes.Done.toString(), (($_JSON_SignUp_Tow_Successful) js).isDone())
                            .put("Password", (($_JSON_SignUp_Tow_Successful) js).getState())
                            .put("Image", (($_JSON_SignUp_Tow_Successful) js).getByteBuffer());
                    ListJSONObjectToSend.add(temp);

                }
                break;
                case "Message_Text": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Message_Text")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Message) js).getIdTo())
                            .put("Message", (($_JSON_Message_Text) js).getMessage())
                            .put("MType", (($_JSON_Message_Text) js).getMType())
                            .put("Time", (($_JSON_Message_Text) js).getTime())
                            .put($_JSONAttributes.User_Name.toString(), (($_JSON_Message_Text) js).getUsername())

                            .put($_JSONAttributes.Id.toString(), (($_JSON_Message_Text) js).getIdFrom());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Message_Image": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Message_Image")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Message_Image) js).getIdTo())
                            .put("Message", (($_JSON_Message_Image) js).getBytes());
                    if (i == ourListJSON.size() - 1) {
                        temp.put("MType", "R");
                    } else
                        temp.put("MType", (($_JSON_Message_Image) js).getMType());
                    temp.put($_JSONAttributes.User_Name.toString(), (($_JSON_Message_Image) js).getUsername())
                            .put($_JSONAttributes.Id.toString(), (($_JSON_Message_Image) js).getIdFrom());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Search_User_Successful": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Search_User_Successful")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Search_User_Successful) js).getIdReceived())
                            .put($_JSONAttributes.Done.toString(), (($_JSON_Search_User_Successful) js).isDone())
                            .put("Ids", new JSONArray((($_JSON_Search_User_Successful) js).getIds()))
                            .put("Users_Name", new JSONArray((($_JSON_Search_User_Successful) js).getUsers_Name()))
                            .put("State_Users", new JSONArray((($_JSON_Search_User_Successful) js).getState_users()));

                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Friend_Request": {
                    System.out.println((($_JSON_Friend_Request) js).getId_user());
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Friend_Request")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Friend_Request) js).getIdReceived())
                            .put($_JSONAttributes.Id_Friend_Request.toString(), (($_JSON_Friend_Request) js).getId_user())
                            .put($_JSONAttributes.user_friend_request.toString(), (($_JSON_Friend_Request) js).getUser_friend_request());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Add_Friend_Response": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Add_Friend_Response")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Add_Friend_Response) js).getIdReceived())
                            .put($_JSONAttributes.Done.toString(), (($_JSON_Add_Friend_Response) js).isDone())
                            .put($_JSONAttributes.Add_Friend_Id.toString(), (($_JSON_Add_Friend_Response) js).getId_user());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Friend_Refusal_Request": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Friend_Refusal_Request")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Friend_Refusal_Request) js).getIdReceived())
                            .put($_JSONAttributes.Id_Friend_Refusal_Request.toString(), (($_JSON_Friend_Refusal_Request) js).getId_user())
                            .put($_JSONAttributes.user_friend_request.toString(), (($_JSON_Friend_Refusal_Request) js).getUser_friend_request());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Refusal_Friend_Response": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Refusal_Friend_Response")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Refusal_Friend_Response) js).getIdReceived())
                            .put($_JSONAttributes.Done.toString(), (($_JSON_Refusal_Friend_Response) js).isDone())
                            .put($_JSONAttributes.Refusal_Friend_Id.toString(), (($_JSON_Refusal_Friend_Response) js).getId_user());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Accept_Friend_Response": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Accept_Friend_Response")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Accept_Friend_Respons) js).getIdReceived())
                            .put($_JSONAttributes.Done.toString(), (($_JSON_Accept_Friend_Respons) js).isDone())
                            .put($_JSONAttributes.Accept_Friend_Id.toString(), (($_JSON_Accept_Friend_Respons) js).getId_user());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Friend_Accept_Response": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Friend_Accept_Response")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Friend_Accept_Response) js).getIdReceived())
                            .put($_JSONAttributes.Id_Friend_Accept_Response.toString(), (($_JSON_Friend_Accept_Response) js).getId_user())
                            .put($_JSONAttributes.user_friend_request.toString(), (($_JSON_Friend_Accept_Response) js).getUser_friend_request());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Remove_Friend_Response": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Remove_Friend_Response")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Remove_Friend_Response) js).getIdReceived())
                            .put($_JSONAttributes.Done.toString(), (($_JSON_Remove_Friend_Response) js).isDone())
                            .put($_JSONAttributes.Remove_Friend_Id.toString(), (($_JSON_Remove_Friend_Response) js).getId_user());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Friend_Remove_Response": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Friend_Remove_Response")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Friend_Remove) js).getIdReceived())
                            .put($_JSONAttributes.Id_Friend_Remove_Response.toString(), (($_JSON_Friend_Remove) js).getId_user())
                            .put($_JSONAttributes.user_friend_request.toString(), (($_JSON_Friend_Remove) js).getUser_friend_request());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Remove_Request_Response": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Remove_Request_Response")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Remove_Request_Response) js).getIdReceived())
                            .put($_JSONAttributes.Done.toString(), (($_JSON_Remove_Request_Response) js).isDone())
                            .put($_JSONAttributes.Remove_Request_Id.toString(), (($_JSON_Remove_Request_Response) js).getId_user());
                    ListJSONObjectToSend.add(temp);
                    break;
                }
                case "Friend_Remove_Request": {
                    JSONObject temp = new JSONObject();
                    temp.put($_JSONAttributes.Type.toString(), "Friend_Remove_Request")
                            .put($_JSONAttributes.IdRecive.toString(), (($_JSON_Friend_Remove_Request) js).getIdReceived())
                            .put($_JSONAttributes.Id_Request_Remove_Response.toString(), (($_JSON_Friend_Remove_Request) js).getId_user())
                            .put($_JSONAttributes.user_friend_request.toString(), (($_JSON_Friend_Remove_Request) js).getUser_friend_request());
                    ListJSONObjectToSend.add(temp);
                    break;
                }


            }

            i++;
        }

        return ListJSONObjectToSend;
    }

}