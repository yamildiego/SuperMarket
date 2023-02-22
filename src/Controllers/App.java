package Controllers;

import Interfaz.Menu;

public class App {
    public App() {
    }

    public static void main(String args[]) throws Exception {
        ControllerProducts.getInstancia().loadProducts();
        ControllerSales.getInstancia().loadSales();
        new Menu().setVisible(true);
    }
}
