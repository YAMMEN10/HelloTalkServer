package Information;

import java.io.File;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public abstract class $_Information implements Serializable {

    public $_Information() {
    }

    protected String state ;
    protected File picture ;
    protected String name ;
    protected  String user_name;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public abstract String getID() ;

}