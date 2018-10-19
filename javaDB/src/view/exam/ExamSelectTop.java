package view.exam;

import javax.swing.*;
import java.awt.*;

public class ExamSelectTop  extends JPanel {
    private static ExamSelectTop instance = null;
    JLabel Text = new JLabel("@@@ nghia la gi??");
    public static ExamSelectTop getInstance()
    {
        if(instance ==null)

        {
            instance = new ExamSelectTop();
            return instance;
        }else return instance;
    }
    public void setTextLbl(String data)
    {
        Text.setText(data + " nghĩa là gì?");
    }
    protected ExamSelectTop()
    {
        init();
    }
    private void init()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, 180));
        setBackground(new Color(19, 39, 68));
        Text.setFont( new Font("Monaco", Font.PLAIN, 22));
        Text.setForeground(Color.WHITE);
        Text.setHorizontalAlignment(SwingConstants.CENTER);
        add(Text,BorderLayout.CENTER);
    }
}
