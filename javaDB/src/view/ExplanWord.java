package view;

import API.Speaker;
import view.search.BtnNone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    BtnNone word = new BtnNone();
    JLabel explan = new JLabel();
    public JPanel panel= new JPanel(new BorderLayout());
    public ExplanWord()
    {
        init();
    }
    public void setData(String Word,String Explan)
    {
        word.setText(Word);
        explan.setText("<html><div style='font-size:11px'>"+Explan+"</div></html>");
        //System.out.println(Explan);

    }
    private void init()
    {
        setLayout(new BorderLayout());
        word.setIcon(new ImageIcon("icons/speaker.png"));
        word.setContentAreaFilled(false);
        word.setFont(new Font("Monaco", Font.PLAIN, 20));
        word.setHorizontalAlignment(SwingConstants.CENTER);
        word.setHorizontalTextPosition(SwingConstants.LEFT);
        word.setForeground(Color.red);

        word.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event)
            {
                if (event.getClickCount() == 2) {
                    new Speaker(((BtnNone)event.getSource()).getText());
                }
            }
        });

        explan.setHorizontalAlignment(SwingConstants.CENTER);
        explan.setVerticalAlignment(SwingConstants.TOP);
        panel.add(word,BorderLayout.PAGE_START);
        panel.add(explan,BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
    }
}
