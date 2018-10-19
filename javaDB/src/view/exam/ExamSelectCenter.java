package view.exam;

import view.Card.CardItem;
import view.mainFrame;
import view.search.BtnNone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamSelectCenter extends JPanel  implements ActionListener {
    private static ExamSelectCenter instance = null;
    private BtnNone []option =new BtnNone[4];


    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTextSelect1(String text1, int i) {
        this.option[i].setText(text1);
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
        for(int i =0; i <4; i++)
        {
            option[i]= new BtnNone();
            if(i%2==0) option[i].setBackground(Color.WHITE);
            else option[i].setBackground(new Color(242, 242, 242));
            option[i].setActionCommand("option#"+i);
            option[i].addActionListener(this);
            add(option[i]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        try {
            if (cmd.startsWith("option#")) {
                for(int i = 0; i<4; i++)
                {
                    if(cmd.equals("option#"+i))
                    {
                        if (option[i].getText().equals(ExamSelect.getInstance().wordIndex.getWordVi())) {
                            JOptionPane.showMessageDialog(mainFrame.getInstance(),
                                    "Câu Trả Lời Của Bạn Rất Chính Xác",
                                    "Thông Báo",JOptionPane.INFORMATION_MESSAGE);
                        } else JOptionPane.showMessageDialog(mainFrame.getInstance(),
                                "Rất Tiếc ! Câu Trả Lời Của Bạn Sai Mất Rồi",
                                "Thông Báo",JOptionPane.WARNING_MESSAGE);
                        ExamSelect.getInstance().loopExam();
                    }
                }


            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
