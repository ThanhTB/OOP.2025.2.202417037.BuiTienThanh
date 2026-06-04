package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;
import javax.swing.*;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");

        centerPanel.setLayout(new GridLayout(5, 2, 10, 10));

        centerPanel.add(new JLabel("Title:")); 
        tfTitle = new JTextField(); 
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category:")); 
        tfCategory = new JTextField(); 
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost ($):")); 
        tfCost = new JTextField(); 
        centerPanel.add(tfCost);

        centerPanel.add(new JLabel("Authors (comma-separated):")); 
        tfAuthors = new JTextField(); 
        centerPanel.add(tfAuthors);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());

            Book book = new Book(title, category, cost);

            String authorsInput = tfAuthors.getText().trim();
            if (!authorsInput.isEmpty()) {
                String[] authorArray = authorsInput.split(",");
                for (String author : authorArray) {
                    book.addAuthor(author.trim());
                }
            }

            this.store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            
            new StoreManagerScreen(store);
            this.dispose();
        });

        centerPanel.add(new JLabel("")); 
        centerPanel.add(btnAdd);
        
        setVisible(true);
    }
}