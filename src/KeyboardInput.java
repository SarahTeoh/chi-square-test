import java.io.*;
import java.util.*;

public class KeyboardInput {

    public String read(String msg) {
	// キーボード入力による文字列
	String str = null;
	try {
	    //InputStreamReaderクラスのオブジェクトを作成する
	    InputStreamReader reader= new InputStreamReader(System.in);
		    
	    //BufferedReaderクラスのオブジェクトを作成する
	    BufferedReader bufreader = new BufferedReader(reader);


	    //readLineメソッドを使って入力された文字列を取得する
	    System.out.print(msg);
	    str = bufreader.readLine();
	} catch (Exception e) {
	    // 例外処理を行う。
	    System.out.println("例外 " + e + " が発生しました");
	}
	return str;
    }
}