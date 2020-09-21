import java.util.Arrays;
import java.lang.Math;

public class Enshuu1{
	public static void main(String[] args){	
		KeyboardInput aKeyboard = new KeyboardInput();
		Output writeToFile = new Output();

		double min = 0.0, max = 0.0, stepSize=0.0;
		int numberofJishou = 0;

		// コマンドライン引数 1：x最小値、2：x最大値、3：刻み幅、４：事象の数
		min = Double.parseDouble(args[0]);
		max = Double.parseDouble(args[1]);
		stepSize = Double.parseDouble(args[2]);
		numberofJishou = Integer.parseInt(args[3]);
		

		int m, n, l;
		int maxVal = 40;  						//カイ２乗分布のグラフのx軸の最大値
		int timesOfRepeat = 1000;  				//繰り返す回数

		int[] jishou;							//各事象の度数の配列
		double[] k; 							//カイ２乗のデータを階級に分けて、各級の度数の配列　
		k = new double[timesOfRepeat]; 
    	Arrays.fill(k, 0.000);					//配列の一括初期化
    	double[] kai2jyou;						//カイ２乗の配列
    	kai2jyou = new double[timesOfRepeat];   //カイ２乗の配列の長さは繰り返す回数
    	
    	for(l = 0; l < timesOfRepeat; l++){
    		Ransuu randomNumbers = new Ransuu(); //正規乱数の配列を生成
			Kyuuwake kyuuwake = new Kyuuwake();
			Chisquare chisquare = new Chisquare();
    		jishou = kyuuwake.wakeru(randomNumbers.makeArray(), min, max, stepSize, numberofJishou);
    		kai2jyou[l] = chisquare.findUpperLimitOfEveryKaikyuu(jishou, min , max, stepSize);
    	}

    	for(m = 0; m < kai2jyou.length; m++){    //ここから階級に分ける
			k[(int)kai2jyou[m]] = k[(int)kai2jyou[m]] + 1;
		}	
		
		for (n = 0; n < k.length; n++){	        //1000回繰り返したので、1000で割る
			k[n] = k[n]/timesOfRepeat;	
		}

		double[] newK = Arrays.copyOfRange(k, 0, maxVal+1);
		writeToFile.output(newK, 1, "chiSquareTestStimulation.csv");
	
	}
		
}

