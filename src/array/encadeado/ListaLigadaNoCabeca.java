package array.encadeado;

/**
 * 
 * @author Kleber Junio
 * @param <T> 
 */

//Classe que ultiliza um conjunto de Nos
//para implementar uma lista ligada (linkedlist)

//Nesse tipo de lista não é necessario realocar memoria,
//cada item da lista guarda o endereco de memoria do proximo item, ou seja, 
//é uma memoria em cadeia
public class ListaLigadaNoCabeca<T> {
    
    //no que armazena o endereco do primeiro elemento da lista
    private No vrNoCabeca = null;
    //Qtd de elementos da lista
    private int qtdElementos = 0; 
    
    //Metodo que retorna a quantidade de elementos
    public int tamanho(){
        return qtdElementos;
    }
    
    //Metodo usado para iserir um novo elemento
    public void adiciona(T valor){
        
        //transformando o valor a ser adicionado em um nó
        No novo = new No(valor);
        qtdElementos++;
        
        //verifica se o nó cabeça da lista existe
        if(vrNoCabeca == null){
            vrNoCabeca = novo;
            return; //volta para o metodo que o chamou
        }
        
        //percorrer a lista até achar um nó que não aponta para ninguém
        No aux = vrNoCabeca;
        while(aux.proximo != null){
            aux = aux.proximo;
        }
        //quando a variavel aux sair de dentro do while, ela estará em 
        //um nó da lista que não aponta pra ninguem. Nesse momento eu posso criar
        //um no espacho "proximo" de dentro do ultimo nó
        aux.proximo = novo;
        
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
    
    //metodo que diz se a lista está vazia ou não
    public boolean isEmpty(){
        
        //Verifica se o No cabeca esta instanciado ou nao
        if(vrNoCabeca == null){
            return true;
        }
        return false;
    }
    
    public T remover(int posicao){
        
        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao > qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }
        
        //Verifica se o nó a ser removido é o primeiro
        if(posicao == 0){
            
            T copy = (T) vrNoCabeca.getConteudo();//salvando o conteudo do primeiro nó 
            vrNoCabeca = vrNoCabeca.proximo;//Perdendo o primeiro nó
            qtdElementos--;//subtraio da qtd de elementos
            return copy;
        }
        
        //Variavel auxiliar que aponta para o nó que se deseja remover
        No noAtual = vrNoCabeca;
        for (int pos = 0; pos < posicao; pos++) {
           noAtual = noAtual.proximo;
        }
        
        //Salvando o no que se deseja remover
        T copy = (T) noAtual.getConteudo();
        
        //Variavel auxiliar que aponta para o nó anterior ao que se deseja remorver
        No noAnterior = vrNoCabeca; 
        for (int pos = 0; pos + 1 < posicao; pos++) {
            noAnterior = noAnterior.proximo;
        }
        
        //Setando o atributo "proximo" do no anterior com o atributo "proximo" do nó atual
        //Perdendo assim o conteudo do no atual
        noAnterior.proximo = noAtual.proximo;
        qtdElementos--;//subtraio da qtd de elementos
        return copy;
    }
    //Setando um valor em uma posição existente no array
    public T set(int posicao, T valor){
        
        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao > qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }
        
        //Variavel que armazenara o retorno do metodo
        T vrRetorno = null;
        
        //Verificando se a posicao de set e a ultima da lista
        if(posicao == (tamanho()-1)){
            adiciona(valor); //setando valor na ultima posicao da lista
        }else {
        
            //no que percorrera a lista ate encontar a posicao desejada
            No aux = vrNoCabeca;
            
            for (int i = 0; i < posicao; i++) {
                aux = aux.proximo;
            }
            //salva o conteudo que sera perdido
            vrRetorno = (T) aux.getConteudo();
            
            //setar o nó com o novo valor
            aux.setConteudo(valor);

        }
        return (T) vrRetorno;
    }   
    
    //Metodo usado para adicionar em uma determinada posição
    public void adicionarEm(int posicao, T valor){
        
        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao > qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }
        
        //Cria o novo nó e incrementa a qtd elementos da lista
        No novoNo = new No(valor);
        qtdElementos++;

        //Verifica se a posicao de insercao e a primeira
        if(posicao == 0){
            novoNo.proximo = vrNoCabeca;
            vrNoCabeca = novoNo;
            return;
        }

        //No que percorrera a lista ate se chegar no No anterior ao da posicao desejada
        No noAnterior = vrNoCabeca;    
        
        //percorrendo a lista ate o No anterior ao da posicao desejada
        for (int pos = 0; pos < posicao - 1; pos++ ){
            noAnterior = noAnterior.proximo;
        }
        
        //Setando o novo No e o No Anterior
        novoNo.proximo = noAnterior.proximo;
        noAnterior.proximo = novoNo;
    }
    
    @Override
    public String toString() {
        
        //Variavel que sera retornada com os dados da lista
        String valores = ""; 
        
        //No auxiliar que percorrera toda a lista
        No aux = vrNoCabeca;
        while(aux != null){
            
            valores = valores + "[ " + aux.getConteudo() + " ]";
            
            aux = aux.proximo;
        }
        
        return valores;
    }
    
}
