/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class DictionaryManagement{
    private final String PATH = "Dictionary.txt";
    private static DictionaryManagement instance = null;
    public static DictionaryManagement getInstance() throws IOException
    {
        if(instance ==null)
        {
            instance = new DictionaryManagement();
            return instance;
        }
        else return instance;
    }
    protected DictionaryManagement() throws IOException
    {
        init();
    }
    private void init() throws IOException
    {
        getDataFromFile();
    }
    public void getDataFromFile() throws IOException
    {
        try
        {
            FileReader reader = new FileReader(PATH);
            BufferedReader read = new BufferedReader(reader);
            String data;
            while ((data = read.readLine()) != null) {
                //System.out.println(data);
                int index = data.indexOf("\t");
                Dictionary.getInstance().add(new Word(data.substring(0, index), data.substring(index + 1, data.length())));

            }
        }catch(IOException e)
        {
            System.out.println(e);
        }
    }
    public void editWordByIndex(int index,String WordAnh,String WordViet)
    {
        if(index <Dictionary.getInstance().size()||index >-1)
        {
            Dictionary.getInstance().get(index).setWord_target(WordAnh);
            Dictionary.getInstance().get(index).setWord_explain(WordViet);
        }

    }
    public void deleteWordByIndex(int index)
    {
        if(index <Dictionary.getInstance().size()||index >-1)
        Dictionary.getInstance().remove(index);
    }
    public void addWordInDictionary(String WordAnh,String WordViet)
    {
        Dictionary.getInstance().add(new Word(WordAnh,WordViet));
        Dictionary.getInstance().sort(new SortbyWord());
    }
    public int Search(int dau, int cuoi,String data)
    {
        if(dau >=cuoi) return 0;
        if(Dictionary.getInstance().get(dau).getWord_target().indexOf(data) ==0) return dau;
        if(Dictionary.getInstance().get(cuoi).getWord_target().indexOf(data) ==0) return cuoi;
        if(Dictionary.getInstance().get((dau+cuoi)/2).getWord_target().indexOf(data) ==0) return (dau  +cuoi)/2;

        else
        {
            if(Dictionary.getInstance().get((dau+cuoi)/2).getWord_target().compareTo(data) >0)
                return Search(dau+1,(dau+cuoi)/2-1,data); else
                return Search((cuoi + dau)/2+1,cuoi-1,data);

        }
    }
}

class SortbyWord implements Comparator<Word>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Word a, Word b)
    {
        return a.getWord_target().compareTo(b.getWord_target());
    }
}
