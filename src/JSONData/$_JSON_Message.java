package JSONData;

import Operation.$_MessageTextOperation;
import Operation.$_Operation;

public abstract class $_JSON_Message  extends  $_JSON_Comunication{


   // private  String message;
    //private byte[] bytes;
   protected String MType;
protected  String time;
protected String username;
    public $_JSON_Message(String type, String idFrom, String idTo,String MType, String time, String username) {
        super(type, idFrom, idTo);
      //  this.message=message;
        //this.bytes = bytes;
        this.MType = MType;
        this.time = time;
        this.username = username;
    }

    public String getMType() {
        return MType;
    }

    public void setMType(String MType) {
        this.MType = MType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
