package Model;

import java.io.IOException;
import java.util.ArrayList;

public class ArrayResult extends ArrayList<Word> {
    protected static ArrayResult instance = null;
    public static ArrayResult getInstance() throws IOException {
        if(instance ==null)
        {
            instance = new ArrayResult();
            return instance;
        }
        else return instance;
    }
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayResult() throws IOException {

    }
    public  void kq() throws IOException {
        int index = DictionaryManagement.getInstance().Search(0,Dictionary.getInstance().size()-1,data);
        int i=index;
        System.out.println(index);
        int j = index;
        while(data.indexOf(Dictionary.getInstance().get(i).getWord_target())==0&& i < Dictionary.getInstance().size())
            i++;
        while(data.indexOf(Dictionary.getInstance().get(i).getWord_target())==0&& i >0)
            j--;
        for(int k =j; k <=j;k++)
        {
            add(new Word(Dictionary.getInstance().get(k).getWord_target()
            ,Dictionary.getInstance().get(k).getWord_explain()
            ));
//            System.out.println(Dictionary.getInstance().get(k).getWord_target()
//                    +Dictionary.getInstance().get(k).getWord_explain());
        }
        for(int e =0; e < getInstance().size(); e++)
        {
            System.out.println(getInstance().get(e).getWord_target());
        }
    }
}
