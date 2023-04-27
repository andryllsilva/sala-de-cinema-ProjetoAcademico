package Teste;

import Cinema.Assento;
import Cinema.Mapa;
import Cinema.Menu;

public class Main {
    public static void main(String[] args) {
        Mapa mapa = new Mapa(14, 12);
        Menu menu = new Menu(mapa);
        menu.mostrarMenu();
    }
}