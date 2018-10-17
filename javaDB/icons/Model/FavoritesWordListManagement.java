package Model;

public class FavoritesWordListManagement {

    public void editWordByIndex(int index,String WordAnh,String WordViet)
    {
        if(index <FavoritesWordList.getInstance().size()||index >-1)
        {
            FavoritesWordList.getInstance().get(index).setWord_target(WordAnh);
            FavoritesWordList.getInstance().get(index).setWord_explain(WordViet);
        }

    }
    public void deleteWordByIndex(int index)
    {
        if(index <FavoritesWordList.getInstance().size()||index >-1)
            FavoritesWordList.getInstance().remove(index);
    }
    public void addWordInDictionary(String WordAnh,String WordViet)
    {
        FavoritesWordList.getInstance().add(new Word(WordAnh,WordViet));
        FavoritesWordList.getInstance().sort(new SortbyWord());
    }
}
