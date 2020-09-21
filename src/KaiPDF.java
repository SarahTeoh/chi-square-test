
public class KaiPDF {

    public double calcFuncValue(double x, int df) {
	double nn = (double)df/2;

	return 1 / (Math.pow(2, nn) * gamma(nn)) * Math.pow(x, nn-1) * Math.exp(-0.5*x);
    }
    public static double loggamma(double xx) { // ガンマ関数の対数
	double LOG_2PI = Math.log(2 * Math.PI); // log(2PI)
	int N = 8;
	double B0  = 1.0;           // 以下は Bernoulli 数
	double B1  = (-1.0 / 2.0);
	double B2  = ( 1.0 / 6.0);
	double B4  = (-1.0 / 30.0);
	double B6  = ( 1.0 / 42.0);
	double B8  = (-1.0 / 30.0);
	double B10 = ( 5.0 / 66.0);
	double B12 = (-691.0 / 2730.0);
	double B14 = ( 7.0 / 6.0);
	double B16 = (-3617.0 / 510.0);

        double v = 1.0;
        while (xx < N) { v *= xx; xx++; }
        double w = 1 / (xx * xx);
        double ret =    B16 / (16 * 15);
        ret = ret * w + B14 / (14 * 13);
        ret = ret * w + B12 / (12 * 11);
        ret = ret * w + B10 / (10 *  9);
        ret = ret * w + B8  / ( 8 *  7);
        ret = ret * w + B6  / ( 6 *  5);
        ret = ret * w + B4  / ( 4 *  3);
        ret = ret * w + B2  / ( 2 *  1);
        ret = ret / xx + 0.5 * LOG_2PI - Math.log(v) - xx
                       + (xx - 0.5) * Math.log(xx);
        return ret;
    }
    public static double gamma(double xx) { // ガンマ関数
        if (xx < 0.0)
            return  Math.PI /
                    (Math.sin(Math.PI * xx) * Math.exp(loggamma(1 - xx)));
        return Math.exp(loggamma(xx));
    }
}