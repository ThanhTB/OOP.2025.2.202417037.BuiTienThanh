package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame{
    private Store store;

    public StoreManagerScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Store store = new Store();

        store.addMedia(new hust.soict.hedspi.aims.media.DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new hust.soict.hedspi.aims.media.DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new hust.soict.hedspi.aims.media.DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));
        store.addMedia(new hust.soict.hedspi.aims.media.DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 29.95f));


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StoreManagerScreen(store);
            }
        });
    }

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View store")); // Đang ở view store nên không cần gán

        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> { new AddBookToStoreScreen(store); this.dispose(); });
        
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> { new AddCompactDiscToStoreScreen(store); this.dispose(); });
        
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> { new AddDigitalVideoDiscToStoreScreen(store); this.dispose(); });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        // BỔ SUNG: Tạo nút View Cart giao diện
        JButton viewCartButton = new JButton("View cart");
        viewCartButton.setPreferredSize(new java.awt.Dimension(100, 40));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue()); // Đẩy nút về biên bên phải
        header.add(viewCartButton);             // Thêm nút vào layout
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();

        int limit = Math.min(mediaInStore.size(), 9);
        for(int i = 0; i < limit; i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }
}
