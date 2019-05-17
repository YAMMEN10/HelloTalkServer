package Operation;

import JSONData.$_JSON;
import JSONData.$_JSON_Message_Image;

import java.util.List;

public class $_MessageImageOperation extends $_CommunicationOperation {
    @Override
    public List<$_JSON> excuteOperation() {
        $_JSON_Message_Image $_json_message = ($_JSON_Message_Image) my_json;
        list_my_json.add($_json_message);
        list_my_json.add(new $_JSON_Message_Image($_json_message.getType(), $_json_message.getIdFrom(), $_json_message.getIdFrom(), $_json_message.getMType(), $_json_message.getTime(), $_json_message.getBytes(), $_json_message.getUsername()));
        list_my_json.add(new $_JSON_Message_Image($_json_message.getType(), $_json_message.getIdFrom(), $_json_message.getIdTo(), "R", $_json_message.getTime(), $_json_message.getBytes(), $_json_message.getUsername()));
        return list_my_json;
    }
}
