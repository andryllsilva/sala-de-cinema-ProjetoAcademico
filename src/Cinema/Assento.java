package Cinema;
public class Assento {
    private char fileira;
    private int assento;
    private boolean disponivel;

    public Assento(char fileira, int assento) {
        this.fileira = fileira;
        this.assento = assento;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar() {
        this.disponivel = false;
    }

    public void cancelarReserva() {
        this.disponivel = true;
    }

    @Override
    public String toString() {
        if (disponivel) {
            return "O";
        } 
        return "X";
    }
}