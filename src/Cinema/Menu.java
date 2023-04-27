package Cinema;
import java.util.Scanner;

public class Menu {
    private Mapa mapa;

    public Menu(Mapa mapa) {
        this.mapa = mapa;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("MENU");
            System.out.println("1 - Fazer reserva");
            System.out.println("2 - Cancelar reserva");
            System.out.println("3 - Mostrar mapa de assentos");
            System.out.println("4 - Mostrar quantidade de lugares livres e ocupados");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    fazerReserva();
                    break;
                case 2:
                    cancelarReserva();
                    break;
                case 3:
                    mostrarMapa();
                    break;
                case 4:
                    mostrarQuantidades();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);
    }

    private void fazerReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a letra da fileira: ");
        char fileira = scanner.next().charAt(0);
        System.out.print("Digite o número do assento: ");
        int assento = scanner.nextInt();

        if (mapa.reservar(fileira, assento)) {
            System.out.println("Reserva realizada com sucesso!");
        } else {
            System.out.println("Assento indisponível!");
        }
    }

    private void cancelarReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a letra da fileira: ");
        char fileira = scanner.next().charAt(0);
        System.out.print("Digite o número do assento: ");
        int assento = scanner.nextInt();

        if (mapa.cancelarReserva(fileira, assento)) {
            System.out.println("Reserva cancelada com sucesso!");
        } else {
            System.out.println("Assento não estava reservado!");
        }
    }

    private void mostrarMapa() {
        mapa.mostrarMapa();
    }

    private void mostrarQuantidades() {
        System.out.println("Lugares livres: " + mapa.getLugaresLivres());
        System.out.println("Lugares ocupados: " + mapa.getLugaresOcupados());
    }
}