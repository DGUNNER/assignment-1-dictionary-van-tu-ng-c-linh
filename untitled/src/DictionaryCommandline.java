import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement{
    //DictionaryManagement dictionaryManagement = new DictionaryManagement();

    //private Dictionary dictionary  = new Dictionary();


<<<<<<< HEAD
   public Dictionary getDictionary()
   {
       if(dictionary ==null)
       {
           dictionary = new Dictionary();
       }
       return dictionary;
   }
=======
>>>>>>> 1478d69f7cb863bdd89f7c00d0b8c95b7220c926

    public void showAllWords(){
        System.out.println("NO\t\t\t|\t\tENGLISH\t\t\t\t\t|\t\t\tVIETNAMESE");
        for(int i = 0; i < dictionary.wordList.size();i++){
            System.out.println(i+1 + "\t\t\t|\t\t" + dictionary.wordList.get(i).getWord_target() +
                    "\t\t\t\t\t|\t\t" + dictionary.wordList.get(i).getWord_explain());
        }
    }

<<<<<<< HEAD


=======
>>>>>>> 1478d69f7cb863bdd89f7c00d0b8c95b7220c926
    public void dictionaryBasic(){

        insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
<<<<<<< HEAD
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile();
        showAllWords();
        dictionaryManagement.dictionaryLookup();
=======

        insertFromFile();
        showAllWords();
        DictionaryLockup();
>>>>>>> 1478d69f7cb863bdd89f7c00d0b8c95b7220c926
    }
    //Tim kiem cac tu theo cac ki tu dau
    public void dictionarySearches(){
        String search ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap tu can tim kiem :");
        search = scanner.nextLine();
        for(int i = 0; i < dictionary.wordList.size(); i++){
            if(dictionary.wordList.get(i).getWord_target().indexOf(search) == 0){

                System.out.println(dictionary.wordList.get(i).getData());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
<<<<<<< HEAD
        dictionaryCommandline.dictionaryBasic();
        dictionaryCommandline.dictionaryAdvanced();
        dictionaryCommandline.dictionarySearches();
=======
        //dictionaryCommandline.insertFromFile();
        dictionaryCommandline.dictionaryBasic();
        dictionaryCommandline.dictionaryAdvanced();
        dictionaryCommandline.dictionarySearches();
        dictionaryCommandline.dictionaryExportToFile();
>>>>>>> 1478d69f7cb863bdd89f7c00d0b8c95b7220c926
    }

}
