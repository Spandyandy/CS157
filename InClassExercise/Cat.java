import java.io.*;

public class Cat {
  // Read and echo a text file, numbering the lines
  // Author: Angela McDermott, September 1, 1996 

    private FileReader fr;
    private BufferedReader br;

  public Cat (String filename) {
    // open local file given by filename
    try {
      fr = new FileReader(filename);
    }
    catch (FileNotFoundException e) {
      System.out.println("File Not Found: " + filename);
      System.exit(-1);
    }

    br = new BufferedReader(fr);
  }

  public void readAndEcho () {
    String s = "";
    for (int line = 1; ; line++) {
      try {
        s = br.readLine();
      }
      catch (IOException ioe) {
        System.out.println("Error Reading File");
        System.exit(-1);
      }
      if (s == null) return;  // if end-of-file
      System.out.println(line + "\t" + s);
    } 
  }
}