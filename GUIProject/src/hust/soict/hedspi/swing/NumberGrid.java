package hust.soict.hedspi.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGrid extends JFrame {

    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {

        setLayout(new BorderLayout(10,10));

        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tfDisplay.setFont(new Font("Arial", Font.PLAIN, 24));

        // ép chiều cao cho ô hiển thị
        tfDisplay.setPreferredSize(
                new java.awt.Dimension(300,50)
        );

        add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4,3,5,5));

        addButtons(panelButtons);

        add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(350,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NumberGrid();
    }

    void addButtons(JPanel panelButtons) {

        ButtonListener listener = new ButtonListener();

        for(int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            btnNumbers[i].addActionListener(listener);
            panelButtons.add(btnNumbers[i]);
        }

        btnDelete = new JButton("DEL");
        btnDelete.addActionListener(listener);
        panelButtons.add(btnDelete);

        btnNumbers[0] = new JButton("0");
        btnNumbers[0].addActionListener(listener);
        panelButtons.add(btnNumbers[0]);

        btnReset = new JButton("C");
        btnReset.addActionListener(listener);
        panelButtons.add(btnReset);
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String button = e.getActionCommand();

            if(button.matches("[0-9]")) {

                tfDisplay.setText(
                        tfDisplay.getText() + button
                );

            } else if(button.equals("DEL")) {

                String text = tfDisplay.getText();

                if(text.length() > 0) {
                    text = text.substring(
                            0,
                            text.length()-1
                    );
                }

                tfDisplay.setText(text);

            } else {

                tfDisplay.setText("");

            }
        }
    }
}