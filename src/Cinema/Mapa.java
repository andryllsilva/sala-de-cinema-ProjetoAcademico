package Cinema;
public class Mapa {
    private Assento[][] assentos;
    private int lugaresLivres;
    private int lugaresOcupados;
    private char[] colunas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};

    public Mapa(int fileiras, int assentosPorFileira) {
        this.assentos = new Assento[fileiras][assentosPorFileira];
        this.lugaresLivres = fileiras * assentosPorFileira;
        this.lugaresOcupados = 0;

        for (int i = 0; i < fileiras ; i++) {
            for (int j = 0; j < assentosPorFileira; j++) {
                assentos[i][j] = new Assento(colunas[j], j+1);
            }
        }
    }

    public boolean reservar(char fileira, int assento) {
    	int indexFileira = indiceFileira(fileira);
        if (assentos[indexFileira][assento-1].isDisponivel()) {
            assentos[indexFileira][assento-1].reservar();
            lugaresLivres--;
            lugaresOcupados++;
            return true;
        } else {
            return false;
        }
    }
    
    private int indiceFileira(char letra) {
        for (int i = 0; i < colunas.length; i++) {
            if (colunas[i] == Character.toUpperCase(letra)) {
                return i;
            }
        }
        return -1;
    }

    public boolean cancelarReserva(char fileira, int assento) {
    	int indexFileira = indiceFileira(fileira);
        if (!assentos[indexFileira][assento-1].isDisponivel()) {
            assentos[indexFileira][assento-1].cancelarReserva();
            lugaresLivres++;
            lugaresOcupados--;
            return true;
        } else {
            return false;
        }
    }
    
    public void mostrarColuna() {
    	System.out.print("   ");
    	for (int j = 0; j < colunas.length; j++) {
            System.out.print(colunas[j] + " ");
        }
    	System.out.println();
    }

    public void mostrarMapa() {
        System.out.println("MAPA DE ASSENTOS:");
        mostrarColuna(); 
        for (int i = 0; i < assentos.length; i++) {
        	if (i + 1 < 10) {
        		System.out.print((i+1) + "  ");
                for (int j = 0; j < assentos[i].length; j++) {
                    System.out.print(assentos[i][j].toString() + " ");
                }
        	}else {
        		System.out.print((i+1) + " ");
                for (int j = 0; j < assentos[i].length; j++) {
                    System.out.print(assentos[i][j].toString() + " ");
                }
        	}
        	System.out.println();
        }
        mostrarColuna();
    }

    public int getLugaresLivres() {
        return lugaresLivres;
    }

    public int getLugaresOcupados() {
        return lugaresOcupados;
    }
}
