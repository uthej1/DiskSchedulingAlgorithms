package diskscheduling.graph ;
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Graph extends Application {
	static public int x[] , y[] ;	
	
    @Override public void start(Stage stage) {
        stage.setTitle("Disk Scheduling Algorithms");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Track No.");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Time");

        lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE); //Asking LineChart not to sort based on x-values
       
        XYChart.Series series = new XYChart.Series();
        series.setName("Disk Scheduling Algorithms");
        //populating the series with data
        for (int i = 0 ; i < x.length ; i++ ) {
        	series.getData().add(new XYChart.Data(x[i] , y[i])) ;
        }
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]) {	
    	launch(args) ;
    }

}
