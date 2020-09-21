public class CalcMeanSD {

        static double sqr( double x ){
                        return x * x;
        }
        
        public static double[] calc(double[] data){
                int n = data.length;                             //データの個数 
                double sum = 0.0;
                double maxData = data[0];                            //データの最大値をデータの最初の値に初期化する
                double minData = data[0];
                double numberOfKaikyuu = Math.round(1 + (Math.log(n-1)/Math.log(2)));
                double stepSize, minRange, maxRange;

                //meanSD = {平均, 標準偏差, データの最小値を切り上げた値, 階級数};
                double[] meanSD = new double[5];

                for (int i = 0; i < n; i++){
                        sum += data[i];                          //データの和
                        maxData = Math.max(maxData, data[i]);    //データの最大値
                        minData = Math.min(minData, data[i]);    //データの最小値
                                                                
                }
                double mean = sum / n;        
                meanSD[0] = mean;                                               //平均
                double ssum = 0.0;

                for (int i = 0; i < n; i++){
                        ssum += sqr(data[i] - mean);                            //２乗和
                }

                double variance = ssum / n;                                     //分散
                double sd = Math.sqrt(variance);                                //標準偏差
                stepSize = Math.floor((maxData-minData)/numberOfKaikyuu);       //階級幅
                meanSD[1] = sd;
                meanSD[2] = Math.ceil(minData);
                meanSD[3] = stepSize;
                meanSD[4] = numberOfKaikyuu;

                System.out.println("平均 = " + mean);
                System.out.println("標準偏差 = " + sd);
                System.out.println("分散 = " + variance);
                
                return meanSD;
        }


}