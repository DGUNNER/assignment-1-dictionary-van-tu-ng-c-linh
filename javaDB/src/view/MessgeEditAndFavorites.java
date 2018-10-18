
package view;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class MessgeEditAndFavorites extends JFrame implements ActionListener {
        private static MessgeEditAndFavorites instance = null;
        public static MessgeEditAndFavorites getInstance()
        {
            if(instance == null)
            {
                instance = new MessgeEditAndFavorites();
                return instance;
            }else
                return instance;
        }
        public JTextField txBoxAnh = new JTextField();
        public JTextField txBoxVi = new JTextField();

        public String getTxBoxAnh() {
            return txBoxAnh.getText();
        }

        public void setTxBoxAnh(String Anh) {
            this.txBoxAnh.setText(Anh);
        }

        public String  getTxBoxVi() {
            return txBoxVi.getText();
        }

        public void setTxBoxVi(String Viet) {
            this.txBoxVi.setText(Viet);
        }

        public final int _width =400;
        public final int _height =180;

        private int indexCollection = -1; // -1  là thêm thẻ// số khác là sửa thể thứ indexCollection


        public int getIndexCollection() {
            return indexCollection;
        }

        public void setIndexCollection(int indexCollection) {
            this.indexCollection = indexCollection;
        }



        JButton btnOK = new JButton("OK");
        JButton btnCANCEL = new JButton("CANCEL");


        public JLabel Title = new JLabel();
        public void init(){

            Title.setHorizontalAlignment(SwingConstants.CENTER);
            add(Title, BorderLayout.PAGE_START);
            add(GridComponentCenter(),BorderLayout.CENTER);
            add(ComponentBottom(),BorderLayout.PAGE_END);
            add(GridComponentLeft(),BorderLayout.LINE_START);
        }

        public MessgeEditAndFavorites()
        {
            setLayout(new BorderLayout(15,5));
            setSize(new Dimension(_width,_height));
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            //setUndecorated(true);
            getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            init();

        }
        public JPanel GridComponentLeft()
        {
            JPanel panel = new JPanel(new GridLayout(2,1,10,10));
            JLabel lblAnh = new JLabel("Từ Tiếng Anh");

            lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
            JLabel lblViet = new JLabel("Từ Tiếng Việt");
            lblViet.setHorizontalAlignment(SwingConstants.CENTER);

            panel.add(lblAnh);
            panel.add(lblViet);

            return panel;
        }

        public void resetAnhViet()
        {
            txBoxAnh.setText("");
            txBoxVi.setText("");
//            TiengAnh ="";
//            TiengViet = "";
        }
        public JPanel GridComponentCenter()
        {
            JPanel panel = new JPanel(new GridLayout(2,1,10,10));



            panel.add(txBoxAnh);
            panel.add(txBoxVi);

            return panel;
        }
        public JPanel ComponentBottom()
        {
            JPanel panel = new JPanel(new FlowLayout());

            btnOK.addActionListener(Controller.getInstance());
            btnOK.setActionCommand("btnOKMessage");
            panel.add(btnOK);
            panel.add(btnCANCEL);

            return panel;
        }

        public static void main(String[] args) {

            MessgeEditAndFavorites.getInstance().setVisible(true);
            //message.showMessageDialog(null, "jhgjhg" ,"áds",0);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
