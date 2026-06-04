package hust.soict.hedspi.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // BỔ SUNG: Luôn thêm nút "Add to cart" cho mọi loại Media
        JButton addToCartButton = new JButton("Add to cart");
        container.add(addToCartButton);

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị hộp thoại thông báo thành công trực quan bằng Swing
                javax.swing.JOptionPane.showMessageDialog(
                    javax.swing.SwingUtilities.getWindowAncestor(MediaStore.this),
                    "Added \"" + media.getTitle() + "\" to cart successfully!",
                    "Cart Update",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
                );
            }
        });


        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            container.add(playButton);

            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(MediaStore.this), "Playing Media", true);
                    dialog.setLayout(new FlowLayout());
                    dialog.setSize(300, 150);
                    dialog.setLocationRelativeTo(null);

                    JLabel label = new JLabel("Playing: " + media.getTitle() + "...");
                    dialog.add(label);

                    JButton closeButton = new JButton("Close");
                    closeButton.addActionListener(el -> dialog.dispose());
                    dialog.add(closeButton);

                    dialog.setVisible(true);
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}