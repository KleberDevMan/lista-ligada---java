
import array.encadeado.FilaLigada;
import array.encadeado.ListaLigadaNoCabeca;
import array.encadeado.ListaLigadaNoCalda;
import array.encadeado.ListaLigadaNoCalda2;
import array.encadeado.MeuArrayList;
import array.encadeado.PilhaLigada;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Kleber Junio
 */

//laboratorio de testes
public class TestesEficiencia {

    public static void main(String[] args) {
        
//        ListaLigadaNoCalda2 array = new ListaLigadaNoCalda2();
//        
//        for (int i = 0; i != 100000; i++) {
//            array.adiciona(i);
//        }
//        
//        Random r = new Random();
//        
//        long inicio = System.currentTimeMillis();
//        
//        for (int i = 0; i < 10000; i++) {
//            array.remover(r.nextInt(10000));
//        }
//        
//        System.out.println("\n tamanho: "+array.tamanho());
//
//        long fim = System.currentTimeMillis();
//        long time = fim - inicio;
//        System.out.println("\n tempo lista no calda: "+time);

        MeuArrayList array = new MeuArrayList();
        
        
        for (int i = 0; i != 100000; i++) {
            array.adicionar(i);
        }
        Random r = new Random();
        
        long inicio = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            array.remover(r.nextInt(10000));
        }
        
        System.out.println("\n tamanho: "+array.tamanho());

        long fim = System.currentTimeMillis();
        long time = fim - inicio;
        System.out.println("\n tempo lista memoria estatica: "+time);
    }
}
