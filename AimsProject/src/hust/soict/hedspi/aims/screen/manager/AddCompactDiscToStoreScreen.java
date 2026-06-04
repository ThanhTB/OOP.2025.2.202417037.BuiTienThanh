package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;
import javax.swing.*;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfDirector, tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add Compact Disc to Store");

        centerPanel.setLayout(new GridLayout(6, 2, 10, 10));

        centerPanel.add(new JLabel("Title:")); 
        tfTitle = new JTextField(); 
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category:")); 
        tfCategory = new JTextField(); 
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost ($):")); 
        tfCost = new JTextField(); 
        centerPanel.add(tfCost);

        centerPanel.add(new JLabel("Director:")); 
        tfDirector = new JTextField(); 
        centerPanel.add(tfDirector);

        centerPanel.add(new JLabel("Artist:")); 
        tfArtist = new JTextField(); 
        centerPanel.add(tfArtist);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            String director = tfDirector.getText().trim();
            String artist = tfArtist.getText().trim();

            // BỔ SUNG: Kiểm tra định dạng số cho Cost
            float cost;
            try {
                cost = Float.parseFloat(tfCost.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Cost must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            CompactDisc cd = new CompactDisc(title, category, cost, 0, director, artist);
            cd.addTrack(new Track(title + " - Track 1", 4)); 

            this.store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "Compact Disc added successfully!");
            
            new StoreManagerScreen(store);
            this.dispose();
        });

        centerPanel.add(new JLabel("")); 
        centerPanel.add(btnAdd);
        
        setVisible(true);
    }
}