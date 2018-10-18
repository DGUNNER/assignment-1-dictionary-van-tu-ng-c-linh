package ScrollableJPopupmenu;

import view.search.BtnNone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldSwing");
        final JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
        XJPopupMenu menu = new XJPopupMenu(frame);
        JButton btn;
        for(int i =0; i< 100 ; i++)
        {
            btn= new JButton("Ádádfasdfasfgasdfhjhtgjkasdfgasdfasdfasdf"+i);
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    System.out.println( ((JButton)e.getSource()).getText() );
                    menu.hidemenu();
                }
            });
            menu.add(btn);
        }

        menu.show((Component)frame,10,10);

    }
}
