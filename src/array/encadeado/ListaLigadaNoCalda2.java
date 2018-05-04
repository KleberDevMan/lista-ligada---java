/*
 *Classe com nó cabeça e no calda - Feita novamente
 */
package array.encadeado;

/**
 *
 * @author Kleber Junio
 */
public class ListaLigadaNoCalda2<T> {
    
    //no que armazena o endereco do primeiro elemento da lista
    private No<T> vrNoCabeca = null;
    //no que armazena o endereco do ultimo elemento da lista
    private No<T> vrNoCalda = null;
    //Qtd de elementos da lista
    private int qtdElementos = 0; 
    
    //Metodo que retorna a quantidade de elementos
    public int tamanho(){
        return qtdElementos;
    }
    
    //metodo que diz se a lista está vazia ou não
    public boolean isEmpty(){
        
        //Verifica se o No cabeca esta instanciado ou nao
        if(vrNoCabeca == null){
            return true;
        }
        return false;
    }
    
    //metodo que busca uma determinada posiçao na lista de memoria encadiada
    public T get(int posicao){
        
        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao > qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }
        
        //Variavel que percorrera a lista ate chegar na posicao desejada
        No aux = vrNoCabeca;
        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }
        //Devolvendo o conteudo posicao desejada
        return (T) aux.getConteudo();
    }
    
    //Metodo usado para iserir um novo elemento
    public void adiciona(T valor){
        //transformando o valor a ser adicionado em um nó
        No novo = new No(valor);
        qtdElementos++;
        
        //verifica se o nó cabeça da lista existe
        if(vrNoCabeca == null){
            vrNoCabeca = novo;
            vrNoCalda = novo;
            return; //volta para o metodo que o chamou
        }
        //o proximo da cauda aponta para o novo 
        vrNoCalda.proximo = novo;
        //revalido a cauda
        vrNoCalda = novo;
    }
    @SuppressWarnings("empty-statement")
    public T remover(int posicao){
        
        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao > qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }
        
        //Verifica se o nó a ser removido é o primeiro e unico nó da lista
        if(posicao == 0 && vrNoCabeca.proximo == null){
            T copy = (T) vrNoCabeca.getConteudo();//salvando o conteudo do primeiro nó 
            vrNoCabeca = null;//Perdendo o primeiro nó
            vrNoCalda = null;//Perdendo o ultimo nó
            qtdElementos--;//subtraio da qtd de elementos
            return copy;
        }
        
        //Verifica se o nó a ser removido é o primeiro, porem existem outros elementos na lista
        if(posicao == 0){
            T copy = vrNoCabeca.getConteudo();
            vrNoCabeca = vrNoCabeca.proximo;//perco o primeiro valor
            qtdElementos--;//subtraio da qtd de elementos
            return copy;
        }
        
        //percorrendo a lista até a posicao anterior a que se deseja remover
        No<T> temp = vrNoCabeca;
        for (int pos = 0; pos < posicao - 1; pos++, temp = temp.proximo);
        
        T copy = (T) temp.proximo.getConteudo();//salvando o valor do no que se deseja remover
        temp.proximo = temp.proximo.proximo;//perdendo o no que se deseja remover
        qtdElementos--;//subtraio da qtd de elementos
        
        if(posicao == this.tamanho() - 1){
            vrNoCalda = temp;
        }
        return copy;
    }
    
}
