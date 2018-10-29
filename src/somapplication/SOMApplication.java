/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package somapplication;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Br. David Klecker
 */
public class SOMApplication extends Application {
    
	private static int A1[] = {0, 0, 1, 1, 0, 0, 0, 
	                           0, 0, 0, 1, 0, 0, 0, 
	                           0, 0, 0, 1, 0, 0, 0, 
	                           0, 0, 1, 0, 1, 0, 0, 
	                           0, 0, 1, 0, 1, 0, 0, 
	                           0, 1, 1, 1, 1, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           1, 1, 1, 0, 1, 1, 1};

	private static int B1[] = {1, 1, 1, 1, 1, 1, 0, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 1, 1, 1, 1, 0, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           1, 1, 1, 1, 1, 1, 0};

	private static int C1[] = {0, 0, 1, 1, 1, 1, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 0, 1, 1, 1, 1, 0};

	private static int D1[] = {1, 1, 1, 1, 1, 0, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           1, 1, 1, 1, 1, 0, 0};

	private static int E1[] = {1, 1, 1, 1, 1, 1, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 0, 
	                           0, 1, 0, 1, 0, 0, 0, 
	                           0, 1, 1, 1, 0, 0, 0, 
	                           0, 1, 0, 1, 0, 0, 0, 
	                           0, 1, 0, 0, 0, 0, 0, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           1, 1, 1, 1, 1, 1, 1};

	private static int J1[] = {0, 0, 0, 1, 1, 1, 1, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 0, 1, 1, 1, 0, 0};

	private static int K1[] = {1, 1, 1, 0, 0, 1, 1, 
	                           0, 1, 0, 0, 1, 0, 0, 
	                           0, 1, 0, 1, 0, 0, 0, 
	                           0, 1, 1, 0, 0, 0, 0, 
	                           0, 1, 1, 0, 0, 0, 0, 
	                           0, 1, 0, 1, 0, 0, 0, 
	                           0, 1, 0, 0, 1, 0, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           1, 1, 1, 0, 0, 1, 1};

	private static int A2[] = {0, 0, 0, 1, 0, 0, 0, 
	                           0, 0, 0, 1, 0, 0, 0, 
	                           0, 0, 0, 1, 0, 0, 0, 
	                           0, 0, 1, 0, 1, 0, 0, 
	                           0, 0, 1, 0, 1, 0, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 1, 1, 1, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0};

	private static int B2[] = {1, 1, 1, 1, 1, 1, 0, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 1, 1, 1, 1, 1, 0, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 1, 1, 1, 1, 1, 0};

	private static int C2[] = {0, 0, 1, 1, 1, 0, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 0, 1, 1, 1, 0, 0};

	private static int D2[] = {1, 1, 1, 1, 1, 0, 0, 
	                           1, 0, 0, 0, 0, 1, 0, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 1, 0, 
	                           1, 1, 1, 1, 1, 0, 0};

	private static int E2[] = {1, 1, 1, 1, 1, 1, 1, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 1, 1, 1, 1, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 1, 1, 1, 1, 1, 1};

	private static int J2[] = {0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 0, 1, 1, 1, 0, 0};

	private static int K2[] = {1, 0, 0, 0, 0, 1, 0, 
	                           1, 0, 0, 0, 1, 0, 0, 
	                           1, 0, 0, 1, 0, 0, 0, 
	                           1, 0, 1, 0, 0, 0, 0, 
	                           1, 1, 0, 0, 0, 0, 0, 
	                           1, 0, 1, 0, 0, 0, 0, 
	                           1, 0, 0, 1, 0, 0, 0, 
	                           1, 0, 0, 0, 1, 0, 0, 
	                           1, 0, 0, 0, 0, 1, 0};

	private static int A3[] = {0, 0, 0, 1, 0, 0, 0, 
	                           0, 0, 0, 1, 0, 0, 0, 
	                           0, 0, 1, 0, 1, 0, 0, 
	                           0, 0, 1, 0, 1, 0, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 1, 1, 1, 1, 0, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 1, 0, 0, 0, 1, 1};

	private static int B3[] = {1, 1, 1, 1, 1, 1, 0, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 1, 1, 1, 1, 0, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           1, 1, 1, 1, 1, 1, 0};

	private static int C3[] = {0, 0, 1, 1, 1, 0, 1, 
	                           0, 1, 0, 0, 0, 1, 1, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 0, 
	                           1, 0, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 0, 1, 1, 1, 0, 0};

	private static int D3[] = {1, 1, 1, 1, 0, 0, 0, 
	                           0, 1, 0, 0, 1, 0, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 1, 0, 0, 
	                           1, 1, 1, 1, 0, 0, 0};

