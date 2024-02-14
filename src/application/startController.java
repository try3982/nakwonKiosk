package application;


import java.io.IOException;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;

import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class startController {
	@FXML
	private ImageView imageView;
	
	@FXML
    private ListView<ProductItem> cartItem;
	
	private Image selectedImage;
	private String selectedName;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private static startController instance;
	
	
    public static startController getInstance() {
        if (instance == null) {
            instance = new startController();
        }
        return instance;
    }
    
    public List<ProductItem> getCartItems() {
        return cartItem.getItems();
    }
    
	//첫 화면에서 포장/메뉴를 선택했을 때 상품 화면으로 가기 위함.
	public void switchToRecommand(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("recommand.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//모든 과정이 마치면 첫 화면으로 돌아가기 위함.
	public void switchToStart(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("startcontrol.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//상품을 선택하면 다음 단계인 업그레이드 / 장바구니 추가 화면으로 이동
	@FXML
	public void switchToUpg() throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("choiceUpg.fxml"));
        Parent root = loader.load();
        
        choiceUpgrade controller = loader.getController();
        controller.initData(selectedImage, selectedName);
        
        // 새로운 화면을 표시합니다.
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // 현재 화면을 닫습니다.
        Stage currentStage = (Stage) imageView.getScene().getWindow();
        currentStage.close();
        
	}
	
	
	public static class ProductItem{
        private final Image image;
        private final String name;

        public ProductItem(Image image, String name) {
            this.image = image;
            this.name = name;
        }

        public Image getImage() {
            return image;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
	
}
