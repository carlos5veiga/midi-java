import java.util.ArrayList;
import java.util.List;

public class Escala {
    private static final String NOTAS[] = {"Fább", "Dóbb", "Solbb", "Rébb", "Lább", "Mibb", "Sibb",
                                    "Fáb", "Dób", "Solb", "Réb", "Láb", "Mib", "Sib",
                                    "Fá", "Dó", "Sol", "Ré", "Lá", "Mi", "Si",
                                    "Fá#", "Dó#", "Sol#", "Ré#", "Lá#", "Mi#", "Si#"};
    
    private static final int SOM_NOTAS[] = {51, 46, 53, 48, 55, 50, 57,
                                    52, 59, 54, 61, 56, 63, 58,
                                    65, 60, 67, 62, 69, 64, 71,
                                    66, 73, 68, 75, 70, 77, 72};

    private static final int NOTA_NAO_ENCONTRADA = 400;

    private int tonica;
    private int somTonica;

    private List<String> maior = new ArrayList<>();
    private List<String> menorPrimitiva = new ArrayList<>();
    private List<String> menorHarmonica = new ArrayList<>();
    private List<String> menorMelodica = new ArrayList<>();
    
    public Escala(){
    }

    public Escala(String nota){
        init(nota);
    }

    public void init(String nota) {
        tonica = findNota(nota);
  
        if (tonica == NOTA_NAO_ENCONTRADA) {
            throw new NotFoundException("Nota não encontrada: " + nota);
        }
        
        setMaior();
        setMenorPrimitiva();
        setMenorHarmonica();
        setMenorMelodica();
    }

    public int getSomTonica(){
        return this.somTonica;
    }

    public List<String> getMaior() {
        return this.maior;
    }

    private void setMaior() {  
        maior.add(NOTAS[tonica]);
        maior.add(NOTAS[tonica+2]);
        maior.add(NOTAS[tonica+4]);
        maior.add(NOTAS[tonica-1]);
        maior.add(NOTAS[tonica+1]);
        maior.add(NOTAS[tonica+3]);
        maior.add(NOTAS[tonica+5]);
        maior.add(NOTAS[tonica]);
    }

    public List<String> getMenorPrimitiva() {
        return this.menorPrimitiva;
    }

    private void setMenorPrimitiva() {
        menorPrimitiva.add(NOTAS[tonica]);
        menorPrimitiva.add(NOTAS[tonica+2]);
        menorPrimitiva.add(NOTAS[tonica-3]);
        menorPrimitiva.add(NOTAS[tonica-1]);
        menorPrimitiva.add(NOTAS[tonica+1]);
        menorPrimitiva.add(NOTAS[tonica-4]);
        menorPrimitiva.add(NOTAS[tonica-2]);
        menorPrimitiva.add(NOTAS[tonica]);
    }

    public List<String> getMenorHarmonica() {
        return this.menorHarmonica;
    }

    private void setMenorHarmonica() {
        menorHarmonica.add(NOTAS[tonica]);
        menorHarmonica.add(NOTAS[tonica+2]);
        menorHarmonica.add(NOTAS[tonica-3]);
        menorHarmonica.add(NOTAS[tonica-1]);
        menorHarmonica.add(NOTAS[tonica+1]);
        menorHarmonica.add(NOTAS[tonica-4]);
        menorHarmonica.add(NOTAS[tonica+5]);
        menorHarmonica.add(NOTAS[tonica]);
    }

    public List<String> getMenorMelodica() {
        return this.menorMelodica;
    }

    private void setMenorMelodica() {
        menorMelodica.add(NOTAS[tonica]);
        menorMelodica.add(NOTAS[tonica+2]);
        menorMelodica.add(NOTAS[tonica-3]);
        menorMelodica.add(NOTAS[tonica-1]);
        menorMelodica.add(NOTAS[tonica+1]);
        menorMelodica.add(NOTAS[tonica+3]);
        menorMelodica.add(NOTAS[tonica+5]);
        menorMelodica.add(NOTAS[tonica]);
        menorMelodica.add(NOTAS[tonica-2]);
        menorMelodica.add(NOTAS[tonica-4]);
        menorMelodica.add(NOTAS[tonica+1]);
        menorMelodica.add(NOTAS[tonica-1]);
        menorMelodica.add(NOTAS[tonica-3]);
        menorMelodica.add(NOTAS[tonica+2]);
        menorMelodica.add(NOTAS[tonica]);
    }

    private int findNota(String nota) {
        for(int x = 0; x < NOTAS.length; x++) {
            if (nota.equals(NOTAS[x])) {
                somTonica = SOM_NOTAS[x];
                return x;
            }
        }
        return NOTA_NAO_ENCONTRADA;
    }

    @Override
    public String toString() {
        return 
            "Tônica: " + maior.get(0) + "\n" +
            "Escala Maior: " + maior + "\n" +
            "Escala Menor Primitiva: " + menorPrimitiva + "\n" +
            "Escala Menor Harmônica: " + menorHarmonica + "\n" +
            "Escala Menor Melódica: " + menorMelodica + "\n";
    }


}

