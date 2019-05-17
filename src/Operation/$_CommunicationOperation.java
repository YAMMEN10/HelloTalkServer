package Operation;

import JSONData.$_JSON;

import java.util.*;

/**
 * 
 */
public  abstract class $_CommunicationOperation extends $_NetworkOperation {

    /**
     * Default constructor
     */
    public $_CommunicationOperation() {
    }

    @Override
    public abstract List<$_JSON> excuteOperation() ;

}