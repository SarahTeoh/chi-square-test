import java.util.Arrays;
import java.math.BigDecimal;
import java.math.RoundingMode;

//各階級の上限値を標準化し、z-スコアとする
//z = {z1, z2, z3, ....};
public class CalcZscore{
	public static double[] calc(double[] upperLimitOfEveryKaikyuu, double mean, double sd){
			double[] z = new double[upperLimitOfEveryKaikyuu.length];

			for(int i = 0; i < upperLimitOfEveryKaikyuu.length ;i++){
				BigDecimal bd = new BigDecimal(((upperLimitOfEveryKaikyuu[i]-mean)/sd));
    			bd = bd.setScale(2, RoundingMode.HALF_UP);
				z[i] = bd.doubleValue();
			}
			return z;
	}
}