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

    public JPanel data;
    static int index =0;

    private void loaddata() throws SQLException {
        data = ListCard.getInstance().panel;
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

        if (index < data.getComponentCount())
        {
        ExamSelectCenter.getInstance().index = index;
        ExamSelectTop.getInstance().setTextLbl(((CardItem)data.getComponent(index)).getTextBtnAnh());
        ExamSelectCenter.getInstance().setData(((CardItem)data.getComponent(index)).getTextBtnViet());

        ExamSelectCenter.getInstance().setTextSelect1(((CardItem)data.getComponent(index)).getTextBtnViet());
        ExamSelectCenter.getInstance().setTextSelect2(((CardItem)data.getComponent((index+1)%data.getComponentCount())).getTextBtnViet());
        ExamSelectCenter.getInstance().setTextSelect3(((CardItem)data.getComponent((index+2)%data.getComponentCount())).getTextBtnViet());
        ExamSelectCenter.getInstance().setTextSelect4(((CardItem)data.getComponent((index+3)%data.getComponentCount())).getTextBtnViet());
        ExamSelectCenter.getInstance().repaint();
        index++;
        }
    }
}
