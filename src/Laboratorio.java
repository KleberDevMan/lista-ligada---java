
import array.encadeado.ListaLigadaNoCaldaNoCabeca;

/*
 * 
 */

/**
 *
 * @author Kleber Junio
 */
public class Laboratorio {
    
    public static void main(String[] args) {
        
        ListaLigadaNoCaldaNoCabeca array = new ListaLigadaNoCaldaNoCabeca();

        array.adiciona("a");
        array.adiciona("b");
        array.adiciona("c");
        array.adiciona("d");
        array.adiciona("f");
//
        System.out.println("Tamanho antes: "+array.tamanho());

        
        System.out.println("Tamanho depois: "+array.tamanho());
        
        System.out.println(array);
    }
    
}
