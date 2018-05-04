package array.encadeado;

/*
 * Classe que implementa um nó na lista Java
 */
/**
 *
 * @author Kleber Junio
 *
 */
public class No<T> {

    //Armazena o conteudo do No
    private T conteudo = (T) new Object();
    //Armazena o endereco do proximo No
    public No proximo = null;

    //Construtor inicializando atributos
    public No(T conteudo) {
        this.conteudo = conteudo;
    }

    //Getters e Setters
    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }
}
