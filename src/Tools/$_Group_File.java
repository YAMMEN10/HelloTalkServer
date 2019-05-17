package Tools;


import Room.$_Client;
import Room.$_Group;

import java.io.*;
import java.util.ArrayList;

public class $_Group_File extends $_Storage{
    //--------------------------------------------Attribute's------------------------------------------------------//
    private String folder_group_name = "Groups";
    private String groups_path = storage_path + File.separator + folder_group_name;
    public String getFolder_group_name() {
        return folder_group_name;
    }
    public void setFolder_group_name(String folder_group_name) {
        this.folder_group_name = folder_group_name;
    }
    public String getGroups_path() {
        return groups_path;
    }
    public void setGroups_path(String groups_path) {
        this.groups_path = groups_path;
    }

    //--------------------------------------------Method's------------------------------------------------------//
    @Override
    public boolean add(Object group) throws IOException {
        $_Group my_group = ($_Group) group ;
        String file_name =  my_group.getGroup_information().getID() ;
        if(isExist(file_name ))return false ;
        File client_file = new File(groups_path + File.separator+ file_name+ ".cl");
        ObjectOutputStream out = null;  ;
        try {
            out = new ObjectOutputStream(new FileOutputStream(client_file)) ;
            out.writeObject(my_group);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
        return true ;

    }
    //--------------------------------------------------------------------------------------------------//
    @Override
        public boolean update(Object group) throws IOException {
            $_Group my_group = ($_Group) group ;
            String id = my_group.getGroup_information().getID() ;
            if(!isExist(id))return false ;
            delete(id) ;
            add(group) ;
            return true;
        }
    //--------------------------------------------------------------------------------------------------//
        @Override
        public boolean delete(String id) {
            if(!isExist(id))return false ;
            File group_file = new File(storage_path + File.separator + id + ".cl");
            group_file.delete() ;
            return true;
        }
    //--------------------------------------------------------------------------------------------------//
        @Override
        public boolean isExist(String file_name) {
            File group_folder = new File(groups_path) ;
            for(File client : group_folder.listFiles())
            {
                if(client.getName().equals(file_name))return true ;
            }
            return false;
        }
    //--------------------------------------------------------------------------------------------------//
    @Override
        public Object get(String id) throws IOException {
            $_Group client = null ;
            if(!isExist(id))return null ;
            File group_folder = new File(groups_path + File.separator + id + ".cl");
            ObjectInputStream in = null;  ;
            try {
                in = new ObjectInputStream(new FileInputStream(group_folder)) ;
                client = ($_Group) in.readObject() ;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally{
                in.close();
            }
            return client ;
        }

    @Override
    public ArrayList<$_Client> getIdOfUserName(String id) {
        return null;
    }

}
