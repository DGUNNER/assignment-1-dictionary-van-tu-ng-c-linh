import java.io.*;

public class vs {


    public static void main(String[] args) throws IOException {

        // The name of the file to open.
            String fileName = "D:\\dictionary.txt";

        FileReader reader = new FileReader("D:\\dictionary.txt");
        BufferedReader read = new BufferedReader(reader);
        String str;
        while ((str = read.readLine())!= null)
        {
            System.out.println(str.indexOf("\t"));
            //System.out.println(str.indexOf(""));
            System.out.println(str);
        }
        read.close();
    }


}
