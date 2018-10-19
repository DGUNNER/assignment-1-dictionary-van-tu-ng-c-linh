package view.exam;

import view.Card.CardItem;
import view.Card.ListCard;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class ExamSelect extends JPanel {
    private static ExamSelect instance = null;

    public JPanel pl;
    static int index =0;
    public Word wordIndex;
    ArrayList<Word> data = new ArrayList<>();
    ArrayList<String> dapAn = new ArrayList<>();
    public  void loaddata() throws SQLException {
        pl = ListCard.getInstance().panel;
        for(int i=0; i < pl.getComponentCount(); i++)
        {
            data.add(new Word(
                    ((CardItem)pl.getComponent(i)).getTextBtnAnh(),
                    ((CardItem)pl.getComponent(i)).getTextBtnViet()
            ));
            dapAn.add(data.get(i).getWordVi());
        }
    }

    public static ExamSelect getInstance() throws SQLException {
        if(instance ==null)

        {
            instance = new ExamSelect();
            return instance;
        }else return instance;
    }
    public ExamSelect() throws SQLException {
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

        if (data.size()>0)
        {
            Random ran= new Random();
            int ranIndex =ran.nextInt(data.size());
            wordIndex = data.get(ranIndex); // chonj ngaa nhien 1 caau dde hoi
            data.remove(ranIndex); // xoas phan tu ddo ddi
            ExamSelectTop.getInstance().setTextLbl(wordIndex.getWordEng());
            //dday cau hoi leen topExam
            // ngau nhien chon index dap an dung
            int indexDapAnDung = ran.nextInt(4);
            ExamSelectCenter.getInstance().setTextSelect1(wordIndex.getWordVi(),indexDapAnDung);
            for(int i =0; i<4; i++)
            {
                if(i !=indexDapAnDung)// neu la o k phai dap an ddung thi random
                {
                    //ramdom lua chon ngau nhian khac dap an
                    String x;
                    do{
                         x= dapAn.get(ran.nextInt(dapAn.size()));
                        //System.out.println(x);
                    }while(x.equals(wordIndex.getWordVi()));

                    ExamSelectCenter.getInstance().setTextSelect1(x,i);
                }
            }

        ExamSelectCenter.getInstance().repaint();
        index++;
        }
        else
        {
            ExamSelectTop.getInstance().Text.setText("Bạn Đã Hoàn Thành Bài Kiểm Tra Kiến Thức :)");
            for(int i=0; i <4; i++)
            ExamSelectCenter.getInstance().setTextSelect1("",i);

            ExamSelectCenter.getInstance().repaint();
        }
    }
}
