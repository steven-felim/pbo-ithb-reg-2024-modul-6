package view.panels;

import javax.swing.*;
import java.awt.*;

public class ShowImage {
    public JLabel createShowImage(String path, String type){
        ImageIcon imageIcon = new ImageIcon(path);
        Image originalImage = imageIcon.getImage();
        Image scaledImage = originalImage;

        if(type.equals("pasFoto")){
            scaledImage = originalImage.getScaledInstance(200, 280, Image.SCALE_SMOOTH);
        } else {
            scaledImage = originalImage.getScaledInstance(200, 70, Image.SCALE_SMOOTH);
        }

        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(scaledIcon);
        label.setVisible(true);
        return label;
    }
}
