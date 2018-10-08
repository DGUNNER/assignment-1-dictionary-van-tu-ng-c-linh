package dictionary;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
//import com.darkprograms.speech.translator.GoogleTranslate;


public class DictionaryManagement {
    static Scanner scanner = new Scanner(System.in);
    //private static final String fileDictionary = "Dictionary.txt";

    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
    Dictionary dictionary  = dictionaryCommandline.getDictionary();
    final  String path = "data/dictionary.txt";
    public Dictionary getDictionary()
    {
        return dictionary;
    }

    //Doc File
    public  void insertFromFile() throws IOException {

        //Dictionary dictionary = new Dictionary();

        try {

            FileReader reader = new FileReader(path);
            BufferedReader read = new BufferedReader(reader);
            String data;
            while ((data = read.readLine()) != null) {
                //System.out.println(data);
                int index = data.indexOf("\t");
                dictionary.wordList.add(new Word(data.substring(0, index), data.substring(index + 1, data.length())));

            }
            read.close();
        }catch (IOException e)
        {
            System.out.println(e);
        }
//                dictionary.wordList.get(i).setWord_target(data.substring(0,index));

               //dictionary.wordList.add(new Word(data.substring(0,index),data.substring(index+1,data.length())));
    }
    //Tra cuu tu dien
    public void dictionaryLookup()
    {
        boolean isfound =false;
        scanner.nextLine();
        System.out.println("nhap tu can tim kiem :");
        String search = scanner.nextLine();
        //System.out.println(search);
        for(int i =0; i< dictionary.wordList.size(); i++)
        {
            if(dictionary.wordList.get(i).getWord_target().indexOf(search)==0)
            {
                isfound = true;
                System.out.println(dictionary.wordList.get(i).getData());
            }
        }
        if(isfound==false)
        {
            System.out.println("khong tin thay!!");
        }
    }
    //Sua word
    public void repairDictionary(){
        String search, newEngWord ,newexplain  ;
        scanner.nextLine();
        //Scanner scanner = new Scanner(System.in);
        System.out.println("nhap tu can sua :");
        search = scanner.nextLine();
        for(int i =0; i< dictionary.wordList.size(); i++)
        {
            if(search.equals(dictionary.wordList.get(i).getWord_target()))
            {
                System.out.println("You want repair to: ");
                newEngWord = scanner.nextLine();
                dictionary.wordList.get(i).setWord_target(newEngWord);
                System.out.println("Mean of new word: ");
                newexplain = scanner.nextLine();
                dictionary.wordList.get(i).setWord_explain(newexplain);
            }
        }

    }
    //xoa word trong dictionary
    public void removeWord(){
        String search ;
        scanner.nextLine();
        System.out.println("nhap tu can xoa :");
        search = scanner.nextLine();
        for(int i =0; i< dictionary.wordList.size(); i++)
        {
            if(search.equals(dictionary.wordList.get(i).getWord_target()))
            {
                dictionary.wordList.remove(i);
            }
        }

    }
    //Them word vao dictionary
    public void addWord(String anh, String viet){
        dictionary.wordList.add(new Word(anh,viet));
    }

    //Ghi Dictionary vao File
    public void dictionaryExportToFile(){
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i = 0; i < dictionary.wordList.size(); i++)
            {
                printWriter.println(dictionary.wordList.get(i).getData());
            }
            printWriter.close();

        }catch (Exception e)
        {
            System.out.println(e);
        }

        /*
        try {
            int i = 0;
            FileWriter fw = new FileWriter("D:\\dictionary.txt");
            while (i < dictionary.wordList.size()) {
                fw.write(dictionary.wordList.get(i).getData());
                //System.out.println(dictionary.wordList.get(i).getData());
                i++;
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
        */

    }
//    void translate() throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("nhập từ cần tra nghĩa:");
//        String wordEnglish = scanner.nextLine();
//        String wordVietNam =TranslateByVietNam(wordEnglish);
//        addWord(wordEnglish,wordVietNam);
//        System.out.println(wordVietNam);
//    }
//
//    static String TranslateByVietNam( String inLanguge) throws IOException {
//        return GoogleTranslate.translate("vi", inLanguge);
//    }

    public static void main(String[] args) throws IOException {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile();
        int choose ;
        do{
            System.out.println("Choose 0: Exit\nChoose 1: See dictionary" +
                    "\nChoose 2: Search Word\nChoose 3: Lookup dictionary\nChoose 4: Add word to dictionary" +
                    "\nChoose 5: Repair dictionary\nChoose 6: Remove word\nYour choose: ");
            choose = scanner.nextInt();
            if(choose == 1)
            dictionaryManagement.dictionaryCommandline.showAllWords();
            //if(choose == 2)
            //dictionaryManagement.translate();
            else if(choose == 3) {
                //scanner.nextLine();
                dictionaryManagement.dictionaryLookup();
            }
            else if(choose ==4){
                System.out.println("English word you want add:");
                scanner.nextLine();
                String eWord = scanner.nextLine();
                System.out.println("Explain of english word:");
                String vWord = scanner.nextLine();
                dictionaryManagement.addWord(eWord,vWord);
            }
            else if(choose == 5)
                dictionaryManagement.repairDictionary();
            else if(choose == 6)
                dictionaryManagement.removeWord();
            else
                break;
            dictionaryManagement.dictionaryExportToFile();
          //  dictionaryManagement.insertFromFile();
        }while (choose!= 0);

        dictionaryManagement.dictionaryCommandline.showAllWords();


    }

}
