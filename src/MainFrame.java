import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    final private Font mainFont = new Font("Segos print", Font.BOLD, 18);
    JTextField tfFirstName, tfLastName;
    JLabel lbWelcome;

    public void initialize(){

        /**********Form Panel**********/
        JLabel lblFirstName = new JLabel("Nombre");
        lblFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lblLastName = new JLabel("Apellido");
        lblLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4,1,5,5));
        formPanel.setOpaque(false);
        formPanel.add(lblFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lblLastName);
        formPanel.add(tfLastName);

        /**********Welcome Panel**********/
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        /**********Button Panel**********/
        JButton btnOK = new JButton("OK");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String firsName = tfFirstName.getText();
                String lastName = tfLastName.getText();
                lbWelcome.setText("Hola " + firsName + " " + lastName);
            }
            
        });

        JButton btnClear = new JButton("Limpiar");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tfFirstName.setText("");
                tfLastName.setText("");
                lbWelcome.setText("");
            }
            
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,5,5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnOK);
        buttonPanel.add(btnClear);

    /**********Main Panel**********/

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);


        setTitle("Primer proyecto");
        setSize(500,600);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}
