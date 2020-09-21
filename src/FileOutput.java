import java.io.*;

public class FileOutput {

    public void write(String dataFileName, String outputData) {
	PrintWriter writer = null;
	try {
	    writer = new PrintWriter(new BufferedWriter(new FileWriter(dataFileName)));
	    writer.println(outputData);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (writer != null) {
		    writer.flush();
		    writer.close();
		}
	    } catch (Exception e) {
	    }
	}
    }
}