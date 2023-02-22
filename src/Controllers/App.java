package Controllers;

import Interfaz.Menu;

public class App {
    public App() {
    }

    public static void main(String args[]) throws Exception {
        ControllerProducts.getInstance().loadProducts();
        ControllerSales.getInstance().loadSales();
        // new Menu().setVisible(true);
    }
}
