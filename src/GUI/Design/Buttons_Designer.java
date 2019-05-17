package GUI.Design;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static GUI.Design.Button_Style.List_Element_Style;

public class Buttons_Designer extends Element_Designer {

    public void AddStyle(Button element, Button_Style element_style) {
        switch (element_style)
        {
            case  List_Element_Style:
            {
                List_Element_Button(element);
                break ;
            }
            default: break;
        }
    }
    public void test()
    {
        System.out.println(getClass().getResource("Images/person.jpg")) ;
    }

    public void List_Element_Button(Button element)
    {

        element.setPrefWidth(1110);
        element.setBorder(new Border(new BorderStroke(Color.web("#ffffff"), BorderStrokeStyle.SOLID,null,null)));
        element.setBackground(new Background(new BackgroundFill(Color.web("#1d1d1d"),null,null)));
        element.setTextFill(Color.WHITE);
        element.setFont(Font.font("Comic Sans MS", FontWeight.BOLD,13));
    }
}
