package dictionary;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    ArrayList<Word> wordList = new ArrayList<Word>(10000) ;
    Scanner scanner = new Scanner(System.in);
    public void  insertFromCommandline()
    {
        System.out.println("nhap so luong tu :");
        int  n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0;  i < n; i++){
            System.out.println("Nhap tu: ");

            String wordtarget = scanner.nextLine();
            System.out.println("Nhap nghia: ");
            String wordexplain = scanner.nextLine();
            wordList.add(new Word(wordtarget,wordexplain));
        }

    }

    public static void main(String[] args) {
        Dictionary a = new Dictionary();
        a.insertFromCommandline();
    }
}
