import java.util.Scanner;

public class TesteEscala {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Informe a tônica: ");
        String tonica = sc.nextLine();
        
        Escala escala1 = new Escala(tonica);
        System.out.println(escala1);

        PlayEscala.escalaMaior(escala1.getSomTonica());
        PlayEscala.escalaMenorPrimitiva(escala1.getSomTonica());
        PlayEscala.escalaMenorHarmonica(escala1.getSomTonica());
        PlayEscala.escalaMenorMelodica(escala1.getSomTonica());

        sc.close();
    }
}
