import java.io.*;
import java.util.*;

public class Ransuu{

	//正規乱数の生成
	public static double normRand(){
	// 中心極限定理 (n=12)
	int i;
	double sum=0.0;
	for( i = 0; i < 12; i++ ){
	    sum += Math.random();
	}
	return sum-6.0;
	}

	//正規乱数の配列を生成
	public static double[] makeArray(){
		int j;
		int n = 1000; //1000個乱数データ
		double[] ransuu; //正規乱数の配列
		ransuu = new double[n]; 
		for (j = 0 ; j < n; j++) {
			ransuu[j] = normRand();
		}

		return ransuu;
	}

}
