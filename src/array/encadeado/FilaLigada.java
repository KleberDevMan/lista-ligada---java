/*
 *
 */
package array.encadeado;

/**
 *
 * @author Kleber Junio
 */
public class FilaLigada<T> extends ListaLigadaNoCabeca<T> {

    //Metodo que insere um elemento na primeira posicao da fila
    public void iserir(T valor) {
        this.adiciona(valor);
    }

    //Metodo que remove o ultimo elemento da fila
    public T remover() {
        return (T) remover(0);
    }

    //Metodo para visualizar os elemetos da fila
    @Override
    public String toString() {
        return super.toString();
    }
}
