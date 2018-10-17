package Model;


import java.util.ArrayList;

public class FavoritesWordList extends ArrayList<Word> {
    protected static FavoritesWordList instance = null;
    public static FavoritesWordList getInstance()
    {
        if(instance ==null)
        {
            instance = new FavoritesWordList();
            return instance;
        }
        else return instance;
    }

    public FavoritesWordList()  {
        loadData();
    }
    private void loadData()
    {
        //DictionaryManagement.getInstance().getDataFromFile();
        /*for (int i = 0; i <10; i++) // add 10 từ đầu tiên của list dictionary
        {
            add(new Word(Dictionary.getInstance().get(i).getWord_target(),
                    Dictionary.getInstance().get(i).getWord_explain()));
        }*/
    }
}
