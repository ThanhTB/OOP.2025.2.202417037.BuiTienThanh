package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Biến lưu tổng tích lũy, khởi tạo bằng 0

    // Constructor để thiết lập các thành phần giao diện (GUI) và xử lý sự kiện
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an Integer: "));
        
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));
        
        tfOutput = new TextField(10);
        tfOutput.setEditable(false); // Ô này chỉ để hiển thị kết quả, không cho nhập
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true); // Hiển thị cửa sổ
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    // Class nội bộ (Inner class) để xử lý sự kiện khi người dùng nhấn Enter
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent evt) {
            // Lấy chuỗi nhập vào, chuyển thành số nguyên và cộng dồn vào sum
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            
            // Xóa ô nhập liệu để người dùng nhập số tiếp theo
            tfInput.setText("");
            
            // Hiển thị tổng mới ra ô kết quả
            tfOutput.setText(sum + "");
        }
    }
}