	private static int E3[] = {1, 1, 1, 1, 1, 1, 1, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           0, 1, 0, 0, 1, 0, 0, 
	                           0, 1, 1, 1, 1, 0, 0, 
	                           0, 1, 0, 0, 1, 0, 0, 
	                           0, 1, 0, 0, 0, 0, 0, 
	                           0, 1, 0, 0, 0, 0, 0, 
	                           0, 1, 0, 0, 0, 0, 1, 
	                           1, 1, 1, 1, 1, 1, 1};

	private static int J3[] = {0, 0, 0, 0, 1, 1, 1, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 0, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 0, 1, 1, 1, 0, 0};

	private static int K3[] = {1, 1, 1, 0, 0, 1, 1, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           0, 1, 0, 0, 1, 0, 0, 
	                           0, 1, 0, 1, 0, 0, 0, 
	                           0, 1, 1, 0, 0, 0, 0, 
	                           0, 1, 0, 1, 0, 0, 0, 
	                           0, 1, 0, 0, 1, 0, 0, 
	                           0, 1, 0, 0, 0, 1, 0, 
	                           1, 1, 1, 0, 0, 1, 1};
	
	private static int MAX_CLUSTERS = 25;
	private static int INPUT_PATTERNS = 21;
	private static int VEC_LEN = 63;
	private static int VEC_XLEN = 5;
	private static int VEC_YLEN = 5;
	private static double DECAY_RATE = 0.96;                  //About 100 iterations.
	private static double MIN_ALPHA = 0.01;
	private static double RADIUS_REDUCTION_POINT = 0.023;     //Last 20% of iterations.
	
	private static double alpha = 0.6;
	private static double d[] = new double[MAX_CLUSTERS];           //Network nodes.
	
	//Weight matrix with randomly chosen values between 0.0 and 1.0
	private static double w[][] = new double[MAX_CLUSTERS][VEC_LEN];
	
	private static ArrayList<double[]> pattern = null;
	private static String names[] = null;
        public FXMLDocumentController controller;
        private ArrayList<BufferedImage> FullFacesArray;
        
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        controller = (FXMLDocumentController)loader.getController();
        controller.SOMDoc = this;

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

