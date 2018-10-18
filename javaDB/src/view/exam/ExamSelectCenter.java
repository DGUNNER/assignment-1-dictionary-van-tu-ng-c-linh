package view.exam;

import view.Card.CardItem;
import view.search.BtnNone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamSelectCenter extends JPanel  implements ActionListener {
    private static ExamSelectCenter instance = null;

    private BtnNone option1= new BtnNone();
    private BtnNone option2= new BtnNone();
    private BtnNone option3= new BtnNone();
    private BtnNone option4= new BtnNone();

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTextSelect1(String text1) {
        this.option1.setText(text1);
    }

    public void setTextSelect2(String text) {
        this.option2.setText(text);
    }

    public void setTextSelect3(String text) {
        this.option3.setText(text);
    }

    public void setTextSelect4(String text) {
        this.option4.setText(text);
    }



    public static ExamSelectCenter getInstance()
    {
        if(instance ==null)

        {
            instance = new ExamSelectCenter();
            return instance;
        }else return instance;
    }
    public int index =0;
    public ExamSelectCenter()
    {
        init();
    }
    private void init()
    {
        setLayout(new GridLayout(4,1));
        option1.setBackground(Color.WHITE);
        option2.setBackground(Color.WHITE);
        option3.setBackground(Color.WHITE);
        option4.setBackground(Color.WHITE);


        option1.setActionCommand("option1");
        option2.setActionCommand("option2");
        option3.setActionCommand("option3");
        option4.setActionCommand("option4");


        option2.addActionListener(this);
        option1.addActionListener(this);
        option3.addActionListener(this);
        option4.addActionListener(this);
        add(option1);
        add(option2);
        add(option3);
        add(option4);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        try {
            if (cmd.equals("option1")) {

                if (option1.getText().equals(((CardItem)ExamSelect.getInstance().data.getComponent(index)).getTextBtnViet())) {
                    System.out.println("chọn đúng");
                } else System.out.println("chọn sai");
                ExamSelect.getInstance().loopExam();
            } else if (cmd.equals("option2")) {

                if (option2.getText().equals(((CardItem)ExamSelect.getInstance().data.getComponent(index)).getTextBtnViet())) {
                    System.out.println("chọn đúng");
                } else System.out.println("chọn sai");
                ExamSelect.getInstance().loopExam();

            } else if (cmd.equals("option3")) {
                if (option3.getText().equals(((CardItem)ExamSelect.getInstance().data.getComponent(index)).getTextBtnViet())) {
                    System.out.println("chọn đúng");
                } else System.out.println("chọn sai");
                ExamSelect.getInstance().loopExam();

            } else if (cmd.equals("option4")) {
                if (option4.getText().equals(((CardItem)ExamSelect.getInstance().data.getComponent(index)).getTextBtnViet())) {
                    System.out.println("chọn đúng");
                } else System.out.println("chọn sai");
                ExamSelect.getInstance().loopExam();

            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
