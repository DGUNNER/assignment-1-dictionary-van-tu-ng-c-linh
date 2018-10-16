import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
class table extends JPanel implements ActionListener{
    private static table instance = null;

    public static table getInstance()
    {
        if(instance == null)
        {
            instance = new table();
            return instance;
        }else
            return instance;
    }
    public table()
    {
        setLayout( new CardLayout());
        JButton btn1 = new JButton("nguyen van tu");
        JButton btn2 = new JButton("nguyen duy manh");

        btn1.setActionCommand("vantu");
        btn2.setActionCommand("duymanh");
        btn1.setBackground(Color.white);
        btn2.setBackground(Color.white);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        add(btn1,"tu");
        add(btn2,"manh");
    }


    public static void main(String []args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLayout(new BorderLayout());

        frame.add(table.getInstance(),BorderLayout.CENTER);
        //frame.setContentPane(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        if(actionEvent.getActionCommand().equals("vantu"))
        { System.out.println("abc");
            CardLayout cardLayout = (CardLayout) table.getInstance().getLayout();
            cardLayout.show(table.getInstance(),"manh");
        }
        else
        { System.out.println("123");
            CardLayout cardLayout = (CardLayout) table.getInstance().getLayout();
            cardLayout.show(table.getInstance(),"tu");
        }


    }
}