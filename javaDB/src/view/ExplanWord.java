package view;

import javax.swing.*;
import java.awt.*;

public class ExplanWord extends JPanel {
    protected static ExplanWord instance = null;
    public static ExplanWord getInstance(){
        if(instance == null)
        {
            instance = new ExplanWord();
            return instance;
        }else
            return instance;
    }
    JLabel word = new JLabel();JLabel explan = new JLabel();
    public JPanel panel= new JPanel();
    public ExplanWord()
    {
        init();
    }
    public void setData(String Word,String Explan)
    {
        word.setText("<html><h1 style='color:red'>"+Word +"</h1></html>");
        explan.setText("<html>"+Explan+"</html>");
        //System.out.println(Explan);
        panel.add(word,BorderLayout.LINE_START);
        panel.add(explan,BorderLayout.CENTER);
    }
    private void init()
    {
        word.setHorizontalAlignment(SwingConstants.CENTER);
        explan.setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(new BorderLayout());
        //JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);


        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
    }
}
