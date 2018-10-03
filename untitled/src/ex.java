import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ex {
    private static final String FILENAME = "data.txt";

    public static void main(String[] args) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String content = "Nội dung mình muốn viết vào file\n";

            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.write(content);
            System.out.println("Xong");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}