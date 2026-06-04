package hust.soict.hedspi.aims.screen.customer.controller;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Cart cart;
    public void setCart(Cart cart){
        this.cart = cart;
    }

    @FXML
    private Button btnAddtoCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        try {
            cart.addMedia(media);
            
            // Thông báo thành công
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cart Update");
            alert.setHeaderText(null);
            alert.setContentText("The media '" + media.getTitle() + "' has been added to cart.");
            alert.showAndWait();

        } catch (LimitExceededException e) {
            // Thông báo khi giỏ hàng bị đầy
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cart Error");
            alert.setHeaderText("Cart is Full");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        } catch (IllegalArgumentException e) {
            // Thông báo khi sản phẩm đã trùng trong giỏ
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cart Warning");
            alert.setHeaderText("Duplicate Item");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if(media instanceof Playable){
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("Playing Media");
            alert.setHeaderText("Playing: " + media.getTitle());
            alert.showAndWait();
        }
    }

    private Media media;
    public void setData(Media media){
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost()+ " $");
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else{
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddtoCart, new Insets(0, 0, 0, 60));
        }
    }
}

