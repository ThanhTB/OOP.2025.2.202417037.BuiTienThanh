package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    private Store store;
    private Cart cart;

    public CartController(Store store, Cart cart){
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory; 

    @FXML
    private TableColumn<Media, Float> colMediaCost;     

    @FXML
    private TableColumn<Media, Integer> colMediaId;      

    @FXML
    private TableColumn<Media, String> colMediaTitle;  

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            // Tạo một pop-up Alert thông báo đang phát media
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("Playing Media");
            alert.setHeaderText("Playing: " + media.getTitle());
            alert.showAndWait();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
                fxmlLoader.setController(new ViewStoreController(store, cart));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Cart");
                stage.show();       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    public void initialize(){
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getFilteredItems() != null) {
            tblMedia.setItems(cart.getFilteredItems());
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                updateButtonBar((Media) newValue); // Ép kiểu ngược lại về Media khi truyền vào hàm
            }            
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        // Khởi tạo giá trị tiền ban đầu
        costLabel.setText(String.format("%.2f $", cart.totalCost()));

        // Tự động cập nhật tiền mỗi khi danh sách giỏ hàng thay đổi
        cart.getFilteredItems().addListener((javafx.collections.ListChangeListener<Media>) c -> {
            costLabel.setText(String.format("%.2f $", cart.totalCost()));
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                applyFilterAndSort(newValue);
            }
        });

        // Tự động cập nhật lại danh sách khi người dùng click chuyển đổi tiêu chí lọc (ID <-> Title)
        radioBtnFilterId.selectedProperty().addListener((opt, oldVal, newVal) -> applyFilterAndSort(tfFilter.getText()));
        radioBtnFilterTitle.selectedProperty().addListener((opt, oldVal, newVal) -> applyFilterAndSort(tfFilter.getText()));
    }

    void updateButtonBar(Media media){
        if(media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            if(media instanceof Playable){
                btnPlay.setVisible(true);
            }
            else{
                btnPlay.setVisible(false);
            }
        }
    }

    void showFilteredMedia(String filterString) {
        // Nếu ô tìm kiếm trống, hiển thị lại toàn bộ danh sách (Predicate luôn đúng)
        if (filterString == null || filterString.isEmpty()) {
            cart.getFilteredItems().setPredicate(media -> true);
            return;
        }

        String lowerCaseFilter = filterString.toLowerCase().trim();

        // Đặt bộ lọc Predicate mới dựa trên RadioButton được chọn
        cart.getFilteredItems().setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                // Lọc theo ID (Chuyển ID thành chuỗi để so sánh chứa ký tự)
                String idString = String.valueOf(media.getId());
                return idString.contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                // Lọc theo Title
                if (media.getTitle() != null) {
                    return media.getTitle().toLowerCase().contains(lowerCaseFilter);
                }
            }
            return false; // Không khớp tiêu chí nào thì ẩn đi
        });
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
            alert.setTitle("Order Warning");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty!");
            alert.showAndWait();
            return;
        }

        // Thông báo đặt hàng thành công
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Order Status");
        alert.setHeaderText(null);
        alert.setContentText("An order has been created successfully!");
        alert.showAndWait();

        // Xóa sạch giỏ hàng
        cart.getItemsOrdered().clear();
    }

    private void applyFilterAndSort(String filterString) {
        // 1. Khởi tạo danh sách chứa các sản phẩm thỏa mãn bộ lọc từ giỏ hàng gốc
        java.util.List<Media> filteredList = new java.util.ArrayList<>();

        if (filterString == null || filterString.isEmpty()) {
            filteredList.addAll(cart.getItemsOrdered());
        } else {
            String lowerCaseFilter = filterString.toLowerCase().trim();
            for (Media media : cart.getItemsOrdered()) {
                if (radioBtnFilterId.isSelected()) {
                    // Lọc theo ID
                    if (String.valueOf(media.getId()).contains(lowerCaseFilter)) {
                        filteredList.add(media);
                    }
                } else if (radioBtnFilterTitle.isSelected()) {
                    // Lọc theo Tiêu đề (Title)
                    if (media.getTitle() != null && media.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                        filteredList.add(media);
                    }
                }
            }
        }

        tblMedia.setItems(null);
        tblMedia.setItems(javafx.collections.FXCollections.observableArrayList(filteredList));
    }
}

