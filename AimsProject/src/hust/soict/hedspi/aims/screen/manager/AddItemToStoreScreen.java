package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel centerPanel;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        // Tạo thanh North chứa MenuBar chung
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        cp.add(north, BorderLayout.NORTH);

        // Khung Center để các lớp con đè giao diện nhập liệu lên
        centerPanel = new JPanel();
        cp.add(centerPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(1024, 768);
        setLocationRelativeTo(null);
    }

    // Thanh Menu điều hướng dùng chung cho tất cả màn hình Add
    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        viewStoreMenu.addActionListener(e -> {
            new StoreManagerScreen(store); // Quay lại màn hình chính
            this.dispose(); // Tắt màn hình hiện tại
        });
        menu.add(viewStoreMenu);

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
}
