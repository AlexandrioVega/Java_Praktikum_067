import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class POSSystem extends JFrame {
    private JTable productTable, cartTable;
    private DefaultTableModel productModel, cartModel;
    private JLabel detailLabel, totalLabel, pointsLabel;
    private JTextField qtyField;
    private JButton addToCartBtn, checkoutBtn, printBtn;
    private JTextArea receiptArea;
    private double totalAmount = 0;
    private int points = 0;
    
    public POSSystem() {
        setTitle("POIN Off-Sales - Java Swing");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Menu Bar
        createMenuBar();
        
        // Main Panel
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        // Left Panel - Product List
        mainPanel.add(createProductPanel());
        
        // Right Panel - Shopping Cart
        mainPanel.add(createCartPanel());
        
        add(mainPanel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }
    
    private JPanel createProductPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Produk"));
        
        // Product Table
        String[] productColumns = {"ID", "Nama Produk", "Harga (Rp)"};
        productModel = new DefaultTableModel(productColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Add sample products
        productModel.addRow(new Object[]{"P001", "Air Mineral 600ml", "3000"});
        productModel.addRow(new Object[]{"P002", "Kopi Sachet", "5000"});
        productModel.addRow(new Object[]{"P003", "Roti Isi", "8000"});
        productModel.addRow(new Object[]{"P004", "Snack Keripik", "6000"});
        productModel.addRow(new Object[]{"P005", "Minuman Botol", "12000"});
        
        productTable = new JTable(productModel);
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productTable.setRowHeight(25);
        productTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        productTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        productTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateProductDetail();
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(productTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Bottom Panel - Product Detail
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        detailLabel = new JLabel("Detail: - ");
        detailLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        bottomPanel.add(detailLabel, BorderLayout.NORTH);
        
        JPanel qtyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qtyPanel.add(new JLabel("Qty:"));
        qtyField = new JTextField("1", 5);
        qtyPanel.add(qtyField);
        
        addToCartBtn = new JButton("Add to Cart");
        addToCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });
        qtyPanel.add(addToCartBtn);
        
        bottomPanel.add(qtyPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createCartPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Keranjang"));
        
        // Cart Table
        String[] cartColumns = {"ID", "Nama Produk", "Qty", "Harga", "Subtotal"};
        cartModel = new DefaultTableModel(cartColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Keranjang awalnya kosong
        
        cartTable = new JTable(cartModel);
        cartTable.setRowHeight(25);
        cartTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        cartTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        cartTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        cartTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        cartTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        
        JScrollPane scrollPane = new JScrollPane(cartTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Bottom Panel - Total and Buttons
        JPanel bottomPanel = new JPanel(new BorderLayout());
        
        JPanel totalPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        totalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        
        totalLabel = new JLabel("Total: Rp0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalPanel.add(totalLabel);
        
        pointsLabel = new JLabel("Points: 0");
        totalPanel.add(pointsLabel);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        checkoutBtn = new JButton("Checkout");
        checkoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });
        buttonPanel.add(checkoutBtn);
        
        printBtn = new JButton("Cetak");
        printBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printReceipt();
            }
        });
        buttonPanel.add(printBtn);
        
        totalPanel.add(buttonPanel);
        bottomPanel.add(totalPanel, BorderLayout.NORTH);
        
        // Receipt Area
        JPanel receiptPanel = new JPanel(new BorderLayout());
        receiptPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        receiptPanel.add(new JLabel("Struk:"), BorderLayout.NORTH);
        
        receiptArea = new JTextArea(8, 30);
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        JScrollPane receiptScroll = new JScrollPane(receiptArea);
        receiptPanel.add(receiptScroll, BorderLayout.CENTER);
        
        bottomPanel.add(receiptPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void updateProductDetail() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            String id = productModel.getValueAt(selectedRow, 0).toString();
            String name = productModel.getValueAt(selectedRow, 1).toString();
            String price = productModel.getValueAt(selectedRow, 2).toString();
            
            detailLabel.setText("Detail: " + id + " - " + name + " (Rp" + 
                              formatCurrency(Double.parseDouble(price)) + ")");
        }
    }
    
    private void addToCart() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Pilih produk terlebih dahulu!");
            return;
        }
        
        try {
            int qty = Integer.parseInt(qtyField.getText());
            if (qty <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity harus lebih dari 0!");
                return;
            }
            
            String id = productModel.getValueAt(selectedRow, 0).toString();
            String name = productModel.getValueAt(selectedRow, 1).toString();
            String price = productModel.getValueAt(selectedRow, 2).toString();
            double priceValue = Double.parseDouble(price);
            double subtotal = priceValue * qty;
            
            // Check if item already exists in cart
            boolean found = false;
            for (int i = 0; i < cartModel.getRowCount(); i++) {
                if (cartModel.getValueAt(i, 0).equals(id)) {
                    int existingQty = Integer.parseInt(cartModel.getValueAt(i, 2).toString());
                    int newQty = existingQty + qty;
                    double newSubtotal = priceValue * newQty;
                    cartModel.setValueAt(newQty, i, 2);
                    cartModel.setValueAt(String.valueOf((int)newSubtotal), i, 4);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                cartModel.addRow(new Object[]{id, name, qty, price, String.valueOf((int)subtotal)});
            }
            
            calculateTotal();
            qtyField.setText("1");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity harus berupa angka!");
        }
    }
    
    private void calculateTotal() {
        totalAmount = 0;
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            double subtotal = Double.parseDouble(cartModel.getValueAt(i, 4).toString());
            totalAmount += subtotal;
        }
        
        points = (int) (totalAmount / 1000);
        
        totalLabel.setText("Total: Rp" + formatCurrency(totalAmount));
        pointsLabel.setText("Points: " + points);
    }
    
    private void checkout() {
        if (cartModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Keranjang masih kosong!");
            return;
        }
        
        generateReceipt();
        
        JOptionPane.showMessageDialog(this, "Checkout berhasil!\nTotal: Rp" + 
                                    formatCurrency(totalAmount) + "\nPoints: " + points);
        
        // Reset hanya keranjang, struk tetap ada
        cartModel.setRowCount(0);
        totalAmount = 0;
        points = 0;
        totalLabel.setText("Total: Rp0.00");
        pointsLabel.setText("Points: 0");
        qtyField.setText("1");
    }
    
    private void generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("================================\n");
        receipt.append("     POIN Off-Sales\n");
        receipt.append("================================\n\n");
        
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            String name = cartModel.getValueAt(i, 1).toString();
            String qty = cartModel.getValueAt(i, 2).toString();
            String price = cartModel.getValueAt(i, 3).toString();
            String subtotal = cartModel.getValueAt(i, 4).toString();
            
            receipt.append(name).append("\n");
            receipt.append("  ").append(qty).append(" x Rp").append(price);
            receipt.append(" = Rp").append(subtotal).append("\n");
        }
        
        receipt.append("\n--------------------------------\n");
        receipt.append("Total: Rp").append(formatCurrency(totalAmount)).append("\n");
        receipt.append("Points: ").append(points).append("\n");
        receipt.append("================================\n");
        receipt.append("   Terima Kasih!\n");
        receipt.append("================================\n");
        
        receiptArea.setText(receipt.toString());
    }
    
    private void printReceipt() {
        if (receiptArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belum ada struk untuk dicetak!\nKlik Checkout terlebih dahulu.");
            return;
        }
        
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                }
                
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                
                // Set font
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));
                
                // Print receipt text
                String[] lines = receiptArea.getText().split("\n");
                int y = 50;
                for (String line : lines) {
                    g2d.drawString(line, 50, y);
                    y += 15;
                }
                
                return PAGE_EXISTS;
            }
        });
        
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
                JOptionPane.showMessageDialog(this, "Struk berhasil dicetak!");
                
                // Reset struk setelah cetak
                receiptArea.setText("");
                
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(this, 
                    "Gagal mencetak struk!\nPastikan printer sudah terinstall.\n\nError: " + e.getMessage(),
                    "Print Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void resetTransaction() {
        // Clear cart table
        cartModel.setRowCount(0);
        
        // Clear receipt area
        receiptArea.setText("");
        
        // Reset total and points
        totalAmount = 0;
        points = 0;
        totalLabel.setText("Total: Rp0.00");
        pointsLabel.setText("Points: 0");
        
        // Reset quantity field
        qtyField.setText("1");
    }
    
    private String formatCurrency(double amount) {
        return String.format("%,.2f", amount);
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new POSSystem();
            }
        });
    }
}