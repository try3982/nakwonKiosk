package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class choiceUpgrade {
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Image selectedImage;
	private String selectedName;
	
	public void initData(Image selectedImage, String selectedName) {
        this.selectedImage = selectedImage;
        this.selectedName = selectedName;
    }
	
	public void switchToUpg(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Upg.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void switchToCart(ActionEvent event) throws IOException{
		if (selectedImage != null && selectedName != null) {
            // 장바구니에 상품 추가
            startController.ProductItem productItem = new startController.ProductItem(selectedImage, selectedName);
            // startController 클래스의 장바구니 리스트에 상품 추가
            startController.getInstance().getCartItems().add(productItem);
    
		}
		startController controller = new startController();
        controller.switchToRecommand(event);
	}
	
}
