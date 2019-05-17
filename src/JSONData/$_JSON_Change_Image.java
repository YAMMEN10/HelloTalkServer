package JSONData;

public class $_JSON_Change_Image extends $_JSON_Account {
    byte[] image;
    public $_JSON_Change_Image(String type, String idFrom, String user_name, byte[] image) {
        super(type, idFrom, user_name);
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
