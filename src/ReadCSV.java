import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;


public class ReadCSV {
  public static double[] read(String fileName) {

    //ファイル読み込みで使用する３つのクラス
    FileInputStream fi = null;
    InputStreamReader is = null;
    BufferedReader br = null;

    //身長データの配列
    double[] heightData;
    heightData = new double[1000];

    try {

      //読み込みファイルのインスタンス生成
      //ファイル名を指定する
      fi = new FileInputStream(fileName);
      is = new InputStreamReader(fi);
      br = new BufferedReader(is);

      //読み込み行数の管理
      int i = 0;
      int j = 0;

      //列名を管理する為の配列
      String[] lines = null;
      String line;

      //1行ずつ読み込みを行う
      while ((line = br.readLine()) != null) {
        if(i == 0){
          i++; //第1行目は列名なので身長データ配列に格納しない
        }else{

          //カンマで分割した内容を配列に格納する
          // arr = { "male" ,"身長のデータ"};
          String[]  oneLine = line.split(";");
          heightData[j] =  Double.parseDouble(oneLine[1]);
          
          //行数のインクリメント
          i++;
          j++;
        }
      }
      

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        br.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return heightData; //読み込んだデータを配列として返す
  }
}