package Information;

import java.io.File;
import java.io.Serializable;
import java.util.*;

/**
 *
 */
public abstract  class $_AccountInformation extends $_Information implements Serializable {

    public $_AccountInformation(String state , File picture , String name , String password ,String user_name) {

        this.state = state ;
        this.picture = picture ;
        this.name = name ;
        this.password = password ;
        this.user_name=user_name;
    }

    private String password;


}