        initialize();
        training();
        printResults();

    }

    /**
     * @param args the command line arguments
     */ 
    
    private void initialize() throws IOException
    {
        //String ImagePath    = "C:\\Users\\Br. David Klecker\\Documents\\NetBeansProjects\\ImageInformation\\src\\Faces.JPG";
        //FullFacesArray = StoreImageIntoArray(ImagePath, 50, 50, 30, 30, 2, 2, 2);
        
        String ImagePath = "C:\\Users\\Br. David Klecker\\Downloads\\Dogs\\TrainingSet\\DogsGrid.jpg";
        FullFacesArray = StoreImageIntoArray(ImagePath, 75, 75, 10, 10, 2, 2, 2);
        
        pattern = new ArrayList<double[]>();
        ArrayList<String> faceNames = new ArrayList();
        
        for(int i=0; i<FullFacesArray.size(); i++){
            pattern.add(CreateImageColorArray(FullFacesArray.get(i)));
            faceNames.add(String.format("Face:%d",i+1));
        }
        
        INPUT_PATTERNS  = pattern.size();
        VEC_LEN         = pattern.get(0).length;
        MAX_CLUSTERS    = 25;
        d               = new double[MAX_CLUSTERS];
	w               = new double[MAX_CLUSTERS][VEC_LEN];
        
        for(int i=0; i<MAX_CLUSTERS; i++){
            for(int j=0; j<VEC_LEN; j++){
                w[i][j] = new Random().nextDouble();
            }
        }
        
        names = faceNames.toArray(new String[faceNames.size()]);
            
		/*pattern = new ArrayList<int[]>();
		pattern.add(A1);
		pattern.add(B1);
		pattern.add(C1);
		pattern.add(D1);
		pattern.add(E1);
		pattern.add(J1);
		pattern.add(K1);
		pattern.add(A2);
		pattern.add(B2);
		pattern.add(C2);
		pattern.add(D2);
		pattern.add(E2);
		pattern.add(J2);
		pattern.add(K2);
		pattern.add(A3);
		pattern.add(B3);
		pattern.add(C3);
		pattern.add(D3);
		pattern.add(E3);
		pattern.add(J3);
		pattern.add(K3);
		
		names = new String[]{"A1", "B1", "C1", "D1", "E1", "J1", "K1", 
		                     "A2", "B2", "C2", "D2", "E2", "J2", "K2", 
		                     "A3", "B3", "C3", "D3", "E3", "J3", "K3"}; 
		
		for(int i = 0; i < MAX_CLUSTERS; i++)
		{
			for(int j = 0; j < VEC_LEN; j++)
			{
				w[i][j] = new Random().nextDouble();
			}
		}*/
		
		return;
	}
	
	private void training()
	{
            int iterations = 0;
	    boolean reductionFlag = false;
	    int reductionPoint = 0;
	    int dMin = 0;
	    
	    while(alpha > MIN_ALPHA)
	    {
	        iterations += 1;

	        for(int vecNum = 0; vecNum <= (INPUT_PATTERNS - 1); vecNum++)
	        {
	            //Compute input for all nodes.
	            computeInput(pattern.get(vecNum));

	            //See which is smaller?
	            dMin = minimum(d);

	            //Update the weights on the winning unit.
	            updateWeights(vecNum, dMin);

	        } // VecNum
	        
	        //Reduce the learning rate.
	        alpha = DECAY_RATE * alpha;

	        //Reduce radius at specified point.
	        if(alpha < RADIUS_REDUCTION_POINT){
	            if(reductionFlag == false){
	                reductionFlag = true;
	                reductionPoint = iterations;
	            }
	        }
	    }

	    System.out.println("Iterations: " + iterations);
		
	    System.out.println("Neighborhood radius reduced after " + reductionPoint + " iterations.");
		
		return;
	}
	    
    private void computeInput(double[] vectorArray)
	{
		clearArray(d);

	    for(int i = 0; i <= (MAX_CLUSTERS - 1); i++){
	        for(int j = 0; j <= (VEC_LEN - 1); j++){
	            d[i] += Math.pow((w[i][j] - vectorArray[j]), 2);
	        } // j
	    } // i
		return;
	}
    
    private void updateWeights(int vectorNumber, int dMin)
	{
    	int y = 0;
    	int PointA = 0;
    	int PointB = 0;
    	boolean done = false;

	    for(int i = 0; i < VEC_LEN; i++)
	    {
	        // Only include neighbors before radius reduction point is reached.
	        if(alpha > RADIUS_REDUCTION_POINT){
	            y = 1;
	            while(!done)
	            {
	                if(y == 1){                                   // Top row of 3.
	                    if(dMin > VEC_XLEN - 1){
	                        PointA = dMin - VEC_XLEN - 1;
	                        PointB = dMin - VEC_XLEN + 1;
	                    }else{
	                        y = 2;
	                    }
	                }
	                if(y == 2){                                   // Middle row of 3.
	                    PointA = dMin - 1;
	                    //DMin is like an anchor position right between these two.
	                    PointB = dMin + 1;
	                }
	                if(y == 3){                                   // Bottom row of 3.
	                    if(dMin < (VEC_XLEN * (VEC_YLEN - 1))){
	                        PointA = dMin + VEC_XLEN - 1;
	                        PointB = dMin + VEC_XLEN + 1;
	                    }else{
	                        done = true;
	                    }
	                }

	                if(!done){
	                    for(int DIndex = PointA; DIndex < PointB; DIndex++)
	                    {
	                        // Check if anchor is at left side.
	                        if(dMin % VEC_XLEN == 0){
	                            // Check if anchor is at top.
	                            if(DIndex > PointA){
	                            	w[DIndex][i] = w[DIndex][i] + (alpha * (pattern.get(vectorNumber)[i] - w[DIndex][i]));
	                            }
	                        // Check if anchor is at right side.
	                        }else if((dMin + 1) % VEC_XLEN == 0){
	                            // Check if anchor is at top.
	                            if(DIndex < PointB){
	                                w[DIndex][i] = w[DIndex][i] + (alpha * (pattern.get(vectorNumber)[i] - w[DIndex][i]));
	                            }
	                        // Otherwise, anchor is not at either side.
	                        }else{
	                            w[DIndex][i] = w[DIndex][i] + (alpha * (pattern.get(vectorNumber)[i] - w[DIndex][i]));
	                        }
	                    } // DIndex
	                }

	                if(y == 3){
	                    done = true;
	                }
	                y += 1; // prepare to start the next row.

	            }
	        }else if(alpha <= RADIUS_REDUCTION_POINT){
	            // Update only the winner.
	            w[dMin][i] = w[dMin][i] + (alpha * (pattern.get(vectorNumber)[i] - w[dMin][i]));
	        }

	    } // i
		return;
	}
    
    private void clearArray(double[] nodeArray)
	{
		for(int i = 0; i <= (MAX_CLUSTERS - 1); i++)
	    {
	        nodeArray[i] = 0.0;
	    } // i
		return;
	}
    
    private int minimum(double[] nodeArray)
	{
		int winner = 0;
	    boolean foundNewWinner = false;
	    boolean done = false;

	    while(!done)
	    {
	        foundNewWinner = false;
	        for(int i = 0; i <= (MAX_CLUSTERS - 1); i++)
	        {
	            if(i != winner){             //Avoid self-comparison.
	                if(nodeArray[i] < nodeArray[winner]){
	                    winner = i;
	                    foundNewWinner = true;
	                }
	            }
	        } // i

	        if(foundNewWinner == false){
	            done = true;
	        }
	    }
	    return winner;
	}
    
    private void printResults()
    {
        int OffsetX = 75;
        int OffsetY = 75;        
        int dMin = 0;
        
        HashMap<Integer, ArrayList<Integer>> clusters = new HashMap();

        //Print clusters created.
        System.out.println("Clusters for training input:");
        for(int vecNum = 0; vecNum < INPUT_PATTERNS; vecNum++)
        {
            //Compute input.
            computeInput(pattern.get(vecNum));

            //See which is smaller.
            dMin = minimum(d);

            System.out.print("\nVector (");
            System.out.print("Pattern " + vecNum + ", " + names[vecNum]);
            System.out.print(") fits into category " + dMin + "\n");
            if(clusters.get(dMin) != null){
                clusters.get(dMin).add(vecNum);
            }
            else{
                ArrayList<Integer> newList = new ArrayList();
                newList.add(vecNum);
                clusters.put(dMin, newList);
            }

        } // VecNum

        GraphicsContext gc          = controller.ImageClusteringCanvas.getGraphicsContext2D();
        double width                = controller.ImageClusteringCanvas.getWidth();
        double height               = controller.ImageClusteringCanvas.getHeight();

        Iterator it = clusters.entrySet().iterator();
        int RowX = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int ColX = 0;
            int ClusterNumber = (int) pair.getKey();
            ArrayList<Integer> ImagesInCluster = (ArrayList<Integer>) pair.getValue();
            for(int i=0; i<ImagesInCluster.size(); i++){
                gc.drawImage(ConvertBufferedImageToImage(FullFacesArray.get(ImagesInCluster.get(i))), ColX, RowX);
                ColX += OffsetX + 10;                        
            }
            RowX += OffsetY + 10;
        }
    }
	
    public Image ConvertBufferedImageToImage(BufferedImage bf){
        
        return SwingFXUtils.toFXImage(bf, null);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public double[] CreateImageColorArray(BufferedImage Face){
        
        double[] rtn = new double[Face.getHeight() * Face.getWidth()];
        int count = 0;
        int Halfway = 128;
        for(int i=0; i<Face.getHeight();i++){           

            for(int j=0; j<Face.getWidth(); j++){
                
                Color c1 = new Color(Face.getRGB(i, j));
                
                /* Normalize the data to be one or 0*/
                if(c1.getRed() > 128)
                    rtn[count++] = 1;
                else
                    rtn[count++] = 0;
            }
        }
        return rtn;
    }
    
    public ArrayList<BufferedImage> StoreImageIntoArray(String Path, int Width, int Height, int SizeWidth, int SizeHeight, int offsetx, int offsety, int gap) throws IOException{
        
        ArrayList<BufferedImage> images = new ArrayList();
        
        BufferedImage FullImage = ImageIO.read(new File(Path));
        
        int imageSizeWidth          = Width;   //How big are the images we are getting
        int imageSizeHeight         = Height;   //How big are the images we are getting
        int numberOfImagesWidth     = SizeWidth;   //How many images are along the x axis
        int numberOfImagesHeight    = SizeHeight;   //How many images are along the y axis
        int NumberOfImages          = SizeWidth * SizeHeight;  //This should be the previous 2 values multiplied
        int offsetX                 = offsetx;    //Where do the images actually start in the main image
        int offsetY                 = offsety;    
        int Gap                     = gap;    //Is there a gap between all images. 
        double S[][]                = new double[NumberOfImages][NumberOfImages];
        
        for(int i=0; i<numberOfImagesWidth; i++){

            for(int j=0; j<numberOfImagesHeight; j++){

                int row = i % numberOfImagesWidth;
                int col = j % numberOfImagesHeight;
                int x = (col*(imageSizeWidth+offsetX))+gap;
                int y = (row*(imageSizeHeight+offsetY))+gap;
                BufferedImage subimage = FullImage.getSubimage(x, y, imageSizeWidth, imageSizeHeight);
                images.add(subimage);
            }
        }
        return images;
    }        
}
