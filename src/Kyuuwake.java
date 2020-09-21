import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

//乱数データを級に分ける
public class Kyuuwake{
	public static int[] wakeru(double data[], double min, double max, double stepSize, int numberOfJishou){
		int j;	
		int[] jishou; 
		jishou = new int[numberOfJishou];
		Arrays.fill(jishou, 0);		//全ての要素を一括に0に初期化

		if (min < 0){				//負のデータを含んだ場合にやりやすいためにデータグラフを０以上の部分にあるように並行移動
			min = min +30;
			max = max +30;
			for(j = 0; j < data.length; j++){		//データを階級に分ける
				data[j] = data[j] +30;
				if ( data[j] <= min)
					jishou[0] = jishou[0] + 1;		
				else if ( data[j] > max )
					jishou[numberOfJishou-1] = jishou[numberOfJishou-1] + 1;
				else
					jishou[(int)(Math.ceil((data[j]-min)/stepSize))] = jishou[(int)(Math.ceil((data[j]-min)/stepSize))]+ 1;
				}
			}
		else{
			for(j = 0; j < data.length; j++){		//データを階級に分ける
				if ( data[j] <= min)
					jishou[0] = jishou[0] + 1;	
				else if ( data[j] > max )
					jishou[numberOfJishou-1] = jishou[numberOfJishou-1] + 1;
				else
					jishou[(int)(Math.ceil((data[j]-min)/stepSize))] = jishou[(int)(Math.ceil((data[j]-min)/stepSize))]+ 1;
			}
		}
		return jishou;	
	}
	
	public static int[] combine(int[] jishou){
		int[] combinedJishou = new int[jishou.length-1];

		int l, m;

		for(l = 0; l < jishou.length; l++){
			if(jishou[l] <= 5){
				jishou[0] = jishou[0] + jishou[l]; //度数が5以下の事象をjishou[0]に統合する
			}
		}

		for(m = 0; m < (jishou.length-1) ; m++ ){
			combinedJishou[m] = jishou[m];
		}
		
		return combinedJishou;
	}
			
}
