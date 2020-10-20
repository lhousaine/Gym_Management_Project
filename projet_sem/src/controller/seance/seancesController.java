package controller.seance;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Tarifs;
import model.TarifsImpDat;
import model.seance;
import model.seancedaoimp;

public class seancesController  implements Initializable{
	     @FXML
	    private BorderPane princpane;
	     private Label[] labels;
	     private GridPane emploistab;
	     @FXML
	     private Button modseance;
	     seancedaoimp sd;
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			     emploistab=new GridPane();
			     sd=new seancedaoimp();
			     labels=new Label[28];
			     Label l=new Label("");l.setAlignment(Pos.CENTER);
		         Label l0=new Label("    Lundi");l0.setAlignment(Pos.CENTER);l0.setFont(Font.font(20));
		         Label l1=new Label("    Mardi");l1.setAlignment(Pos.CENTER);l1.setFont(Font.font(20));
		         Label l2=new Label("    Mercredi");l2.setAlignment(Pos.CENTER);l2.setFont(Font.font(20));
		         Label l3=new Label("    Jeudi");l3.setAlignment(Pos.CENTER);l3.setFont(Font.font(20));
		         Label l4=new Label("    Vendredi");l4.setAlignment(Pos.CENTER);l4.setFont(Font.font(20));
		         Label l5=new Label("    Samedi");l5.setAlignment(Pos.CENTER);l5.setFont(Font.font(20));
		         Label l6=new Label("    Dimanche");l6.setAlignment(Pos.CENTER);l6.setFont(Font.font(20));
		         Label l7=new Label("    09-12");l7.setAlignment(Pos.CENTER);l7.setFont(Font.font(20));
		         Label l8=new Label("    13-16");l8.setAlignment(Pos.CENTER);l8.setFont(Font.font(20));
		         Label l9=new Label("    16-19");l9.setAlignment(Pos.CENTER);l9.setFont(Font.font(20));
		         Label l10=new Label("   19-22");l10.setAlignment(Pos.CENTER);l10.setFont(Font.font(20));
		         emploistab.setVgap(5);
		         emploistab.setHgap(5);
		         int numrows=5;
		     	int numcols=8;
		     	 ColumnConstraints[] columns = new ColumnConstraints[numcols];
		    	 RowConstraints[] rows=new RowConstraints[numrows];
		         for (int i = 0; i < numcols; ++i) {
		            columns[i] = new ColumnConstraints();
		            columns[i].setHgrow(Priority.ALWAYS) ;  //Allow column to grow
		            columns[i].setFillWidth(true);
		            emploistab.getColumnConstraints().add(columns[i]);
		         }
		         for (int i = 0; i < numrows; ++i) {
		             rows[i] = new RowConstraints();
		             rows[i].setVgrow(Priority.ALWAYS) ;  //Allow column to grow
		             rows[i].setFillHeight(true);
		             emploistab.getRowConstraints().add(rows[i]);
		          }
		         int k=0;
		         emploistab.add(l,0,0);
		         emploistab.add(l0,1,0);
		         emploistab.add(l1,2,0);
		         emploistab.add(l2,3,0);
		         emploistab.add(l3,4,0);
		         emploistab.add(l4,5,0);
		         emploistab.add(l5,6,0);
		         emploistab.add(l6,7,0);
		         emploistab.add(l7,0,1);
		         emploistab.add(l8,0,2);
		         emploistab.add(l9,0,3);
		         emploistab.add(l10,0,4);
		         //remplir le tableau de seances
		         ObservableList<seance> seances=sd.seanceslist();
		         String str="";
		         for (int i = 1; i <numrows; ++i){
		        	 for (int j = 1; j < numcols; ++j){
		        		 if(k<seances.size()) {
		        			 str=seances.get(k).getSports()+"";
		        		 }else {
		        			 str="aucun Sport";
		        		 }
		            labels[k] = new Label(str);
		            labels[k].setFont(Font.font(15));
		            labels[k].setAlignment(Pos.CENTER);
		            labels[k].setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);   // full-width
		            emploistab.add(labels[k],j,i);  // control, col, row
		            k++;
		         }
		         }
		         princpane.setPadding(new Insets(5,5,5,5));  
		         princpane.setCenter(emploistab);
		         emploistab.setGridLinesVisible(true);
		}
	     @FXML
	     void ModifierAction(ActionEvent event) {
	    		Stage signup =new Stage();
	    		try {
	    			Parent root = FXMLLoader.load(getClass().getResource("/view/seances/ModifierSeance.fxml"));
	    			Scene scene = new Scene(root);
	    			signup.setScene(scene);
	    			signup.show();
	    		} catch (IOException e){
	    			e.printStackTrace();
	    		}
	     }
}
