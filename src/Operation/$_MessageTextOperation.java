package Operation;

import JSONData.$_JSON;
import JSONData.$_JSON_Message;
import JSONData.$_JSON_Message_Text;

import java.util.List;

public class $_MessageTextOperation extends  $_CommunicationOperation{


    @Override
    public List<$_JSON> excuteOperation() {
        $_JSON_Message_Text $_json_message=($_JSON_Message_Text) my_json;
        list_my_json.add($_json_message);
        list_my_json.add(new $_JSON_Message_Text($_json_message.getType(),$_json_message.getIdFrom(),$_json_message.getIdFrom(), $_json_message.getMType(),$_json_message.getTime(),  $_json_message.getMessage(), $_json_message.getUsername()));

        return list_my_json;
    }
}
