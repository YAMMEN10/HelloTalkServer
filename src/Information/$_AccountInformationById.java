package Information;

import java.io.File;
import java.io.Serializable;
import java.util.*;

public class $_AccountInformationById extends $_AccountInformation implements Serializable {

    private String id;

    public $_AccountInformationById(String id ,String state , File picture , String name , String password ,String user_name) {
        super( state ,picture , name , password,user_name ) ;
        this.id = id ;

    }

    @Override
    public String getID() {
        return id;
    }


}