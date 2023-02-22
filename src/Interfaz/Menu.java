package Interfaz;

import java.awt.Image;
import java.awt.Toolkit;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Assets/shopping.png"));
        return retValue;
    }

    private void initComponents() {
        imagen = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuProducts = new javax.swing.JMenu();
        agregarProduct = new javax.swing.JMenuItem();
        listProducts = new javax.swing.JMenuItem();
        updateStock = new javax.swing.JMenuItem();
        menuSales = new javax.swing.JMenu();
        registrarSale = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        facturacionFecha = new javax.swing.JMenuItem();
        facturacionEntreFechas = new javax.swing.JMenuItem();
        ProductsBajoStock = new javax.swing.JMenuItem();
        ProductMayorRecaudacion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supermarket Management");
        setMinimumSize(new java.awt.Dimension(200, 200));
        setResizable(false);

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/shopping-fondo.jpg"))); // NOI18N

        menuProducts.setText("Products");

        agregarProduct.setText("Create new product");
        agregarProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });
        menuProducts.add(agregarProduct);

        listProducts.setText("Product list");
        listProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listProductsActionPerformed(evt);
            }
        });
        menuProducts.add(listProducts);

        updateStock.setText("Update stock");
        updateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStockActionPerformed(evt);
            }
        });
        menuProducts.add(updateStock);

        barraMenu.add(menuProducts);

        menuSales.setText("Sales");

        registrarSale.setText("New sale");
        registrarSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarSaleActionPerformed(evt);
            }
        });
        menuSales.add(registrarSale);

        barraMenu.add(menuSales);

        menuReportes.setText("Reports");

        facturacionFecha.setText("Billing by date");
        facturacionFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturacionFechaActionPerformed(evt);
            }
        });
        menuReportes.add(facturacionFecha);

        facturacionEntreFechas.setText("Billing between dates");
        facturacionEntreFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturacionEntreFechasActionPerformed(evt);
            }
        });
        menuReportes.add(facturacionEntreFechas);

        ProductsBajoStock.setText("Products with low stock");
        ProductsBajoStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsBajoStockActionPerformed(evt);
            }
        });
        menuReportes.add(ProductsBajoStock);

        ProductMayorRecaudacion.setText("Product with the highest grossing");
        ProductMayorRecaudacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductMayorRecaudacionActionPerformed(evt);
            }
        });
        menuReportes.add(ProductMayorRecaudacion);

        barraMenu.add(menuReportes);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 437,
                                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {
        new CreateProduct(this, true).setVisible(true);
    }

    private void listProductsActionPerformed(java.awt.event.ActionEvent evt) {
        new ListProducts(this, true).setVisible(true);
    }

    private void updateStockActionPerformed(java.awt.event.ActionEvent evt) {
        new StockProduct(this, true).setVisible(true);
    }

    private void registrarSaleActionPerformed(java.awt.event.ActionEvent evt) {
        new RegistrarVenta(this, true).setVisible(true);
    }

    private void facturacionFechaActionPerformed(java.awt.event.ActionEvent evt) {
        new FacturacionEnFecha(this, true).setVisible(true);
    }

    private void facturacionEntreFechasActionPerformed(java.awt.event.ActionEvent evt) {
        new FacturacionEntreFechas(this, true).setVisible(true);
    }

    private void ProductsBajoStockActionPerformed(java.awt.event.ActionEvent evt) {
        new ListProductsStockMinimum(this, true).setVisible(true);
    }

    private void ProductMayorRecaudacionActionPerformed(java.awt.event.ActionEvent evt) {//
        new ReportProductRecaudadoEnFecha(this, true).setVisible(true);
    }

    private javax.swing.JMenuItem ProductMayorRecaudacion;
    private javax.swing.JMenuItem ProductsBajoStock;
    private javax.swing.JMenuItem updateStock;
    private javax.swing.JMenuItem agregarProduct;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem facturacionEntreFechas;
    private javax.swing.JMenuItem facturacionFecha;
    private javax.swing.JLabel imagen;
    private javax.swing.JMenuItem listProducts;
    private javax.swing.JMenu menuProducts;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuSales;
    private javax.swing.JMenuItem registrarSale;
}
