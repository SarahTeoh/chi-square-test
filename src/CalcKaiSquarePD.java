import java.io.*;
import java.util.*;

public class CalcKaiSquarePD {

    KeyboardInput aKeyboard = new KeyboardInput();
    FileOutput anOutput = new FileOutput();

    double[] dataSet;
    double[] xSquareDataSet;
    String[][] xSquareFreqOfClass;
    
    public void executeCalculation(int degreeOfFree, double maxRange, double stepSize) {
	// 確率密度関数による計算の繰り返し
	double xValue = 0.0;
	KaiPDF aPDF = new KaiPDF();
	String outputData = "";
	while (xValue <= maxRange) {
	    outputData += xValue + "," + aPDF.calcFuncValue(xValue, degreeOfFree) + "\n";

	    xValue += stepSize;
	}
	// 計算結果のファイル出力
	this.anOutput.write("calculated.csv", outputData);
    }
    /* main */
    public static void main(String args[]) {
	CalcKaiSquarePD aTest;

	aTest = new CalcKaiSquarePD();

	// コマンドライン引数 1：自由度、2：最大値、3：刻み幅
	int degreeOfFree=0;
	double maxRange=0.0, stepSize=0.0;

	degreeOfFree = Integer.parseInt(args[0]);
	maxRange = Double.parseDouble(args[1]);
	stepSize = Double.parseDouble(args[2]);

	aTest.executeCalculation(degreeOfFree, maxRange, stepSize);
    }
}