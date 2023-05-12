/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restaurante;

import javax.swing.JOptionPane;

/**
 *
 * @author emmanuel
 */
public class Restaurante {
     public static void main(String[] args) {
        // Menú del restaurante
        String[] opcionesMenu = {"1. Desayunos", "2. Comidas", "3. Cenas", "4. Bebidas", "5. Postres"};
        String[][] platillos = { 
            {"Huevos rancheros", "Chilaquiles", "Omelette con espinaca", "Molletes", "Club sandwich", "Quesadillas", "Avena con frutas", "Fruta con cereal y yogurt", "Pan frances", "Hot cakes"}, 
            {"Ensalada César", "Pasta Alfredo", "Sándwich de pollo", "Hamburguesa", "Pizza", "Tacos al pastor", "Carne asada", "Pechuga a la plancha", "Arroz con pollo", "Papas fritas"}, 
            {"Sopa de verduras", "Sopa de lentejas", "Pollo al horno", "Salmón a la parrilla", "Chuletas de cerdo", "Tostadas de tinga", "Tortas ahogadas", "Enchiladas suizas", "Tacos de pescado", "Tamales"}, 
            {"Refresco", "Agua mineral", "Jugo de frutas", "Cerveza", "Vino tinto", "Margarita", "Mojito", "Piña colada", "Café helado", "Té helado"}, 
            {"Pastel de chocolate", "Flan", "Helado", "Cheesecake", "Tiramisú", "Pay de limón", "Crepas de frutas", "Gelatina", "Brownie", "Frutas de temporada"}
        };
        int[][] precios = { 
            {60, 50, 70, 45, 25, 20, 35, 15, 25, 15}, 
            {90, 120, 80, 100, 150, 70, 130, 100, 90, 50}, 
            {50, 60, 120, 200, 80, 70, 90, 100, 60, 40}, 
            {20, 15, 25, 35, 80, 60, 70, 80, 30, 25}, 
            {60, 40, 50, 80, 100, 70, 90, 25, 50, 35}
        };
        int opcionMenu = 0;
        String ordenCliente = "";
        int total = 0;
        
        // Ciclo principal del programa
        while (opcionMenu >= 0 && opcionMenu < opcionesMenu.length) {
            // Mostrar menú y pedir opción al usuario
            ordenCliente += "\n\n";
            ordenCliente += "MENU DEL RESTAURANTE\n";
            ordenCliente += "----------------------\n";
            for (int i = 0; i < opcionesMenu.length; i++) {
                ordenCliente += opcionesMenu[i] + "\n";
            }
            ordenCliente += "0. Salir\n";
            ordenCliente += "----------------------\n";
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(ordenCliente + "\n" + "Ingrese la opción que desea: "));
           // Validar opción del usuario
        if (opcionMenu < 0 || opcionMenu > opcionesMenu.length) {
            JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
        } else if (opcionMenu == 0) {
            // Salir del programa
            JOptionPane.showMessageDialog(null, "Gracias por su visita.");
            break;
        } else {
            // Mostrar platillos y precios de la opción seleccionada
            ordenCliente = "";
            ordenCliente += "MENU DE " + opcionesMenu[opcionMenu-1].toUpperCase() + "\n";
            ordenCliente += "----------------------\n";
            for (int i = 0; i < platillos[opcionMenu-1].length; i++) {
                ordenCliente += (i+1) + ". " + platillos[opcionMenu-1][i] + " - $" + precios[opcionMenu-1][i] + "\n";
            }
            ordenCliente += "----------------------\n";
            
            // Pedir orden al usuario
            int opcionPlatillo = 0;
            int cantidadPlatillo = 0;
            do {
                opcionPlatillo = Integer.parseInt(JOptionPane.showInputDialog(ordenCliente + "\n" + "Ingrese el número del platillo que desea (0 para terminar): "));
                if (opcionPlatillo > 0 && opcionPlatillo <= platillos[opcionMenu-1].length) {
                    cantidadPlatillo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de " + platillos[opcionMenu-1][opcionPlatillo-1] + " que desea: "));
                    total += precios[opcionMenu-1][opcionPlatillo-1] * cantidadPlatillo;
                    ordenCliente += cantidadPlatillo + " " + platillos[opcionMenu-1][opcionPlatillo-1] + " - $" + precios[opcionMenu-1][opcionPlatillo-1] * cantidadPlatillo + "\n";
                } else if (opcionPlatillo == 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
                }
            } while (opcionPlatillo != 0);
            
            // Mostrar cuenta del cliente
            if (total > 0) {
                JOptionPane.showMessageDialog(null, """
                                                    RESTAURANTE EL BUEN COMER
                                                    ----------------------
                                                    """ + ordenCliente + "----------------------\n" + "TOTAL: $" + total + "\n" + "Gracias por su compra.");
                total = 0;
            }
        }
    }
}
}
