import java.util.Arrays;
import java.util.List;

public class Enshuu2{
	public static void main(String[] args){	
		KeyboardInput aKeyboard = new KeyboardInput();
		ReadCSV readFile = new ReadCSV();
		CalcMeanSD meanSD = new CalcMeanSD();
		Kyuuwake kyuuwake = new Kyuuwake();
		CalcZscore calcZScore = new CalcZscore();
		Chisquare calcChiSquare = new Chisquare();
		Output writeToFile = new Output();

		double min = 0.0, max = 0.0, stepSize=0.0;
		double mean, sd, minRange, maxRange, kaikyuuSize, numberOfKaikyuu, chiSquare, criticalPValue;
		int numberofJishou = 0;
		int i, degreeOfFreedom, indexOfInputPValue;
		String fileName;

		double[] heightData, zScore, e;
		double[] mean_and_sd = new double[5];
		double[] p = {0.995, 0.975,	0.05, 0.025, 0.01, 0.005};
		double[][] kai2jyou = {{0.000, 0.001, 3.841, 5.024,	6.635, 7.879} ,{0.010, 0.051, 5.991, 7.378, 9.210, 10.597}, {0.072, 0.216, 7.815, 9.348, 11.345, 12.838}, {0.207, 0.484, 9.488, 11.143, 13.277, 14.860}, {0.412, 0.831, 11.070, 12.832, 15.086, 16.750}, {0.676, 1.237,	12.592,	14.449,	16.812,	18.548}, {0.989, 1.690,	14.067,	16.013,	18.475, 20.278}, {1.344, 2.180,	15.507,	17.535,	20.090,	21.955}, {1.735, 2.700,	16.919,	19.023,	21.666,	23.589}, {2.156, 3.247,	18.307,	20.483,	23.209,	25.188} };
		int[] dosuu;


		// コマンドライン引数 1：データのcsvファイル名、2: 有意水準　3：事象の数
		fileName = args[0];
		criticalPValue = Double.parseDouble(args[1]);
		
		heightData = readFile.read(fileName);
		mean_and_sd = meanSD.calc(heightData);
		mean = mean_and_sd[0];				//平均
		sd = mean_and_sd[1];				//標準偏差
		minRange = mean_and_sd[2];			//最小値
		kaikyuuSize = mean_and_sd[3]; 		//階級幅
		numberOfKaikyuu = mean_and_sd[4];	//階級数
		maxRange = minRange + kaikyuuSize*(numberOfKaikyuu-1) ;

		//各階級の上限値を求め、配列に格納する
		double[] upperLimitOfEveryKaikyuu = new double[((int)numberOfKaikyuu)];
		for(i = 0; i < numberOfKaikyuu; i++){
			upperLimitOfEveryKaikyuu[i] = minRange + (kaikyuuSize*i);	
		}
		
		dosuu = kyuuwake.combine(kyuuwake.wakeru(heightData, minRange, maxRange, kaikyuuSize, ((int)numberOfKaikyuu)+1));
		zScore = calcZScore.calc(upperLimitOfEveryKaikyuu, mean, sd);
		chiSquare = calcChiSquare.calcCombinedChiSquare(zScore, dosuu, kaikyuuSize);
		//chiSquare = e[dosuu.length+1];
		
		double[] dosuu_double = new double[dosuu.length];
		for(int j=0; j<dosuu.length; j++){
        	dosuu_double[j] = dosuu[j];
		}
		
		writeToFile.output(dosuu_double, kaikyuuSize , "chiSquareTest.csv");
		

		degreeOfFreedom = dosuu.length - 3; 	//カイ２乗の自由度
		indexOfInputPValue = 0;
		for(int k = 0; k < p.length; k++){
			if(p[k] == criticalPValue)
				indexOfInputPValue = k;
		}

		System.out.println("事象数: " + dosuu.length);
		System.out.println("カイ２乗自由度: " + degreeOfFreedom);
		System.out.println("入力された有意水準:  " + criticalPValue);
		System.out.println("棄却域 " + kai2jyou[degreeOfFreedom-1][indexOfInputPValue]);
		System.out.println("カイ２乗: " + chiSquare);

		if(chiSquare > kai2jyou[degreeOfFreedom-1][indexOfInputPValue])
			System.out.println("結論: 帰無仮説を採択しない。データは正規分布に従わない。");
		else
			System.out.println("結論: 帰無仮説を採択する。データは正規分布に従う。");

	
	}
	
}