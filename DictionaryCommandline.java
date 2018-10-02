import java.util.Scanner;

public class DictionaryCommandline {
    //DictionaryManagement dictionaryManagement = new DictionaryManagement();

    private Dictionary dictionary  = new Dictionary();

   public void setDictionary(Dictionary d)
   {
       dictionary = d;
   }

    public void showAllWords(){
        System.out.println("NO\t\t\t|\t\tENGLISH\t\t\t\t\t|\t\t\tVIETNAMESE");
        for(int i = 0; i < dictionary.wordList.size();i++){
            System.out.println(i+1 + "\t\t\t|\t\t" + dictionary.wordList.get(i).getWord_target() +
                    "\t\t\t\t\t|\t\t" + dictionary.wordList.get(i).getWord_explain());
        }
    }

    public static void main(String[] args) {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        dictionaryCommandline.dictionaryBasic();
        dictionaryCommandline.dictionaryAdvanced();
        dictionaryCommandline.dictionarySearches();
    }
    public void dictionaryBasic(){

        dictionary.insertFromCommandline();
        showAllWords();
    }
    public void dictionaryAdvanced() {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile();
        showAllWords();
        dictionaryManagement.DictionaryLockup();
    }
    public void dictionarySearches(){
        String search ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap tu can tim kiem :");
        search = scanner.nextLine();
        for(int i = 0; i < dictionary.wordList.size(); i++){
            if(dictionary.wordList.get(i).getWord_target().indexOf(search) == 0){

                dictionary.wordList.get(i).showData();
            }
        }
    }


}
