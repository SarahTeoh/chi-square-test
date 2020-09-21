import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class Chisquare{
	//カイ２乗の計算
    public static double findUpperLimitOfEveryKaikyuu(int[] jishou, double min, double max, double stepSize){
    	
    	int l;
    	double chiSquare;

    	//下側累積確率関数におけるdouble z;
    	double[] z;
    	z = new double[jishou.length-1];	
    	double x = 0.0;
    	for(l = 0; l < jishou.length-1 ; l++){
    		z[l] = min + x;
    		x += stepSize;
    	}

		chiSquare = calcChiSquare(z, jishou);

    	return chiSquare;
    }

    //カイ２乗の計算
    public static double calcChiSquare(double[] z, int[] jishou){
    	Probability kakuritsu = new Probability();
    	
    	double[] e;
    	double chisquare = 0.0;
    	int k;
    	e = new double[jishou.length];

    	for(k = 0; k < jishou.length  ; k++){ 			//事象の数はjishou[]の要素数
    		//期待値e_k
    		if (k == 0)
    			e[k]= 1000*(kakuritsu.normLowerDistribution(z[k]));		//下側確率
    		else if(k == (jishou.length-1))
    			e[k]= 1000*(kakuritsu.normUpperDistribution(z[k-1]));	//上側確率
    		else
    			e[k]= 1000*(kakuritsu.normLowerDistribution(z[k]) - kakuritsu.normLowerDistribution(z[k-1])) ;

    		chisquare = chisquare +  (Math.pow((jishou[k]-e[k]), 2)/e[k]);

    	}
    	return chisquare;
    }

    //度数が小さい事象を合併した場合の場合のカイ２乗の計算
    public static double calcCombinedChiSquare(double[] z, int[] jishou, double kaikyuuSize){
    	Probability kakuritsu = new Probability();
    	Output writeToFile = new Output();		//各階級の期待度数をファイルに書き込むためのクラス
    	
    	double[] e;
    	double chisquare = 0.0;
    	int k;
    	e = new double[jishou.length];

    	for(k = 0; k < jishou.length  ; k++){ 			//事象の数はjishou[]の要素数
    		//期待値e_k
    		if (k == 0)	//度数5以下の事象を一つの事象(jishou[0])に合併したから両側確率を計算
    			e[k]= 1000*(kakuritsu.normLowerDistribution(z[k]) + kakuritsu.normUpperDistribution(z[z.length-1])) ;
    		else if(k == (jishou.length-1))
    			e[k]= 1000*(kakuritsu.normUpperDistribution(z[k-1]));
    		else
    			e[k]= 1000*(kakuritsu.normLowerDistribution(z[k]) - kakuritsu.normLowerDistribution(z[k-1])) ;

    		chisquare = chisquare +  (Math.pow((jishou[k]-e[k]), 2)/e[k]);

    	}

    	//各階級の期待度数をKitaiDosuu.csvに書き込む
    	writeToFile.output(e, kaikyuuSize , "KitaiDosuu.csv"); 

    	return chisquare;
    }

}