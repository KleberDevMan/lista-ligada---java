package array.encadeado;

/*
 * Classe que implementa um nó na lista Java
 */
/**
 *
 * @author Kleber Junio
 *
 */
public class NoMelhorado<T> {

    //Armazena o conteudo do No
    private T conteudo = (T) new Object();
    //Armazena o endereco do proximo No
    public NoMelhorado proximo = null;
    //Armazena o endereco do No anterior
    public NoMelhorado anterior = null;

    //Construtor inicializando atributos
    public NoMelhorado(NoMelhorado anterior, T conteudo) {
        this.conteudo = conteudo;
        this.anterior = anterior;
    }

    //Construtor recebendo apenas
    public NoMelhorado(T conteudo) {
        this.conteudo = conteudo;
    }

    //Getters e Setters ---------------
    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoMelhorado getProximo() {
        return proximo;
    }

    public void setProximo(NoMelhorado proximo) {
        this.proximo = proximo;
    }

    public NoMelhorado getAnterior() {
        return anterior;
    }

    public void setAnterior(NoMelhorado anterior) {
        this.anterior = anterior;
    }

}
