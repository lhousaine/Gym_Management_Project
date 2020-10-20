package controller.tarif;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.border.EmptyBorder;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Tarifs;
import model.TarifsImpDat;

public class tarifsController implements Initializable{
    @FXML
    private Button ModifierTarif;
    @FXML
    private BorderPane princpane;
    private Label[] labels;
    private TarifsImpDat tard;
    private GridPane tariftab;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		tard=new TarifsImpDat();
		initialeTarifs();
	}
    @FXML
    void ModifierTarifAction(ActionEvent event) {
    	Stage signup =new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/tarif/ModifierTarifScene.fxml"));
			Scene scene = new Scene(root);
			signup.setScene(scene);
			signup.show();
		
		} catch (IOException e){
			e.printStackTrace();
		}
    }
    void initialeTarifs() {
    	tariftab=new GridPane();
         Label l0=new Label("");l0.setAlignment(Pos.CENTER);
         Label l1=new Label("      Categorie 1");l1.setAlignment(Pos.CENTER);l1.setFont(Font.font(20));
         Label l2=new Label("      Categorie 2");l2.setAlignment(Pos.CENTER);l2.setFont(Font.font(20));
         Label l3=new Label("      Categorie 3");l3.setAlignment(Pos.CENTER);l3.setFont(Font.font(20));
         Label l4=new Label("      Categorie 4");l4.setAlignment(Pos.CENTER);l4.setFont(Font.font(20));
         Label l5=new Label("        1 mois");l5.setAlignment(Pos.CENTER);l5.setFont(Font.font(25));
         Label l6=new Label("        2 mois");l6.setAlignment(Pos.CENTER);l6.setFont(Font.font(25));
         Label l7=new Label("        3 mois");l7.setAlignment(Pos.CENTER);l7.setFont(Font.font(25));
         Label l8=new Label("        6 mois");l8.setAlignment(Pos.CENTER);l8.setFont(Font.font(25));
         Label l9=new Label("        12 mois");l9.setAlignment(Pos.CENTER);l9.setFont(Font.font(25));
         
		tariftab.setStyle("-fx-padding: 10;");
		tariftab.setVgap(5);
		tariftab.setHgap(5);
		tariftab.setPadding(new Insets(15, 0, 15, 0));
    	int numrows=6;
    	int numcols=5;
    	 ColumnConstraints[] columns = new ColumnConstraints[numcols];
    	 RowConstraints[] rows=new RowConstraints[numrows];
 
         for (int i = 0; i < numcols; ++i) {
            columns[i] = new ColumnConstraints();
            columns[i].setHgrow(Priority.ALWAYS) ;  // Allow column to grow
            columns[i].setFillWidth(true);
            tariftab.getColumnConstraints().add(columns[i]);
         }
         for (int i = 0; i < numrows; ++i) {
             rows[i] = new RowConstraints();
             rows[i].setVgrow(Priority.ALWAYS) ;  // Allow column to grow
             rows[i].setFillHeight(true);
             tariftab.getRowConstraints().add(rows[i]);
          }
         int k=0;
         tariftab.add(l0,0,0);
         tariftab.add(l1,1,0);
         tariftab.add(l2,2,0);
         tariftab.add(l3,3,0);
         tariftab.add(l4,4,0);
         tariftab.add(l5,0,1);
         tariftab.add(l6,0,2);
         tariftab.add(l7,0,3);
         tariftab.add(l8,0,4);
         tariftab.add(l9,0,5);
         labels = new Label[20];
         ObservableList<Tarifs> tarifs=tard.SelectTarifs();
         String str="";
         for (int i = 1; i <numrows; ++i){
        	 for (int j = 1; j < numcols; ++j){
        		 if(k<tarifs.size()) {
        			 str=tarifs.get(k).getPrix()+"";
        		 }else {
        			 str="0.0";
        		 }
            labels[k] = new Label(str);
            labels[k].setFont(Font.font(25));
            labels[k].setAlignment(Pos.CENTER);
            labels[k].setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);   // full-width
            tariftab.add(labels[k],j,i);  // control, col, row
            k++;
         }
         }
         princpane.setPadding(new Insets(5,5,5,5));  
         princpane.setCenter(tariftab);
         tariftab.setGridLinesVisible(true);
    }
}
