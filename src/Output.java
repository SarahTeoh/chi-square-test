import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Output{
	//csvファイルに出力
    public static void output(double[] array, double stepSize, String fileName){
    	FileOutput anOutput = new FileOutput();
		int k;
		String outputData = "";
		double xValue = 0.0;
		int m;
		for(m = 0; m < array.length; m++){
			outputData += xValue +","+ array[m]+ "\n";
			xValue += stepSize;
		}

		anOutput.write(fileName, outputData);
    }
}