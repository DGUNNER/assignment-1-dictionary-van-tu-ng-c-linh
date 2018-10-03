import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {
    //DictionaryManagement dictionaryManagement = new DictionaryManagement();

    private Dictionary dictionary  = new Dictionary();

   public Dictionary getDictionary()
   {
       if(dictionary ==null)
       {
           dictionary = new Dictionary();
       }
       return dictionary;
   }

    public void showAllWords(){
        System.out.println("NO\t\t\t|\t\tENGLISH\t\t\t\t\t|\t\t\tVIETNAMESE");
        for(int i = 0; i < dictionary.wordList.size();i++){
            System.out.println(i+1 + "\t\t\t|\t\t" + dictionary.wordList.get(i).getWord_target() +
                    "\t\t\t\t\t|\t\t" + dictionary.wordList.get(i).getWord_explain());
        }
    }

    public static void main(String[] args) throws IOException {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        dictionaryCommandline.dictionaryBasic();
        dictionaryCommandline.dictionaryAdvanced();
        dictionaryCommandline.dictionarySearches();
    }

    public void dictionaryBasic(){

        dictionary.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile();
        showAllWords();
        dictionaryManagement.DictionaryLockup();
    }
    //Tim kiem cac tu theo cac ki tu dau
    public void dictionarySearches(){
        String search ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap tu can tim kiem :");
        search = scanner.nextLine();
        for(int i = 0; i < dictionary.wordList.size(); i++){
            if(dictionary.wordList.get(i).getWord_target().indexOf(search) == 0){

                System.out.print(dictionary.wordList.get(i).getData());
            }
        }
    }


}
