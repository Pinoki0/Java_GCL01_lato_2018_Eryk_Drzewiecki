package kursJavaFx;
import javafx.stage.Stage;
import java.util.Calendar;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;


 
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
        Group root = new Group();
        Scene scene = new Scene(root, 700,600, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
        launchClock(root);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void launchClock(Group root) {
        
    //	TableView table = new TableView();
    	 Line line[] = new Line[60]; 
        Group group = new Group();	
        //grupa rozszerza Parent
        
        
        for (double s = 1.0; s <= 60; s = s + 1.0) {
            if (s % 5 == 0) {
                line[(int) s - 1] = new Line(
                        200.0 + 124.0 * Math.cos(s * Math.PI / 30.0),
                        150.0 + 124.0 * Math.sin(s * Math.PI / 30.0),
                        200.0 + 110.0 * Math.cos(s * Math.PI / 30.0),
                        150.0 + 110.0 * Math.sin(s * Math.PI / 30.0)
                );
            } else {														//rysowanie podzia³ek na tarczy
                line[(int) s - 1] = new Line(
                        200.0 + 124.0 * Math.cos(s * Math.PI / 30.0),
                        150.0 + 124.0 * Math.sin(s * Math.PI / 30.0),
                        200.0 + 120.0 * Math.cos(s * Math.PI / 30.0),
                        150.0 + 120.0 * Math.sin(s * Math.PI / 30.0)
                );
          }

            line[(int) s - 1].setStroke(Color.BLACK);
            line[(int) s - 1].setStrokeWidth(4);								//line[i] ustawianie wygl¹du itd
            line[(int) s - 1].setStrokeLineCap(StrokeLineCap.ROUND);
            group.getChildren().add(line[(int) s - 1]);

        }
        
        root.getChildren().add(group);
    	
        Line second= new Line(200,150,200,30);
        Line hour =new Line(200,150,200,30);
        Line minute= new Line(200,150,200,25);
     //Arc(x,y,r,r,rozci¹ga siê od k¹ta k1 do k2)
       final Arc cSec= new Arc(200,150,130,130,90,360);
       final Arc luk=new Arc(200,150,135,135,90,360);
        root.getChildren().addAll(cSec, hour, minute,second,luk);
  
       cSec.setFill(Color.TRANSPARENT);		//setFill odpowiedzialne za wype³nienie (transparent - przezroczyste)
        luk.setFill(Color.TRANSPARENT);
        cSec.setStroke(Color.RED);
        luk.setStroke(Color.BLACK);
  	// setStroke obrys konturu kszta³t
        //definiuje szerokoœæ kwadratowej lini pióra
        cSec.setStrokeWidth(4);
        luk.setStrokeWidth(2);
        second.setStroke(Color.RED);
        hour.setStrokeWidth(4);
       second.setStrokeWidth(4);
       minute.setStrokeWidth(4);
       hour.setStrokeLineCap(StrokeLineCap.ROUND);
       minute.setStrokeLineCap(StrokeLineCap.ROUND);
       second.setStrokeLineCap(StrokeLineCap.ROUND);
  		// defniuje kszta³t lini (round - zaokr¹glona)
        cSec.setStrokeLineCap(StrokeLineCap.ROUND);

        TableView<Alarm> table = new TableView<Alarm>();
        final ObservableList<Alarm> data =
                FXCollections.observableArrayList(
                new Alarm("22", "33", "14"),
                new Alarm("12", "15", "45"),
                new Alarm("4", "5", "47"),
                new Alarm("6", "7", "22"),
                new Alarm("9", "9", "52"));
        final HBox hb = new HBox();
        TableColumn HourCol = new TableColumn("Hour");
        HourCol .setMinWidth(100);
        HourCol .setCellValueFactory(
            new PropertyValueFactory<Alarm, String>("hour"));
        HourCol .setCellFactory(TextFieldTableCell.forTableColumn());
        HourCol .setOnEditCommit(
            new EventHandler<CellEditEvent<Alarm, String>>() {
                @Override
                public void handle(CellEditEvent<Alarm, String> t) {
                    ((Alarm) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setHour(t.getNewValue());
                }
            }
        );
 
 
        TableColumn MinuteCol = new TableColumn("Minute");
        MinuteCol.setMinWidth(100);
        MinuteCol.setCellValueFactory(
            new PropertyValueFactory<Alarm, String>("minute"));
        MinuteCol.setCellFactory(TextFieldTableCell.forTableColumn());
        MinuteCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Alarm, String>>() {
                @Override
                public void handle(CellEditEvent<Alarm, String> t) {
                    ((Alarm) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setMinute(t.getNewValue());
                }
            }
        );
 
        TableColumn SecondCol = new TableColumn("Second");
        SecondCol.setMinWidth(100);
        SecondCol.setCellValueFactory(
            new PropertyValueFactory<Alarm, String>("second"));
        SecondCol.setCellFactory(TextFieldTableCell.forTableColumn());
        SecondCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Alarm, String>>() {
                @Override
                public void handle(CellEditEvent<Alarm, String> t) {
                    ((Alarm) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setSecond(t.getNewValue());
                }
            }
        );
 
        table.setItems(data);
        table.getColumns().addAll(HourCol, MinuteCol, SecondCol);
 
        final TextField addHour = new TextField();
        addHour.setPromptText("Hour");
        addHour.setMaxWidth(HourCol.getPrefWidth());
        final TextField addMinute = new TextField();
        addMinute.setMaxWidth(MinuteCol.getPrefWidth());
        addMinute.setPromptText("Minute");
        final TextField addSecond = new TextField();
        addSecond.setMaxWidth(SecondCol.getPrefWidth());
        addSecond.setPromptText("Second");
 
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Alarm(
                        addHour.getText(),
                        addMinute.getText(),
                        addSecond.getText()));
                addHour.clear();
                addMinute.clear();
                addSecond.clear();
            }
        });
 
        hb.getChildren().addAll(addHour, addMinute, addSecond, addButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 350));
        	vbox.getChildren().addAll(table,hb);
        
        root.getChildren().add(vbox);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Calendar c = Calendar.getInstance();
                cSec.setLength(-(c.get(Calendar.SECOND)) / 60.0 * 360.0);
                final double seedSecondDegrees  = c.get(Calendar.SECOND) * (360 / 60);
                final double seedMinuteDegrees  = (c.get(Calendar.MINUTE) + seedSecondDegrees / 360.0) * (360 / 60);
                final double seedHourDegrees  = (c.get(Calendar.HOUR)   + seedMinuteDegrees / 360.0) * (360 / 12) ;
                second.setEndX(200.0+130.0*Math.cos(Math.toRadians(seedSecondDegrees-90)));
                second.setEndY(150.0+130.0*Math.sin(Math.toRadians(seedSecondDegrees-90)));
                minute.setEndX(200.0+120.0*Math.cos(Math.toRadians(seedMinuteDegrees-90)));
                minute.setEndY(150.0+120.0*Math.sin(Math.toRadians(seedMinuteDegrees-90)));
                hour.setEndX(200.0+90.0*Math.cos(Math.toRadians(seedHourDegrees-90)));
                hour.setEndY(150.0+90.0*Math.sin(Math.toRadians(seedHourDegrees-90)));
            }

        }));

        timeline.setCycleCount(Animation.INDEFINITE);		//animacja ustawiona na nieskoñczonoœæ
        timeline.play();
       
    }
    public static class Alarm {
    	 
        private final SimpleStringProperty AHour;
        private final SimpleStringProperty AMinute;
        private final SimpleStringProperty ASecond;
 
        private Alarm(String AHourr, String AMinutee, String ASecondd) {
            this.AHour = new SimpleStringProperty(AHourr);
            this.AMinute = new SimpleStringProperty(AMinutee);
            this.ASecond = new SimpleStringProperty(ASecondd);
        }
 
        public String getHour() {
            return AHour.get();
        }
 
        public void setHour(String AHourr) {
        	AHour.set(AHourr);
        }
 
        public String getMinute() {
            return AMinute.get();
        }
 
        public void setMinute(String AMinutee) {
        	AMinute.set(AMinutee);
        }
 
        public String getSecond() {
            return ASecond.get();
        }
 
        public void setSecond(String ASecondd) {
        	ASecond.set(ASecondd);
        }
    }
    
}

