package view.exam;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ExamSelect extends JPanel {
    private static ExamSelect instance = null;

    ArrayList<String> tiengViet = new  ArrayList();
    ArrayList<String> tienganh = new  ArrayList();
    ArrayList<Boolean> tmp = new ArrayList<Boolean>(tiengViet.size());
    static int index =0;

    private void loaddata()
    {
        tiengViet.add("gà");
        tienganh.add("chicken");
        tiengViet.add("chos");
        tienganh.add("dog");
        tiengViet.add("chim");
        tienganh.add("bird");
        tiengViet.add("cây");
        tienganh.add("tree");
        tiengViet.add("bút");
        tienganh.add("pen");
    }

    public static ExamSelect getInstance()
    {
        if(instance ==null)

        {
            instance = new ExamSelect();
            return instance;
        }else return instance;
    }
    public ExamSelect()
    {
        loaddata();
        init();
    }
    private void init(){
        setLayout(new BorderLayout());
        loopExam();
        add(ExamSelectTop.getInstance(),BorderLayout.PAGE_START);
        add(ExamSelectCenter.getInstance(),BorderLayout.CENTER);
    }

    void loopExam() {

        if (index < tiengViet.size())
        {
        ExamSelectCenter.getInstance().index = index;
        ExamSelectTop.getInstance().setTextLbl(tienganh.get(index));
        ExamSelectCenter.getInstance().setData(tiengViet.get(index));

        ExamSelectCenter.getInstance().setTextSelect1(tiengViet.get(index));
        ExamSelectCenter.getInstance().setTextSelect2(tiengViet.get((index + 1) % tiengViet.size()));
        ExamSelectCenter.getInstance().setTextSelect3(tiengViet.get((index + 2) % tiengViet.size()));
        ExamSelectCenter.getInstance().setTextSelect4(tiengViet.get((index + 3) % tiengViet.size()));
        ExamSelectCenter.getInstance().repaint();
        index++;
        }
    }
}
