import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class DictionaryManagement {
    //private static final String fileDictionary = "Dictionary.txt";

    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
    Dictionary dictionary  = dictionaryCommandline.getDictionary();

    public Dictionary getDictionary()
    {
        return dictionary;
    }

    //Doc File
    public void insertFromFile(){

        //Dictionary dictionary = new Dictionary();
        File file  = new File("D:\\dictionary.txt");
        try
        {
            int i = 0;
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {

                String data = scanner.nextLine();
                System.out.println(data);
                int index = data.indexOf("\t");

//                dictionary.wordList.get(i).setWord_target(data.substring(0,index));

               dictionary.wordList.add(new Word(data.substring(0,index),data.substring(index+1,data.length())));

                i++;
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }


    }
    //Tra cuu tu dien
    public void DictionaryLockup()
    {
        boolean isfound =false;
        String search ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap tu can tim kiem :");
        search = scanner.nextLine();
        System.out.println(search);
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
        String search ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap tu can tim kiem :");
        search = scanner.nextLine();
        for(int i =0; i< dictionary.wordList.size(); i++)
        {
            if(search.equals(dictionary.wordList.get(i).getWord_target()))
            {
                //dictionary.wordList.get(i).setWord_explain();
            }
        }

    }
    //xoa word trong dictionary
    public void removeWord(){
        String search ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap tu can tim kiem :");
        search = scanner.nextLine();
        for(int i =0; i< dictionary.wordList.size(); i++)
        {
            if(search.equals(dictionary.wordList.get(i).getWord_target()))
            {
                dictionary.wordList.remove(i);
            }
        }

    }
    //Them word vap dictionary
    public void addWord(String anh, String viet){
        dictionary.wordList.add(new Word(anh,viet));
    }

    //Ghi Dictionary vao File
    public void dictionaryExportToFile(){
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

    }

    public static void main(String[] args) {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile();

        //dictionaryManagement.dictionaryCommandline.setDictionary(dictionaryManagement.getDictionary());
        dictionaryManagement.dictionaryCommandline.showAllWords();
        dictionaryManagement.DictionaryLockup();
        dictionaryManagement.addWord("bye","Tam biet");
        dictionaryManagement.dictionaryCommandline.showAllWords();
        dictionaryManagement.dictionaryExportToFile();
    }

}
